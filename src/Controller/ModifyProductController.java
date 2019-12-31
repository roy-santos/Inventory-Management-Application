package Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProductController implements Initializable {

    Stage stage;
    Parent scene;
    ObservableList<Part> tempAssociatedPartsList = FXCollections.observableArrayList();

    @FXML
    private TextField productIdField;

    @FXML
    private TextField productNameField;

    @FXML
    private TextField productStockField;

    @FXML
    private TextField productPriceField;

    @FXML
    private TextField productMaxField;

    @FXML
    private TextField productMinField;

    @FXML
    private TextField partSearchField;

    @FXML
    private TableView<Part> inventoryPartsTableView;

    @FXML
    private TableColumn<Part, Integer> inventoryPartId;

    @FXML
    private TableColumn<Part, String> inventoryPartName;

    @FXML
    private TableColumn<Part, Integer> inventoryStockLevel;

    @FXML
    private TableColumn<Part, Double> inventoryPrice;

    @FXML
    private TableView<Part> associatedPartsTableView;

    @FXML
    private TableColumn<Part, Integer> associatedPartId;

    @FXML
    private TableColumn<Part, String> associatedPartName;

    @FXML
    private TableColumn<Part, Integer> associatedStockLevel;

    @FXML
    private TableColumn<Part, Double> associatedPrice;

    @FXML
    void onActionAddPart(ActionEvent event) {

        int id = Integer.parseInt(productIdField.getText());

        for(Product product: Inventory.getAllProducts()) {
            if(product.getId() == id) {
                product.getAllAssociatedParts().add(inventoryPartsTableView.getSelectionModel().getSelectedItem());
            }
        }

    }

    @FXML
    void onActionDeletePart(ActionEvent event) {

        int id = Integer.parseInt(productIdField.getText());

        for(Product product: Inventory.getAllProducts()) {
            if (product.getId() == id) {
                product.getAllAssociatedParts().remove(associatedPartsTableView.getSelectionModel().getSelectedItem());
            }
        }
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

        int id = Integer.parseInt(productIdField.getText());


        for(Product product: Inventory.getAllProducts()) {
            if(product.getId() == id) {

                product.setName(productNameField.getText());
                product.setStock(Integer.parseInt(productStockField.getText()));
                product.setPrice(Double.parseDouble(productPriceField.getText()));
                product.setMax(Integer.parseInt(productMaxField.getText()));
                product.setMin(Integer.parseInt(productMinField.getText()));
            }

        }

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreenView.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionSearchPart(ActionEvent event) {

        inventoryPartsTableView.setItems(Inventory.getAllParts());

    }

    public void sendProductInfo(Product product) {

        // Set product info fields
        productIdField.setText(Integer.toString(product.getId()));
        productNameField.setText(product.getName());
        productStockField.setText(Integer.toString(product.getStock()));
        productPriceField.setText(Double.toString(product.getPrice()));
        productMaxField.setText(Integer.toString(product.getMax()));
        productMinField.setText(Integer.toString(product.getMin()));

        // Set associated parts table view
        associatedPartsTableView.setItems(product.getAllAssociatedParts());

        // Fill associated parts column with values

        associatedPartId.setCellValueFactory(new PropertyValueFactory<>("id"));
        associatedPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        associatedStockLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
        associatedPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Set Parts table view
        inventoryPartsTableView.setItems(Inventory.getAllParts());

        // Fill Parts column with values
        inventoryPartId.setCellValueFactory(new PropertyValueFactory<>("id"));
        inventoryPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        inventoryStockLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
        inventoryPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

    }

}
