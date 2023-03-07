package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class DashboardAdminController implements Initializable {

    @FXML
    private TableView<?> tableviewUser;
    @FXML
    private TableColumn<?, ?> idUser;
    @FXML
    private TableColumn<?, ?> Username;
    @FXML
    private TableColumn<?, ?> CinUser;
    @FXML
    private TableColumn<?, ?> AdresseUser;
    @FXML
    private TableColumn<?, ?> PasswordUser;
    @FXML
    private TableColumn<?, ?> EmailUser;
    @FXML
    private TableColumn<?, ?> RoleUser;
    @FXML
    private TableColumn<?, ?> ProUser;
    @FXML
    private Button btnSupp;
    @FXML
    private Button btnModifier;
    @FXML
    private TextField Recherche_User;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SupprimerUser(MouseEvent event) {
    }

    @FXML
    private void ModifierU(MouseEvent event) {
    }

    @FXML
    private void logout(MouseEvent event) {
    }

    @FXML
    private void search(MouseEvent event) {
    }

    @FXML
    private void showUser(ActionEvent event) {
    }
    
}
