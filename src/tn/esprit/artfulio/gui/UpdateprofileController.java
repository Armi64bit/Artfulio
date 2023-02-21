package tn.esprit.artfulio.gui;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tn.esprit.artfulio.entites.Profile;
import tn.esprit.artfulio.services.ProfileService;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class UpdateprofileController implements Initializable {

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

    }

    @FXML
    private void edit(ActionEvent event) {
    }

    public void updatepreloadtxt(String bio, String ig, String fb, String twitter, String ytb) {
        tfbio.setText(bio);
        tfig.setText(ig);
        tffb.setText(fb);
        tftwitter.setText(twitter);
        tfytb.setText(ytb);

    }

    @FXML
    private void switcheditprofile(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Authentication.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(UpdateprofileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css;
            css = this.getClass().getResource("application.css").toExternalForm();
   scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void update(ActionEvent event) {
        String bio = tfbio.getText();
        String ig = tfig.getText();
        String fb = tffb.getText();
        String twitter = tftwitter.getText();
        String ytb = tfytb.getText();
        ProfileService ps = new ProfileService();
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        /*
        if (tfytb.getText().length() < 1) {
            JOptionPane.showMessageDialog(null, "champ youtube vide !!!");
        } else if (tftwitter.getText().length() < 1) {
            JOptionPane.showMessageDialog(null, "champ twitter vide !!!");
        } else if (tfig.getText().length() < 1) {
            JOptionPane.showMessageDialog(null, "champ ig vide !!!");
        } else if (tffb.getText().length() < 1) {
            JOptionPane.showMessageDialog(null, "champ fb vide !!!");
        } else if (tfbio.getText().matches(regex) == true) {
            JOptionPane.showMessageDialog(null, "bio invalid");
        } else if (tfbio.getText().length() < 1) {
            JOptionPane.showMessageDialog(null, "bio vide");
        } else if (ps.checkRedonnondance(tfig.getText(), tffb.getText(), tftwitter.getText(), tfytb.getText()) != 1) {
            JOptionPane.showMessageDialog(null, " profile existe déja");
        } else {*/
        Profile p = new Profile(bio, ig, fb, twitter, ytb);
        if (ps.modifierProfile(p) != true) {
            JOptionPane.showMessageDialog(null, "PROFILE pas updated");
        } else {
            {
                JOptionPane.showMessageDialog(null, "PROFILE  updated");
            }
        }
        /* }*/

    }
      private void showAlertWithHeaderText(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
      
         public void delprofile(){
     String bio = tfbio.getText();
        String ig = tfig.getText();
        String fb = tffb.getText();
        String twitter = tftwitter.getText();
        String ytb = tfytb.getText();
        ProfileService ps = new ProfileService();
       Profile p = new Profile(bio, ig, fb, twitter, ytb);
      
      if (ps.supprimerProfile(p) != true) {
            JOptionPane.showMessageDialog(null, "PROFILE pas supprimé");
        } else {
            {
                JOptionPane.showMessageDialog(null, "PROFILE  supprimé");
            tfbio.setText("");
         tfig.setText("");
      tffb.setText("");
        tftwitter.setText("");
       tfytb.setText("");
            }
        }
            

}   

    
                   }
