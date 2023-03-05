/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.esprit.artfulio.entites.sous_categorie;

import tn.esprit.artfulio.utils.MyConnection;

/**
 *
 * @author CALLO
 */
public class SouscategorieService implements ISouscategorieService {
static Connection myconnex
       = MyConnection.getInstance().getConnection();
    @Override
    public int ajoutersouscategorie(sous_categorie p) {
         int id= -1;
         try {
              
             String req1 = "INSERT INTO `sous_cat`(`id_sous_cat`, `nom_sous_cat`, `type_sous_cat`, `id_categorie`) VALUES (NULL,'"+p.getNom_sous_categorie()+"','"+p.getType_sous_categorie()+"')";
         //  String req1 = " INSERT INTO  `categorie` (`id_categorie`, `type_categorie`, `nom_categorie`) VALUES (NULL, '"+p.getNom_categorie()+"', '"+p.getType_categorie()+"')";

            Statement ste = myconnex.createStatement();
          id = ste.executeUpdate(req1);
       } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
       
    }

    @Override
    public boolean modifiersouscategorie(sous_categorie p) {
               try {
         int id_categorie = 7;
           String nom = p.getNom_sous_categorie();
         String type = p.getType_sous_categorie();
       

          
          String req = "UPDATE `sous_cat` SET `nom_sous_cat`= ?,`type_sous_cat`='[value-3]', WHERE 1  `id_sous_cat`='"+p.getId_sous_categorie()+"' ";
     //  String req = "   UPDATE `categorie` SET  `type_categorie` = ?, `nom_categorie` = ? WHERE `id_categorie` = '" + p.getId_categorie()+ "';";
    

           PreparedStatement ps = myconnex
                  .prepareStatement(req);
                   ps.setString(1, nom);
            ps.setString(2, type);
   

          ps.executeUpdate();

      int rowsUpdated = ps.executeUpdate();
          if (rowsUpdated > 0) {
               System.out.println("An existing user was updated successfully!");

          }
          return true;
      } catch (SQLException ex) {
           return false;
  }
//        
    }

    @Override
    public boolean supprimersouscategorie(sous_categorie p) {
          try {
        String req = "DELETE FROM `sous_cat` WHERE id_sous_cat = ? ";
          PreparedStatement ps = myconnex
                  .prepareStatement(req);
        ps.setInt(1, p.getId_sous_categorie());
        ps.executeUpdate();
       return true;

      } catch (SQLException ex) {
           System.out.println(ex);
           return false;        }
    }
       
//    }
    

    @Override
    public List<sous_categorie> affichersouscategorie() {
      
    List<sous_categorie> list = new ArrayList<>();
        try {
            String req = "select * from sous_cat";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                sous_categorie s = new sous_categorie();
                s.setType_sous_categorie(res.getString("type_sous_cat"));
                s.setNom_sous_categorie(res.getString("nom_sous_cat"));

                list.add(s);
            }
        } catch (SQLException ex) {
        }
        return list;
    }

    }
