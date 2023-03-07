/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.reflect.Reflection;
import tn.esprit.artfulio.entites.Collaboration;
import tn.esprit.artfulio.gui.Data;
import tn.esprit.artfulio.gui.ModifierCollaborationController;
import tn.esprit.artfulio.services.ServCollaboration;
import tn.esprit.artfulio.utils.SessionManager;
import  tn.esprit.artfulio.entites.User;


/**
 * FXML Controller class
 *
 * @author lelou
 */
public class MenuCollaborationController implements Initializable {

    @FXML
    private Button button_mofidier;
    @FXML
    private Button btn_annulerCol;
    @FXML
    private TableView<Collaboration> tableGeneralCollab;
    @FXML
    private TableColumn<Collaboration, String> col_artiste;
    @FXML
    private TableColumn<Collaboration, String> col_titre;
    @FXML
    private TableColumn<Collaboration, String> col_type;
    @FXML
    private TableColumn<Collaboration, String> col_status;
    @FXML
    private Label label_periode;
    @FXML
    private Label label_descrition;
    @FXML
    private TextField Recherche;

    @FXML
    private Label label_titre;
    
    @FXML
    private Label label_email;
    
    @FXML
    private Button btn_imprimer;
        
    @FXML
    private AnchorPane anchorPieChart = new AnchorPane();
    
       @FXML
    private AnchorPane anctype  = new AnchorPane();;

    @FXML
    private PieChart pieType = new PieChart();
    
    @FXML
    private Button btn_retour;

    Stage stage;
    Scene scene;
    Parent root;

    /**
     * Initializes the controller class.
     */
    //variable locale
    int myIndex;
    int id;
    ServCollaboration svc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tableGeneralCollab.setFixedCellSize(50);
        svc = new ServCollaboration();
        afficherGraphique();
       // anchorPieChart.getChildren().add(chartType);
        affichagerTableMenu();
    }

    /**
     *
     * @param event
     */
    @FXML
    public void getAnnuler(ActionEvent event) {
        Collaboration c = new Collaboration();
        ServCollaboration serv = new ServCollaboration();
        c.setType_collaboration(Data.description);
        c.setTitre(Data.titre);
        c.setId_collaboration(1);
        System.out.println("le titre : " + c.getTitre());
        System.out.println("l'id est: " + c.getId_collaboration());
        System.out.println("le tla description : " + c.getDescription());
        c.setId_collaboration(6);

        if (serv.supprimerCollaboration(c)) {
            Data.information("la suppression réussit", "fini");
        } else {
            Data.warning(" échec de la suppression", "Erreur");
        }
        afficherGraphique();
        affichagerTableMenu();
    }

    /**
     *
     * @param event
     */
    //*********************************************************************************************
    @FXML
    private void getViewModifier(ActionEvent event) {
        try {
            // Charger la scène2.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierCollaboration.fxml"));
            Parent root = loader.load();

            // Passer les données de nom et prénom à la scène2
            ModifierCollaborationController modifController = loader.getController();
            Collaboration c = new Collaboration();
            ServCollaboration sercol = new ServCollaboration();
            c.setTitre(Data.titre);
            c.setType_collaboration(Data.description);
            //on recupere toute les info dune collaboration
            System.out.println("le titre "+Data.titre);
            System.out.println("le type "+Data.type);
         
            c= sercol.recherche(Data.titre,Data.type);
            Data.id = c.getId_collaboration();
            Data.nom=c.getNom_user();
            Data.email=c.getEmail_user();
            modifController.afficherModif(c);

            // Afficher la scène2
            Scene scene = new Scene(root);
            Stage stage = (Stage) button_mofidier.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //**********************************************************************************************
    public void affichagerTableMenu() {
        ObservableList<Collaboration> listCol = FXCollections.observableArrayList();
        ServCollaboration servcol = new ServCollaboration();

        for (Collaboration c : servcol.afficherCollaboration(User.getCurrent_User().getUsername())) {
            listCol.add(c);
        }

        tableGeneralCollab.setItems(listCol);
        col_artiste.setCellValueFactory(new PropertyValueFactory<Collaboration, String>("titre"));
        col_titre.setCellValueFactory(new PropertyValueFactory<Collaboration, String>("titre"));
        col_type.setCellValueFactory(new PropertyValueFactory<Collaboration, String>("type_collaboration"));
        col_status.setCellValueFactory(new PropertyValueFactory<Collaboration, String>("status"));

        //****************** recherche *****************************************
        FilteredList<Collaboration> filterdata = new FilteredList<Collaboration>(listCol, btn_annulerCol -> true);

        //2. set filter predicate whenever rhe filter changes.
        Recherche.textProperty().addListener((obbervable, oldValue, newValue) -> {
            filterdata.setPredicate(collaboration -> {
                //if filter text is empty, display all collaboration
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                //compare first name and last name of all
                String lowerCaseFilter = newValue.toLowerCase();
                String status = "" + collaboration.getStatus();
                if (collaboration.getTitre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;  //filter match titre
                }
                if (collaboration.getType_collaboration().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;  //filter match type collaboration
                }
                if (status.toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;  //filter match type collaboration
                } else {
                    return false;
                }
            });
        });

        //wrap the filter in sorted list
        SortedList<Collaboration> sortedData = new SortedList<>(filterdata);

        //4 bind the sorted data with tableView
        sortedData.comparatorProperty().bind(tableGeneralCollab.comparatorProperty());

        tableGeneralCollab.setItems(sortedData);

        //*********************************************************************
         
            
        //affichage dynamique
        tableGeneralCollab.setRowFactory(tabrow -> {

            TableRow<Collaboration> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = tableGeneralCollab.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(tableGeneralCollab.getItems().get(myIndex).getId_collaboration()));
                    label_descrition.setText(tableGeneralCollab.getItems().get(myIndex).getTitre());

                    Data.titre = tableGeneralCollab.getItems().get(myIndex).getTitre();
                    Data.description = tableGeneralCollab.getItems().get(myIndex).getType_collaboration();
                    Data.type = tableGeneralCollab.getItems().get(myIndex).getType_collaboration();
                    Collaboration cc = new Collaboration();
                     ServCollaboration svc = new ServCollaboration();
                    cc= svc.recherche(Data.titre,Data.type);
                     Data.id = cc.getId_collaboration();
                    // label_periode.setText(tableGeneralCollab.getItems().get(myIndex).getDescription());
                    label_periode.setText(cc.getDate_sortie().toString());
                    label_descrition.setText(cc.getDescription());
                    label_titre.setText(cc.getTitre());
                    label_email.setText(cc.getEmail_user());
                }
            });
            return myRow;
        });
    }

    public void warning(String message, String titre) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titre);
        alert.setContentText(message);
        // alert.setHeaderText("le dessous");
        alert.showAndWait();
    }
    //-------------- piChart
      public void afficherGraphique() {
        svc.createChart(anchorPieChart);
    }

          @FXML
    void btn_imp(ActionEvent event) {

           try {
            // Charger la scène2.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("imprimerCollaborationn.fxml"));
            Parent root = loader.load();

            // Passer les données de nom et prénom à la scène2
            ImprimerCollaborationnController modifController = loader.getController();
            Collaboration c = new Collaboration();
            ServCollaboration sercol = new ServCollaboration();
            c.setTitre(Data.titre);
            c.setType_collaboration(Data.description);
            //on recupere toute les info dune collaboration
            System.out.println("le titre "+Data.titre);
            System.out.println("le type "+Data.type);
         
            c= sercol.recherche(Data.titre,Data.type);
            Data.id = c.getId_collaboration();
            Data.nom=c.getNom_user();
            Data.email=c.getEmail_user();
            modifController.afficherModif(c);

            // Afficher la scène2
            Scene scene = new Scene(root);
            Stage stage = (Stage) button_mofidier.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   @FXML
    void button_retour(ActionEvent event) {
    
        switchScene("profile.fxml",btn_retour);
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
