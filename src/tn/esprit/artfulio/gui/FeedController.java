package tn.esprit.artfulio.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class FeedController implements Initializable {

    @FXML
    private VBox postscontainer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            for(int i=0;i<6;i++){
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource("artworkpost.fxml"));
                VBox vbox=loader.load();
              /*  artworkcontroller artcont=loader.getController();
                artcont.setdata(artwork);*/
              postscontainer.getChildren().add(vbox);
                
            }
        } catch (Exception e) {
        }
    }


    
    
}
