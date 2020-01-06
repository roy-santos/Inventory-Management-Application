package Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import javax.xml.ws.handler.LogicalHandler;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddPartController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private RadioButton addPartInHouse;

    @FXML
    private ToggleGroup partSource;

    @FXML
    private RadioButton addPartOutsourced;

    @FXML
    private Label addPartvariableLabel;

    @FXML
    private TextField addPartID;
    @FXML
    private TextField addPartName;

    @FXML
    private TextField addPartInventory;

    @FXML
    private TextField addPartPrice;

    @FXML
    private TextField addPartMax;

    @FXML
    private TextField addPartMin;

    @FXML
    private TextField addPartVariableField;

    @FXML
    void onActionAddPartIn(ActionEvent event) {

        addPartvariableLabel.setText("Machine ID:");
    }

    @FXML
    void onActionAddPartOut(ActionEvent event) {

        addPartvariableLabel.setText("Company Name:");
    }

    @FXML
    void onActionReturnToMainScreen(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Changes wont be saved, continue?");
        alert.setTitle("CONFIRMATION");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/MainScreenView.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }

    @FXML
    void onActionSave(ActionEvent event) throws IOException {

            int id = Inventory.getAllParts().size() + 1;
            String name = addPartName.getText();
            double price = Double.parseDouble(addPartPrice.getText());
            int stock = Integer.parseInt(addPartInventory.getText());
            int min = Integer.parseInt(addPartMin.getText());
            int max = Integer.parseInt(addPartMax.getText());

            if (stock < max && stock > min) {

                if (addPartInHouse.isSelected()) {

                    int machineId = Integer.parseInt(addPartVariableField.getText());
                    Inventory.addPart(new InHouse(id, name, price, stock, min, max, machineId));
                } else {

                    String companyName = addPartVariableField.getText();
                    Inventory.addPart(new Outsourced(id, name, price, stock, min, max, companyName));
                }

                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/view/MainScreenView.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Please make sure that inventory quantity is greater than minimum and less than the maximum value.");
                alert.showAndWait();
            }


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
