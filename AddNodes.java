import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddNodes {

	public VBox getCheckboxes(){
		
		VBox checkboxContainer = new VBox();
		
		for(int i = 0; i < 5; i++){
		 CheckBox checkbox = new CheckBox();
		 Group checkGroup = new Group();
		 
		 checkbox.setText("fasfsa");
		 
		 checkGroup.getChildren().add(checkbox);
		 
		 checkboxContainer.getChildren().add(checkGroup);
		}
		
		return checkboxContainer;
	}

}