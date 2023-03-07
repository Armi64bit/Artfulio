package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtCIN;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPWD;
    @FXML
    private PasswordField txtConfPWD;
    @FXML
    private Button btnSignUp;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField txtADR;
    @FXML
    private Label lblMSG;
    @FXML
    private ChoiceBox<?> choiceBoxRole;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void returnToLogin(MouseEvent event) {
    }

    @FXML
    private void choisirRole(MouseEvent event) {
    }

    @FXML
    private void inscription(ActionEvent event) {
    }
    
}
