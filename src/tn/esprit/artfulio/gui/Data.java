/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import java.time.LocalDate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author lelou
 */
public class Data {

    public static String description_artwork = "";
    //public static String titre = "";
    public static LocalDate date;
    public static String type = "";
    public static int id_type;
    public static String email = "";
    public static String nom_artwork = "";
    public static int id_artist;
    public static float dimension_artwork;
    public static float prix_artwork;

    
    /*
    
      private int id_artwork;
    private String nom_artwork;
    private String description_artwork;
    private float prix_artwork;
    private int id_type ;
    private Date date; 
    private int id_artist;
    private String lien_artwork;
    private float dimension_artwork;
    private String img_artwork;
    
    
    */

    public static void warning(String message, String titre) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titre);
        //alert.setContentText(message);
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    public static void information(String message, String titre) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titre);
        //   alert.setContentText(message);
        alert.setHeaderText(message);
        alert.showAndWait();
    }

}