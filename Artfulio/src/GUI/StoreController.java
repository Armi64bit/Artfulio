/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utils.MyConnection;
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


import entities.Artwork;
import java.sql.Connection;
import javafx.scene.image.Image;

import services.MyListener;


/**
 *
 * @author Asus
 */
public class StoreController implements Initializable{
    

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
    
    private MyListener MyListener;
    public static Connection myconnex
           = MyConnection.getInstance().getConnection();
    
    
    
    private List<Artwork> list = new ArrayList<>();
    public List<Artwork> afficherartwork() {
        
          
    try {
        
            String req = "SELECT * FROM `artwork`";
            
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
           
            while (res.next()) {
                Artwork s = new Artwork();
                s.setNom_artwork(res.getString("nom_artwork"));
                s.setDescription_artwork(res.getString("description_artwork"));
                s.setLien_artwork(res.getString("lien_artwork"));
                s.setImg_artwork(res.getString("img_artwork"));
                s.setPrix_artwork(res.getFloat("prix_artwork"));
                s.setId_artist(res.getInt("id_artist"));
                s.setDimension_artwork(res.getFloat("dimension_artwork"));
                s.setDate(res.getDate("date"));
                s.setId_type(res.getInt("id_type"));

  

               list.add(s);
            }
       
       } catch (SQLException ex) {
        }
        return list;
    }
    private void setChosenArt(Artwork artwork){
    artNamelabe.setText(artwork.getNom_artwork());
    artPricelabel.setText(String.valueOf(artwork.getPrix_artwork()));
   // image = new Image(getClass().getResourceAsStream(artwork.getImg_artwork()));
   //fruitImg.setImage(image);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        list= afficherartwork();
        if (list.size() > 0) {
            setChosenArt(list.get(0));
            MyListener = new MyListener() {
                @Override
                public void onClickListener(Artwork artwork) {
                    setChosenArt(artwork);
                }
            
          

                };
                    }
            
        
      
        int column = 0;
        int row = 1;
        try {
            System.out.println(  list.size());
         
        for (int i=0; i<list.size(); i++){
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("../Presentation/Art_FXML.fxml"));
            System.out.println(fxmlloader.getLocation());
            AnchorPane anchorPane = fxmlloader.load();
           
            ArtController artController = fxmlloader.getController();
            artController.setData(list.get(i),MyListener);
            if(column == 3){
                column =0;
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
        }}
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    


}
