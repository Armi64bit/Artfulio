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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author WINDOWS 10
 */
public class ModifierUserController implements Initializable {

    private TextField cinM;
    @FXML
    private Button modifier_btn;

    @FXML
    private TextField idUser;
    @FXML
    private TextField RoleUser;
    @FXML
    private TextField ProUser;
    @FXML
    private TextField CinUser;
    @FXML
    private TextField PasswordUser;
    @FXML
    private TextField AdresseUser;
    @FXML
    private TextField EmailUser;
    @FXML
    private TextField Username;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void ModifierUser(MouseEvent event) throws SQLException {
        UserService rec = new UserService();

        Integer id = Integer.parseInt(idUser.getText());
        String username = Username.getText();
        String cin = CinUser.getText();
        String adresse = AdresseUser.getText();
        String pass = PasswordUser.getText();
        String email = EmailUser.getText();
        String role = RoleUser.getText();
        String pro = ProUser.getText();

        User R = new User(id, username, cin, adresse, pass, email, role, false);
        rec.modifierUtilisateur(R);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Artfulio :: Success Message");
        alert.setHeaderText(null);
        alert.setContentText("Utilsateur modifié");
        alert.showAndWait();

    }

    public void setText(User user) {

        String id = String.valueOf(user.getId_user());
        idUser.setText(id);

        Username.setText(user.getUsername());
        CinUser.setText(user.getCin_user());

        AdresseUser.setText(user.getAdresse_user());
        PasswordUser.setText(user.getPassword_user());
        EmailUser.setText(user.getEmail_user());
        RoleUser.setText(user.getRole());
        ProUser.setText(String.valueOf(user.isIs_pro()));

    }

  /*  public void setTextFields(User user) {
        idUser.setText(String.valueOf(user.getId_user()));
        CinUser.setText(String.valueOf(user.getCin_user()));
        AdresseUser.setText(String.valueOf(user.getAdresse_user()));
        PasswordUser.setText(user.getPassword_user());
        EmailUser.setText(user.getEmail_user());
        RoleUser.setText(user.getRole());
        ProUser.setText(String.valueOf(user.isIs_pro()));

    }*/

    @FXML
    private void textfieldDesign1(MouseEvent event) {
    }

    @FXML
    private void textfieldDesign1(KeyEvent event) {
    }

    @FXML
    private void retour(MouseEvent event) throws IOException {
        GoPage("/gui/DashboardAdmin.fxml", event);
    }

  

}
