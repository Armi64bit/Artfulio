package tn.esprit.artfulio.gui;

import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import tn.esprit.artfulio.api.QR;
import tn.esprit.artfulio.entites.User;
import tn.esprit.artfulio.entites.artwork;
import tn.esprit.artfulio.services.ArtworkService;
import tn.esprit.artfulio.services.UserService;


/**
 * FXML Controller class
 *
 * @author msi
 */
public class AddkpostController implements Initializable {

    @FXML
    private ImageView Imgpost;
    @FXML
    private Button imp;
    @FXML
    private DatePicker dateart;
    @FXML
    private Button vld;
    @FXML
    private TextField nom;
    @FXML
    private TextField desc;
    @FXML
    private ChoiceBox<?> type;
    @FXML
    private TextField lien;
    @FXML
    private TextField dim;
    @FXML
    private TextField prix;
 
    @FXML
    private TextField path;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }


    @FXML
    public void handleChooseImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new ExtensionFilter("All Files", ".")
        );
        File selectedFile = fileChooser.showOpenDialog(((Node) event.getTarget()).getScene().getWindow());
        if (selectedFile != null) {
            String imagePath = selectedFile.toURI().toString();
            Image image = new Image(imagePath);
            Imgpost.setImage(image);
            path.setText(selectedFile.getAbsolutePath());
        }
    }

    @FXML
    private void addimg(ActionEvent event) {
        //  int u=user.getValue().toString;
        String n = nom.getText();
        String des=desc.getText();
        String i=path.getText();
        System.out.println(i);
        //String sDate1=dateart.getValue().toString();
        //Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);
        //Date da=date1;
        // int  typ=type.getValue().toString();
        String  li=lien.getText();
         float  di=Float.valueOf(dim.getText());
        int id= Integer.parseInt( prix.getText());
        float p=(float)id;
         
        ArtworkService as = new ArtworkService();
         
java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            
        artwork a= new artwork(n, des, p, 4, date, User.Current_User.getId_user(), li, di, i);
        as.ajouterartwork2(a);

      QR qr=new QR();
      String path=a.getLien_artwork();
     
      qr.Create_QR(path,a.getNom_artwork());


    }
    

}
