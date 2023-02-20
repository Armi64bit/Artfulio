package tn.esprit.artfulio.gui;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.artfulio.entites.Profile;
import tn.esprit.artfulio.services.ProfileService;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class EditprofileController implements Initializable {
  private Stage stage;
 private Scene scene;
 private Parent root;
    @FXML
    private TextField tfbio;
    @FXML
    private TextField tfig;
    @FXML
    private TextField tffb;
    @FXML
    private TextField tftwitter;
    @FXML
    private TextField tfytb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    public void switcheditprofile(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("Authentication.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
      @FXML
    public void edit(ActionEvent event){
   String bio = tfbio.getText();
   String ig = tfig.getText();
   String fb = tffb.getText();
   String twitter = tftwitter.getText();
   String ytb = tfytb.getText();
   
      Profile p = new Profile(bio,ig,fb,twitter,ytb);
        ProfileService profileService = new ProfileService();
   if (profileService.ajouterProfile(p)==-1)
   {showAlertWithHeaderText("AJOUTER PROFILE","AJOUTER PROFILE","PROFILE pas AJOUTé");
   }else {
   {showAlertWithHeaderText("AJOUTER PROFILE","AJOUTER PROFILE","PROFILE AJOUTé");
   }}
   
     
    }
    private void showAlertWithHeaderText(String title,String header,String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);

		alert.showAndWait();
	}
    
}
