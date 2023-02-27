/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

   
    private void GoPage(String Path,MouseEvent event) throws IOException{
    FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(getClass().getResource(Path));
                                Parent parent =loader.load();
                                Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                Scene scene =new Scene(parent);
                                Window.setScene(scene);
                                Window.show();
    
    }
    
    @FXML
    private void inscription(MouseEvent event) throws IOException {
       if(validerInscription()){ 
           UserService user = new UserService();
           user.ajouterUtilisateur(new User(txtUserName.getText(),txtCIN.getText(), txtADR.getText(),txtPWD.getText(), txtEmail.getText(), "Client", false, ""));
           
           GoPage("/gui/Login.fxml", event);}
          
    }
       private Boolean validerInscription() {
             boolean ok =true;
        String userName = txtUserName.getText();
        String CIN = txtCIN.getText();
        String ADR = txtADR.getText();
        
        String email = txtEmail.getText();
        String password = txtPWD.getText();
        String confirmPassword = txtConfPWD.getText();

        // Valider les entrées de l'utilisateur
        if (userName.isEmpty() || ADR.isEmpty() ||CIN.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            afficherErreur("Tous les champs sont requis");
               ok= false;
            return ok;
        }
        if (!password.equals(confirmPassword)) {
            afficherErreur("Les mots de passe ne correspondent pas");
            ok= false;
            return ok;
        }
        return ok;
        }
        private void afficherErreur(String message) {
            
            lblMSG.setText(message);
        }

    @FXML
    private void returnToLogin(MouseEvent event) throws IOException {
         GoPage("/gui/Login.fxml", event);
    }
}
