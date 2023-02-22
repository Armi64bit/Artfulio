/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Utils.MyConnection;
import entities.VenteProduit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
            String req1 = "INSERT INTO `vente_produit`(`Id_Vente`, `Id_Artist`, `Id_Client`, `Paiement`, `Prix`, `Id_Piece_art`) VALUES ('0','"+ v.getId_Artist()+"','"+v.getId_Client()+"','?','?','?');";
                           
            Statement ste = myconnex.createStatement();
            id = ste.executeUpdate(req1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    
  
    }

    @Override
    public boolean modifierVente(VenteProduit v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimerVente(VenteProduit v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VenteProduit> afficheventes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
