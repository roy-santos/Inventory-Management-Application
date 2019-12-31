package InventoryManagerMain;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
import Model.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../View/MainScreenView.fxml"));
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(new Scene(root, 1110, 442));
        primaryStage.show();
    }

    public static void main(String[] args) {

        Part part1 = new InHouse(1, "Part1", 5.99, 3,1,2, 1234);
        Part part2 = new Outsourced(2,"Part2", 3.44, 5,1,19,"Joe's");
        Part part3 = new InHouse(3, "Part3", 3.99, 13,10,20, 1234);
        Part part4 = new Outsourced(4,"Part14", 10.95, 25,15,30,"FlanCrest Enterprise");

        Inventory.addPart(part1);
        Inventory.addPart(part2);
        Inventory.addPart(part3);
        Inventory.addPart(part4);

        Product product1 = new Product(10,"Product1",19.99,5,1,5);
        Product product2 = new Product(11,"Product2",29.99,12,10,15);
        Product product3 = new Product(12,"Product3",49.99,6,5,20);

        Inventory.addProduct(product1);
        Inventory.addProduct(product2);
        Inventory.addProduct(product3);

        launch(args);
    }
}
