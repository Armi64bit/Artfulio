/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.*;
/**
 *
 * @author lelou
 */
public class DBConnexion {
    
   private static DBConnexion instance = null;
   private Connection connexion = null;
   private String url = "jdbc:mysql://localhost:3306/clubesprit";
   private String utilisateur = "michel";
   private String motDePasse = "michel";

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
