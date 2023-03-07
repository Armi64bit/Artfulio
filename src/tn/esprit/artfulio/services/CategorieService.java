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
import tn.esprit.artfulio.entites.categorie;
import tn.esprit.artfulio.utils.MyConnection;

/**
 *
 * @author CALLO
 */
public class CategorieService implements ICategorieService{
static Connection myconnex
           = MyConnection.getInstance().getConnection();
    @Override
    public int ajoutercategorie(categorie p) {
           int id = -1;
        try {
           String req1 = " INSERT INTO  `categorie` (`id_categorie`, `type_categorie`, `nom_categorie`) VALUES (NULL, '"+p.getNom_categorie()+"', '"+p.getType_categorie()+"')";

            Statement ste = myconnex.createStatement();
            id = ste.executeUpdate(req1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    @Override
    public boolean modifiercategorie(categorie p) {
       try {
           int id_categorie = 7;
           String nom = p.getNom_categorie();
          String type = p.getType_categorie();
        

       String req = "  UPDATE `categorie` SET  `type_categorie` = ?, `nom_categorie` = ? WHERE `id_categorie` = '" + p.getId_categorie()+ "';";
    

           PreparedStatement ps = myconnex
                  .prepareStatement(req);
       
            ps.setString(1, type);
            ps.setString(2, nom);
    

           ps.executeUpdate();

       int rowsUpdated = ps.executeUpdate();
           if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");

           }
           return true;
      } catch (SQLException ex) {
           return false;
   }
    }

    @Override
    public boolean supprimercategorie(categorie p) {
    
     try {
          String req = "delete from `categorie` where id_categorie= ? ";
          PreparedStatement ps = myconnex
                  .prepareStatement(req);
         ps.setInt(1, p.getId_categorie());
        ps.executeUpdate();
       return true;

       } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    

    @Override
    public List<categorie> affichercategorie() {
          List<categorie> list = new ArrayList<>();
    try {
            String req = "select * from `categorie`";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                categorie s = new categorie();
                s.setType_categorie(res.getString("type_categorie"));
                s.setNom_categorie(res.getString("nom_categorie"));

               list.add(s);
            }
       } catch (SQLException ex) {
        }
        return list;
    }

    
}
