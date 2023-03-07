/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import tn.esprit.artfulio.services.UserService;
import tn.esprit.artfulio.entites.User;
import tn.esprit.artfulio.services.Email;


/**
 * FXML Controller class
 *
 * @author WINDOWS 10
 */
public class ReinitialisationMDPController implements Initializable {

    @FXML
    private TextField recipientTextField;
    @FXML
    private Button btnRetour;
    @FXML
    private Button btnsend;
     private Connection cnx;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("xxx");
        
                
    }

    private void GoPage(String Path, MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(Path));
        Parent parent = loader.load();
        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        Window.setScene(scene);
        Window.show();

    }

    @FXML
    private void returnToLogin(MouseEvent event) throws IOException {
        GoPage("Login.fxml", event);
    }

    void sendPassword(){
        System.out.println("cxcccccccccccccccccc");
         UserService us= new UserService();
         User u=us.afficherparmail(recipientTextField.getText());
                String query2="select * from user where email_user=? ";
                String email1="empty";
                 try {
            PreparedStatement smt = cnx.prepareStatement(query2);
            smt.setString(1, recipientTextField.getText());
             ResultSet rs= smt.executeQuery();
                if(rs.next()){
                   email1=rs.getString("email_user");
                     System.out.println(email1);
                }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
                 sendMail(email1);
    }
    public void sendMail(String recepient){   
           
        try {
            String username = "artfuliotn@gmail.com";
            String password ="mdvztnyyyycnexok";
//            String username = "michel.bodoldjob@esprit.tn";
//            String password ="hxdhgdtthfmjqqfj";
System.out.println("Envoie de la collaboration par mail en cours !! ");
// Etape 1 : Création de la session
Properties props = new Properties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable","true");
props.put("mail.smtp.host","smtp.gmail.com");
props.put("mail.smtp.port","587");

Session session = Session.getInstance(props,new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);}
});

Message message = preparedMessage(session,username,recepient);
Transport.send(message);
System.out.println("Message envoyé !!");
        } catch (MessagingException ex) {
            Logger.getLogger(ReinitialisationMDPController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
     private Message preparedMessage(Session session, String myAccountEmail, String recepient){
        try {
            //String query2="select * from user where email_user=?";
            UserService us= new UserService();
            User u=us.afficherparmail(recepient);
            
            String userEmail=u.getEmail_user(); ;
            String pass=u.getPassword_user();
//      try {
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress(userEmail));
message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(myAccountEmail));
message.setSubject("recuperation mdp");
message.setText("Mr/Mme "+u.getUsername()+" voici votre mpd: /n " +u.getPassword_user() );

return message;
        } catch (MessagingException ex) {
            Logger.getLogger(ReinitialisationMDPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return null;
    }
     
    void sendPaswword_btn(MouseEvent event) {
       
      // sendPassword();
       
    }

    @FXML
    private void sendPaswword_btn(ActionEvent event) throws URISyntaxException {
        try {
            Email.envoyermdp(recipientTextField.getText());
       Data.information("Votre mot de passe est envoyé /n verifier votre boite mail", "Reussi");
                   Desktop.getDesktop().browse(new URL("https://mail.google.com/mail/u/1/?pli=1#inbox").toURI());


        } catch (MessagingException ex) {
            Logger.getLogger(ReinitialisationMDPController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReinitialisationMDPController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    
    
}
