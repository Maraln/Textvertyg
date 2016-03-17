package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
    public static String mainScreenID = "main";
    public static String mainScreenFile = "AdminView.fxml";
    public static String statsScreenID = "statistik";
    public static String statsScreenFile = "StatistikView.fxml";
    public static String groupScreenID = "group";
    public static String groupScreenFile = "GroupView.fxml";
    public static String userScreenID = "users";
    public static String userScreenFile = "UserView.fxml";

	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		 	ScreenController mainContainer = new ScreenController();
			mainContainer.loadScreen(Main.mainScreenID, Main.mainScreenFile);
	        mainContainer.loadScreen(Main.statsScreenID, Main.statsScreenFile);
	        mainContainer.loadScreen(Main.groupScreenID, Main.groupScreenFile);
	        mainContainer.loadScreen(Main.userScreenID, Main.userScreenFile);
	     
	        
	        mainContainer.setScreen(Main.mainScreenID);
	        
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
