package tn.esprit.artfulio.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tn.esprit.artfulio.entites.User;
import tn.esprit.artfulio.entites.artwork;
import tn.esprit.artfulio.entites.sous_categorie;
import tn.esprit.artfulio.services.ArtworkService;
import tn.esprit.artfulio.services.SouscategorieService;
import tn.esprit.artfulio.services.StoreService;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class PortfolioitemController implements Initializable {

    @FXML
    private Label datepost;
    @FXML
    private ImageView Imgpost;
    @FXML
    private Label id_art;
    @FXML
    private HBox nom_sous_cat;
    @FXML
    private Label noms;
    @FXML
    private Button sell;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

public void setdata(artwork a) {
 
 
//Image img= new Image(getClass().getResourceAsStream(a.getImg_artwork()));
//Image pdp= new Image(getClass().getResourceAsStream("logo.png"));
setImage(a.getImg_artwork());
//setpdp(a.getId_artist());
   // Imgpost.setImage(img);
  //imgprofile.setImage(pdp);
   Date currentDate = a.getDate();
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(currentDate);

   // String date =DateFormat.format(a.getDate());
    datepost.setText(dateString);
    //txtcaption.setText(a.getDescription_artwork());
      //  setartistename(a.getId_artist());
       SouscategorieService sc=new SouscategorieService();
        sous_categorie liss =new sous_categorie();

  sous_categorie liss2 =new sous_categorie();
     if (User.getCurrent_User().getId_user()!=a.getId_artist()){sell.setVisible(false);}

  
  
       liss= sc.affichersouscategorienom(a.getId_type());
           liss2= sc.affichersouscategorienom(sc.affichersouscategorienom(liss.getNom_sous_categorie()).getNom_sous_categorie());
              noms.setText("@"+liss2.getType_sous_categorie());      
       id_art.setText(""+a.getId_artwork());
    
}
public void setImage(String imagePath) {
    File imageFile = new File(imagePath);
    Image image = new Image(imageFile.toURI().toString());
    Imgpost.setImage(image);
      
}

    @FXML
    private void qr(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("qr.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            QrController q=fxmlLoader.getController();
            ArtworkService as= new ArtworkService();
            int idart= Integer.parseInt(id_art.getText());
         artwork a=as.afficherartwork1(idart);
            q.qrwindow(a);
            stage.setTitle(a.getNom_artwork());
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void preview(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("preview.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            PreviewController q=fxmlLoader.getController();
            ArtworkService as= new ArtworkService();
            int idart= Integer.parseInt(id_art.getText());
         artwork a=as.afficherartwork1(idart);
            q.qrwindow(a);
            stage.setTitle(a.getNom_artwork());
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void sell(ActionEvent event) {
        StoreService ss= new StoreService();
        ArtworkService as= new ArtworkService();
        int idart= Integer.parseInt(id_art.getText());
        artwork a= as.afficherartwork1(idart);
        if(ss.ajouterArt(a)!=-1){
        Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Artwork ajouté");
           // alert.setContentText("Please select an artwork to add to your cart.");
            alert.showAndWait();}
        
    }
    
}
