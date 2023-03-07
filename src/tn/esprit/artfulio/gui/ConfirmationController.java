package tn.esprit.artfulio.gui;

import java.net.URL;
import tn.esprit.artfulio.entites.Email;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.mail.MessagingException;
import tn.esprit.artfulio.services.StoreService;
import tn.esprit.artfulio.entites.User;


public class ConfirmationController  implements Initializable{

    @FXML
    private TextField emailField;

    @FXML
    private Button sendButton;

    
    
    @FXML
    private void handleSendButton() {
        // Get the email address entered by the user
        String email = emailField.getText();
        
         Email e = new Email();
                try {
                   // e.envoyer(c.getEmail_user(), LocalDate.now().toString(), c.getNom_user());
                    e.envoyer(email, LocalDate.now().toString(), "test");
                } catch (MessagingException ex) {
                    System.out.println("error");
                }
    
    }

@Override
    public void initialize(URL url, ResourceBundle rb) {
                       emailField.setText(User.getCurrent_User().getEmail_user());

    }

}

