/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.arfulio.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.esprit.Artfulio.entites.Collaboration;
import tn.esprit.Artfulio.gui.Data;
import tn.esprit.Artfulio.gui.ModifierCollaborationController;
import tn.esprit.Artfulio.services.ServCollaboration;

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

    Stage stage;
    Scene scene;
    Parent root;

    /**
     * Initializes the controller class.
     */
    //variable locale
    int myIndex;
    int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        System.out.println("l'id est: " + c.getId_collaboration());

        if (serv.supprimerCollaboration(c)) {
            System.out.println("la suppression c'est bien passe");
        } else {
            System.out.println("la suppression c'est mal passe");
        }
        affichagerTableMenu();
    }

    /**
     *
     * @param event
     */
    @FXML
    public void getViewModifier(ActionEvent event) throws IOException {
        System.out.println("je suis a ce niveau");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierCollaboration.fxml"));
        root = loader.load();

        //get controller of modiferController.fxml
        // System.out.println(getClass().getResource("modififerCollaboration.fxml"));
        ModifierCollaborationController modifControl = loader.getController();

        //passation des donnée entre les scenes
        modifControl.information("banane", "orange", "plantain");
        modifControl.afficherModif("le cul", "la life");
        //show modifcontrol in stage

        stage = new Stage();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(new Scene(root));
        stage.setScene(scene);
        //   stage.initStyle(StageStyle.UTILITY);
        //  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.show();

        System.out.println("on a pas executer le loading");
        //  if (Data.description.isEmpty() || Data.titre.isEmpty()) {
        //          warning("veuillez choisir la collaboration a modifier", "erreur");
        //  } else {
        System.out.println(getClass().getResource("modifierCollaboration.fxml"));

        // }
    }

    public void affichagerTableMenu() {
        ObservableList<Collaboration> listCol = FXCollections.observableArrayList();
        ServCollaboration servcol = new ServCollaboration();
        for (Collaboration c : servcol.afficherCollaboration()) {
            listCol.add(c);
        }

        tableGeneralCollab.setItems(listCol);
        // col_artiste.setCellValueFactory(colab -> colab.getTableView().idProperty());
        col_titre.setCellValueFactory(new PropertyValueFactory<Collaboration, String>("titre"));
        col_type.setCellValueFactory(new PropertyValueFactory<Collaboration, String>("type_collaboration"));
        col_status.setCellValueFactory(new PropertyValueFactory<Collaboration, String>("status"));
        // col_status.setCellValueFactory(new PropertyValueFactory<Collaboration, String>("description"));
        //    col_artiste.setCellValueFactory(new PropertyValueFactory<Collaboration, String>("date_sortie"));

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
                    // label_periode.setText(tableGeneralCollab.getItems().get(myIndex).getDescription());
                    label_periode.setText(tableGeneralCollab.getItems().get(myIndex).getDate_sortie().toString());
                }
            });
            return myRow;
        });
    }

    @FXML
    void Recherche(ActionEvent event) {

        String mot = Recherche.getText();
        Collaboration cc = new Collaboration();

        if (mot.isEmpty()) {
            warning("veuillez saisir une valeur", "erreur");
        } else {
            cc.setDescription(mot);
            cc.setTitre(mot);
            cc.setType_collaboration(mot);
            ServCollaboration sercol = new ServCollaboration();
            sercol.recherche(cc);
            if (sercol.recherche(cc) == null) {
                System.out.println("pas delement comme ca");
            } else {
                ObservableList<Collaboration> listCol = FXCollections.observableArrayList();
                ServCollaboration servcol = new ServCollaboration();
                for (Collaboration c : servcol.afficherCollaboration()) {
                    listCol.add(c);
                }

                tableGeneralCollab.setItems(listCol);
                // col_artiste.setCellValueFactory(colab -> colab.getTableView().idProperty());
                col_titre.setCellValueFactory(new PropertyValueFactory<Collaboration, String>("titre"));
                col_type.setCellValueFactory(new PropertyValueFactory<Collaboration, String>("type_collaboration"));
                col_status.setCellValueFactory(new PropertyValueFactory<Collaboration, String>("status"));
                // col_status.setCellValueFactory(new PropertyValueFactory<Collaboration, String>("description"));
                //    col_artiste.setCellValueFactory(new PropertyValueFactory<Collaboration, String>("date_sortie"));

                //affichage dynamique
                /*     tableGeneralCollab.setRowFactory(tabrow -> {

            TableRow<Collaboration> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = tableGeneralCollab.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(tableGeneralCollab.getItems().get(myIndex).getId_collaboration()));
                    label_descrition.setText(tableGeneralCollab.getItems().get(myIndex).getTitre());
                    
                    Data.titre = tableGeneralCollab.getItems().get(myIndex).getTitre();
                    Data.description = tableGeneralCollab.getItems().get(myIndex).getType_collaboration();
                   // label_periode.setText(tableGeneralCollab.getItems().get(myIndex).getDescription());
                    label_periode.setText(tableGeneralCollab.getItems().get(myIndex).getDate_sortie().toString());
                }
            });
            return myRow;
        }); */
            }
        }

    }

    public void warning(String message, String titre) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titre);
        alert.setContentText(message);
        // alert.setHeaderText("le dessous");
        alert.showAndWait();
    }

}
