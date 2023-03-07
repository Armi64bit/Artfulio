/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
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
        GoPage("/gui/Login.fxml", event);
    }

    void sendPassword(){
        System.out.println("cxcccccccccccccccccc");
                String query2="select * from user where email_user=? ";
                String email1="empty";
                 try {
            PreparedStatement smt = cnx.prepareStatement(query2);
            smt.setString(1, recipientTextField.getText());
             ResultSet rs= smt.executeQuery();
                if(rs.next()){
                   email1=rs.getString("email");
                     System.out.println(email1);
                }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
                 sendMail(email1);
    }
    public void sendMail(String recepient){
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        String myAccountEmail = "artfuliotn@gmail.com";
        String passwordd = "mdvztnyyyycnexok";
       
        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail,passwordd);
            }
        });
        Message message =preparedMessage(session,myAccountEmail,recepient);
        try{
            Transport.send(message);
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Artfulio :: Boite Mail");
                alert.setHeaderText(null);
                alert.setContentText("consulter votre boite mail !!");
                alert.showAndWait();  
           
        }catch(Exception ex){
        }
               
    }
     private Message preparedMessage(Session session, String myAccountEmail, String recepient){
         String query2="select * from user where email_user=?";
         String userEmail="null" ;
         String pass="empty";
        try {
            PreparedStatement smt = cnx.prepareStatement(query2);
            smt.setString(1, recipientTextField.getText());
             ResultSet rs= smt.executeQuery();
             System.out.println(rs);
                if(rs.next()){
                   pass=rs.getString("password");
                   userEmail=rs.getString("email");                }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.print("c est en cours");
        String text="Votre mot de pass est :"+pass+"";
        String object ="Recupération de mot de passe";
        Message message = new MimeMessage(session);
        try{
        message.setFrom(new InternetAddress(myAccountEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
        message.setSubject(object);
        String htmlcode ="<h1> "+text+" </h1> <h2> <b> </b2> </h2> ";
        message.setContent(htmlcode, "text/html");
         System.out.println("Message envoyeer");
         
           System.out.println(pass);
           
        return message;
       
        }catch(MessagingException ex){
            ex.printStackTrace();
        }
    return null;
    }
     
    @FXML
    void sendPaswword_btn(MouseEvent event) {
        sendMail(recipientTextField.getText());
       sendPassword();
       
    }

    
    
}
