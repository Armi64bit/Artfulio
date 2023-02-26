package tn.esprit.artfulio.gui;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tn.esprit.artfulio.entites.User;
import tn.esprit.artfulio.entites.artwork;
import tn.esprit.artfulio.services.ArtworkService;
import java.text.DateFormat; 
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar; 
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import tn.esprit.artfulio.services.UserService;

import javafx.scene.paint.*;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class ArtworkpostController implements Initializable {

    @FXML
    private ImageView imgprofile;
    @FXML
    private Label fbname;
    @FXML
    private ImageView imgbadge;
    @FXML
    private Label datepost;
    @FXML
    private Label txtcaption;
    @FXML
    private ImageView Imgpost;
    @FXML
    private Label txtnbreact;
    @FXML
    private Label nbcomments;
    @FXML
    private Label nbshare;
    @FXML
    private HBox reactionsContainer;
    @FXML
    private ImageView like;
    @FXML
    private ImageView love;
    @FXML
    private ImageView atomic;
    @FXML
    private ImageView tongue;
    @FXML
    private HBox likeContainer;
    @FXML
    private ImageView postrec;
    @FXML
    private Label reactionname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
public void setdata(artwork a) {
 
 
//Image img= new Image(getClass().getResourceAsStream(a.getImg_artwork()));
//Image pdp= new Image(getClass().getResourceAsStream("logo.png"));
setImage(a.getImg_artwork());
setpdp(a.getId_artist());
   // Imgpost.setImage(img);
  //imgprofile.setImage(pdp);
   Date currentDate = a.getDate();
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(currentDate);

   // String date =DateFormat.format(a.getDate());
    datepost.setText(dateString);
    txtcaption.setText(a.getDescription_artwork());
        setartistename(a.getId_artist());
   
            
       
    
}

public void setImage(String imagePath) {
    File imageFile = new File(imagePath);
    Image image = new Image(imageFile.toURI().toString());
    Imgpost.setImage(image);
      
}
public void setpdp( int id) {
     User u = new User();
     UserService us = new UserService();
u=us.afficherProfilefb(id);
    File imageFile = new File(u.getImg_user());
    Image image = new Image(imageFile.toURI().toString());
    imgprofile.setImage(image);
    
      
}
public void setartistename(int id ){
     User u = new User();
     UserService us = new UserService();
u=us.afficherProfilefb(id);
  fbname.setText(u.getUsername());
}

private Image getRoundImage(Image image, int radius) {
    int width = (int) image.getWidth();
    int height = (int) image.getHeight();

    WritableImage wImage = new WritableImage(radius * 2, radius * 2);
    PixelWriter pixelWriter = wImage.getPixelWriter();
    PixelReader pixelReader = image.getPixelReader();
    Color c1 = new Color(0, 0, 0, 0);

    int w = (width / 2);
    int h = (height / 2);
    int r = radius * radius;

    for (int i = (width / 2) - radius, k = 0; i < w + radius; i++, k++)
        for (int j = (height / 2) - radius, b = 0; j < h + radius; j++, b++) {
            if ((i - w) * (i - w) + (j - h) * (j - h) > r)
                pixelWriter.setColor(k, b, c1);
            else
                pixelWriter.setColor(k, b, pixelReader.getColor(i, j));
        }
    return wImage;
}


public void onreactionpressed(MouseEvent me){

switch (((ImageView) me.getSource()).getId())
{ case "like":
    setreact(me);
    break;
    case "love":
    setreactlove(me);
    break;
    case "atomic":
    setreactatomic(me);
    break;
    
    case "tongue":
    setreacttongue(me);
    break;
    
    
}}
public void setreacttongue(MouseEvent me){

//if(System.currentTimeMillis()-starttime>50){
reactionsContainer.setVisible(false);
Image react= new Image(getClass().getResourceAsStream("tongue-out.png"));
postrec.setImage(react);
reactionname.setText("Haha");
reactionname.setTextFill(Color.web("red"));

//}
}
public void setreactatomic(MouseEvent me){

//if(System.currentTimeMillis()-starttime>50){
reactionsContainer.setVisible(false);
Image react= new Image(getClass().getResourceAsStream("love.png"));
postrec.setImage(react);
reactionname.setText("Atomic");
reactionname.setTextFill(Color.web("purple"));

//}
}
public void setreact(MouseEvent me){

//if(System.currentTimeMillis()-starttime>50){
reactionsContainer.setVisible(false);
Image react= new Image(getClass().getResourceAsStream("like.png"));
postrec.setImage(react);
reactionname.setText("Like");

reactionname.setTextFill(Color.web("blue"));
//}
}
public void setreactlove(MouseEvent me){

//if(System.currentTimeMillis()-starttime>50){
reactionsContainer.setVisible(false);
Image react= new Image(getClass().getResourceAsStream("heart.png"));
postrec.setImage(react);
reactionname.setText("Love");
reactionname.setTextFill(Color.web("red"));

//}
}

@FXML
public void onlikecontainermousereleased(MouseEvent me){

//if(System.currentTimeMillis()-starttime>50){
reactionsContainer.setVisible(true);
//}
}

 
}
