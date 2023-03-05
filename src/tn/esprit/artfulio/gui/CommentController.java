package tn.esprit.artfulio.gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import  tn.esprit.artfulio.services.commentaireservice;
import  tn.esprit.artfulio.services.UserService;

import  tn.esprit.artfulio.entites.commentaire;
import  tn.esprit.artfulio.entites.User;


/**
 * FXML Controller class
 *
 * @author msi
 */
public class CommentController implements Initializable {

    @FXML
    private ImageView imgprofile;
    @FXML
    private Label usernamecom;
    @FXML
    private ImageView imgbadge;
    @FXML
    private Label id_user;
    @FXML
    private Label txtcom;
    @FXML
    private Label datepost;
    @FXML
    private ImageView delete;
    @FXML
    private Label id_com;
    @FXML
    private ImageView edit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       commentaire c=new commentaire();
//       commentaireservice cs = new  commentaireservice();
//       c=cs.affichercom(54);
//       
//        loadcom(c);
   }    

    
    public void loadcom(commentaire c){
    // 
       
        UserService us= new UserService();
       // c=cs.affichercommentaire().get(0);
        
        User u =us.afficherProfilefb(c.getId_util());
        usernamecom.setText(u.getUsername());
        setpdp(c.getId_util());
       txtcom.setText(c.getTexte());
       datepost.setText(c.getDate_post());
       id_com.setText(""+c.getId_com());
       }
    public void setpdp( int id) {
     User u = new User();
     UserService us = new UserService();
u=us.afficherProfilefb(id);
    File imageFile = new File(u.getImg_user());
    Image image = new Image(imageFile.toURI().toString());
    imgprofile.setImage(image);   
}
    @FXML
   public void delcom(){
       int id= Integer.parseInt(id_com.getText());
       commentaire c = new commentaire(id);
       commentaireservice cs=new commentaireservice();
       cs.supprimercommentaire(c);
       
   }
   public void setinvis(){
       delete.setVisible(false);
               edit.setVisible(false);
   }

   
   
    
}
