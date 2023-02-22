/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Utils.MyConnection;
import entities.Piece_Art;
import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Asus
 */
public class PieceService implements IPiece_Art{

     Connection myconnex
            = MyConnection.getInstance().getConnection();
    
    @Override
    public int ajouterArt(Piece_Art a) {
         int id = -1;
        try {
            String req1 = "INSERT INTO piece_art (id_piece_art, nom)"
                    + " VALUES (NULL, '" + a.getNom() +"'); ";

            Statement ste = myconnex.createStatement();
            id = ste.executeUpdate(req1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }
       
    

    @Override
    public boolean modifierArt(Piece_Art a) {
         try {
            String nom = a.getNom();
           

            String req = "  UPDATE `piece_art` SET  `nom` = ? WHERE `piece_art`.`nom` = '" + a.getNom()+ "';";

            PreparedStatement ps = myconnex
                    .prepareStatement(req);
           // ps.setInt(1, id_util);
            ps.setString(1, nom);
           

            ps.executeUpdate();

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");

            }

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerArt(Piece_Art a) {
     try {
            String req = "delete from piece_art where nom= ? ";
            PreparedStatement ps = myconnex
                    .prepareStatement(req);
            ps.setString(1, a.getNom());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
   
    }

    @Override
    public List<Piece_Art> afficherArts() {
     List<Piece_Art> list = new ArrayList<>();
        try {
            String req = "select * from piece_art";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                Piece_Art p = new Piece_Art();
                p.setId_piece_art(res.getInt("id_piece_art"));
                p.setNom(res.getString("nom"));
               

                list.add(p);
            }
        } catch (SQLException ex) {
        }
        return list;    
    }
    
}
