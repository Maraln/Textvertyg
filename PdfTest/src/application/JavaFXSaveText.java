package application;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 

//importera bibloteket

// laddda ner   https://sourceforge.net/projects/itext/  
//för att öppna /skapa pdf importera biblotek se itextpdf-.5.5.8jar


/**
 * @kungen
 */
public class JavaFXSaveText extends Application {
     
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Spara fråger");
       
        TextArea textArea = new TextArea();
 
        Button buttonSave = new Button("Spara");
                 
        buttonSave.setOnAction((ActionEvent event) -> {
          FileChooser fileChooser = new FileChooser();
             
         //   Set extension filter
            FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("PDF-fil",".pdf");
            fileChooser.getExtensionFilters().add(extFilter);
             
          //  Show save file dialog
            File file = fileChooser.showSaveDialog(primaryStage);
             
          if(file != null){
                SaveFile(textArea.getText(), file);
            	saveTopdf(file.getPath(),textArea.getText());
            }
        	
        	
        	// nu kan vi skapa en egen sök väg där vi vill pdf ska finnas i Pdf format
        	

        	
        });
        Group root = new Group();
        
         
        VBox vBox = new VBox();
        vBox.getChildren().addAll(textArea, buttonSave);
         
        root.getChildren().add(vBox);
         
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter;
              
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(JavaFXSaveText.class
                .getName()).log(Level.SEVERE, null, ex);
        }
          
    }// metoden skapas för att spara text
    public void saveTopdf(String path,String text){
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(path));
			document.open();
			Paragraph paragraph = new Paragraph();
			paragraph.add(text);
			document.add(paragraph);
			document.close();
		} catch (Exception e) {

			e.printStackTrace();

		}
    	
    	
    }
     
}