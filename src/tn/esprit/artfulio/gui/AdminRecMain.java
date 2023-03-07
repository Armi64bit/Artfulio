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
public class AdminRecMain extends Application {

    @Override
    public void start(Stage stage) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("AdminReclamation.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            String css;
            css = this.getClass().getResource("feed.css").toExternalForm();
            scene.getStylesheets().add(css);

            stage.setTitle("Admin Reclamation sec");
            stage.show();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
