package tn.esprit.artfulio.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import tn.esprit.artfulio.entites.User;
import tn.esprit.artfulio.entites.artwork;

import tn.esprit.artfulio.services.UserService;
import tn.esprit.artfulio.services.ArtworkService;
import tn.esprit.artfulio.gui.ArtworkpostController;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class FeedController implements Initializable {

    @FXML
    private BorderPane parent;
    @FXML
    private VBox postscontainer;
    @FXML
    private Button chnagemode;
    @FXML
    private VBox usercontainer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      feed();
      users();
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
        parent.getStylesheets().remove("file:feeddark.css");
        parent.getStylesheets().add("feed.css");
        /*Image img = new Image("url");
    imgmode.setImage(img);*/

    }
    
    public void feed (){
    
        ArtworkService as = new ArtworkService();

        List<artwork> listart = new ArrayList<>();
       // users();
        try {

            listart = as.afficherartwork();
            for (int i = 0; i < listart.size(); i++) {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("artworkpost.fxml"));
                VBox vbox = loader.load();
                ArtworkpostController artcont = loader.getController();
                artcont.setdata(listart.get(i));
                postscontainer.getChildren().add(vbox);

            }
        } catch (Exception e) {
        }
}

    public void users() {
         User u = new User();
        UserService us = new UserService();
        List<User> list = new ArrayList<>();
      try {
            list = us.afficheruser();
        
            System.out.println(list.size());
        for (int j = 0; j < list.size(); j++) {

           
                FXMLLoader loaderu = new FXMLLoader();
                loaderu.setLocation(getClass().getResource("useritem.fxml"));
                HBox vboxu = loaderu.load();
               UseritemController artcont = loaderu.getController();
                artcont.setpdp(list.get(j));
                usercontainer.getChildren().add(vboxu);
        }} catch (IOException ex) {
               Logger.getLogger(FeedController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    

    public void setdarkmode() {
        parent.getStylesheets().remove("feed.css");
        parent.getStylesheets().add("feeddark.css");
    }

}
