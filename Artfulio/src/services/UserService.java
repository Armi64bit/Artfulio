/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Utils.MyConnection;
import entities.User;
import java.sql.Connection;
import java.util.List;
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
public class UserService implements IUser{

    Connection myconnex
            = MyConnection.getInstance().getConnection();
    @Override
    public int ajouterUser(User p) {
        int id = -1;
        try {
            String req1 = "INSERT INTO user (id_util, nom)"
                    + " VALUES (NULL, '" + p.getNom() +"'); ";

            Statement ste = myconnex.createStatement();
            id = ste.executeUpdate(req1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }
        
    

    @Override
    public boolean modifierUser(User p) {
        try {
            String nom = p.getNom();
           

            String req = "  UPDATE `user` SET  `nom` = ? WHERE `user`.`nom` = '" + p.getNom()+ "';";

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
    public boolean supprimerUser(User p) {
         try {
            String req = "delete from user where nom= ? ";
            PreparedStatement ps = myconnex
                    .prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }

    @Override
    public List<User> afficherUsers() {
        List<User> list = new ArrayList<>();
        try {
            String req = "select * from user";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                User p = new User();
                p.setId_util(res.getInt("id_util"));
                p.setNom(res.getString("nom"));
               

                list.add(p);
            }
        } catch (SQLException ex) {
        }
        return list;
    }
    
}
