package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.Group;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddNodes {
	
	String pathIni = "C:/test.ini";
	double X;
	double Y;

	
	
	public void readFromTextFile(){
		
		Group group = new Group();
		
		
		
		 try(Scanner sc = new Scanner(new File(pathIni))){ 
			 while(sc.hasNextLine() ) {
				 
			String name = sc.nextLine();
			
			 //Sends information to create a combobox on the specified coordinates in the textfile
             if(name.equals("checkbox")){
            	 if(sc.hasNextDouble());
            	   X = sc.nextDouble();
            	   Y = sc.nextDouble();
            	   group.getChildren().add(createCheckbox(X, Y));
            	 //  tabPane.getSelectionModel().getSelectedItem().setContent(group);
            	      	 
		        
		        }
             //Sends information to create a textfield on the specified coordinates in the textfile
             if(name.equals("textfield")){
            	 System.out.println("textfält");
           	  if(sc.hasNextDouble());
             	   X = sc.nextDouble();
             	   Y = sc.nextDouble();
             	   System.out.println(X);
             	  System.out.println(Y);
      //       	   root.getChildren().add(createTextField(X,Y));
			 }
             //Sends information to create a textarea on the specified coordinates in the textfile 
             if(name.equals("textarea")){
            	 System.out.println("textarea");
           	  if(sc.hasNextDouble());
             	   X = sc.nextDouble();
             	   Y = sc.nextDouble();
             	   System.out.println(X);
             	  System.out.println(Y);
       //      	   root.getChildren().add(createTextArea(X,Y));
			 }
		    } 
		 }
		    catch (FileNotFoundException e) {
		        
		    }
	}

//Creates checkbox
public CheckBox createCheckbox(double x, double y){
CheckBox cb = new CheckBox("Checkbox");
cb.setLayoutX(x);
cb.setLayoutY(y);	
return cb;

}
//Creates textfield
public TextField createTextField(double x, double y){
TextField tf = new TextField("Textfield");
tf.setPrefSize(100, 20);

tf.setLayoutX(x);
tf.setLayoutY(y);
return tf;
}
//Creates textarea
public TextArea createTextArea(double x, double y){
TextArea ta = new TextArea("Textarea");
ta.setPrefSize(100, 20);

ta.setLayoutX(x);
ta.setLayoutY(y);
return ta;

	}
}
	

