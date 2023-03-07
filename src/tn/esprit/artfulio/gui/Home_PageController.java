/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import tn.esprit.artfulio.entites.artwork;
import tn.esprit.artfulio.utils.MyConnection;

/**
 *
 * @author CALLO
 */
public class Home_PageController implements Initializable {
        @FXML
    private ImageView ItemImg;

    @FXML
    private VBox chosenItemCard;

    @FXML
    private Label statusArticle;
    
      @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;
    
     public static Connection myconnex
           = MyConnection.getInstance().getConnection();
    
    private List<artwork> list = new ArrayList<>();
    
    public List<artwork> afficherartwork(){
            try {
            String req = "SELECT * FROM `artwork`";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
             while (res.next()) {
                artwork s = new artwork();
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

      private void setChosenArt(artwork artwork){
    statusArticle.setText(artwork.getNom_artwork());
   // artPricelabel.setText(String.valueOf(artwork.getPrix_artwork()));
    
      }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    
    
    
}
