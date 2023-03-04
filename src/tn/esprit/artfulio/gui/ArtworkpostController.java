package tn.esprit.artfulio.gui;

import java.io.File;
import java.io.IOException;
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
import java.util.ArrayList;
import java.util.Date;  
import java.util.Calendar; 
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import tn.esprit.artfulio.services.UserService;

import javafx.scene.paint.*;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.esprit.artfulio.entites.commentaire;
import tn.esprit.artfulio.services.commentaireservice;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class ArtworkpostController implements Initializable {
    private Stage stage;
 private Scene scene;
 private Parent root;
 
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
    @FXML
    private Label id_user;
    @FXML
    private VBox commentcontainer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    coms ();   
    }    
    
public void setdata(artwork a) {
 commentaireservice cs=new commentaireservice();
 
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
   
            id_user.setText(""+a.getId_artist()+"");
            int numcom=cs.numcom(a.getId_artwork());
            nbcomments.setText(numcom+"  commentaire(s)");
            System.out.println(numcom);
       
    
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
   if(u.getIs_pro()==0)
    {
   imgbadge.setVisible(false);}
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
    @FXML
    public void setreacttongue(MouseEvent me){

//if(System.currentTimeMillis()-starttime>50){
reactionsContainer.setVisible(false);
Image react= new Image(getClass().getResourceAsStream("tongue-out.png"));
postrec.setImage(react);
reactionname.setText("Haha");
reactionname.setTextFill(Color.web("red"));

//}
}
    @FXML
    public void setreactatomic(MouseEvent me){

//if(System.currentTimeMillis()-starttime>50){
reactionsContainer.setVisible(false);
Image react= new Image(getClass().getResourceAsStream("love.png"));
postrec.setImage(react);
reactionname.setText("Atomic");
reactionname.setTextFill(Color.web("purple"));

//}
}
    @FXML
    public void setreact(MouseEvent me){

//if(System.currentTimeMillis()-starttime>50){
reactionsContainer.setVisible(false);
Image react= new Image(getClass().getResourceAsStream("like.png"));
postrec.setImage(react);
reactionname.setText("Like");

reactionname.setTextFill(Color.web("blue"));
//}
}
    @FXML
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

   

    @FXML
    private void taketoprofile(MouseEvent event) {
        try {
            int id= Integer.parseInt(id_user.getText());
            FXMLLoader loaderp = new FXMLLoader(getClass().getResource("profile.fxml"));
            root = loaderp.load();
            ProfileController pc = loaderp.getController();
            pc.setdata(id);
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ArtworkpostController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void coms (){
    
        commentaireservice as = new commentaireservice();

        List<commentaire> listcom = new ArrayList<>();
       // users();
        try {

            listcom = as.affichercommentaire();
            for (int i = 0; i < listcom.size(); i++) {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("comment.fxml"));
                HBox vbox = loader.load();
                CommentController artcont = loader.getController();
                artcont.loadcom(listcom.get(i));
                commentcontainer.getChildren().add(vbox);

            }
        } catch (Exception e) {
        }
}

  

}
