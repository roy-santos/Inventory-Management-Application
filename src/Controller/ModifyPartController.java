package Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
import Model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private RadioButton modPartInHouse;

    @FXML
    private ToggleGroup partSource;

    @FXML
    private RadioButton modPartOutsourced;

    @FXML
    private Label modPartVariableName;

    @FXML
    private TextField partIdField;

    @FXML
    private TextField modPartVariableField;

    @FXML
    private TextField partPriceField;

    @FXML
    private TextField partStockField;

    @FXML
    private TextField partNameField;

    @FXML
    private TextField partMaxField;

    @FXML
    private TextField partMinField;

    @FXML
    void onActionModPartIn(ActionEvent event) {

        modPartVariableName.setText("Machine ID:");
    }

    @FXML
    void onActionModPartOut(ActionEvent event) {

        modPartVariableName.setText("Company Name:");
    }

    @FXML
    void onActionReturnToMainScreen(ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreenView.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionSave(ActionEvent event) throws IOException {

        int id = Integer.parseInt(partIdField.getText());

        for(Part part: Inventory.getAllParts()) {

            if(part.getId() == id) {

                part.setName(partNameField.getText());
                part.setStock(Integer.parseInt(partStockField.getText()));
                part.setPrice(Double.parseDouble(partPriceField.getText()));
                part.setMax(Integer.parseInt(partMaxField.getText()));
                part.setMin(Integer.parseInt(partMinField.getText()));

                if(modPartInHouse.isSelected()) {

                    ((InHouse) part).setMachineId(Integer.parseInt(modPartVariableField.getText()));
                } else {

                    ((Outsourced) part).setCompanyName(modPartVariableField.getText());
                }

            }

        }

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreenView.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    public void sendPartInfo(Part part) {

        if(part instanceof InHouse) {
            modPartInHouse.setSelected(true);
            modPartVariableName.setText("Machine ID:");
            modPartVariableField.setText(String.valueOf(((InHouse) part).getMachineId()));
        } else {
            modPartOutsourced.setSelected(true);
            modPartVariableName.setText("Company Name:");
            modPartVariableField.setText(((Outsourced) part).getCompanyName());
        }

        partIdField.setText(String.valueOf(part.getId()));
        partNameField.setText(part.getName());
        partStockField.setText(String.valueOf(part.getStock()));
        partPriceField.setText(String.valueOf(part.getPrice()));
        partMaxField.setText(String.valueOf(part.getMax()));
        partMinField.setText(String.valueOf(part.getMin()));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
