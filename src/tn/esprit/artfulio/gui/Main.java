/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author lelou
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        System.out.println("chemin");
        System.out.println(getClass().getResource("feedadmin.fxml"));
       Parent root = FXMLLoader.load(getClass().getResource("feedadmin.fxml")); 
        
    //     System.out.println(getClass().getResource("menuCollaboration.fxml"));
    //   Parent root = FXMLLoader.load(getClass().getResource("menuCollaboration.fxml")); 
     /* System.out.println(getClass().getResource("modifierCollaboration.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("modifierCollaboration.fxml")); */
                
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
