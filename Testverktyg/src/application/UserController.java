package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/** 
 * denna klass har till uppgift att koppa samman de andra klasserna som inehåller logik 
 * Controller klassen ska inte innefatta mycket logik
 * klassen innehåller just nu 5 metoder 
 * 
 * **/

public class UserController {
	
	String pathIni = "C:/test.ini";
	double X;
	double Y;
	
	
	@FXML
	private Button backButton;
	@FXML
	private Button nextButton;
	@FXML
	private Button finnishButton;	
	@FXML
	private TabPane tabPane;
	
	// eventsen för knapparna
	@FXML
	public void onBack(ActionEvent event){
		System.out.println("knappen funkar");
	}
	
	@FXML
	public void onNext(ActionEvent event){
		System.out.println("knappen funkar");
	}
	
	@FXML
	public void onFinnish(ActionEvent event){
		readFromTextFile();
		System.out.println("knappen funkar");
	}

	public void readFromTextFile(){
		
		Rectangle rectangle = new Rectangle(1000, 1000);
		rectangle.setFill(Color.TRANSPARENT);
		rectangle.setMouseTransparent(true);
		AnchorPane group = new AnchorPane();
		
		group.getChildren().add(rectangle);	
		
		group.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
		//System.out.println(e.getX());
		//System.out.println(e.getY());
		});
		
	
		
		
		 try(Scanner sc = new Scanner(new File(pathIni))){ 
			 while(sc.hasNextLine() ) {
				 
			String name = sc.nextLine();
			
			 //Sends information to create a combobox on the specified coordinates in the textfile
             if(name.equals("checkbox")){
            	 if(sc.hasNextDouble());
            	   X = sc.nextDouble();
            	   Y = sc.nextDouble();
            	   group.getChildren().add(createCheckbox(X, Y));           	   
            	   tabPane.getSelectionModel().getSelectedItem().setContent(group);
            	      	 
		        
		        }
             //Sends information to create a textfield on the specified coordinates in the textfile
             if(name.equals("textfield")){            	
           	  if(sc.hasNextDouble());
             	   X = sc.nextDouble();
             	   Y = sc.nextDouble();        
             	 group.getChildren().add(createTextField(X, Y));
          	     tabPane.getSelectionModel().getSelectedItem().setContent(group);
			 }
             //Sends information to create a textarea on the specified coordinates in the textfile 
             if(name.equals("textarea")){
           	
           	  if(sc.hasNextDouble());
             	   X = sc.nextDouble();
             	   Y = sc.nextDouble();
             	 group.getChildren().add(createTextArea(X, Y));
          	     tabPane.getSelectionModel().getSelectedItem().setContent(group);
			 }
		    } 
		 }
		    catch (FileNotFoundException e) {
		        
		    }
	}

//Creates checkbox
public CheckBox createCheckbox(double x, double y){	
//	HBox box = new HBox(new CheckBox(), new TextField());
//    box.setAlignment(Pos.BASELINE_CENTER);
//    box.setLayoutX(x);
//    box.setLayoutY(y);
//    return box;			
CheckBox cb = new CheckBox("Svarsalternativ");
cb.setLayoutX(x);
cb.setLayoutY(y);	
return cb;

}

//Creates textfield
public TextField createTextField(double x, double y){
TextField tf = new TextField("Textfält tar emot eventuell kommentar för svarsfältet nedan.");
tf.setEditable(false);
tf.setPrefSize(705, 20);
tf.setLayoutX(x);
tf.setLayoutY(y);
return tf;

}
//Creates textarea
public TextArea createTextArea(double x, double y){
TextArea ta = new TextArea("Textarea");
ta.setPrefSize(705, 135);
ta.setLayoutX(x);
ta.setLayoutY(y);
return ta;

	}
   
}
	

