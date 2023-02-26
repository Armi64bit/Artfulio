package tn.esprit.artfulio.gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tn.esprit.artfulio.entites.User;
import tn.esprit.artfulio.services.UserService;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class UseritemController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Label username;
    @FXML
    private ImageView imgbadge;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      User u = new User();
     UserService us = new UserService();
    u=us.afficherProfilefb(9);
        setpdp(u);
    }    
    
    public void setpdp(  User u) {
    
     
    File imageFile = new File(u.getImg_user());
    Image image = new Image(imageFile.toURI().toString());
    img.setImage(image);
    username.setText(u.getUsername());
    
      
}
}
