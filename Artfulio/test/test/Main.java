package test ;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import entities.Artwork;
import services.StoreService;


public class Main extends Application{

   
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Store.fxml"));
        primaryStage.setTitle("Artfulio");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }



   public static void main(String[] args) {
       launch(args);

//      public static void main(String[] args) {
//      Artwork a = new Artwork(0, "test1","test1", 111, 111, 11,"test1", 111,"test1");
//        StoreService serviceStore = new  StoreService();
//        System.out.println(serviceStore.supprimerArt(a));
//        System.out.println(serviceStore.afficherArts());
        

        
    }}
