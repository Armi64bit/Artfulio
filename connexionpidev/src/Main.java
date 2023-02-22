
import entites.Categorie;
import java.io.IOException;
import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.CategorieService;
import utils.MyConnection;

public class Main extends Application {
 
    public void start(Stage primaryStage) throws IOException  
    {
          
       
       Parent parentPage = FXMLLoader.load(getClass().getResource("/gui/FXML2.fxml"));
        
      //Parent parentPage = FXMLLoader.load(getClass().getResource("/interfaces/Annonceback.fxml"));
        // Parent parentPage = FXMLLoader.load(getClass().getResource("/interfaces/AlertsGUI.fxml"));
        Scene scene = new Scene(parentPage);
        
         primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
         
       
       
    }
    
    
    
    
    
  
    public static void main (String []args){  
        
    
    launch(args);
        Categorie c = new Categorie("hamza","jgf","jhg", "dd");
        CategorieService personneService = new CategorieService();
     System.out.println( personneService.ajouter(c));
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
          System.out.println( personneService.afficher());
      //   System.out.println( personneService.modifierPersonne(p));
        //  System.out.println( personneService.supprimerPersonne(p));
        //  System.out.println( personneService.afficherPersonnes());
                    

}

    private static Object MyConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
