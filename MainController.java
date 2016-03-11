package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {
 @FXML
 private Label lblStatus;
 
 @FXML
 private TextField txtUserName;
 
 @FXML
 private TextField txtPassword;
 
 public void Login(ActionEvent event) throws IOException{
	 if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass")){
		 lblStatus.setText("login success");
		 Stage primaryStage = new Stage();
		 
		 Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,400,400);
		
			primaryStage.setScene(scene);
			primaryStage.show();
	 } else{
		 lblStatus.setText("login field");
		 
		 
	 }
	
	 
 }
}
