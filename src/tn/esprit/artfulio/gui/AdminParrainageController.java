/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import tn.esprit.artfulio.entites.User;
import tn.esprit.artfulio.entites.parrainage;
import tn.esprit.artfulio.entites.reclamation;
import tn.esprit.artfulio.services.UserService;
import tn.esprit.artfulio.services.parrainageCRUD;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import tn.esprit.artfulio.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author 21652
 */
public class AdminParrainageController implements Initializable {

    @FXML
    private MenuItem delete;

    @FXML
    private MenuItem edit;

    @FXML
    private TableColumn<parrainage, String> emailc;

    @FXML
    private TableColumn<parrainage, Integer> id_parc;

    @FXML
    private TableView<parrainage> parrtab;

    @FXML
    private TableColumn<parrainage, Integer> statusc;

    @FXML
    private TableColumn<parrainage, String> usernamec;
    @FXML
    private TableColumn<parrainage, String> typerolec;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtrole;

    @FXML
    private TextField txtstatus;

    @FXML
    private TextField txtusername;

    @FXML
    private TextField demsearch;

    parrainage p = new parrainage();
    parrainageCRUD pc = new parrainageCRUD();
    @FXML
    private MenuItem edit1;

    @FXML
    void Delete(ActionEvent event) throws SQLException, MessagingException {

        parrainage u = parrtab.getSelectionModel().getSelectedItem();
        pc.Delete(p);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Controle de reclamation");
        alert.setHeaderText("Réclamation est supprimée!");
        alert.showAndWait();

    }

    @FXML
    void edit(ActionEvent event) throws SQLException, MessagingException {

        parrainage u = parrtab.getSelectionModel().getSelectedItem();
        String to = User.Current_User.getEmail_user();
        String from = "artfulio.manager@gmail.com";
        String host = "localhost";
        String port = "25";
        String username = User.Current_User.getUsername();
        int id_parr = p.getId_parrainage();
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        final String email = "artfulio.manager@gmail.com";//
        final String password = "jiuaqccdckflopea";

        if (txtstatus.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setHeaderText("Verifier les données!");
            alert.showAndWait();

        } else {
            p.setIs_pro(Integer.valueOf(txtstatus.getText()));
            pc.Update(p);

            Properties props = System.getProperties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.ssl.trust", "*");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            props.put("mail.store.protocol", "pop3");
            props.put("mail.transport.protocol", "smtp");

            Session session = Session.getInstance(props,
                    new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(email, password);
                }
            });
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to, false));
            msg.setSubject("Résultat de demande d'obtention de titre PRO");
            msg.setText("Bienvenue cher " + User.Current_User.getUsername() + "\n"
                    + "Je suis l'un des fondateurs d'Artfulio et je voulais personnellement vous souhaiter la bienvenue dans la famille des artistes pros ! Nous sommes impatients de voir les capacités de vous avec nous !\n"
                    + "Chaleureusement\n"
                    + "sofien");
            msg.setSentDate(new Date());
            Transport.send(msg);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Demande de parrainage");
            alert.setHeaderText("Demande envoyée!");
            alert.showAndWait();

        }
    }

    void search_user() {

        List<parrainage> par = pc.listeDesEntites();
        ObservableList<parrainage> olp = FXCollections.observableArrayList(par);
        id_parc.setCellValueFactory(new PropertyValueFactory<>("id_parrainage"));
        emailc.setCellValueFactory(new PropertyValueFactory<>("email"));
        usernamec.setCellValueFactory(new PropertyValueFactory<>("username"));
        statusc.setCellValueFactory(new PropertyValueFactory<>("is_pro"));
        typerolec.setCellValueFactory(new PropertyValueFactory<>("type_role"));
        parrtab.setItems(olp);
        FilteredList<parrainage> filteredData = new FilteredList<>(olp, b -> true);
        demsearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(person.getId_parrainage()).indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches iderec
                } else {
                    return false; // Does not match.
                }
            });
        });
        SortedList<parrainage> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(parrtab.comparatorProperty());
        parrtab.setItems(sortedData);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        List<parrainage> par = pc.listeDesEntites();
        ObservableList<parrainage> olp = FXCollections.observableArrayList(par);
        id_parc.setCellValueFactory(new PropertyValueFactory<>("id_parrainage"));
        emailc.setCellValueFactory(new PropertyValueFactory<>("email"));
        usernamec.setCellValueFactory(new PropertyValueFactory<>("username"));
        statusc.setCellValueFactory(new PropertyValueFactory<>("is_pro"));
        typerolec.setCellValueFactory(new PropertyValueFactory<>("type_role"));
        parrtab.setItems(olp);

        search_user();
    }

    @FXML
    private void Refresh(ActionEvent event) throws SQLException {
        List<parrainage> par = pc.listeDesEntites();
        ObservableList<parrainage> olp = FXCollections.observableArrayList(par);
        id_parc.setCellValueFactory(new PropertyValueFactory<>("id_parrainage"));
        emailc.setCellValueFactory(new PropertyValueFactory<>("email"));
        usernamec.setCellValueFactory(new PropertyValueFactory<>("username"));
        statusc.setCellValueFactory(new PropertyValueFactory<>("is_pro"));
        typerolec.setCellValueFactory(new PropertyValueFactory<>("type_role"));
        parrtab.setItems(olp);
    }

    private void getData(MouseEvent event) {

        parrainage u = parrtab.getSelectionModel().getSelectedItem();

        txtstatus.setText(String.valueOf(u.getIs_pro()));
        txtstatus.setText(u.getEmail());
        txtstatus.setText(String.valueOf(u.getId_parrainage()));
        txtstatus.setText(u.getUsername());
        txtstatus.setText(u.getType_role());

    }

}
