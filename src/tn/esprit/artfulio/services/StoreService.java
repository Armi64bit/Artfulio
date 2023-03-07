/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.services;

import tn.esprit.artfulio.utils.MyConnection;
import tn.esprit.artfulio.entites.artwork;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static tn.esprit.artfulio.services.ArtworkService.myconnex;
//import static services.ArtworkService.myconnex;

/**
 *
 * @author Asus
 */
public class StoreService implements IStoreService{
public static Connection myconnex
           = MyConnection.getInstance().getConnection();
    @Override
    public int ajouterArt(artwork p) {
        
        
         
      
        int id = -1;
        try {
  String sql = "INSERT INTO store (id_produit,id_piece_art, nom_artwork, prix_artwork, img_artwork)"
                    + " VALUES (NULL, ?,?,?,?); ";
            PreparedStatement statement = myconnex.prepareStatement(sql);
            statement.setInt(1, p.getId_artwork());
            statement.setString(2, p.getNom_artwork());   
            statement.setFloat(3, p.getPrix_artwork());  
            statement.setString(4, p.getImg_artwork());   
         
            id = statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    

    @Override
    public boolean modifierArt(artwork a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimerArt(artwork a) {
         try {
          String req = "DELETE FROM `store` WHERE id_piece_art= ? ";
          PreparedStatement ps = myconnex
                  .prepareStatement(req);
         ps.setInt(1, a.getId_artwork());
        ps.executeUpdate();
       return true;

       } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    

    @Override
    public List<artwork> afficherArts() {
         
         List<artwork> list = new ArrayList<>();
        try {
            String req = "select * from store";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                artwork p = new artwork();
                p.setId_artwork(res.getInt("id_produit"));
                p.setNom_artwork(res.getString("nom_artwork"));
                p.setPrix_artwork(res.getFloat("prix_artwork"));
                p.setImg_artwork(res.getString("img_artwork"));
               

                list.add(p);
            }
        } catch (SQLException ex) {
        }
        return list;
    }
    
}
