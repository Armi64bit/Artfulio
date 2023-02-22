/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piartfulio;

import entities.Collaboration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.ServCollaboration;

/**
 * FXML Controller class
 *
 * @author lelou
 */
public class FXMLCollaborateurController implements Initializable {

      //---- changement de page
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    //----- info collab
    @FXML
    private TextField ccollab1;
    @FXML
    private TextField ccollab2;
    @FXML
    private DatePicker cdateDebut;
    @FXML
    private DatePicker cdateFin;
    @FXML
    private Label confirmationLabel;
    
    //----- affichage collaborateur
    @FXML
    private ListView<Collaboration> listViewCollaborator;
    @FXML
    private Label labelCurrentCollaborator;
    
    ServCollaboration servcollab ;
    Collaboration c ;
    Collaboration currentCollaboration ;
    
    //modification
    private int idmofif;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        servcollab = new ServCollaboration();
        c = new Collaboration();
    }    
    
     public void validerCollaboration(ActionEvent event) {
        
        c.setUser1(ccollab1.getText());
        c.setUser2(ccollab2.getText());
        c.setDate_debut(cdateDebut.getValue());
        c.setDate_fin(cdateFin.getValue());
       
       

      //  System.out.println("le chemin: "+this.getClass().getResource("FXMLafficherCollaborateur.fxml"));
        if(servcollab.ajouterCollaboration(c) != -1){
            System.out.println(c);   
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
        }else{
            System.out.println("il n'ya rien dans c");
       }
      //  int nombre = Integer.valueOf(valeur_id.getValue());

      //  String mot = String.valueOf(valeur_id2.getValue());

       // valeur_id3.setValue(String.valueOf(nombre));		//modifier la valeur d'un textFile

        // Appeler la méthode de validation du modèle
        // boolean estValide = utilisateurValide();

    }
    
      public void ViewCollection(ActionEvent event){
        
        listViewCollaborator.getItems().addAll(servcollab.afficherCollaboration());
        listViewCollaborator.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Collaboration>(){
            @Override
            public void changed(ObservableValue<? extends Collaboration> observable, Collaboration oldValue, Collaboration newValue) {
                currentCollaboration = listViewCollaborator.getSelectionModel().getSelectedItem();
                labelCurrentCollaborator.setText(currentCollaboration.getUser1()+" -->  "+currentCollaboration.getUser2()+currentCollaboration.getId());
                c.setId(currentCollaboration.getId());
            }
            
        });
    }
      
        public void modifer(ActionEvent event){       
       
       try {
                root = FXMLLoader.load(getClass().getResource("FXMLModifierCollaborateur.fxml"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            //    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();             
    }
        
        public void validerModification(ActionEvent event){
        c.setUser1(ccollab1.getText());
        c.setUser2(ccollab2.getText());
        c.setDate_debut(cdateDebut.getValue());
        c.setDate_fin(cdateFin.getValue());   
        //c.setId(idmofif);
       
        System.out.println("le chemin: "+this.getClass().getResource("FXMLafficherCollaborateur.fxml"));
            System.out.println("id du collab est: "+c.getId());
        if(servcollab.modifierCollaboration(c)){
            System.out.println(c);   
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
        }else{
            System.out.println("il n'ya rien dans c");
       }
        }
}

    

