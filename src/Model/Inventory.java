package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    public static void addPart(Part part) {

        allParts.add(part);

    }

    public static void addProduct(Product product) {

        allProducts.add(product);

    }

    public static Part lookupPart(int partId) {

    }

    public static Product lookupProduct(int productId) {

    }

    public static Part lookupPart(String partName) {

    }

    public static Product lookupProduct(String productName) {

    }

    public static void updatePart(int index, Part part) {
        // refer back to int index parameter on UML diagram
    }

    public static void updateProduct(int index, Product product) {
        // refer back to int index parameter on UML diagram
    }

    public static void deletePart(Part part) {

    }

    public static void deleteProduct(Product product) {

    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }

}
