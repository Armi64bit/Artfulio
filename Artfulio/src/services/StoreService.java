/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Utils.MyConnection;
import entities.Artwork;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static services.ArtworkService.myconnex;

/**
 *
 * @author Asus
 */
public class StoreService implements IStoreService{
public static Connection myconnex
           = MyConnection.getInstance().getConnection();
    @Override
    public int ajouterArt(Artwork a) {
              int id = -1;
        try {
             
            String req1 = "INSERT INTO store (id_produit,id_piece_art, nom_artwork, prix_artwork, img_artwork)"
                    + " VALUES (NULL, '" + a.getId_artwork() +"',+'"+a.getNom_artwork()+"','"+a.getPrix_artwork()+"','"+a.getImg_artwork()+"'); ";
       //    String req1 = " INSERT INTO  `categorie` (`id_categorie`, `type_categorie`, `nom_categorie`) VALUES (NULL, '"+p.getNom_categorie()+"', '"+p.getType_categorie()+"')";

            Statement ste = myconnex.createStatement();
            id = ste.executeUpdate(req1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    

    @Override
    public boolean modifierArt(Artwork a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimerArt(Artwork a) {
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
    public List<Artwork> afficherArts() {
         
         List<Artwork> list = new ArrayList<>();
        try {
            String req = "select * from store";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                Artwork p = new Artwork();
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
