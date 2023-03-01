/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.Artfulio.gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.MessagingException;
import tn.esprit.Artfulio.entites.Collaboration;
import tn.esprit.Artfulio.services.Email;
import tn.esprit.Artfulio.services.ServCollaboration;

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
    
     private Collaboration c ;
    ServCollaboration servcollab;
    
        /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
             ObservableList<String> listType = FXCollections.observableArrayList("Financiere","Musicale","duo");
             type.getItems().addAll(listType);
              c = new Collaboration();
              servcollab = new ServCollaboration();

    } 

    @FXML
    void buttonSendDemande(ActionEvent event) {

              
        Email e = new  Email();
               try {
                e.envoyer("michelscoot@gmail.com",LocalDate.now().toString(),"le nom de l'artiste");
            } catch (MessagingException ex) {
                Logger.getLogger(ServCollaboration.class.getName()).log(Level.SEVERE, null, ex);
         } 
       
        c.setTitre(titre.getText());
        c.setDate_sortie(date_sortie.getValue());
        c.setType_collaboration(type.getValue());
        c.setDescription(description.getText());
        System.out.println(c);
        if((servcollab.ajouterCollaboration(c) != -1)){
            System.out.println("ajout reussi");
           // information("votre demande a bien été envoye", "etat envoie", "bonne journée");
         }else{
             System.out.println("ajout echec ajout");
           // warning();
        }   
    }
    
   
    
}
