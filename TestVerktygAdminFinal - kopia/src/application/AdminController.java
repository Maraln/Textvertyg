package application;

import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

/**
 * Denna klass har till uppgift att koppa samman de andra klasserna som
 * inehåller logik Controller klassen ska inte innefatta mycket logik klassen
 * innehåller just nu 5 metoder.
 * 
 **/
public class AdminController implements ControlledScreen {

	// skapar en referens variabel av klassen ScreenController så att man kan
	// ändra till statistik guit
	private ScreenController myController;

	@FXML
	private TabPane tabpane;

	private WriteToTextFile write = new WriteToTextFile();
	private AddNodes addnodes = new AddNodes(write);

	@FXML
	// skapar en arraylist som lagrar anchorpanes , så man kan hålla reda på
	// vilken nod tillhör vilken tab
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
		// värde
		AnchorPane pane;
		// om tabpane inte är tom(att den har en eller mer tabs) skall denna kod
		// göras
		if (!tabpane.getTabs().isEmpty()) {
			// jag fångar upp den valda anchorpanen och tilldelar den till pane
			// så jag sedan kan lägga till noder på den spesefika tabben som är
			// vald
			pane = anchorPaneList.get(tabpane.getSelectionModel().getSelectedIndex());
			// lägger till noden till pane

			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Meddelande");
			dialog.setHeaderText("Sätt i text i checkbox :");
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

	// lägger till en tab
	@FXML
	public void onAddTab(ActionEvent event) {
		// skapar en ny anchorpane för varje tab som skapas
		AnchorPane pane = new AnchorPane();
		pane.prefHeight(1000);
		pane.prefWidth(1000);
		// lägger till tabben i en arraylist av typen AnchorPane
		anchorPaneList.add(pane);
		// lägger till en ny tab i tabpane och ger den enskilda tabben en
		// anchorpane
		tabpane.getTabs().add(addnodes.getNewTab(pane));
		write.setTextInFile("tab");
		write.setTextInFile("newtab");
	}

	// när knappen trycks skall textfilen ingemo valt skickas till användaren



	// lägger till ett textfält
	@FXML
	public void onAddTextfield() {
		AnchorPane pane;

		if (!tabpane.getTabs().isEmpty()) {
			pane = anchorPaneList.get(tabpane.getSelectionModel().getSelectedIndex());
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Meddelande");

			pane.getChildren().add(addnodes.getTextField());
			tabpane.getSelectionModel().getSelectedItem().setContent(pane);
			write.setTextInFile("textfield");
			write.setTextInFile("");
			write.setTextInFile("");
			write.setTextInFile("");
		}
	}

	// stänger en tab

	// lägger till en textarea
	@FXML
	public void onAddTextarea() {
		AnchorPane pane;

		if(!tabpane.getTabs().isEmpty()){
			pane = anchorPaneList.get(tabpane.getSelectionModel().getSelectedIndex());
			pane.getChildren().add(addnodes.getTextArea());
		    tabpane.getSelectionModel().getSelectedItem().setContent(pane);
		    write.setTextInFile("textarea2");
		    write.setTextInFile("");
		    write.setTextInFile("");
		 }		
	}

	@FXML
	public void onSetTime() {

		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Meddelande");
		dialog.setHeaderText("Sätt i text i checkbox :");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			String text = result.get();
			write.setTextInFile("time");
			write.setTextInFile(text);
			System.out.println(text);
		}
	}
	
	@FXML
	public void onDeleteTab(){
	if (tabpane.getTabs().isEmpty()) return;
		
		Tab selectedTab = tabpane.getSelectionModel().getSelectedItem();
		tabpane.getTabs().remove(selectedTab);
	}
	
	// visar en ruta med statistik
	@FXML
	public void onShowStatistics(ActionEvent event) {
		myController.setScreen(Main.statsScreenID);
	}
	
	@FXML
	public void onHandleAdmins(ActionEvent event) {
		
	}
	
	@FXML
	public void onHandleUsers(ActionEvent event) {
	myController.setScreen(Main.userScreenID);
	}
	
	@FXML
	public void onHandleGroups(ActionEvent event) {
	myController.setScreen(Main.groupScreenID);
	
	}
	
	@FXML
	public void onAbout() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("About");
		alert.setHeaderText("Välkommen till Admin!");
		alert.setContentText("Detta är system som används för skapa prov.");
		alert.getButtonTypes().remove(1);
		alert.showAndWait();
	}
}
