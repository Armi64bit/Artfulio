/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
    private Hyperlink link;

   
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
    private void seConnecter(MouseEvent event) throws SQLException, IOException {
     if(txtUserName.getText().isEmpty()||txtPWD.getText().isEmpty()){
     msg.setText("** rempl.....");
     }else{
        
        UserService user = new UserService();
      
      if(  user.loginUtilisateur(txtUserName.getText(),txtPWD.getText())){
              GoPage("/gui/DashboardAdmin.fxml", event) ;
          // ok
      }else{
      msg.setText("** Login ou PWD incorrecte");
          // incorrecte
          
      }
     
     }
     
    }

    @FXML
    private void inscription(MouseEvent event) throws IOException {
        GoPage("/gui/Inscription.fxml", event) ;
        
    }


  

    

   

    
}
