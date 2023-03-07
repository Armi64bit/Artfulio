package tn.esprit.artfulio.gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tn.esprit.artfulio.entites.artwork;
import tn.esprit.artfulio.services.ArtworkService;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class QrController implements Initializable {

    @FXML
    private ImageView qr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  ArtworkService as= new  ArtworkService();
        
  artwork a=new artwork("rufus");
        qrwindow(a);
        // TODO
    }
    
    
public void qrwindow(artwork a){
    ArtworkService as= new ArtworkService();
    artwork ar=as.afficherartwork1(a.getId_artwork());
    
    setim(a.getNom_artwork());
}    
    
public void setim(String id){
   File imageFile = new File("C:\\Users\\msi\\Documents\\GitHub\\Artfulio\\qr_output\\"+id+".png");
    Image image = new Image(imageFile.toURI().toString());
     
            qr.setImage(image);}
}

