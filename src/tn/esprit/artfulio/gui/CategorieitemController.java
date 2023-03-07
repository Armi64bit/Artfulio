package tn.esprit.artfulio.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;

import tn.esprit.artfulio.entites.artwork;
import tn.esprit.artfulio.entites.sous_categorie;
import tn.esprit.artfulio.services.ArtworkService;
import tn.esprit.artfulio.services.SouscategorieService;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class CategorieitemController implements Initializable {

    @FXML
    private Label nom_sous_cat;
    @FXML
    private HBox items;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        feedimg();
        // TODO
    }    
    
    
    public void feedimg() {

        ArtworkService as = new ArtworkService();

        List<artwork> listart = new ArrayList<>();
        sous_categorie liss = new sous_categorie();
       List <sous_categorie> liss2 = new ArrayList<>();
        
        // users();
        try {

 SouscategorieService sc=new SouscategorieService();
 
            listart = as.afficherartwork(3);
            for (int i = 0; i < listart.size(); i++) {
            liss= sc.affichersouscategorienom(listart.get(i).getId_type());
   liss2= sc.affichersouscategorie(sc.affichersouscategorienom(liss.getNom_sous_categorie()).getNom_sous_categorie());

             // nom_sous_cat.setText(liss.getNom_sous_categorie());  
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("portfolioitem.fxml"));
                Pane vbox = loader.load();
                PortfolioitemController artcont = loader.getController();
                artcont.setdata(listart.get(i));
                items.getChildren().add(vbox);

            }
        } catch (Exception e) {
        }
    }
}
