package tn.esprit.artfulio.gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import tn.esprit.artfulio.entites.artwork;
import tn.esprit.artfulio.services.ArtworkService;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class ProfileController implements Initializable {

    @FXML
    private BorderPane parent;
    @FXML
    private Button chnagemode;
    @FXML
    private ImageView darkorlight;
    private VBox postscontainer;
    @FXML
    private ImageView imgfb;
    @FXML
    private ImageView imgtwtr;
    @FXML
    private ImageView imgytb;
    @FXML
    private HBox portfoliocontainer;
    @FXML
    private ImageView imgytb1;
    @FXML
    private HBox musiccontainer;
    @FXML
    private HBox portfoliocontainer1;
    @FXML
    private HBox videocontainer;
    @FXML
    private HBox portfoliocontainer11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         feed(portfoliocontainer);
         feed(musiccontainer);
         feed(videocontainer);
         
    }    

    
     public void feed (HBox portfoliocontainer){
    
        ArtworkService as = new ArtworkService();

        List<artwork> listart = new ArrayList<>();
       // users();
        try {

            listart = as.afficherartwork();
            for (int i = 0; i < listart.size(); i++) {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("portfolioitem.fxml"));
                VBox vbox = loader.load();
                PortfolioitemController artcont = loader.getController();
                artcont.setdata(listart.get(i));
                portfoliocontainer.getChildren().add(vbox);

            }
        } catch (Exception e) {
        }
}
@FXML
    public void ig()
    {   try {
    Desktop.getDesktop().browse(new URL("https://www.instagram.com").toURI());
} catch (IOException e) {
    e.printStackTrace();
} catch (URISyntaxException e) {
    e.printStackTrace();
}
    
    }
@FXML
    public void fb()
    {   try {
    Desktop.getDesktop().browse(new URL("https://www.fb.com").toURI());
} catch (IOException e) {
    e.printStackTrace();
} catch (URISyntaxException e) {
    e.printStackTrace();
}
    
    }

@FXML
    public void twitter()
    {   try {
    Desktop.getDesktop().browse(new URL("https://www.twitter.com").toURI());
} catch (IOException e) {
    e.printStackTrace();
} catch (URISyntaxException e) {
    e.printStackTrace();
}
    
    }
@FXML
    public void youtube()
    {   try {
    Desktop.getDesktop().browse(new URL("https://www.youtube.com").toURI());
} catch (IOException e) {
    e.printStackTrace();
} catch (URISyntaxException e) {
    e.printStackTrace();
}
    
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
}
