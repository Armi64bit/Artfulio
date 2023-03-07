/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
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
import javafx.scene.control.MenuItem;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.reflect.Reflection;
//import tn.esprit.artfulio.entites.Collaboration;
import tn.esprit.artfulio.entites.artwork;
import tn.esprit.artfulio.entites.categorie;

import tn.esprit.artfulio.gui.Data;
//import tn.esprit.artfulio.gui.ModifierCollaborationController;
import tn.esprit.artfulio.services.ArtworkService;

/**
 * FXML Controller class
 *
 * @author lelou
 */
public class AdminController implements Initializable {

    @FXML
    private TextField txtDescart;

    @FXML
    private TextField txtnomart;

    @FXML
    private TextField txtprix;
    @FXML
    private TableView<artwork> tableArt;

    @FXML
    private TableColumn<artwork, Integer> ArtistId;

    @FXML
    private TableColumn<artwork, Integer> ArtworkId;

    @FXML
    private TableColumn<artwork, String> DescriptionArt;

    @FXML
    private TextField DescriptionF;

    @FXML
    private TableColumn<artwork, String> NomArt;

    @FXML
    private TableColumn<artwork, Float> Prixc;

    @FXML
    private MenuItem del;

    @FXML
    private MenuItem mf;

    @FXML
    private MenuItem rf;

    // @FXML
    //    private TableView<?> tableArt;
    @FXML
    private TextField txtidrec;

    @FXML
    private TextField txtiduser;

    @FXML
    private TextField txtsearch;

    @FXML
    private Button button_mofidier;
    @FXML
    private Button btn_annulerCol;
    @FXML
    private TableView<artwork> tableInfo;
    @FXML
    private TableColumn<artwork, String> col_artiste;
    @FXML
    private TableColumn<artwork, String> col_titre;
    @FXML
    private TableColumn<artwork, String> col_type;
    @FXML
    private TableColumn<artwork, String> col_status;
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
    private Button btn_ajouter;

    @FXML
    private AnchorPane anchorPieChart = new AnchorPane();

    @FXML
    private AnchorPane anctype = new AnchorPane();
    ;

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
    ArtworkService svc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ArtworkService as = new ArtworkService();
        List<artwork> ser = as.afficherartwork();
        ObservableList<artwork> olp = FXCollections.observableArrayList(ser);
        ArtworkId.setCellValueFactory(new PropertyValueFactory<>("id_artwork"));
        ArtistId.setCellValueFactory(new PropertyValueFactory<>("id_artist"));
        Prixc.setCellValueFactory(new PropertyValueFactory<>("prix_artwork"));
        DescriptionArt.setCellValueFactory(new PropertyValueFactory<>("description_artwork"));
        NomArt.setCellValueFactory(new PropertyValueFactory<>("nom_artwork"));
        tableArt.setItems(olp);
        search_user();

    }

    @FXML
    private void getData(MouseEvent event) {

        artwork u = tableArt.getSelectionModel().getSelectedItem();

        txtDescart.setText(u.getDescription_artwork());
        txtprix.setText(String.valueOf(u.getPrix_artwork()));
        txtnomart.setText(String.valueOf(u.getNom_artwork()));
        // txtiduser.setText(String.valueOf(u.getId_user()));

    }

    @FXML
    private void Refresh(ActionEvent event) throws SQLException {
        ArtworkService rc = new ArtworkService();
        List<artwork> ser = rc.afficherartwork();
        ObservableList<artwork> olp = FXCollections.observableArrayList(ser);
        ArtworkId.setCellValueFactory(new PropertyValueFactory<>("id_artwork"));
        ArtistId.setCellValueFactory(new PropertyValueFactory<>("id_artist"));
        Prixc.setCellValueFactory(new PropertyValueFactory<>("prix_artwork"));
        DescriptionArt.setCellValueFactory(new PropertyValueFactory<>("description_artwork"));
        NomArt.setCellValueFactory(new PropertyValueFactory<>("nom_artwork"));
        tableArt.setItems(olp);
    }

    void search_user() {
        ArtworkService rc = new ArtworkService();
        List<artwork> ser = rc.afficherartwork();

        ObservableList<artwork> olp = FXCollections.observableArrayList(ser);
        ArtworkId.setCellValueFactory(new PropertyValueFactory<>("id_artwork"));
        ArtistId.setCellValueFactory(new PropertyValueFactory<>("id_artist"));
        Prixc.setCellValueFactory(new PropertyValueFactory<>("prix_artwork"));
        DescriptionArt.setCellValueFactory(new PropertyValueFactory<>("description_artwork"));
        NomArt.setCellValueFactory(new PropertyValueFactory<>("nom_artwork"));
        tableArt.setItems(olp);
        FilteredList<artwork> filteredData = new FilteredList<>(olp, b -> true);
        txtsearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(person.getNom_artwork()).indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matcs iderec
                } else {
                    return false; // Does not match.
                }
            });
        });
        SortedList<artwork> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableArt.comparatorProperty());
        tableArt.setItems(sortedData);
    }

    @FXML
    void button_retour(ActionEvent event) {

        //   switchScene(btn_retour,"profile.fxml");
    }

    @FXML
    private void Modifier(ActionEvent event) throws SQLException {

        artwork u = tableArt.getSelectionModel().getSelectedItem();
        artwork r = new artwork();
        //String to = User.Current_User.getEmail_user();

        if ((txtprix.getText().isEmpty()) || (txtDescart.getText().isEmpty()) || (txtnomart.getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Verifier les données!");
            alert.showAndWait();
        } else {
            r.setNom_artwork((txtnomart.getText()));
            //  r.setId_artist(User.Current_User.getId());
            r.setDescription_artwork(txtDescart.getText());
            r.setPrix_artwork(Float.valueOf(txtprix.getText()));
            ArtworkService rc = new ArtworkService();
            rc.modifierartwork(r);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Controle de artwork");
            alert.setHeaderText("artwork est modifié!");
            alert.showAndWait();

        }
    }

    @FXML
    private void Supprimer(ActionEvent event) throws SQLException {
        ArtworkService rc = new ArtworkService();
        artwork u = tableArt.getSelectionModel().getSelectedItem();
        rc.supprimerartwork(u);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Controle de artwork");
            alert.setHeaderText("artwork est supprimé!");
            alert.showAndWait();
    }

}
