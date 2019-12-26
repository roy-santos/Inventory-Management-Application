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
        for(Part part : allParts) {
            if(part.getId() == partId) {
                return part;
            }
        }
        return null;
    }

    public static Product lookupProduct(int productId) {
        for(Product product : allProducts) {
            if(product.getId() == productId) {
                return product;
            }
        }
        return null;
    }


    public static Part lookupPart(String partName) {
        for(Part part: allParts) {
            if(part.getName().equalsIgnoreCase(partName)) {
                System.out.println(part.getName());
                return part;
            }
        }
        return null;
    }

    public static Product lookupProduct(String productName) {
        for(Product product: allProducts) {
            if(product.getName().equalsIgnoreCase(productName)) {
                System.out.println(product.getName());
                return product;
            }
        }
        return null;
    }

    public static void updatePart(int index, Part part) {
        // refer back to int index parameter on UML diagram
    }

    public static void updateProduct(int index, Product product) {
        // refer back to int index parameter on UML diagram
    }

    public static void deletePart(Part part) {
        allParts.remove(part);

    }

    public static void deleteProduct(Product product) {
        allProducts.remove(product);
    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }

}
