package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
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
	private ArrayList<Integer> storeComboBoxKeywordIndex = new ArrayList<Integer>();

	private HashMap<Integer,Double> checkBoxMapX = new HashMap<Integer,Double>();
	private HashMap<Integer,Double> checkBoxMapY = new HashMap<Integer,Double>();
	
	private HashMap<Integer,Double> textFieldMapX = new HashMap<Integer,Double>();
	private HashMap<Integer,Double> textFieldMapY = new HashMap<Integer,Double>();
	
	private HashMap<Integer,Double> textAreaMapX = new HashMap<Integer,Double>();
	private HashMap<Integer,Double> textAreaMapY = new HashMap<Integer,Double>();
	 
	// konstruktor
	WriteToTextFile() {
		
	}

	

	private void SaveFile(File file) {
		System.out.println("checking file");
		try {
			
			
			String txt = "" , checkTxt;
			FileWriter fileWriter;
			
			for(i = 0; i < textList.size(); i++){
				checkTxt = textList.get(i);
				if(textList.get(i).equals("checkbox")){
					storeComboBoxKeywordIndex.add(i);
					System.out.println(storeComboBoxKeywordIndex.toString());
			//		textList.set(storeComboBoxKeywordIndex.get(i)+1,checkBoxMapX.)
				}
			}
			fileWriter = new FileWriter(file);
			for(i = 0; i < textList.size(); i++){
				
				txt = textList.get(i)+ "\r\n";
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
	
	public void setCheckboxY(double checkboxY){
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
	
	// collision index skickas varje gång en checkbox blir dragen , creationIndex updateras varje gång en nod skapas
	public void setCheckBoxMap(Integer collisionIndex , Integer creationIndex ){
		
	// creation index här för att fylla nyckel positionen , value lämmnar jag noll vid tillfället
		checkBoxMapX.put(creationIndex, 0.0);
		checkBoxMapY.put(creationIndex, 0.0);
	
		// varje gång jag drar i en checkbox kallas denna metod och updaterar hashmapen
		checkBoxMapX.replace(collisionIndex,checkboxX);
		checkBoxMapY.replace(collisionIndex,checkboxY);
		
		System.out.println("checkbox"+collisionIndex +" x : " + checkBoxMapX.values() + " \t" +  "y : " + checkBoxMapY.values());
	}
	
	public void setTextFieldMap(Integer index){

	}
	
	public void setTextAreaMap(Integer index){
		
	}
	

	
}
