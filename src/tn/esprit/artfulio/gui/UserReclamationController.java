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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
public class UserReclamationController implements Initializable {

    @FXML
    private TextField txtemail;

    @FXML
    private TextArea txtrec;

    @FXML
    private TextField txttitre;

    @FXML
    private TextField txtuser;

    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Initializes the controller class.
     */
    ReclamationCRUD rc = new ReclamationCRUD();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        UserService us = new UserService();
        User u = us.afficherProfilefb(9);
        User.setCurrent_User(u);
        SessionManager.getInstace(u.getId_user(), u.getCin_user(), u.getUsername(), u.getImg_user(), u.getEmail_user(), u.getAdresse_user(), u.getType_role(), u.getIs_pro());
txtemail.setText(User.getCurrent_User().getEmail_user());
    }

    @FXML
    private void Ajouter(ActionEvent event) throws SQLException, MessagingException {

        reclamation r = new reclamation();
        List<reclamation> reclamations = rc.listeDesEntites();
//artfuliotn@gmail.com
//                mdvztnyyyycnexok
        String to = User.Current_User.getEmail_user();
        String from = "artfuliotn@gmail.com";
        String host = "localhost";
        String port = "25";
        String username = User.Current_User.getUsername();
        int id_rec = r.getId_rec();
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        final String email = "artfuliotn@gmail.com";//
        final String password = "mdvztnyyyycnexok";

        if ((txttitre.getText().isEmpty()) || (txtrec.getText().isEmpty()) || (txtemail.getText().isEmpty()) || (!txtemail.getText().matches(EMAIL_PATTERN))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Verifier vos information!");
            alert.showAndWait();
        } else {

            r.setTitre(txttitre.getText());
            r.setReclamation_sec(txtrec.getText());
            r.setEmail(User.getCurrent_User().getEmail_user());
            r.setId_user(User.Current_User.getId_user());
            rc.ajouterEntitee(r);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ajout");
            alert.setHeaderText("succès.");
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
            msg.setSubject("Réclamation déposée");
            msg.setText("L'utilisateur " + username + " a dépose une réclamation. ");
            msg.setSentDate(new Date());
            Transport.send(msg);

        }

    }
}
