package tn.esprit.artfulio.gui;

import java.io.File;
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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.esprit.artfulio.entites.Profile;

import tn.esprit.artfulio.entites.User;
import tn.esprit.artfulio.entites.artwork;

import tn.esprit.artfulio.services.UserService;
import tn.esprit.artfulio.services.ArtworkService;
import tn.esprit.artfulio.gui.ArtworkpostController;
import tn.esprit.artfulio.services.ProfileService;
import tn.esprit.artfulio.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class FeedadminController implements Initializable {

    @FXML
    private BorderPane parent;
    @FXML
    private VBox postscontainer;
    @FXML
    private VBox usercontainer;
    @FXML
    private ImageView darkorlight;
    @FXML
    private HBox taketocollabbtn;
    @FXML
    private HBox cate;
    @FXML
    private Button logout;
    @FXML
    private HBox reclam;
    @FXML
    private Button shop;
    @FXML
    private HBox pro;
    @FXML
    private Button profile;
    @FXML
    private Button refrech;
    @FXML
    private HBox useradmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     //   user_name.setText(User.getCurrent_User().getUsername());
      feed();
      users();
//      UserService us= new UserService();
//      User u=us.afficherProfilefb(9);
//       User.setCurrent_User(u);
//      SessionManager.getInstace(u.getId_user(),u.getCin_user(),u.getUsername(),u.getImg_user(),u.getEmail_user(),u.getAdresse_user(),u.getType_role(),u.getIs_pro());
//                 //    System.out.println(User.Current_User.getUsername());
    
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
                artcont.coms(listart.get(i).getId_artwork());
 
                postscontainer.getChildren().add(vbox);
                // if(listart.get(i).getId_artist()!=User.getCurrent_User().getId_user()){artcont.setdelvis();
}
            
            //}
            
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
           if(list.get(j).getIs_pro()==1) {
           
                FXMLLoader loaderu = new FXMLLoader();
                loaderu.setLocation(getClass().getResource("useritem.fxml"));
                HBox vboxu = loaderu.load();
                 vboxu.setAlignment(Pos.TOP_LEFT);
 vboxu.setPadding(new Insets(10));
               UseritemController artcont = loaderu.getController();
                artcont.setpdp(list.get(j));
                
                usercontainer.getChildren().add(vboxu);
            }
        }} catch (IOException ex) {
               Logger.getLogger(FeedadminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    

    


@FXML
    private void addartimg(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addkpost.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void imagefeed(MouseEvent event) {
        
        
        
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            
           // Parent root = FXMLLoader.load(getClass().getResource("feedimage.fxml"));/* Exception */
            FXMLLoader loaderp = new FXMLLoader(getClass().getResource("feedimage.fxml"));
            Parent root = loaderp.load();
           
           // FeedimageController fic =loaderp.getController();
            //fic.feed();
            //fic.users();
             Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    

    private void videofeed(MouseEvent event) {
        
        
        
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            
           // Parent root = FXMLLoader.load(getClass().getResource("feedimage.fxml"));/* Exception */
            FXMLLoader loaderp = new FXMLLoader(getClass().getResource("feedvideo.fxml"));
            Parent root = loaderp.load();
           
           // FeedimageController fic =loaderp.getController();
            //fic.feed();
            //fic.users();
             Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    private void musicfeed(MouseEvent event) {
        
        
        
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            
           // Parent root = FXMLLoader.load(getClass().getResource("feedimage.fxml"));/* Exception */
            FXMLLoader loaderp = new FXMLLoader(getClass().getResource("feedmusique.fxml"));
            Parent root = loaderp.load();
           
           // FeedimageController fic =loaderp.getController();
            //fic.feed();
            //fic.users();
             Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }

    @FXML
    private void taketocollab(MouseEvent event) {
        
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuCollaborationadmin.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            //QrController q=fxmlLoader.getController();
           // ArtworkService as= new ArtworkService();
            stage.setTitle("collab");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gottocat(MouseEvent event) {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            //QrController q=fxmlLoader.getController();
           // ArtworkService as= new ArtworkService();
            stage.setTitle("collab");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    @FXML
    private void gotshop(ActionEvent event) {
        
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Store.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            //QrController q=fxmlLoader.getController();
           // ArtworkService as= new ArtworkService();
            stage.setTitle("collab");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void reclam(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminReclamation.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            //QrController q=fxmlLoader.getController();
           // ArtworkService as= new ArtworkService();
            stage.setTitle("collab");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void pro(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminParrainage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            //QrController q=fxmlLoader.getController();
           // ArtworkService as= new ArtworkService();
            stage.setTitle("collab");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void profile(ActionEvent event) {
        try {
            int id= User.getCurrent_User().getId_user();
            FXMLLoader loaderp = new FXMLLoader(getClass().getResource("profile.fxml"));
            Object root = loaderp.load();
            ProfileController pc = loaderp.getController();
            pc.setdata(id);
            pc.feedaudio(id);
            pc.feedimg(id);
            pc.feedmusic(id);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene((Parent) root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ArtworkpostController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   @FXML
    private void logout(ActionEvent event) {
        User u= new User();
        User.setCurrent_User(u);
         try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            
           // Parent root = FXMLLoader.load(getClass().getResource("feedimage.fxml"));/* Exception */
            FXMLLoader loaderp = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loaderp.load();
           
           // FeedimageController fic =loaderp.getController();
            //fic.feed();
            //fic.users();
             Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void refrech(ActionEvent event) {
         User u= new User();
        User.setCurrent_User(u);
         try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            
           // Parent root = FXMLLoader.load(getClass().getResource("feedimage.fxml"));/* Exception */
            FXMLLoader loaderp = new FXMLLoader(getClass().getResource("feedadmin.fxml"));
            Parent root = loaderp.load();
           
           // FeedimageController fic =loaderp.getController();
            //fic.feed();
            //fic.users();
             Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void adminuser(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DashboardAdmin.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            //QrController q=fxmlLoader.getController();
           // ArtworkService as= new ArtworkService();
            stage.setTitle("collab");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}


