/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import tn.esprit.artfulio.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import tn.esprit.artfulio.entites.artwork;
//import entities.Cart;
import java.io.File;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import tn.esprit.artfulio.services.MyListener;

/**
 *
 * @author Asus
 */
public class StoreController implements Initializable {

    private artwork selectedArtwork;
    private Image image;
    public static ObservableList<artwork> Items;
    @FXML
    private ImageView artImg;

    @FXML
    private Label artNamelabe;

    @FXML
    private Label artPricelabel;

    @FXML
    private VBox chosenArtcard;
    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;

    @FXML
    private TextField txtBarSearch;
     public static Connection myconnex
            = MyConnection.getInstance().getConnection();
    
    @FXML
    private void handleCartButton(MouseEvent event) throws IOException {
    
        
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Cart.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            //QrController q=fxmlLoader.getController();
           // ArtworkService as= new ArtworkService();
            stage.setTitle("Cart");
            stage.setScene(new Scene(root1));
            stage.show();
             System.out.println(Items);
        } catch (IOException ex) {
            Logger.getLogger(StoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private Button addTocart;
    //public static Cart cart = new Cart();
    private MyListener MyListener;
  


//    @FXML
//    private void addToCart() {
//        if (selectedArtwork == null) {
//            // No artwork selected, show an error message to the user
//            Alert alert = new Alert(AlertType.ERROR);
//            alert.setHeaderText("No artwork selected");
//            alert.setContentText("Please select an artwork to add to your cart.");
//            alert.showAndWait();
//            return;
//        }
//
//        // Add the selected artwork to the cart
//        cart.addItem(selectedArtwork);
//
//        // Show a confirmation message to the user
//        Alert alert = new Alert(AlertType.INFORMATION);
//        alert.setHeaderText("Artwork added to cart");
//        alert.setContentText(selectedArtwork.getNom_artwork() + " has been added to your cart.");
//        alert.showAndWait();
//        Items = cart.getItems();
//        System.out.println(Items);
//    }
    private List<artwork> list = new ArrayList<>();

    public List<artwork> afficherartwork() {

        try {
            
            String req = "SELECT * FROM `store`";

            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);

           while (res.next()) {
                artwork p = new artwork();
                p.setId_artwork(res.getInt("id_produit"));
                p.setNom_artwork(res.getString("nom_artwork"));
                p.setPrix_artwork(res.getFloat("prix_artwork"));
                p.setImg_artwork(res.getString("img_artwork"));
               

                list.add(p);
            }
        } catch (SQLException ex) {
        }
        return list;
    }

   
public void setImage(String imagePath) {
    File file = new File(imagePath);
    Image image = new Image(file.toURI().toString());
    artImg.setImage(image);
}
    private void setChosenArt(artwork artwork) {
        artNamelabe.setText(artwork.getNom_artwork());
        artPricelabel.setText(String.valueOf(artwork.getPrix_artwork()));
         setImage(artwork.getImg_artwork());
         selectedArtwork = artwork;
    }

    @FXML
    private void handleSearch() {
        String searchText = txtBarSearch.getText().toLowerCase();

        
        FilteredList<artwork> filteredList = new FilteredList<>(FXCollections.observableArrayList(list));
        filteredList.setPredicate(artwork -> artwork.getNom_artwork().toLowerCase().contains(searchText));

       
        grid.getChildren().clear();
        int column = 0;
        int row = 1;
        for (artwork artwork : filteredList) {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("../GUI/Art_FXML.fxml"));

            try {
                AnchorPane anchorPane = fxmlloader.load();

                ArtController artController = fxmlloader.getController();
                artController.setData(artwork, MyListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        list = afficherartwork();
        if (list.size() > 0) {
            setChosenArt(list.get(0));
            MyListener = new MyListener() {
                @Override
                public void onClickListener(artwork artwork) {
                    setChosenArt(artwork);

                }

            };
        }

        int column = 0;
        int row = 1;
        try {

            for (int i = 0; i < list.size(); i++) {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("../GUI/Art_FXML.fxml"));

                AnchorPane anchorPane = fxmlloader.load();

                ArtController artController = fxmlloader.getController();
                artController.setData(list.get(i), MyListener);
                if (column == 3) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
