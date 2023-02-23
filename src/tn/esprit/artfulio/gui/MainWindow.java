/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author karra
 */
public class MainWindow extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {


            Parent root = FXMLLoader.
                    load(getClass().getResource("feed.fxml"));
            Scene scene = new Scene(root);
           String css;
            //css = this.getClass().getResource("application.css").toExternalForm();
   //scene.getStylesheets().add(css);
            primaryStage.setTitle("Artfulio");
            //Image image =new Image("logo.png");
          //  primaryStage.getIcons().add(image);
        //   primaryStage.getIcons().add(new Image("file:logo.png"));
            primaryStage.setScene(scene);
            primaryStage.show();
        
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
}
