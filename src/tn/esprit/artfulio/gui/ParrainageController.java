package tn.esprit.artfulio.gui;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import tn.esprit.artfulio.entites.User;
import tn.esprit.artfulio.entites.parrainage;
import tn.esprit.artfulio.services.UserService;
import tn.esprit.artfulio.services.parrainageCRUD;
import tn.esprit.artfulio.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class ParrainageController implements Initializable {

    @FXML
    private ImageView image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //displayImage();
        UserService us = new UserService();
        User u = us.afficherProfilefb(10);
        User.setCurrent_User(u);
        SessionManager.getInstace(u.getId_user(), u.getCin_user(), u.getUsername(), u.getImg_user(), u.getEmail_user(), u.getAdresse_user(), u.getType_role(), u.getIs_pro());
 
    }    

    @FXML
    private void btnsend(ActionEvent event) throws AddressException, MessagingException {
        
        parrainage p = new parrainage();
        parrainageCRUD pc = new parrainageCRUD();
        List<parrainage> parrainages = pc.listeDesEntites();
        String to = User.Current_User.getAdresse_user();
        String from = "artfulio.manager@gmail.com";
        String host = "localhost";
        String port = "25";
        String username = User.Current_User.getUsername();
        int id_parr = p.getId_parrainage();
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        final String email = "artfulio.manager@gmail.com";//
        final String password = "jiuaqccdckflopea";

        if (User.Current_User.getIs_pro() == 1) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Vous etes deja un compte pro!");
            alert.showAndWait();
        } else {

            
            p.setEmail(User.Current_User.getEmail_user());
            p.setIs_pro(User.Current_User.getIs_pro());
            p.setType_role(User.Current_User.getType_role());
            p.setUsername(User.Current_User.getUsername());
            pc.add(p);
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
                msg.setSubject("Demande de parrainage ");
                msg.setText("L'utilisateur " + username + " a fait une demande d'obtention d'un statut d'artiste pro");
                msg.setSentDate(new Date());
                Transport.send(msg);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Demande de parrainage");
                alert.setHeaderText("Demande envoyée!");
                alert.showAndWait();

            
        }

    
    }
    
}
