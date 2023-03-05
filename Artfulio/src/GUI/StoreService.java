/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utils.MyConnection;
import entities.Artwork;
import entities.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import services.IStoreService;

/**
 *
 * @author Asus
 */
public class StoreService implements IStoreService{
  Connection myconnex
            = MyConnection.getInstance().getConnection();
    
    @Override
    public int ajouterArt(Artwork a) {
       
    
         int id = -1;
        try {
            
            String req1 = "INSERT INTO store (id_produit,id_piece_art, nom_artwork, prix_artwork, img_artwork)"
                    + " VALUES (NULL, '" + a.getId_artwork() +"',+'"+a.getNom_artwork()+"','"+a.getPrix_artwork()+"','"+a.getImg_artwork()+"'); ";

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
