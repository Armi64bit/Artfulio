/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import tn.esprit.artfulio.entites.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tn.esprit.artfulio.services.UserService1;
import tn.esprit.artfulio.services.UserService;


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
         UserService user = new UserService();
         User u = user.afficherProfilefb(txtUserName.getText());
        if (txtUserName.getText().isEmpty() || txtPWD.getText().isEmpty()) {
            msg.setText("SVP remplir tt les champs");
        } else {

           
            if(txtUserName.getText().equals("admin") && txtPWD.getText().equals("admin") )
        {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                     alert.setTitle("Artfulio :: Success Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Bienvenu Admin");
                     alert.showAndWait();
                       GoPage("feedadmin.fxml", event);
                 
           
               
                User.setCurrent_User(u);
                // ok

            } else if (txtUserName.getText().equals(u.getUsername()) && txtPWD.getText().equals(u.getPassword_user())){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                     alert.setTitle("Artfulio :: Success Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Bienvenu a Artfulio");
                     alert.showAndWait();
                       GoPage("feed.fxml", event);
                 
           
              // User u = user.afficherProfilefb(txtUserName.getText());
                User.setCurrent_User(u);
                System.out.println(User.getCurrent_User().getUsername());
                
            }else {
                msg.setText("Login ou PWD incorrecte");
                // incorrecte

            }


        }

    }


    @FXML
    private void Resetpwd(MouseEvent event) throws IOException {
         try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            
           // Parent root = FXMLLoader.load(getClass().getResource("feedimage.fxml"));/* Exception */
            FXMLLoader loaderp = new FXMLLoader(getClass().getResource("reinitialisationMDP.fxml"));
            Parent root = loaderp.load();
           
           // FeedimageController fic =loaderp.getController();
            //fic.feed();
            //fic.users();
             Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
        // GoPage("reinitialisationMDP.fxml", event);
    

    @FXML
    private void inscription(ActionEvent event) {
         try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            
           // Parent root = FXMLLoader.load(getClass().getResource("feedimage.fxml"));/* Exception */
            FXMLLoader loaderp = new FXMLLoader(getClass().getResource("Inscription.fxml"));
            Parent root = loaderp.load();
           
           // FeedimageController fic =loaderp.getController();
            //fic.feed();
            //fic.users();
             Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
        
    }

 


