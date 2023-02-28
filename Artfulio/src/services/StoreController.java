/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
import javafx.scene.layout.VBox;
import static services.ArtworkService.myconnex;
import tn.esprit.artfulio.entites.artwork;

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
    
    private List<artwork> list = new ArrayList<>();
    public List<artwork> afficherartwork() {
          
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        list= afficherartwork();
        System.out.println(list);
      
        int column = 0;
        int row = 0;
        try {
            System.out.println(  list.size());
         
        for (int i=0; i<list.size(); i++){
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("../Presentation/Art_FXML.fxml"));
            System.out.println(fxmlloader.getLocation());
            AnchorPane anchorPane = fxmlloader.load();
            System.out.println(list);
            System.out.println(anchorPane);
            ArtController artController = fxmlloader.getController();
            artController.setData(list.get(i));
            if(column == 3){
                column =0;
                row++;
            }
            grid.add(anchorPane, column++, row);
            GridPane.setMargin(anchorPane, new Insets(10));
        }}
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    


}
