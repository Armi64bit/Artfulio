package tn.esprit.artfulio.gui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.esprit.artfulio.entites.User;
import tn.esprit.artfulio.entites.artwork;
import tn.esprit.artfulio.services.ArtworkService;
import tn.esprit.artfulio.services.ProfileService;
import tn.esprit.artfulio.entites.Profile;
import tn.esprit.artfulio.entites.skills;

import tn.esprit.artfulio.services.UserService;
import tn.esprit.artfulio.services.skillsservice;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class ProfileController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    Stack<UpdateprofileController> controllers = new Stack<>();
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
    @FXML
    private ImageView imgprofile;
    @FXML
    private Label username;
    @FXML
    private Label bio;
    @FXML
    private ImageView ig;
    @FXML
    private HBox editprofile;
    @FXML
    private HBox skillcontainer;
    @FXML
    private Label id_user;
    @FXML
    private Button chnagemode1;
    @FXML
    private HBox collabwitth;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //feedimg();
      //  feedaudio();
    //    feedmusic();

    }

    public void feedaudio(int id) {

        ArtworkService as = new ArtworkService();

        List<artwork> listart = new ArrayList<>();
        // users();
        try {

            listart = as.afficherartwork(4,id);
            for (int i = 0; i < listart.size(); i++) {
                if (listart.get(i).getId_type()==4) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("portfolioitem.fxml"));
                    VBox vbox = loader.load();
                    PortfolioitemController artcont = loader.getController();
                    artcont.setdata(listart.get(i));
                    musiccontainer.getChildren().add(vbox);

                }
            }
        } catch (Exception e) {
        }
    }

    public void feedimg(int id) {

        ArtworkService as = new ArtworkService();

        List<artwork> listart = new ArrayList<>();
        // users();
        try {

            listart = as.afficherartwork(2,id);
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

    public void feedmusic(int id) {//feedvideo

        ArtworkService as = new ArtworkService();
 
        List<artwork> listart = new ArrayList<>();
        // users();
        try {

            listart = as.afficherartwork(3,id);
            for (int i = 0; i < listart.size(); i++) {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("portfolioitem.fxml"));
                VBox vbox = loader.load();
                PortfolioitemController artcont = loader.getController();
                artcont.setdata(listart.get(i));
                videocontainer.getChildren().add(vbox);

            }
        } catch (Exception e) {
        }
    }

    ProfileService pss = new ProfileService();

    @FXML
    public void ig() {
        try {
            int id = Integer.parseInt(id_user.getText());

            Desktop.getDesktop().browse(new URL("wwww." + pss.getprofileuser(id).getIg() + ".com").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void fb() {
        try {
            Desktop.getDesktop().browse(new URL("https://www.fb.com").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void twitter() {
        try {
            Desktop.getDesktop().browse(new URL("https://www.twitter.com").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void youtube() {
        try {
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

    public void setpdp(int id) {
        User u = new User();
        UserService us = new UserService();
        u = us.afficherProfilefb(id);
        File imageFile = new File(u.getImg_user());
        Image image = new Image(imageFile.toURI().toString());
        imgprofile.setImage(image);
    }

    public void setdata(int id) {
        User u = new User();
        UserService us = new UserService();
        u = us.afficherProfilefb(id);

        setpdp(id);

        username.setText(u.getUsername());
        ProfileService ps = new ProfileService();
        Profile p = new Profile();
        p = ps.getprofileuser(id);
        bio.setText(p.getBio());
        id_user.setText("" + id + "");
        skillsservice ss = new skillsservice();
        List<skills> sk = new ArrayList<>();
        sk = ss.afficherskills(id);

    }

    @FXML
    private void GoToprofile(ActionEvent event) throws IOException {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("feed.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void taketoprofile(MouseEvent event) {
        try {
            int id = Integer.parseInt(id_user.getText());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("updateprofile.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            UpdateprofileController pc = fxmlLoader.getController();
            ProfileService ps = new ProfileService();
            Profile p = new Profile();
UserService us =new UserService();
User u =new User();
u=us.afficherProfilefb(id);
            p = ps.getprofileuser(id);

            pc.updatepreloadtxt(p.getBio(), p.getIg(), p.getFb(), p.getTwitter(), p.getYtb(), id,u.getUsername(),u.getImg_user());

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GoToprofile(MouseEvent event) {
    }

    @FXML
    private void takedomcollab(MouseEvent event) {
        
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DemandeCollaboration.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
             DemandeCollaborationController q=fxmlLoader.getController();
             int id = Integer.parseInt(id_user.getText());
             q.setid_artiste(id);
// ArtworkService as= new ArtworkService();
            stage.setTitle("collab");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FeedController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
