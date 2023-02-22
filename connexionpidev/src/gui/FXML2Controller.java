/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.Categorie;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import services.CategorieService;

/**
 * FXML Controller class
 *
 * @author CALLO
 */
public class FXML2Controller implements Initializable {

    @FXML
    private Label test;
    @FXML
    private TableView<?> commande;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> produit;
    @FXML
    private TableColumn<?, ?> client;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> quantite;
    @FXML
    private TableColumn<?, ?> prix;
    @FXML
    private TextField search;
    @FXML
    private TableView<Categorie> tv;
    @FXML
    private TableColumn<Categorie, String> coltype;
    @FXML
    private TableColumn<Categorie, String> coldescription;
    @FXML
    private TableColumn<Categorie, String> coldepart;
    @FXML
    private TableColumn<Categorie, String> coldispo;
    @FXML
    private TableColumn<Categorie, String> colnum;
    @FXML
    private Label e_nom;
    @FXML
    private TextField txtdate;
    @FXML
    private Label e_mail;
    @FXML
    private TextField txtdestination;
    @FXML
    private Label e_password;
    @FXML
    private TextField txtdepart;
    @FXML
    private Label e_telephone;
    @FXML
    private TextField txtdispo;
    @FXML
    private Label e_prenom;
    @FXML
    private Button btnSupp;
    @FXML
    private Button btnmod;
    @FXML
    private Button btnajout;
    @FXML
    private Button closeb;

    /**
     * Initializes the controller class.
     */
    
    CategorieService sl= new CategorieService();
          List <Categorie> l2= new ArrayList<Categorie>();
           ObservableList <Categorie> ls;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ls = FXCollections.observableArrayList();
        coltype.setCellValueFactory(new PropertyValueFactory<Categorie, String>("nom_categorie"));
       coldescription.setCellValueFactory(
                new PropertyValueFactory<Categorie, String>("image_categorie"));
        coldepart.setCellValueFactory(
                new PropertyValueFactory<Categorie, String>("video"));
        coldispo.setCellValueFactory(
                new PropertyValueFactory<Categorie, String>("audio_categorie"));
        
       
   
        System.out.println("aaa"+ls);
      //  tv_liraison.setItems(ls.get(i));
       tv.setItems(ls);
       tv.isEditable();
            //System.out.println(ls);
        
        
        
        
    }    

    @FXML
    private void delete(ActionEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void addCategorie(ActionEvent event) {
        
        if(txtdate.getText().isEmpty()||txtdestination.getText().isEmpty()||txtdepart.getText().isEmpty() ||txtdispo.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(null, "verifer les champs");  
        }
          
        else
        {
        String Date = txtdate.getText();
        String Destination  = txtdestination.getText();
        String Depart = txtdepart.getText();
        String Dispo = txtdispo.getText();
        
        
         
        Categorie c = new Categorie(txtdate.getText(), txtdestination.getText() ,  txtdepart.getText(),txtdispo.getText());
        CategorieService sc = new CategorieService();
        sc.ajouter(c);
                    JOptionPane.showMessageDialog(null, "ajout avec succes");
        txtdate.clear();
        txtdestination.clear();
        txtdepart.clear();
        txtdispo.clear();
        }
        
        
        ls.addAll(sl.afficher());
         tv.setItems(ls);
       
       
         JOptionPane.showMessageDialog(null, "affichage avec succes");
        
        
}
        
        
    @FXML
    private void Close(ActionEvent event) {
    }
    
}
