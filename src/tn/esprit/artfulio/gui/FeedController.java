package tn.esprit.artfulio.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

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
    
    private boolean islightmode=true;
    public  void changemode(ActionEvent e){
        islightmode=!islightmode;
        if(islightmode){
        setlightmode();
        }
        else 
        {setdarkmode();}
    }

public  void setlightmode()
{
    parent.getStylesheets().remove("file:feeddark.css");
    parent.getStylesheets().add("feed.css");
    /*Image img = new Image("url");
    imgmode.setImage(img);*/

}

public  void setdarkmode(){
     parent.getStylesheets().remove("feed.css");
    parent.getStylesheets().add("feeddark.css");
}
    
    
}
