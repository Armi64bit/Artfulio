package tn.esprit.artfulio.gui;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class EditerprofileuserController implements Initializable {

    @FXML
    private BorderPane parent;
    @FXML
    private Button chnagemode;
    @FXML
    private ImageView darkorlight;
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
    private Button cancel;
    @FXML
    private Label id_user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

       private boolean islightmode = true;

    @FXML
    public void changemode(ActionEvent e) {
        islightmode = !islightmode;
        if (islightmode) {
            setlightmode();
        } else {
            setdarkmode();
        }
    }

    public void setlightmode() {
         
        parent.getStylesheets().remove("tn/esprit/artfulio/gui/feeddark.css");
        parent.getStylesheets().add("tn/esprit/artfulio/gui/feed.css");
//             File imageFile = new File("tn/esprit/artfulio/img/mode.png");
//    Image image = new Image(imageFile.toURI().toString());
//    
//        darkorlight.setImage(image);
        /*Image img = new Image("url");
    imgmode.setImage(img);*/

    }
    public void setdarkmode() {
        
        parent.getStylesheets().remove("tn/esprit/artfulio/gui/feed.css");
        parent.getStylesheets().add("tn/esprit/artfulio/gui/feeddark.css");
//          File imageFile = new File("tn/esprit/artfulio/img/dark-mode.png");
//    Image image = new Image(imageFile.toURI().toString());
//    
//        darkorlight.setImage(image);
    }
    private void GoTo(ActionEvent event ,String fxml) throws IOException {
        
          Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
         
    }
    @FXML
    private void takebacktoprofile(ActionEvent event) throws IOException{
     FXMLLoader loaderp = new FXMLLoader();
         int id= Integer.parseInt(id_user.getText());
         System.out.println(id);
        GoTo(event," profile.fxml");
              ProfileController pc = loaderp.getController();
               pc.setdata(id);
        
    }



}
