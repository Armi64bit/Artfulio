/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.MyConnection;
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
 * @author WINDOWS 10
 */
public class UserService implements IService<User> {

    Connection myconnex
            = MyConnection.getInstance().getConnection();

    @Override
    public void ajouter(User u) {
        try {
            String res = "INSERT INTO user (id_user,username,cin_user,adresse_user,password_user,email_user,type_role) VALUES (?,?, ?,?, ?, ?, ?)";

            PreparedStatement ps = myconnex.prepareStatement(res);
            ps.setInt(1, u.getId_user());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getCin_user());
            ps.setString(4, u.getAdresse_user());
            ps.setString(5, u.getPassword_user());
            ps.setString(6, u.getEmail_user());
            ps.setString(7, u.getRole());
            ps.executeUpdate();
            System.out.println("Utlisateur Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifier(User u) throws SQLException {

        String req = "UPDATE user SET id_user =?,username = ?,cin_user = ?,adresse_user = ?,password_user = ?,email_user = ?,type_role = ?";
        PreparedStatement ps = myconnex.prepareStatement(req);
        ps.setInt(1, u.getId_user());
        ps.setString(2, u.getUsername());
        ps.setString(3, u.getCin_user());
        ps.setString(4, u.getAdresse_user());
        ps.setString(5, u.getPassword_user());
        ps.setString(6, u.getEmail_user());
        ps.setString(7, u.getRole());

        ps.executeUpdate();
        System.out.println("Utilisateur Modifié");

    }

    /**
     *
     * @param u
     * @throws SQLException
     */
    @Override
    public void supprimer(User u) throws SQLException {
        String req = "DELETE FROM user WHERE id_user=?";
        PreparedStatement ps = myconnex.prepareStatement(req);
        ps.setInt(1, u.getId_user());
        ps.executeUpdate();
        System.out.println("Utilisateur Supprimé");
    }

    /**
     *
     * @param r
     * @return
     * @throws java.sql.SQLException
     */
    @Override
    public List<User> recuperer() throws SQLException  {
      
           List<User> list = new ArrayList<>();
       
        String s = "select * from user";
        Statement st = myconnex.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            User u = new User();
            u.setId_user(rs.getInt("id_user"));
            u.setUsername(rs.getString("username"));
            u.setCin_user(rs.getString("cin_user"));
            u.setAdresse_user(rs.getString("adresse_user"));
            u.setPassword_user(rs.getString("password_user"));
            u.setEmail_user(rs.getString("email_user"));
            u.setRole(rs.getString("type_role"));
                System.out.println(u);

            list.add(u);

        }
         
        return list;
    }

}
