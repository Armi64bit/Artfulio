///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package services;
//
///**
// *
// * @author Asus
// */
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TableColumn;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import tn.esprit.artfulio.entites.Artwork;
//
//public class ShoppingCartController {
//
//    @FXML
//    private TableView<Artwork> cartTable;
//
//    @FXML
//    private Label totalLabel;
//
//    private ObservableList<Artwork> cartItems = FXCollections.observableArrayList();
//
//    public void initialize() {
//        TableColumn<Artwork, String> productNameCol = new TableColumn<>("Product Name");
//        productNameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
//
//        TableColumn<Artwork, Double> priceCol = new TableColumn<>("Price");
//        priceCol.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
//
//
//        cartTable.getColumns().addAll(productNameCol, priceCol);
//        cartTable.setItems(cartItems);
//    }
//
//    public void addItem(Artwork artwork) {
//        boolean found = false;
//        for (Artwork i : cartItems) {
//            if (i.getNom_artwork().equals(artwork.getNom_artwork())) {
//                found = true;
//                break;
//            }
//        }
//        if (!found) {
//            cartItems.add(artwork);
//        }
//        updateTotal();
//    }
//
//    public void removeItem(Artwork artwork) {
//        cartItems.remove(artwork);
//        updateTotal();
//    }
//
//    public void checkout() {
//        // Implement checkout logic here
//    }
//
//    private void updateTotal() {
//        double total = 0.0;
//        for (Artwork artwork : cartItems) {
//            total += artwork.getPrix_artwork();
//        }
//        totalLabel.setText(String.format("$%.2f", total));
//    }
//}
