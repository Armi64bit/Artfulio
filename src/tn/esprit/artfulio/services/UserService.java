/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.services;

import tn.esprit.artfulio.utils.MyConnection;
import tn.esprit.artfulio.entites.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.artfulio.entites.Profile;
import static tn.esprit.artfulio.services.ProfileService.myconnex;

/**
 *
 * @author WINDOWS 10
 */
public class UserService implements IServiceuser {

    Connection myconnex
            = MyConnection.getInstance().getConnection();


  
    
 

    @Override
    public int ajouteruser(User u) {
 try {
            String res = "INSERT INTO user (id_user,username,cin_user,adresse_user,password_user,email_user,type_role,img_user) VALUES (?,?, ?,?, ?, ?, ?,?)";

            PreparedStatement ps = myconnex.prepareStatement(res);
            ps.setInt(1, u.getId_user());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getCin_user());
            ps.setString(4, u.getAdresse_user());
            ps.setString(5, u.getPassword_user());
            ps.setString(6, u.getEmail_user());
            ps.setString(7, u.getRole());
            ps.setString(8, u.getImg_user());
            
            ps.executeUpdate();
            System.out.println("Utlisateur Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }  return 1;  }

    @Override
    public boolean modifieruser(User u) {
  try {
        String req = "UPDATE user SET username = ?,cin_user = ?,adresse_user = ?,password_user = ?,email_user = ?,type_role = ? where id_user='"+u.getId_user()+"'";
        PreparedStatement ps = myconnex.prepareStatement(req);
       
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getCin_user());
        ps.setString(3, u.getAdresse_user());
        ps.setString(4, u.getPassword_user());
        ps.setString(5, u.getEmail_user());
        ps.setString(6, u.getRole());
        

        ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
return true;
    }
public boolean update(User u) {
  try {
        String req = "UPDATE `user` SET `username` = ?, `img_user` = ? WHERE `user`.`id_user` = ?;";
        PreparedStatement ps = myconnex.prepareStatement(req);
         ps.setString(1, u.getUsername());
          ps.setString(2, u.getImg_user());
           ps.setInt(3, u.getId_user());
        ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
return true;
    }
    @Override
    public boolean supprimeruser(User u) {
 String req = "DELETE FROM user WHERE id_user=?";
        PreparedStatement ps;
        try {
            ps = myconnex.prepareStatement(req);
       
        ps.setInt(1, u.getId_user());
        ps.executeUpdate();
        System.out.println("Utilisateur Supprimé");
         } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
return true;}

    @Override
    public List<User> afficheruser() {

           List<User> list = new ArrayList<>();
       try { 
        String s = "select * from user";
        Statement st;
       
            st = myconnex.createStatement();
        
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
                        u.setImg_user(rs.getString("img_user"));
                u.setIs_pro(rs.getInt("is_pro"));

        
        
            

            list.add(u);

        }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return list;    }
    
  public User afficherProfilefb(int fb) {
         User p = new User();
        try {
            String req = "SELECT * FROM `user` WHERE `id_user` ='"+fb+"' ";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
               p.setId_user(res.getInt("id_user"));
                p.setUsername(res.getString("username"));
               
                p.setCin_user(res.getString("cin_user"));
                p.setAdresse_user(res.getString("adresse_user"));
                p.setPassword_user(res.getString("password_user"));
                p.setEmail_user(res.getString("email_user"));
                p.setRole(res.getString("type_role"));
                 p.setImg_user(res.getString("img_user"));
                 p.setIs_pro(res.getInt("is_pro"));

               
                return p;
            }
        } catch (SQLException ex) {
        }
        return p;
    }
    public User afficherProfilefb(String fb) {
         User p = new User();
        try {
            String req = "SELECT * FROM `user` WHERE `username` ='"+fb+"' ";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
               p.setId_user(res.getInt("id_user"));
                p.setUsername(res.getString("username"));
               
                p.setCin_user(res.getString("cin_user"));
                p.setAdresse_user(res.getString("adresse_user"));
                p.setPassword_user(res.getString("password_user"));
                p.setEmail_user(res.getString("email_user"));
                p.setRole(res.getString("type_role"));
                 p.setImg_user(res.getString("img_user"));
                 p.setIs_pro(res.getInt("is_pro"));

               
                return p;
            }
        } catch (SQLException ex) {
        }
        return p;
    }
     
public User afficherparmail(String fb) {
         User p = new User();
        try {
            String req = "SELECT * FROM `user` WHERE `email_user` ='"+fb+"' ";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
               p.setId_user(res.getInt("id_user"));
                p.setUsername(res.getString("username"));
               
                p.setCin_user(res.getString("cin_user"));
                p.setAdresse_user(res.getString("adresse_user"));
                p.setPassword_user(res.getString("password_user"));
                p.setEmail_user(res.getString("email_user"));
                p.setRole(res.getString("type_role"));
                 p.setImg_user(res.getString("img_user"));
                 p.setIs_pro(res.getInt("is_pro"));

               
                return p;
            }
        } catch (SQLException ex) {
        }
        return p;
    }
    
      public Boolean is_existe(String ch) throws SQLException {
        Boolean ok_pour_avancer = false;
        Statement stmt;
        ResultSet rset;
        try {

            stmt = myconnex.createStatement();
            String query = "select * from user where username='" + ch + "' ;";
            rset = stmt.executeQuery(query);
            if (rset.next()) {
                if ((ch.equals(rset.getString("username")))) {
                    ok_pour_avancer = true;
                }
            }
        } catch (SQLException ex) {

        }

        return ok_pour_avancer;

    }
    
}
