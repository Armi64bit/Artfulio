/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.Artfulio.gui;

import java.time.LocalDate;
import javafx.scene.control.Alert;


/**
 *
 * @author lelou
 */
public class Data {
    public static String description = "";
    public static String titre = "";
    public static LocalDate date_f;
    public static String type = "";
    public static int id;
    public static String email = "";
    public static String nom = "";
    
         public static void warning(String message, String titre) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titre);
        //alert.setContentText(message);
        alert.setHeaderText(message);
        alert.showAndWait();
    }
      
        public static void information(String message,String titre){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titre);
     //   alert.setContentText(message);
        alert.setHeaderText(message);
        alert.showAndWait(); 
    }
}
