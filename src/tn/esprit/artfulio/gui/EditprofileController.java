package tn.esprit.artfulio.gui;

import com.mysql.cj.protocol.Resultset;
import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tn.esprit.artfulio.entites.Profile;
import tn.esprit.artfulio.services.ProfileService;
import tn.esprit.artfulio.utils.MyConnection;

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
    @FXML
    private TableColumn<Profile, String> colbio;
    @FXML
    private TableColumn<Profile, String> colig;
    @FXML
    private TableColumn<Profile, String> colfb;
    @FXML
    private TableColumn<Profile, String> coltwitter;
    @FXML
    private TableColumn<Profile, String> colytb;
    @FXML
    private TableView<Profile> table;
    ObservableList<Profile>prod=FXCollections.observableArrayList();
 Connection myconnex
            = MyConnection.getInstance().getConnection();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
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
     String regex = "^[A-Za-z0-9+_.-]+@(.+)$" ;
     
        /*if(txtcin1.getText().length() > 8 || txtcin1.getText().length() < 8){
            JOptionPane.showMessageDialog(null,"cin non valide, cin doit étre contient 8 chiffres"); }
        */
            
             if( tfytb.getText().length() < 1 ){
             JOptionPane.showMessageDialog(null,"champ youtube vide !!!");
             }
             else if(tftwitter.getText().length() < 1 ){
             JOptionPane.showMessageDialog(null,"champ twitter vide !!!");
             }
            else  if(tfig.getText().length() < 1 ){
             JOptionPane.showMessageDialog(null,"champ ig vide !!!");
             }
            else  if(tffb.getText().length() < 1 ){
             JOptionPane.showMessageDialog(null,"champ fb vide !!!");
             }
             else if (tfbio.getText().matches(regex)==true){
            JOptionPane.showMessageDialog(null,"bio invalid"); }
            else if (tfbio.getText().length() < 1){
            JOptionPane.showMessageDialog(null,"bio vide"); }
            /*else if (ConnectionUtil.checkRedonnondance(txtu.getText())!=0){
                JOptionPane.showMessageDialog(null,"Nom d'utilisateur déja existe");
            }*/
            else {
   
      Profile p = new Profile(bio,ig,fb,twitter,ytb);
        ProfileService profileService = new ProfileService();
   if (profileService.ajouterProfile(p)==-1)
   {showAlertWithHeaderText("AJOUTER PROFILE","AJOUTER PROFILE","PROFILE pas AJOUTé");
   }else {
   {showAlertWithHeaderText("AJOUTER PROFILE","AJOUTER PROFILE","PROFILE AJOUTé");
   }}
            }
     
    }
    private void showAlertWithHeaderText(String title,String header,String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);

		alert.showAndWait();
	}
    
}
