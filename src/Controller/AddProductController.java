package Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
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

public class AddProductController implements Initializable {

    Stage stage;
    Parent scene;
    ObservableList<Part> tempAssociatedPartsList = FXCollections.observableArrayList();

    @FXML
    private TextField addProductId;

    @FXML
    private TextField addProductName;

    @FXML
    private TextField addProductInventory;

    @FXML
    private TextField addProductPrice;

    @FXML
    private TextField addProductMax;

    @FXML
    private TextField addProductMin;

    @FXML
    private TextField addProductPartSearchField;

    @FXML
    private TableView<Part> inventoryPartsTableView;

    @FXML
    private TableColumn<Part, Integer> inventoryPartID;

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
        tempAssociatedPartsList.add(inventoryPartsTableView.getSelectionModel().getSelectedItem());
    }

    @FXML
    void onActionDeletePart(ActionEvent event) {
        tempAssociatedPartsList.remove(associatedPartsTableView.getSelectionModel().getSelectedItem());
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

        int id = Inventory.getAllProducts().size() + 1;
        String name = addProductName.getText();
        double price = Double.parseDouble(addProductPrice.getText());
        int stock = Integer.parseInt(addProductInventory.getText());
        int min = Integer.parseInt(addProductMin.getText());
        int max = Integer.parseInt(addProductMax.getText());

        Inventory.addProduct(new Product(id, name, price, stock, min, max));

        for(Part tempPart : tempAssociatedPartsList) {
            Inventory.getAllProducts().get(Inventory.getAllProducts().size() - 1).addAssociatedPart(tempPart);
        }

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreenView.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionSearchProductPart(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set Parts table view
        inventoryPartsTableView.setItems(Inventory.getAllParts());

        // Fill Parts column with values
        inventoryPartID.setCellValueFactory(new PropertyValueFactory<>("id"));
        inventoryPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        inventoryStockLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
        inventoryPrice.setCellValueFactory(new PropertyValueFactory<>("price"));


        // Set associated parts table view
        associatedPartsTableView.setItems(tempAssociatedPartsList);

        // Fill associated parts column with values

        associatedPartId.setCellValueFactory(new PropertyValueFactory<>("id"));
        associatedPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        associatedStockLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
        associatedPrice.setCellValueFactory(new PropertyValueFactory<>("price"));


    }

}
