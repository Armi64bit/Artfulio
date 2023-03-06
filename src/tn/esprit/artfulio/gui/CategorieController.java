package tn.esprit.artfulio.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
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
public class CategorieController implements Initializable {

    @FXML
    private BorderPane parent;
    @FXML
    private Button chnagemode;
    @FXML
    private ImageView home;
    @FXML
    private Button chnagemode1;
    @FXML
    private ImageView darkorlight;
    @FXML
    private HBox portfoliocontainer;
    @FXML
    private HBox musiccontainer;
    @FXML
    private HBox portfoliocontainer1;
    @FXML
    private HBox videocontainer;
    private HBox portfoliocontainer11;
    @FXML
    private HBox sousvid;
    @FXML
    private Label nom_sous_cat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        feedmusic();
        feedimg();
        feedimgg();
    }    

    @FXML
    private void GoToprofile(MouseEvent event) {
    }

    @FXML
    private void GoTofeed(ActionEvent event) {
    }

    @FXML
    private void changemode(ActionEvent event) {
    }
    
    public void feedimgg() {//feedimg

       ArtworkService as = new ArtworkService();

        List<artwork> listart = new ArrayList<>();
        sous_categorie liss =new sous_categorie();
        List<sous_categorie> liss2 =new ArrayList<>();
        
        
        // users();
        try {

 SouscategorieService sc=new SouscategorieService();
            listart = as.afficherartwork(2);
            for (int i = 0; i < listart.size(); i++) {
             //   liss= sc.affichersouscategorienom(listart.get(i).getId_type());
           //liss2= sc.affichersouscategorie(sc.affichersouscategorienom(liss.getNom_sous_categorie()).getNom_sous_categorie());
             // nom_sous_cat.setText(liss2.getType_sous_categorie());  
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("portfolioitem.fxml"));
                Pane vbox = loader.load();
                PortfolioitemController artcont = loader.getController();
                artcont.setdata(listart.get(i));
                musiccontainer.getChildren().add(vbox);

            }
        } catch (Exception e) {
        }
    }
    
    public void feedimg() {//feedmusic

       ArtworkService as = new ArtworkService();

        List<artwork> listart = new ArrayList<>();
        sous_categorie liss =new sous_categorie();
        List<sous_categorie> liss2 =new ArrayList<>();
        
        
        // users();
        try {

 SouscategorieService sc=new SouscategorieService();
            listart = as.afficherartwork(4);
            for (int i = 0; i < listart.size(); i++) {
                //liss= sc.affichersouscategorienom(listart.get(i).getId_type());
           //liss2= sc.affichersouscategorie(sc.affichersouscategorienom(liss.getNom_sous_categorie()).getNom_sous_categorie());
             // nom_sous_cat.setText(liss2.getType_sous_categorie());  
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("portfolioitem.fxml"));
                Pane vbox = loader.load();
                PortfolioitemController artcont = loader.getController();
                artcont.setdata(listart.get(i));
                musiccontainer.getChildren().add(vbox);

            }
        } catch (Exception e) {
        }
    }
    
    public void feedmusic() {//feedvideo

       ArtworkService as = new ArtworkService();

        List<artwork> listart = new ArrayList<>();
        sous_categorie liss =new sous_categorie();
        List<sous_categorie> liss2 =new ArrayList<>();
        
        
        // users();
        try {

 SouscategorieService sc=new SouscategorieService();
            listart = as.afficherartwork(3);
            for (int i = 0; i < listart.size(); i++) {
             //   liss= sc.affichersouscategorienom(listart.get(i).getId_type());
          // liss2= sc.affichersouscategorie(sc.affichersouscategorienom(liss.getNom_sous_categorie()).getNom_sous_categorie());
             // nom_sous_cat.setText(liss2.getType_sous_categorie());  
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("portfolioitem.fxml"));
                Pane vbox = loader.load();
                PortfolioitemController artcont = loader.getController();
                artcont.setdata(listart.get(i));
                videocontainer.getChildren().add(vbox);

            }
        } catch (Exception e) {
        }
    }
}
