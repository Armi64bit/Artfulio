package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane globale;
    @FXML
    private StackPane stack;
    @FXML
    private AnchorPane panel__;
    @FXML
    private PasswordField txtPWD;
    @FXML
    private TextField txtUserName;
    @FXML
    private Button btnSignIn;
    @FXML
    private Button btnInscri;
    @FXML
    private Label msg;
    @FXML
    private Button btnMdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void seConnecter(MouseEvent event) {
    }

    @FXML
    private void inscription(MouseEvent event) {
    }

    @FXML
    private void Resetpwd(MouseEvent event) {
    }

    @FXML
    private void inscription(ActionEvent event) {
    }
    
}
