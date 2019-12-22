package Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
import Model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddProductController {

    Stage stage;
    Parent scene;

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
    private TextField addProductSearchField;

    @FXML
    private TableView<Part> inventoryPartsTableView;

    @FXML
    private TableColumn<Part, Integer> inventoryPartID;

    @FXML
    private TableColumn<Part, String> inventoryPartName;

    @FXML
    private TableColumn<Part, Integer> inventoryStockLevel;

    @FXML
    private TableColumn<Part, Double> InventoryPrice;

    @FXML
    private TableView<Part> associatedPartsTableView;

    @FXML
    private TableColumn<Part, Integer> associatedPartId;

    @FXML
    private TableColumn<Part, String> associatedPartName;

    @FXML
    private TableColumn<Part, Integer> associatedIStockLevel;

    @FXML
    private TableColumn<Part, Double> associatedPrice;

    @FXML
    void onActionAddPart(ActionEvent event) {

    }

    @FXML
    void onActionDeletePart(ActionEvent event) {

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

        int id = Integer.parseInt(addProductId.getText());
        String name = addProductName.getText();
        double price = Double.parseDouble(addProductPrice.getText());
        int stock = Integer.parseInt(addProductInventory.getText());
        int min = Integer.parseInt(addProductMin.getText());
        int max = Integer.parseInt(addProductMax.getText());

        Inventory.addProduct(new Product(id, name, price, stock, min, max));

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreenView.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionSearchProduct(ActionEvent event) {

    }

}
