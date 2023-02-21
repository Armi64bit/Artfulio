/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a17.gui;

import edu.connexion3a17.entities.Personne;
import edu.connexion3a17.services.PersonneCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author karra
 */
public class AuthenticationController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private Button btnValider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void savePerson(ActionEvent event) {
        try {
            String nom = tfNom.getText();
            String prenom = tfPrenom.getText();
            Personne p = new Personne(3, nom, prenom);
            PersonneCRUD pcd = new PersonneCRUD();
            pcd.ajouterEntitee(p);
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Details.fxml"));
            Parent root = loader.load();
            DetailsController dc = loader.getController();
            dc.setResNom(nom);
            dc.setResPrenom(prenom);
            tfNom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
