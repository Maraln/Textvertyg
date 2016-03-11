package application;

import javafx.application.Platform;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/** 
 * Denna klass har till uppgift att koppa samman de andra klasserna som inehåller logik 
 * Controller klassen ska inte innefatta mycket logik
 * klassen innehåller just nu 5 metoder.
 * 
 * **/
public class AdminController implements ControlledScreen {
	
	private ScreenController myController;
	
	@FXML
	private TabPane tabpane ;
	@FXML
	private Button doneButton;
	@FXML
	private Button addTextfieldButton;
	@FXML
	private Button addCheckboxButton;
	@FXML
	private Button addTabButton;
	@FXML
	private Button statsButton;
	
	private AnchorPane pane = new AnchorPane();
	
	@Override
	public void setScreenParent(ScreenController screenPage) {
		myController = screenPage;
		
	}

	@FXML
	public void onClose() {
		Platform.exit();
	}
	
	@FXML
	public void onAddCheckbox(ActionEvent event){
		CheckBox standardCbx =	new CheckBox();
		standardCbx.setSnapToPixel(true);
		standardCbx.setText("option 1");

		standardCbx.addEventHandler(MouseEvent.MOUSE_RELEASED, e->{
			standardCbx.setLayoutX(e.getX());
			standardCbx.setLayoutY(e.getY());
			System.out.println(e.getX());
			System.out.println(e.getY());
		});
		pane.getChildren().add(standardCbx);
		tabpane.getSelectionModel().getSelectedItem().setContent(pane);

		
	}
	
	@FXML
	public void onAddTab(ActionEvent event){
		pane.setStyle("-fx-background-color:red;");	
		pane.setPrefSize(tabpane.getPrefWidth(), tabpane.getPrefHeight());	
		tabpane.getTabs().add(new Tab("new tab",pane));
	}
	
	@FXML
	public void onDone(ActionEvent event){		
		System.out.println("knappen funkar");
	}
	
	@FXML
	public void onShowStatistics(ActionEvent event){
		myController.setScreen(Main.screen2ID);
	}
	
	@FXML
	public void addTextfieldRealeased(){
		TextField txt = new TextField();
		txt.setMaxWidth(100);
		txt.setMaxHeight(25);
	
		txt.addEventHandler(MouseEvent.MOUSE_RELEASED, e ->{
			txt.setLayoutX(e.getX());
			txt.setLayoutY(e.getY());
		});
		
		pane.getChildren().add(txt);
		tabpane.getSelectionModel().getSelectedItem().setContent(pane);
	}
}
