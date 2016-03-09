import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextInputDialog;

/** 
 * denna klass har till uppgift att koppa samman de andra klasserna som inehåller logik 
 * Controller klassen ska inte innefatta mycket logik
 * klassen innehåller just nu 5 metoder 
 * 
 * **/

public class AdminController {
    private AddNodes addNodes = new AddNodes();
    
    @FXML
    private Button doneButton;
    @FXML
    private Button addTextfieldButton;
    @FXML
    private Button addCheckboxButton;
    @FXML
    private Button addTabButton;
    @FXML
    private Button statsButton;
    @FXML
    private TabPane tabPane;
        
    // event för meny-valen
    @FXML
    public void onClose(ActionEvent event) {
        Platform.exit();
    }
	
    // eventsen för knapparna
    @FXML
    public void onAddTextfield(ActionEvent event) {
        System.out.println("dsada");
    }

    @FXML
    public void onAddCheckbox(ActionEvent event) {
        tabPane.getSelectionModel().getSelectedItem().setContent(addNodes.getCheckboxes());
    }

    @FXML
    public void onAddTab(ActionEvent event) { 
        Tab tab = new Tab("Page " + (tabPane.getTabs().size() + 1));
        tabPane.getTabs().add(tab);
    }

    @FXML
    public void onDone(ActionEvent event) {
        System.out.println("knappen funkar");
    }

    @FXML
    public void onShowStatistics(ActionEvent event) {
        System.out.println("knappen funkar");
    }
}
