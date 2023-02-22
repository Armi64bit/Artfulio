/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a17.gui;

import edu.connexion3a17.entities.reclamation;
import edu.connexion3a17.services.ReclamationCRUD;
import edu.connexion3a17.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author 21652
 */
public class UserReclamationController implements Initializable {

    static Connection myconnex = MyConnection.getInstance().getCnx();

    private Scene scene;

    private Parent root;

    private Stage stage;

    @FXML
    private Button btnrec;

    @FXML
    private Label modlabel;

    @FXML
    private Label createlabel;

    @FXML
    private Button btncreate;

    @FXML
    private TextArea modtxt;

    @FXML
    private TextArea rectct;

    @FXML
    private TextField txttitre;

    @FXML
    private TextField txttlf;

    @FXML
    private TableColumn<?, ?> Date_rec;

    @FXML
    private TableColumn<?, ?> Titre;

    @FXML
    private Button btnmod;

    @FXML
    private Button btnsupp;

    @FXML
    private ListView<reclamation> reclist;

    @FXML
    private TableColumn<reclamation, String> tabdatesec;

    @FXML
    private TableColumn<reclamation, String> tabtitrerec;

    @FXML
    private TextArea txtmod;

    @FXML
    private Button btndel0;

    @FXML
    private Button btnmod0;

    @FXML
    private TableView<reclamation> tabrec;

    @FXML
    private Label reclabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void switchToModifyRec(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("UserReclamation.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToCreRec(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("ModReclamation.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void tablehandleButtonAction(MouseEvent event) {
        ReclamationCRUD ps = new ReclamationCRUD();

        reclamation r = new reclamation();
        reclamation et = (reclamation) tabrec.getSelectionModel().getSelectedItem();
        txttitre.setText(et.getTitre());
        Date.setText(et.getDate());//bech te5ou date mi rec

    }

    @FXML
    void modifyrec(ActionEvent event) {

        String Titre = txttitre.getText();
        String Reclamation_sec = rectct.getText();
        int Num_tlf = Integer.parseInt(txttlf.getText());

        ReclamationCRUD ps = new ReclamationCRUD();
        reclamation r = new reclamation(Titre, Reclamation_sec, Num_tlf);
        ps.Update(r);
        modlabel.setText("Reclamation modifiée!");

    }

    @FXML
    void supprec(ActionEvent event) {

        String Titre = txttitre.getText();
        String Reclamation_sec = rectct.getText();
        int Num_tlf = Integer.parseInt(txttlf.getText());

        ReclamationCRUD ps = new ReclamationCRUD();
        reclamation r = new reclamation(Titre, Reclamation_sec, Num_tlf);
        ps.Delete(r);
        modlabel.setText("Reclamation supprimée!");
        txttitre.setText("");
        rectct.setText("");
        txttlf.setText("");

    }

    @FXML
    void createrec(ActionEvent event) {

        String Titre = txttitre.getText();
        String Reclamation_sec = rectct.getText();
        int Num_tlf = Integer.parseInt(txttlf.getText());

        ReclamationCRUD ps = new ReclamationCRUD();
        reclamation r = new reclamation(Titre, Reclamation_sec, Num_tlf);
        ps.ajouterEntitee(r);
        reclabel.setText("Reclamation ajoutée!");

    }

}
