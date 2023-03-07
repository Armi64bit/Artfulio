/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Role;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author WINDOWS 10
 */
public class InscriptionController implements Initializable {

    @FXML
    private Button btnSignUp;
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
    private Button btnCancel;
    @FXML
    private TextField txtADR;
    @FXML
    private Label lblMSG;
    private ComboBox<String> comboboxRole;
    @FXML
    private ChoiceBox<String> choiceBoxRole;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    private void inscription(MouseEvent event) throws IOException, SQLException {
        if (validerInscription()) {
            UserService user = new UserService();
            user.ajouterUtilisateur(new User(txtUserName.getText(), txtCIN.getText(), txtADR.getText(), txtPWD.getText(), txtEmail.getText(), choiceBoxRole.getValue(), false, ""));

            GoPage("/gui/Login.fxml", event);
        }
    }

    public boolean ValidationEmail() {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9._]+([.][a-zA-Z0-9]+)+");
        Matcher match = pattern.matcher(txtEmail.getText());

        if (match.find() && match.group().equals(txtEmail.getText())) {
            return true;
        } else {
            afficherErreur("Format Email Invalid");;

            return false;
        }
    }

    private Boolean validerInscription() throws SQLException {
        UserService user = new UserService();

        boolean ok = true;
        String userName = txtUserName.getText();
        String CIN = txtCIN.getText();
        String ADR = txtADR.getText();

        String email = txtEmail.getText();
        String password = txtPWD.getText();
        String confirmPassword = txtConfPWD.getText();
        String choiceBoxRole1 = choiceBoxRole.toString();
        // Valider les entrées de l'utilisateur
        if (userName.isEmpty() || ADR.isEmpty() || CIN.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || choiceBoxRole1.isEmpty()) {
           
            afficherErreur("Tous les champs sont requis");
            ok = false;
            return ok;
        }
        if (!password.equals(confirmPassword)) {
            afficherErreur("Les mots de passe ne correspondent pas");
            ok = false;
            return ok;
        }

        if (user.is_existe(userName)) {
            afficherErreur("Username déja existe");
            ok = false;
            return ok;

        }
        if (!ValidationEmail()) {
            afficherErreur("la format du mail est invalide");
            ok = false;
            return ok;
        }
        if (  txtCIN.getText().length() != 8) {
            afficherErreur("la longueur du CIN doit etre egale à 8");
            ok = false;
            return ok;
        }

        return ok;
    }

    private void afficherErreur(String message) {
 Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Errore message");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        
    }

    @FXML
    private void returnToLogin(MouseEvent event) throws IOException {
        GoPage("/gui/Login.fxml", event);
    }

    @FXML
    private void choisirRole(MouseEvent event) throws SQLException {
    }

}
