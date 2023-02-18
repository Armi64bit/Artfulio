package tn.esprit.artfulio.presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class LoginFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField logintxt;
    @FXML
    TextField passwordtxt;
    @FXML
    Button    loginbtn;   
   
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
