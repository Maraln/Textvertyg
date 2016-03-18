package application;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class AddNodes {

	private double orgSceneX, orgSceneY;
	private double orgTranslateX, orgTranslateY;
	int checkboxIndex = -1;
	int textFieldIndex = -1;
	int textAreaIndex = -1;
	
	private ArrayList<TextArea> textareaList = new ArrayList<TextArea>();
	private ArrayList<TextField> textfieldList = new ArrayList<TextField>();
	private ArrayList<CheckBox> checkboxList = new ArrayList<CheckBox>();

	ContextMenu cm = new ContextMenu();

	WriteToTextFile write;

	AddNodes(WriteToTextFile write) {
		this.write = write;

		MenuItem menuItemDelete = new MenuItem("Delete");
		cm.getItems().add(menuItemDelete);

	}

	// retunerar en checkbox
	public CheckBox getCheckbox(String checkboxText) {

		CheckBox checkbox = new CheckBox(checkboxText);
		checkboxList.add(checkbox);
		checkboxIndex++;
		// skickat ett index ++ varje gång en nod skapas för checkbox
		
		System.out.println("checkbox index : " + checkboxIndex);
		// här är en eventhandler för checkboxen som bir skapad
		// evnthandlers uppgift i detta fall är att få orginal positionen av
		// noden
		checkbox.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
			orgSceneX = e.getSceneX();
			orgSceneY = e.getSceneY();
			orgTranslateX = ((CheckBox) (e.getSource())).getTranslateX();
			orgTranslateY = ((CheckBox) (e.getSource())).getTranslateY();
			((CheckBox) (e.getSource())).toFront();
		});
		// skapar en eventhandler så att man kan dra i noden för att ändra
		// posistion
		checkbox.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
			double offsetX = e.getSceneX() - orgSceneX;
			double offsetY = e.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;
			((CheckBox) (e.getSource())).setTranslateX(newTranslateX);
			((CheckBox) (e.getSource())).setTranslateY(newTranslateY);
	//		write.setCheckBoxMap(determineCollisionForCheckBox(newTranslateX, newTranslateY),checkboxIndex);
	//		write.setCheckboxX(newTranslateX);
	//		write.setCheckboxY(newTranslateY);

		});
		
		checkbox.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
			double offsetX = e.getSceneX() - orgSceneX;
			double offsetY = e.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;
			((CheckBox) (e.getSource())).setTranslateX(newTranslateX);
			((CheckBox) (e.getSource())).setTranslateY(newTranslateY);
			write.setCheckBoxMap(determineCollisionForCheckBox(newTranslateX, newTranslateY),checkboxIndex);
			write.setCheckboxX(newTranslateX);
			write.setCheckboxY(newTranslateY);

		});

		return checkbox;
	}



	// att dra i textarean fungerar ej , returnerar en textarea
	public TextArea getTextArea() {
		TextArea textarea = new TextArea();
		textAreaIndex++;
		textareaList.add(textarea);
		textarea.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
			TextArea ta = (TextArea) e.getSource();

			orgSceneX = e.getSceneX();
			orgSceneY = e.getSceneY();
			orgTranslateX = ta.getTranslateX();
			orgTranslateY = ta.getTranslateY();

			ta.toFront();
		});

		textarea.addEventFilter(MouseEvent.MOUSE_DRAGGED, e -> {
			TextArea ta = (TextArea) e.getSource();

			double offsetX = e.getSceneX() - orgSceneX;
			double offsetY = e.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;
			ta.setTranslateX(newTranslateX);
			ta.setTranslateY(newTranslateY);
			
		//	write.setTextAreaMap(determineCollisionForTextArea(newTranslateX, newTranslateY),textAreaIndex);
		//	write.setTextareaX(newTranslateX);
		//	write.setTextareaY(newTranslateY);
		});
		
		textarea.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> {
			TextArea ta = (TextArea) e.getSource();

			double offsetX = e.getSceneX() - orgSceneX;
			double offsetY = e.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;
			ta.setTranslateX(newTranslateX);
			ta.setTranslateY(newTranslateY);
			
			write.setTextAreaMap(determineCollisionForTextArea(newTranslateX, newTranslateY),textAreaIndex);
			write.setTextareaX(newTranslateX);
			write.setTextareaY(newTranslateY);
		});

		return textarea;
	}
	
	

	public TextField getTextField() {
		TextField txt = new TextField();
		txt.setPrefWidth(705);
		txt.setPrefHeight(20);
		
		textfieldList.add(txt);		
		textFieldIndex++;
		
	
		// här är en eventhandler för checkboxen som bir skapad
		// evnthandlers uppgift i detta fall är att få orginal positionen av
		// noden
		txt.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
			orgSceneX = e.getSceneX();
			orgSceneY = e.getSceneY();
			orgTranslateX = ((TextField) (e.getSource())).getTranslateX();
			orgTranslateY = ((TextField) (e.getSource())).getTranslateY();
			((TextField) (e.getSource())).toFront();
		});

		// skapar en eventhandler så att man kan dra i noden för att ändra
		// posistion
		txt.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {

			double offsetX = e.getSceneX() - orgSceneX;
			double offsetY = e.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;
			((TextField) (e.getSource())).setTranslateX(newTranslateX);
			((TextField) (e.getSource())).setTranslateY(newTranslateY);
		//	write.setTextFieldMap(determineCollisionForTextField(newTranslateX, newTranslateY),textFieldIndex);
		//	write.setTextfieldX(newTranslateX);
		//	write.setTextfieldY(newTranslateY);
			
		});
		
		
		txt.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {

			double offsetX = e.getSceneX() - orgSceneX;
			double offsetY = e.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;
			((TextField) (e.getSource())).setTranslateX(newTranslateX);
			((TextField) (e.getSource())).setTranslateY(newTranslateY);
			write.setTextFieldMap(determineCollisionForTextField(newTranslateX, newTranslateY),textFieldIndex);
			write.setTextfieldX(newTranslateX);
			write.setTextfieldY(newTranslateY);
			
		});
		return txt;
	}
	
	
	public Integer determineCollisionForTextField(double x, double y) {
		Node node;
		for (int i = 0; i < textfieldList.size(); i++) {
			node = textfieldList.get(i);
			if (node.getBoundsInParent().intersects((new Rectangle(x, y, 1, 1)).getBoundsInParent())) {

				return i;
			}
		}
		return null;
	}

	// funktionen kollar efter kollistion för textarea och retunerar index av
	// den listan som kollas igenom
	public Integer determineCollisionForTextArea(double x, double y) {
		Node node;
		for (int i = 0; i < textareaList.size(); i++) {
			node = textareaList.get(i);
			if (node.getBoundsInParent().intersects((new Rectangle(x, y, 1, 1)).getBoundsInParent())) {

				return i;
			}
		}
		return null;
	}

	// funktionen kollar efter kollistion för comboBox
	public Integer determineCollisionForCheckBox(double x, double y) {
		Node node;
		for (int i = 0; i < checkboxList.size(); i++) {
			node = checkboxList.get(i);
			if (node.getBoundsInParent().intersects((new Rectangle(x, y, 1, 1)).getBoundsInParent())) {

				return i;
			}
		}
		return null;
	}

	public Tab getNewTab(AnchorPane pane) {

		return new Tab("new Tab", pane);
	}
}
