package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
    public static String screen1ID = "main";
    public static String screen1File = "AdminView.fxml";
    public static String screen2ID = "statistik";
    public static String screen2File = "StatistikView.fxml";

	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		 	ScreenController mainContainer = new ScreenController();
			mainContainer.loadScreen(Main.screen1ID, Main.screen1File);
	        mainContainer.loadScreen(Main.screen2ID, Main.screen2File);
	     
	        
	        mainContainer.setScreen(Main.screen1ID);
	        
	        Group root = new Group();
	        root.getChildren().addAll(mainContainer);
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
