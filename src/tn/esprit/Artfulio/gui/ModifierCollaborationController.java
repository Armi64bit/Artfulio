/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.Artfulio.gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.Artfulio.entites.Collaboration;
import tn.esprit.Artfulio.gui.Data;
import tn.esprit.Artfulio.services.ServCollaboration;

/**
 * FXML Controller class
 *
 * @author lelou
 */
public class ModifierCollaborationController implements Initializable {

    
     @FXML
    private ChoiceBox<String> typeModif;

    @FXML
    private TextField titreModif;

    @FXML
    private TextArea descrip_modif;

    @FXML
    private DatePicker date_fin_modif;

    @FXML
    private Button button_valider_modif;

    @FXML
    private Button button_annuler_modif;
    
    
     //variable locale
    Collaboration collab ;
    ServCollaboration sercol;
    
    
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         collab = new Collaboration();
        sercol = new ServCollaboration();
        
         ObservableList<String> listType = FXCollections.observableArrayList("Financiere", "artistique","production","égérie","formation");
        typeModif.getItems().addAll(listType);
               
        if(Data.titre.isEmpty()){
            titreModif.setText("ce n'est pas arrivé ");
        }
        else{
            titreModif.setText(Data.titre);
            descrip_modif.setText(Data.description);
        } 
    }    
    
    @FXML
    void annulerModification(ActionEvent event) {
        
        Data.information( "notification", "aucune modification éffectué");
           try {
            // Charger la scène2.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menuCollaboration.fxml"));
            Parent root = loader.load();

            // Afficher la scène2
            Scene scene = new Scene(root);
            Stage stage = (Stage) button_annuler_modif.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void validerModif(ActionEvent event) {
        
       collab.setDescription(descrip_modif.getText());
       collab.setTitre(titreModif.getText());
       collab.setType_collaboration(typeModif.getValue());
       collab.setDate_sortie(date_fin_modif.getValue());
       collab.setId_collaboration(Data.id);
       
       if(sercol.modifierCollaboration(collab)){
           System.out.println("l'id modification est: "+Data.id);
           Data.information( "information","demande de validation envoyer");
           try {
            // Charger la scène2.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menuCollaboration.fxml"));
            Parent root = loader.load();

            // Afficher la scène2
            Scene scene = new Scene(root);
            Stage stage = (Stage) button_valider_modif.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
           //mettre le status en attente
       }else{
           Data.warning("erreur modification", "erreur");
       }

    }
    
    public void afficherModif(Collaboration c){
        titreModif.setText(c.getTitre());
         typeModif.setValue(c.getType_collaboration());
      date_fin_modif.setValue(c.getDate_sortie());
        descrip_modif.setText(c.getDescription());
        
    }
    

}
