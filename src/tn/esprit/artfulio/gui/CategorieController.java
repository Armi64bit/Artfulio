package tn.esprit.artfulio.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tn.esprit.artfulio.entites.User;

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
    @FXML
    private Button profile;
    @FXML
    private Button logout;
    @FXML
    private HBox conrainerim;

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
                conrainerim.getChildren().add(vbox);

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

    
    private void GoTofeed(MouseEvent event) {
         try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            
           // Parent root = FXMLLoader.load(getClass().getResource("feedimage.fxml"));/* Exception */
            FXMLLoader loaderp = new FXMLLoader(getClass().getResource("feed.fxml"));
            Parent root = loaderp.load();
           
           // FeedimageController fic =loaderp.getController();
            //fic.feed();
            //fic.users();
             Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedController.class.getName()).log(Level.SEVERE, null, ex);
        }}

    
 @FXML
    private void profile(ActionEvent event) {
        try {
            int id= User.getCurrent_User().getId_user();
            FXMLLoader loaderp = new FXMLLoader(getClass().getResource("profile.fxml"));
            Object root = loaderp.load();
            ProfileController pc = loaderp.getController();
            pc.setdata(id);
            pc.feedaudio(id);
            pc.feedimg(id);
            pc.feedmusic(id);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene((Parent) root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ArtworkpostController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   @FXML
    private void logout(ActionEvent event) {
        User u= new User();
        User.setCurrent_User(u);
         try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            
           // Parent root = FXMLLoader.load(getClass().getResource("feedimage.fxml"));/* Exception */
            FXMLLoader loaderp = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loaderp.load();
           
           // FeedimageController fic =loaderp.getController();
            //fic.feed();
            //fic.users();
             Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GoTofeedf(ActionEvent event) {
    try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            
           // Parent root = FXMLLoader.load(getClass().getResource("feedimage.fxml"));/* Exception */
            FXMLLoader loaderp = new FXMLLoader(getClass().getResource("feed.fxml"));
            Parent root = loaderp.load();
           
           // FeedimageController fic =loaderp.getController();
            //fic.feed();
            //fic.users();
             Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
