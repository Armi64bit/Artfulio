/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import tn.esprit.artfulio.entites.Artiste_Collaboration;
import tn.esprit.artfulio.entites.Collaboration;
import tn.esprit.artfulio.services.Email;
import tn.esprit.artfulio.services.ServArtiste_collaboration;
import tn.esprit.artfulio.services.ServCollaboration;
import tn.esprit.artfulio.services.UserService;


import tn.esprit.artfulio.utils.SessionManager;
import tn.esprit.artfulio.entites.User;



/**
 * FXML Controller class
 *
 * @author lelou
 */
public class DemandeCollaborationController implements Initializable {

    @FXML
    private ChoiceBox<String> type = new ChoiceBox<String>();

    @FXML
    private TextField titre;

    @FXML
    private TextArea description;

    @FXML
    private DatePicker date_sortie;

    @FXML
    private Button buttonSendDemande;

    @FXML
    private Label error_titre;

    @FXML
    private Label error_date;

    @FXML
    private Label error_description;

    @FXML
    private Label error_type;
    
    @FXML
    private Button buttonAnnulerDemande;
    @FXML
    private Label id_artiste;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> listType = FXCollections.observableArrayList("Financiere", "artistique","production","égérie","formation");
        type.getItems().addAll(listType);

    }
  //  public void set
public void setid_artiste(int id){
id_artiste.setText(""+id);}
    @FXML
    void buttonSendDemande(ActionEvent event) {

        Collaboration c = new Collaboration();
        c.setTitre(titre.getText());
        c.setDate_sortie(date_sortie.getValue());
        c.setType_collaboration(type.getValue());
        c.setDescription(description.getText());
        //############## p.get nom profile ############################
       c.setNom_user(User.getCurrent_User().getUsername());
        c.setEmail_user(User.getCurrent_User().getEmail_user());
        
        //###########################################################################
        
        boolean valide = true;

        //controle saisie**********************************************
        // Valide le champ titre
        if (!ValidationChamps.validerChamps(titre, error_titre)) {
            valide = false;
        }
        // Valide le champ description
        if (!ValidationChamps.validerChamps(description, error_description)) {
            valide = false;
        }

        // Valide le champ type
        String verif_type = type.getValue();
        if (verif_type == null) {
            error_type.setText("veuillez selectionner une valeur");
            valide = false;
        }

            // Valide la date de sortie
        if (!ValidationChamps.validerDate(date_sortie, error_date)) {
            valide = false;
        }

        if (valide) {
            // Traiter le formulaire (par exemple, enregistrer les données)
            ServCollaboration servcollab = new ServCollaboration();
            if ((servcollab.ajouterCollaboration(c) != -1)) {
                Data.information("Votre demande de collaboration est en cours d'envoie veuillez patienter!", "Reussi");
                
                //##################################################################
               List<Collaboration> listCol = servcollab.afficherCollaboration();
               int id_col = listCol.get(listCol.size() - 1).getId_collaboration();
                Artiste_Collaboration artCol = new Artiste_Collaboration();
             //   artCol.setId_artiste(Data.id_profil);
            int id = Integer.parseInt(id_artiste.getText());
             //setid_artiste(id);
             artCol.setId_artiste(id);
//artCol.setId_artiste(5);
                artCol.setId_collaboration(id_col);
                
                ServArtiste_collaboration svArtCol = new ServArtiste_collaboration();
                if(svArtCol.ajouterArtister_Collaboration(artCol) != -1){
                    System.out.println("artist - col add with success");  
                }else{
                    System.out.println("mata lors de l'ajout");
                }
                //##################################################################
                Email e = new Email();
                try {
                   // e.envoyer(c.getEmail_user(), LocalDate.now().toString(), c.getNom_user());
                   UserService us=new UserService();
                    e.envoyer(us.afficherProfilefb(id).getEmail_user(), LocalDate.now().toString(), User.getCurrent_User().getUsername());
             
                    ///id_col pour amelioer le mail
                    
                } catch (MessagingException ex) {
                    Logger.getLogger(ServCollaboration.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                // changement de scene
                
                switchScene("menuCollaboration.fxml", buttonSendDemande);
            } else {
                Data.warning("Probleme lors de l'ajout dans la base de donnée", "echec ajout");
            }
        }

        //******************************************************
    }
    
    @FXML
    void AnnulerDemande(ActionEvent event) {
          Data.information( "demande annulé", "notification");
           try {
            // Charger la scène2.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menuCollaboration.fxml"));
            Parent root = loader.load();

            // Afficher la scène2
            Scene scene = new Scene(root);
            Stage stage = (Stage) buttonAnnulerDemande.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void switchScene(String nomScene, Button but){
         try {
            // Charger la scène2.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nomScene));
            Parent root = loader.load();

            // Afficher la scène2
            Scene scene = new Scene(root);
            Stage stage = (Stage) but.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
