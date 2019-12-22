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

        Inventory.addPart(part1);
        Inventory.addPart(part2);

        Product product1 = new Product(10,"Product1",19.99,5,1,5);

        Inventory.addProduct(product1);

        launch(args);
    }
}
