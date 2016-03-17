package application;

import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;

/**
 * Denna klass har till uppgift att koppa samman de andra klasserna som
 * inehåller logik Controller klassen ska inte innefatta mycket logik klassen
 * innehåller just nu 5 metoder.
 * 
 **/
public class AdminController implements ControlledScreen {

	// skapar en referens variabel av klassen ScreenController s� att man kan
	// �ndra till statistik guit
	private ScreenController myController;

	@FXML
	private TabPane tabpane;

	 WriteToTextFile write = new WriteToTextFile();
	private AddNodes addnodes = new AddNodes(write);
	
	@FXML
	// skapar en arraylist som lagrar anchorpanes , s� man kan h�lla reda p�
	// vilken nod tillh�r vilken tab
	private ArrayList<AnchorPane> anchorPaneList = new ArrayList<>();


	@Override
	public void setScreenParent(ScreenController screenPage) {
		myController = screenPage;
	}

	@FXML
	public void onClose() {
		Platform.exit();
	}

	@FXML
	public void onNewFile() {
		write.showFileChooser();
	}

	@FXML
	public void onAddCheckbox(ActionEvent event) {
		String checkboxText;
		// skapar en oinitizerad anchorpane variabel som jag sedan tilldelar ett
		// v�rde
		AnchorPane pane;
		// om tabpane inte �r tom(att den har en eller mer tabs) skall denna kod
		// g�ras
		if (!tabpane.getTabs().isEmpty()) {
			// jag f�ngar upp den valda anchorpanen och tilldelar den till pane
			// s� jag sedan kan l�gga till noder p� den spesefika tabben som �r
			// vald
			pane = anchorPaneList.get(tabpane.getSelectionModel().getSelectedIndex());
			// l�gger till noden till pane

			// s�tter pane till tabben
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Meddelande");
			dialog.setHeaderText("S�tt i text i checkbox :");
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()) {
				checkboxText = result.get();

				pane.getChildren().add(addnodes.getCheckbox(checkboxText));
				tabpane.getSelectionModel().getSelectedItem().setContent(pane);
				write.setTextInFile("checkbox");
				write.setTextInFile("");
				write.setTextInFile("");
				write.setTextInFile(checkboxText);
			}
		}
	}

	// l�gger till en tab
	@FXML
	public void onAddTab(ActionEvent event) {
		// skapar en ny anchorpane f�r varje tab som skapas
		AnchorPane pane = new AnchorPane();
		pane.prefHeight(1000);
		pane.prefWidth(1000);
		// l�gger till tabben i en arraylist av typen AnchorPane
		anchorPaneList.add(pane);
		// l�gger till en ny tab i tabpane och ger den enskilda tabben en
		// anchorpane
		tabpane.getTabs().add(addnodes.getNewTab(pane));
		write.setTextInFile("tab");
		write.setTextInFile("newtab");
	}

	// n�r knappen trycks skall textfilen ingemo valt skickas till anv�ndaren
	@FXML
	public void onDone(ActionEvent event) {

	}

	// visar en ruta med statistik
	@FXML
	public void onShowStatistics(ActionEvent event) {
		myController.setScreen(Main.screen2ID);
	}

	// l�gger till ett textf�lt
	@FXML
	public void onAddTextfield() {
		AnchorPane pane;

		if (!tabpane.getTabs().isEmpty()) {
			pane = anchorPaneList.get(tabpane.getSelectionModel().getSelectedIndex());
			pane.getChildren().add(addnodes.getTextField());
			tabpane.getSelectionModel().getSelectedItem().setContent(pane);
			write.setTextInFile("textfield");
			write.setTextInFile("");
			write.setTextInFile("");
			write.setTextInFile("textf�lt text");
			// write.setTextInFile(String.valueOf(isEditable));
		}
	}

	// st�nger en tab
	@FXML
	public void onCloseTab() {
		System.out.println("close tab");
	}

	
	// l�gger till en textarea
	@FXML
	public void onAddTextarea() {
		AnchorPane pane;

		TextArea textarea = new TextArea();
		if (!tabpane.getTabs().isEmpty()) {
			pane = anchorPaneList.get(tabpane.getSelectionModel().getSelectedIndex());
			pane.getChildren().add(textarea);
			tabpane.getSelectionModel().getSelectedItem().setContent(pane);
			write.setTextInFile("textarea2");
			write.setTextInFile("");
			write.setTextInFile("");
		}
	}
	
	 @FXML
	 public void onSetTime(){
	 
	   TextInputDialog dialog = new TextInputDialog();
	     dialog.setTitle("Meddelande");
	     dialog.setHeaderText("S�tt i text i checkbox :");
	     Optional<String> result = dialog.showAndWait();
	     if (result.isPresent()) {
	      String text = result.get(); 
	      write.setTextInFile("time");
	      write.setTextInFile(text);
	     System.out.println(text);}
	 }
}
