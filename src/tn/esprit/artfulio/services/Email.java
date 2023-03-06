/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.services;


import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import tn.esprit.artfulio.entites.User;

/**
 *
 * @author lelou
 */
public class Email {
    
      public static void envoyer(String destinataire, String date,String name) throws MessagingException {
            
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
            
            Message message = prepareMessage(session,username,destinataire,date,name);
            Transport.send(message);
            System.out.println("Message envoyé !!");
}
        
    

    private static Message prepareMessage(Session session, String username,String destinataire, String date,String name) throws MessagingException {
        
        try { 
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(destinataire));
            message.setSubject("Confirmation de collaboration");
            message.setText("Mr/Mme "+name+" ,  vous a envoyer une demande de collaboration est veuillez confirmer si vous etes interressé\n "+date+"\n veuillez contacter "+User.getCurrent_User().getEmail_user());
           
            return message;
        } catch (AddressException ex) {
            Logger.getLogger( Email.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
