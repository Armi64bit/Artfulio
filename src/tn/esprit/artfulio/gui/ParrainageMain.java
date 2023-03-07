/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 21652
 */
public class ParrainageMain extends Application {
    
    
    public void start(Stage stage) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("Parrainage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Parrainage");
            stage.show();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
