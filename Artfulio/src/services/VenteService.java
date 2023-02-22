/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Utils.MyConnection;
import entities.User;
import entities.VenteProduit;
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
public class VenteService implements IVenteProduit{

     Connection myconnex
            = MyConnection.getInstance().getConnection();
    @Override
    public int ajouterVente(VenteProduit v) {
         int id = -1;
        try {
            String req1 = "INSERT INTO `vente_produit`(`Id_Vente`, `Id_Artist`, `Id_Client`, `Paiement`, `Prix`, `Id_Piece_art`) VALUES ('0','"+ v.getId_Artist()+"','"+v.getId_Client()+"','"+v.getPaiement()+"','"+v.getPrix()+"','"+v.getId_Piece_art()+"');";
                           
            Statement ste = myconnex.createStatement();
            id = ste.executeUpdate(req1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    
  
    }

    @Override
    public boolean modifierVente(VenteProduit v) {
         try {
            int prix = v.getPrix();
           

            String req = "  UPDATE `vente_produit` SET  `prix` = ? WHERE `vente_produit`.`prix` = '" + v.getPrix()+ "';";

            PreparedStatement ps = myconnex
                    .prepareStatement(req);
           // ps.setInt(1, id_util);
            ps.setInt(1,prix );
           

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
    public boolean supprimerVente(VenteProduit v) {
        try {
            String req = "delete from vente_produit where prix= ? ";
            PreparedStatement ps = myconnex
                    .prepareStatement(req);
            ps.setInt(1, v.getPrix());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    @Override
    public List<VenteProduit> afficheventes() {
        List<VenteProduit> list = new ArrayList<>();
        try {
            String req = "select * from vente_produit";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                VenteProduit v = new VenteProduit();
                v.setId_Vente(res.getInt("id_vente"));
                v.setId_Artist(res.getInt("id_Artist"));
                v.setId_Client(res.getInt("id_Client"));
                v.setPrix(res.getInt("Prix"));
                v.setId_Piece_art(res.getInt("id_piece_art"));
                
                
               

                list.add(v);
            }
        } catch (SQLException ex) {
        }
        return list;
    }
    }
    

