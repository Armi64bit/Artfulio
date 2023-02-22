/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import tn.esprit.artfulio.entites.Profile;
import tn.esprit.artfulio.services.ProfileService;
import tn.esprit.artfulio.entites.skills;
import tn.esprit.artfulio.services.skillsservice;

import java.awt.Desktop;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.esprit.artfulio.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author karra
 */
public class AuthenticationController implements Initializable {
  
static Connection myconnex
            = MyConnection.getInstance().getConnection();
    @FXML
    private Label lb_name;
    
    private BorderPane bp;
    
    @FXML
    private Label lb_Bio;
    
    
 
    @FXML
    private Label id_twitter;
     private Stage stage;
 private Scene scene;
 private Parent root;
    @FXML
    private Button btnac1;
  
    @FXML
    private ChoiceBox<String> listprofilebox;
    @FXML
    private Text txtig;
    @FXML
    private Text txtfb;
    @FXML
    private Text txttwt;
    @FXML
    private Text txtytb;
    @FXML
    private Pane imgig;
    @FXML
    private ImageView imgfb;
    @FXML
    private ImageView imgtwtr;
    @FXML
    private ImageView imgytb;
    @FXML
    private Tab txtnameskill;
    @FXML
    private Text txtdesc;
    @FXML
    private TabPane tabskil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ProfileService ps=new ProfileService();
        List <Profile> L =ps.afficherProfile();
        
          // Personne p = new Personne(22, "Esprit", "Ariana");
           String[] str = new String[L.size()];
 
        for (int i = 0; i < L.size(); i++) {
            str[i] = L.get(i).getFb();
        }
       for (int i = 0; i < L.size(); i++) {
      listprofilebox.getItems().add(L.get(i).getFb());
    listprofilebox.setOnAction(this::displayprofile);
          }
        skillsservice ss=new skillsservice();
        List <skills> Ls =ss.afficherskills(/*txtfb.getText()*/) ; //mocdifier ca bech tsallah fazet el skilsl tab
       //   String[] strs = new String[Ls.size()];
  for (int i = 0; i < Ls.size(); i++) {
        Tab tab1 =new Tab(Ls.get(i).getTitre_skill());
        tab1.setClosable( false);
        //txtdescc.setText(Ls.get(i).getDesc_skill());
   Text txtdescc= new Text(Ls.get(i).getDesc_skill());
  
   tab1.setContent(txtdescc);
         tabskil.getTabs().add(tab1);
          
        }
  
        
            
// PersonneCRUD pcd = new PersonneCRUD();
         ////List<Personne> pp=pcd.listeDesEntites();
         //Personne first=pp.get(0);
         
        //lb_name.setText(first.getNom());
        //lb_Bio.setText(first.getPrenom());
       //lb_Bio.setText(first.getPrenom());
        
        
        
    }    
  @FXML
    private Button btnac;
    
        
    
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
    public void displayprofile(ActionEvent event){
        ProfileService ps=new ProfileService();
        String fb=listprofilebox.getValue();
            lb_Bio.setText(ps.afficherProfilefb(fb).getBio());
            txtig.setText(ps.afficherProfilefb(fb).getIg());
            txtfb.setText(ps.afficherProfilefb(fb).getFb());
            txttwt.setText(ps.afficherProfilefb(fb).getTwitter());
            txtytb.setText(ps.afficherProfilefb(fb).getYtb());
            
            
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
   
    private void edit(ActionEvent event){
     loadpage("editprofile.fxml");}
    private void loadpage(String page) {
        
        Parent root =null;
        try {
            root=FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        bp.setCenter(root);
    }
    
    
    @FXML
    public void switcheditprofile(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("editprofile.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  
  scene = new Scene(root);
  String css;
            css = this.getClass().getResource("application.css").toExternalForm();
   scene.getStylesheets().add(css);
  stage.setScene(scene);
  stage.show();
 }
    public void upd(ActionEvent event) throws IOException {
  try {
      root = FXMLLoader.load(getClass().getResource("updateprofile.fxml"));
  
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();}
    catch (IOException ex) {
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.SEVERE, null, ex);
        }}
 
    
    
      @FXML
    public void switchupdateprofile(ActionEvent event) throws IOException {
  
           String bio =lb_Bio.getText();
           String ig=txtig.getText();
           String fb=txtfb.getText();
           String twitter=txttwt.getText();
           String ytb=txtytb.getText();
     FXMLLoader loader = new FXMLLoader(getClass().getResource("updateprofile.fxml"));
root = loader.load();
UpdateprofileController UpdateprofileController = loader.getController();

UpdateprofileController.updatepreloadtxt(bio, ig, fb, twitter, ytb);
//  root = FXMLLoader.load(getClass().getResource("updateprofile.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  
  scene = new Scene(root);
  String css;
            css = this.getClass().getResource("application.css").toExternalForm();
   scene.getStylesheets().add(css);
  stage.setScene(scene);
  stage.show();
 }


    @FXML
    private void test(ActionEvent event) {
    }

}

