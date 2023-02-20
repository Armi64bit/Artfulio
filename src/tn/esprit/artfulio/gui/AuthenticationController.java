/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import tn.esprit.artfulio.entites.Personne;
import java.awt.Desktop;
import java.net.URISyntaxException;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author karra
 */
public class AuthenticationController implements Initializable {

    @FXML
    private Label lb_name;
    
    private BorderPane bp;
    
    @FXML
    private Label lb_Bio;
    
    
 
    @FXML
    private Button btnig;
    @FXML
    private Button btnfb;
    @FXML
    private Button btnTwitter;
    @FXML
    private Button btnytb;
    @FXML
    private Label id_twitter;
     private Stage stage;
 private Scene scene;
 private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           Personne p = new Personne(22, "Esprit", "Ariana");
       // PersonneCRUD pcd = new PersonneCRUD();
         //List<Personne> pp=pcd.listeDesEntites();
         //Personne first=pp.get(0);
         
        //lb_name.setText(first.getNom());
        //lb_Bio.setText(first.getPrenom());
       //lb_Bio.setText(first.getPrenom());
        
        
        
    }    
  @FXML
    private Button btnac;
    
        
    
    @FXML
    public void ig()
    {   try {
    Desktop.getDesktop().browse(new URL("https://www.instagram.com").toURI());
} catch (IOException e) {
    e.printStackTrace();
} catch (URISyntaxException e) {
    e.printStackTrace();
}
    
    }

@FXML
    public void fb()
    {   try {
    Desktop.getDesktop().browse(new URL("https://www.fb.com").toURI());
} catch (IOException e) {
    e.printStackTrace();
} catch (URISyntaxException e) {
    e.printStackTrace();
}
    
    }

@FXML
    public void twitter()
    {   try {
    Desktop.getDesktop().browse(new URL("https://www.twitter.com").toURI());
} catch (IOException e) {
    e.printStackTrace();
} catch (URISyntaxException e) {
    e.printStackTrace();
}
    
    }
@FXML
    public void youtube()
    {   try {
    Desktop.getDesktop().browse(new URL("https://www.youtube.com").toURI());
} catch (IOException e) {
    e.printStackTrace();
} catch (URISyntaxException e) {
    e.printStackTrace();
}
    
    }
   
    private void edit(ActionEvent event){
     loadpage("editprofile.fxml");}
    private void loadpage(String page) {
        
        Parent root =null;
        try {
            root=FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        bp.setCenter(root);
    }
    
    
    @FXML
    public void switcheditprofile(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("editprofile.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }

    @FXML
    private void test(ActionEvent event) {
    }
}
