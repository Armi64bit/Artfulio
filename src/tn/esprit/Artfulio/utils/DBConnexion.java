/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.Artfulio.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lelou
 */
public class DBConnexion {
    private static DBConnexion instance = null;
   private Connection connexion = null;
   private String url = "jdbc:mysql://localhost:3306/work";
   private String utilisateur = "root";
   private String motDePasse = "";

   private DBConnexion() {
      try {
         connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
          System.out.println("connexion reussi");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public static DBConnexion getInstance() {
      if (instance == null) {
         instance = new DBConnexion();
      }
      return instance;
   }

   public Connection getConnexion() {
      return connexion;
   }
}
