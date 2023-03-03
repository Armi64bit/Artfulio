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
import javafx.scene.control.Label;
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

    @FXML
    private Label error_titre;

    @FXML
    private Label error_date;

    @FXML
    private Label error_description;

    @FXML
    private Label error_type;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> listType = FXCollections.observableArrayList("Financiere", "Musicale", "duo");
        type.getItems().addAll(listType);

    }

    @FXML
    void buttonSendDemande(ActionEvent event) {

        Collaboration c = new Collaboration();
        c.setTitre(titre.getText());
        c.setDate_sortie(date_sortie.getValue());
        c.setType_collaboration(type.getValue());
        c.setDescription(description.getText());

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
        System.out.println("valeur de type"+verif_type);
        if (verif_type == null) {
            System.out.println("je suis dans l'erreur");
            error_type.setText("veuillez selectionner une valeur");
            valide = false;
        }

// Valide la date de sortie
        if (!ValidationChamps.validerDate(date_sortie, error_date)) {
            valide = false;
        }

        if (valide) {
            // Traiter le formulaire (par exemple, enregistrer les données)
            System.out.println(c);

            ServCollaboration servcollab = new ServCollaboration();
            if ((servcollab.ajouterCollaboration(c) != -1)) {
                System.out.println("ajout reussi");
                // information("votre demande a bien été envoye", "etat envoie", "bonne journée");
                Email e = new Email();
                try {
                    e.envoyer("michelscoot@gmail.com", LocalDate.now().toString(), "le nom de l'artiste");
                } catch (MessagingException ex) {
                    Logger.getLogger(ServCollaboration.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("ajout echec ajout");
                // warning();
            }
        }

        //******************************************************
    }

}
