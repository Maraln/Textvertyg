package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;

public class WriteToTextFile {

	private int i;

	private double checkboxY;
	private double checkboxX;
	private double textfieldX;
	private double textfieldY;
	private double textareaX;
	private double textareaY;

	private ArrayList<String> textList = new ArrayList<String>();
	
	private HashMap<Integer, Double> checkBoxMapX = new HashMap<Integer, Double>();
	private HashMap<Integer, Double> checkBoxMapY = new HashMap<Integer, Double>();

	private HashMap<Integer, Double> textFieldMapX = new HashMap<Integer, Double>();
	private HashMap<Integer, Double> textFieldMapY = new HashMap<Integer, Double>();

	private HashMap<Integer, Double> textAreaMapX = new HashMap<Integer, Double>();
	private HashMap<Integer, Double> textAreaMapY = new HashMap<Integer, Double>();

	// konstruktor
	WriteToTextFile() {

	}

	private void SaveFile(File file) {
		int iteratorCheckbox = -1;
		int iteratorTextField = -1;
		int iteratorTextArea = -1;
		System.out.println("checking file");
		try {

			String txt = "", checkTxt;
			FileWriter fileWriter;

			// söker efter keywords som checkbox,textfield eller textarea i
			// textlist arrayen
			for (i = 0; i < textList.size(); i++) {
				checkTxt = textList.get(i);
				if (checkTxt.equals("checkbox")) {
					// varje gång checkbox påträffas i loopen Itererar jag en
					// int för att hålla reda på nyckeln som håller värdet i hashmappen
					iteratorCheckbox++;

					textList.set(i + 1, String.valueOf(checkBoxMapX.get(iteratorCheckbox).intValue()));
					textList.set(i + 2, String.valueOf(checkBoxMapY.get(iteratorCheckbox).intValue()));
				}

				if (checkTxt.equals("textfield")) {
					iteratorTextField++;

					textList.set(i + 1, String.valueOf(textFieldMapX.get(iteratorTextField).intValue()));
					textList.set(i + 2, String.valueOf(textFieldMapY.get(iteratorTextField).intValue()));
				}

				if (checkTxt.equals("textarea2")) {
					iteratorTextArea++;

					textList.set(i + 1, String.valueOf(textAreaMapX.get(iteratorTextArea).intValue()));
					textList.set(i + 2, String.valueOf(textAreaMapY.get(iteratorTextArea).intValue()));
				}
			}

			
			fileWriter = new FileWriter(file);
			for (i = 0; i < textList.size(); i++) {

				txt = textList.get(i) + "\r\n";
				fileWriter.write(txt);
			}
			System.out.println(textList.toString());

			fileWriter.close();

		} catch (IOException ex) {
			Logger.getLogger(WriteToTextFile.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void showFileChooser() {
		FileChooser fileChooser = new FileChooser();
		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("INI files (*.ini)", "*.ini");
		fileChooser.getExtensionFilters().add(extFilter);
		// Show save file dialog
		File file = fileChooser.showSaveDialog(null);
		if (file != null) {
			SaveFile(file);
		}
	}

	public void setTextInFile(String text) {
		textList.add(text);

	}

	public void setCheckboxX(double checkboxX) {
		this.checkboxX = checkboxX;
	}

	public void setCheckboxY(double checkboxY) {
		this.checkboxY = checkboxY;
	}

	public void setTextfieldX(double textfieldX) {
		this.textfieldX = textfieldX;
	}

	public void setTextfieldY(double textfieldY) {
		this.textfieldY = textfieldY;
	}

	public void setTextareaX(double textareaX) {
		this.textareaX = textareaX;
	}

	public void setTextareaY(double textareaY) {
		this.textareaY = textareaY;
	}

	// collision index skickas varje gång en checkbox blir dragen ,
	// creationIndex updateras varje gång en nod skapas
	public void setCheckBoxMap(Integer collisionIndex, Integer creationIndex) {

		// creation index här för att fylla nyckel positionen , value lämmnar
		// jag noll vid tillfället
		checkBoxMapX.put(creationIndex, 0.0);
		checkBoxMapY.put(creationIndex, 0.0);

		// varje gång jag drar i en checkbox kallas denna metod och updaterar
		// hashmapen
		checkBoxMapX.replace(collisionIndex, checkboxX);
		checkBoxMapY.replace(collisionIndex, checkboxY);

		System.out.println("checkbox" + collisionIndex + " X : " + checkBoxMapX.get(collisionIndex) + " \t" + "y : "
				+ checkBoxMapY.get(collisionIndex));
	}

	public void setTextFieldMap(Integer collisionIndex, Integer creationIndex) {

		// creation index här för att fylla nyckel positionen , value lämmnar
		// jag noll vid tillfället
		textFieldMapX.put(creationIndex, 0.0);
		textFieldMapY.put(creationIndex, 0.0);

		// varje gång jag drar i en checkbox kallas denna metod och updaterar
		// hashmapen
		textFieldMapX.replace(collisionIndex, textfieldX);
		textFieldMapY.replace(collisionIndex, textfieldY);

		System.out.println("textfield" + collisionIndex + " X : " + textFieldMapX.get(collisionIndex) + " \t" + "y : "
				+ textFieldMapY.get(collisionIndex));
	}

	public void setTextAreaMap(Integer collisionIndex, Integer creationIndex) {

		// creation index här för att fylla nyckel positionen , value lämmnar
		// jag noll vid tillfället
		textAreaMapX.put(creationIndex, 0.0);
		textAreaMapY.put(creationIndex, 0.0);

		// varje gång jag drar i en checkbox kallas denna metod och updaterar
		// hashmapen
		textAreaMapX.replace(collisionIndex, textareaX);
		textAreaMapY.replace(collisionIndex, textareaY);

		System.out.println("textArea" + collisionIndex + " X : " + textAreaMapX.get(collisionIndex) + " \t" + "y : "
				+ textAreaMapY.get(collisionIndex));
	}

}
