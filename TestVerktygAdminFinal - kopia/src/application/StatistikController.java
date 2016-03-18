package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class StatistikController implements ControlledScreen {
	
	private ScreenController myController;
	
	
	@Override
	public void setScreenParent(ScreenController screenPage) {
		myController = screenPage;	
	}
	
	@FXML
	public void onGoToMainScreen(ActionEvent event){
		myController.setScreen(Main.mainScreenID);
	}
	
}
