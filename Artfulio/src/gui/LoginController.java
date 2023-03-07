/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author WINDOWS 10
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane globale;
    @FXML
    private StackPane stack;
    @FXML
    private AnchorPane panel__;
    @FXML
    private Button btnSignIn;
    @FXML
    private PasswordField txtPWD;
    @FXML
    private TextField txtUserName;
    @FXML
    private Label msg;
    @FXML
    private Button btnInscri;
    @FXML
    private Button btnMdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*   FadeTransition ft = new FadeTransition(Duration.seconds(4),globale);
           ft.setFromValue(0);
           ft.setToValue(1);
           ft.play();*/
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
    private void seConnecter(MouseEvent event) throws SQLException, IOException {
        if (txtUserName.getText().isEmpty() || txtPWD.getText().isEmpty()) {
            msg.setText("SVP remplir tt les champs");
        } else {

            UserService user = new UserService();
            if (txtUserName.getText().equals("imen") && txtPWD.getText().equals("0000")) {
               /* Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                     alert.setTitle("Artfulio :: Success Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Bienvenue Admin");
                     alert.showAndWait();*/
                GoPage("/gui/DashboardAdmin.fxml", event);

                User u = user.afficherCurrent_User(txtUserName.getText());
                User.setCurrent_User(u);
                // ok
            } else {
                msg.setText("Login ou PWD incorrecte");
                // incorrecte

            }

        }

    }

    @FXML
    private void inscription(MouseEvent event) throws IOException {
        GoPage("/gui/Inscription.fxml", event);

    }

    @FXML
    private void Resetpwd(MouseEvent event) throws IOException {
        GoPage("/gui/reinitialisationMDP.fxml", event);
    }

}
