package GUI;

import entities.Emaill;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.mail.MessagingException;
import services.StoreService;

public class ConfirmationController {

    @FXML
    private TextField emailField;

    @FXML
    private Button sendButton;

    @FXML
    private void handleSendButton() {
        // Get the email address entered by the user
        String email = emailField.getText();
        
         Emaill e = new Emaill();
                try {
                   // e.envoyer(c.getEmail_user(), LocalDate.now().toString(), c.getNom_user());
                    e.envoyer(email, LocalDate.now().toString(), "test");
                } catch (MessagingException ex) {
                    System.out.println("error");
                }
    }

}
