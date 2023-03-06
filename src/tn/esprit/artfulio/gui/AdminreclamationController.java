/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tn.esprit.artfulio.gui;

import tn.esprit.artfulio.entites.User;
import tn.esprit.artfulio.entites.reclamation;
import tn.esprit.artfulio.services.ReclamationCRUD;
import tn.esprit.artfulio.services.UserService;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import tn.esprit.artfulio.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author Maissa
 */
public class AdminreclamationController implements Initializable {

    @FXML
    private TableView<reclamation> tableServices;
    @FXML
    private TableColumn<reclamation, Integer> Descriptionc;
    @FXML
    private TableColumn<reclamation, String> typePc;
    @FXML
    private TableColumn<reclamation, Integer> Datec;
    @FXML
    private TableColumn<reclamation, String> Prixc;
    @FXML
    private TableColumn<reclamation, String> emailc;
    @FXML
    private TextField txtidrec;
    @FXML
    private TextField txtiduser;
    @FXML
    private TextField DescriptionF;
    @FXML
    private TextField PrixF;
    @FXML
    private TextField txtsearch;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private MenuItem rf;
    @FXML
    private MenuItem mf;
    @FXML
    private MenuItem del;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ReclamationCRUD rc = new ReclamationCRUD();
        List<reclamation> ser = rc.listeDesEntites();
        ObservableList<reclamation> olp = FXCollections.observableArrayList(ser);
        Descriptionc.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
        Datec.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        Prixc.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        typePc.setCellValueFactory(new PropertyValueFactory<>("Reclamation_sec"));
        emailc.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableServices.setItems(olp);
        search_user();
        UserService us = new UserService();
        User u = us.afficherProfilefb(12);
        User.setCurrent_User(u);
        SessionManager.getInstace(u.getId_user(), u.getCin_user(), u.getUsername(), u.getImg_user(), u.getEmail_user(), u.getAdresse_user(), u.getType_role(), u.getIs_pro());

    }

    @FXML
    private void Modifier(ActionEvent event) throws SQLException, MessagingException {

        reclamation u = tableServices.getSelectionModel().getSelectedItem();
        reclamation r = new reclamation();
        String to = User.Current_User.getEmail_user();
        String from = "artfulio.manager@gmail.com";
        String host = "localhost";
        String port = "25";
        String username = User.Current_User.getUsername();
        int id_rec = r.getId_rec();
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        final String email = "artfulio.manager@gmail.com";//
        final String password = "jiuaqccdckflopea";
        
        
        if ((DescriptionF.getText().isEmpty()) || (PrixF.getText().isEmpty()) || (txtiduser.getText().isEmpty()) || (txtidrec.getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Verifier les données!");
            alert.showAndWait();
        } else {
            r.setId_rec(Integer.valueOf(txtidrec.getText()));
            r.setId_user(User.Current_User.getId_user());
            r.setTitre(DescriptionF.getText());
            r.setReclamation_sec(PrixF.getText());
            ReclamationCRUD rc = new ReclamationCRUD();
            rc.Update(r);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Controle de reclamation");
            alert.setHeaderText("Réclamation est modifiée!");
            alert.showAndWait();
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
            msg.setSubject("Réponse au réclamation N°: " + r.getId_rec());
            msg.setText("Voici la reponse de votre réclamation \n"  +r.getReclamation_sec());
            msg.setSentDate(new Date());
            Transport.send(msg);
        }
    }

    @FXML
    private void Supprimer(ActionEvent event) throws SQLException {
        ReclamationCRUD rc = new ReclamationCRUD();
        reclamation u = tableServices.getSelectionModel().getSelectedItem();
        rc.Delete(u);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Controle de reclamation");
        alert.setHeaderText("Réclamation est supprimée!");
        alert.showAndWait();

    }

    @FXML
    private void Refresh(ActionEvent event) throws SQLException {
        ReclamationCRUD rc = new ReclamationCRUD();
        List<reclamation> ser = rc.listeDesEntites();
        ObservableList<reclamation> olp = FXCollections.observableArrayList(ser);
        Descriptionc.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
        Datec.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        Prixc.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        typePc.setCellValueFactory(new PropertyValueFactory<>("Reclamation_sec"));
        tableServices.setItems(olp);
    }

    void search_user() {
        ReclamationCRUD rc = new ReclamationCRUD();
        List<reclamation> ser = rc.listeDesEntites();
        
        ObservableList<reclamation> olp = FXCollections.observableArrayList(ser);
        Descriptionc.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
        Datec.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        Prixc.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        typePc.setCellValueFactory(new PropertyValueFactory<>("Reclamation_sec"));
        emailc.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableServices.setItems(olp);
        FilteredList<reclamation> filteredData = new FilteredList<>(olp, b -> true);
        txtsearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(person.getId_rec()).indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches iderec
                } else {
                    return false; // Does not match.
                }
            });
        });
        SortedList<reclamation> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableServices.comparatorProperty());
        tableServices.setItems(sortedData);
    }

    @FXML
    private void getData(MouseEvent event) {

        reclamation u = tableServices.getSelectionModel().getSelectedItem();

        DescriptionF.setText(u.getTitre());
        PrixF.setText(u.getReclamation_sec());
        txtidrec.setText(String.valueOf(u.getId_rec()));
        txtiduser.setText(String.valueOf(u.getId_user()));

    }

}
