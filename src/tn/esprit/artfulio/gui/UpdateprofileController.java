package tn.esprit.artfulio.gui;

import java.io.File;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tn.esprit.artfulio.entites.Profile;
import tn.esprit.artfulio.services.ProfileService;
import tn.esprit.artfulio.entites.User;
import tn.esprit.artfulio.services.UserService;
import tn.esprit.artfulio.gui.ProfileController;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class UpdateprofileController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    private Stage stage2;
    private Scene scene2;
    private Parent root2;
    
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
    private Button vld;
    @FXML
    private Text delprofile;
    @FXML
    private Label id_user;
    @FXML
    private ImageView newpdp;
    private TextField imageField;
    @FXML
    private TextField username;
    @FXML
    private TextField path;
    @FXML
    private Button imp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }


    public void updatepreloadtxt(String bio, String ig, String fb, String twitter, String ytb,int id,String name,String img) {
        tfbio.setText(bio);
        tfig.setText(ig);
        tffb.setText(fb);
        tftwitter.setText(twitter);
        tfytb.setText(ytb);
        id_user.setText(String.format("%d", id));
username.setText(name);
path.setText(img);
setpdp(id);

    }
    private void taketoprofile(MouseEvent event) {
        try {
            int id= Integer.parseInt(id_user.getText());
            FXMLLoader loaderp = new FXMLLoader(getClass().getResource("src/tn/esprit/artfulio/gui/profile.fxml"));
            root = loaderp.load();
            ProfileController pc = loaderp.getController();
            pc.setdata(id);
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(UpdateprofileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    @FXML
    public void update(ActionEvent event) {
        String bio = tfbio.getText();
        String ig = tfig.getText();
        String fb = tffb.getText();
        String twitter = tftwitter.getText();
        String ytb = tfytb.getText();
        ProfileService ps = new ProfileService();
        UserService us = new UserService();
        String newusername=username.getText();
        String newimg = path.getText();
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
         int id= Integer.parseInt(id_user.getText());

        User u = new User(id,newusername, newimg);
        us.update(u);
        
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
         
           
            ProfileController pc = loaderp.getController();
            pc.setdata(id);
        /* }*/

    }
      private void showAlertWithHeaderText(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
      
    @FXML
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

    private void taketoprofile(ActionEvent event) {
       FXMLLoader loaderp = new FXMLLoader();
         int id= Integer.parseInt(id_user.getText());
         System.out.println(id);
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));/* Exception */
              ProfileController pc = loaderp.getController();
              // pc.setdata(id);
           //FXMLController previousController = controllers.pop();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(UpdateprofileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
        FXMLLoader loaderp = new FXMLLoader();
    private void GoTo(ActionEvent event ,String fxml) throws IOException {
       
          Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
         
    }
    private void takebacktoprofile(ActionEvent event) throws IOException{
  
         int id= Integer.parseInt(id_user.getText());
         System.out.println(id);
        GoTo(event," profile.fxml");
              ProfileController pc = loaderp.getController();
             
//  pc.setdata(id);
        
    }
    
    @FXML
    public void handleChooseImage(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Choose Image File");
    fileChooser.getExtensionFilters().addAll(
            new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
            new ExtensionFilter("All Files", ".")
    );
    File selectedFile = fileChooser.showOpenDialog(((Node) event.getTarget()).getScene().getWindow());
    if (selectedFile != null) {
        String imagePath = selectedFile.toURI().toString();
        Image image = new Image(imagePath);
        newpdp.setImage(image);
        path.setText(selectedFile.getAbsolutePath());
    }
}
    
    public void setpdp(int id) {
        User u = new User();
        UserService us = new UserService();
        u = us.afficherProfilefb(id);
        File imageFile = new File(u.getImg_user());
        Image image = new Image(imageFile.toURI().toString());
        newpdp.setImage(image);
    }

    
                   }
