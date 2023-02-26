/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.arfulio.gui;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.MessagingException;
import javax.management.Notification;
import tn.esprit.arfulio.entites.Collaboration;
import tn.esprit.arfulio.services.Email;
import tn.esprit.arfulio.services.ServCollaboration;

/**
 * FXML Controller class
 *
 * @author lelou
 */
public class DemandeCollaborationController implements Initializable {

       @FXML
    private Label labelcol;

    @FXML
    private Button buttonSendDemande;

    @FXML
    private DatePicker date_sortie;

    @FXML
    private TextField titre;

    @FXML
    private TextArea description;

    @FXML
    private ComboBox<String> combType = new ComboBox<>();
    
   // private String[] tabtype = {"financier, artistique, musicale"};
    
    private Collaboration c ;
    ServCollaboration servcollab;

    /**
     * Initializes the controller class.
     */
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // TODO
         c = new Collaboration();
         servcollab = new ServCollaboration();
     ObservableList<String> listType = FXCollections.observableArrayList("age","poids");
     combType.setItems(listType);
              
       //type.getItems().addAll("beignet","haricot");
    }    
    
   @FXML
    //    c.setDescription(description.getText());
    public void buttonSendDemande(ActionEvent event){
        
        Email e = new  Email();
               try {
                e.envoyer("michelscoot@gmail.com",LocalDate.now().toString(),"le nom de l'artiste");
            } catch (MessagingException ex) {
                Logger.getLogger(ServCollaboration.class.getName()).log(Level.SEVERE, null, ex);
         } 
       
        c.setTitre(titre.getText());
        c.setDate_sortie(date_sortie.getValue());
        c.setType_collaboration("oui");
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
    
    @FXML
    void selectCombType(ActionEvent event) {

    }
     public void warning(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("c'est valider");
        alert.setContentText("la cest le text a afficher");
        alert.setHeaderText("le dessous");
        alert.showAndWait(); 
    }
    
        public void information(String message,String titre, String autre){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titre);
        alert.setContentText(message);
        alert.setHeaderText(autre);
        alert.showAndWait(); 
    }
        
     /*   public void switchScene(){
             try {
                root = FXMLLoader.load(getClass().getResource("FXMLafficherCollaborateur.fxml"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            //    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        }
     */
}

