package tn.esprit.artfulio.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
        setdata();
    }    
    
private void setdata(){
Image img= new Image(getClass().getResourceAsStream("post.jpg"));
Image pdp= new Image(getClass().getResourceAsStream("logo.png"));

    Imgpost.setImage(img);
    imgprofile.setImage(pdp);
    
    fbname.setText("Bahaa Eddine Bouzid");
    
}
private long starttime=0;
public void onlikecontainerpressed(MouseEvent me){

starttime=System.currentTimeMillis();
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
//}
}
public void setreactatomic(MouseEvent me){

//if(System.currentTimeMillis()-starttime>50){
reactionsContainer.setVisible(false);
Image react= new Image(getClass().getResourceAsStream("love.png"));
postrec.setImage(react);
reactionname.setText("Atomic");
//}
}
public void setreact(MouseEvent me){

//if(System.currentTimeMillis()-starttime>50){
reactionsContainer.setVisible(false);
Image react= new Image(getClass().getResourceAsStream("like.png"));
postrec.setImage(react);
reactionname.setText("Like");
//}
}
public void setreactlove(MouseEvent me){

//if(System.currentTimeMillis()-starttime>50){
reactionsContainer.setVisible(false);
Image react= new Image(getClass().getResourceAsStream("heart.png"));
postrec.setImage(react);
reactionname.setText("Love");
//}
}

@FXML
public void onlikecontainermousereleased(MouseEvent me){

//if(System.currentTimeMillis()-starttime>50){
reactionsContainer.setVisible(true);
//}
}

 
}
