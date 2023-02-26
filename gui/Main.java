/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package tn.esprit.arfulio.gui;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tn.esprit.arfulio.entites.Collaboration;
import tn.esprit.arfulio.services.ServCollaboration;

/**
 *
 * @author lelou
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {
        System.out.println("chemin");
        System.out.println(getClass().getResource("menuCollaboration.fxml"));
        System.out.println("chemin 2");
        try {
                Parent root = FXMLLoader.load(getClass().getResource("DemandeCollaboration.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        } catch (Exception e) {
            System.out.println("le getcause" + e.getCause());
            System.out.println("le getmessage " +e.getMessage());
            System.out.println("le stack trace "+e.getStackTrace());
        }
        //System.out.println(getClass().getResource("DemandeCollaboration.fxml"));
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }

}
