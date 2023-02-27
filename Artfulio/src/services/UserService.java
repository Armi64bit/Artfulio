/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.MyConnection;
import entities.Role;
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
public class UserService implements IUserService {

    Connection myconnex
            = MyConnection.getInstance().getConnection();

    @Override
    public void ajouterUtilisateur(User u) {
       
        try {
           
                    String res = "INSERT INTO user (username,cin_user,adresse_user,password_user,email_user,type_role,is_pro,img_user) VALUES (?,?, ?,?, ?, ?, ?,?)";

                    PreparedStatement ps = myconnex.prepareStatement(res);
                    ps.setString(1, u.getUsername());
                    ps.setString(2, u.getCin_user());
                    ps.setString(3, u.getAdresse_user());
                    ps.setString(4, u.getPassword_user());
                    ps.setString(5, u.getEmail_user());
                    ps.setString(6, u.getRole());
                    ps.setBoolean(7, u.isIs_pro());
                     ps.setString(8, u.getImg_user());
                    ps.executeUpdate();
                    System.out.println("Utlisateur Ajouté");
                   
               
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifierUtilisateur(User u) throws SQLException {

        String req = "UPDATE user SET username = ?,cin_user = ?,adresse_user = ?,password_user = ?,email_user = ?,type_role = ?,is_pro =?,img_user =?";
        PreparedStatement ps = myconnex.prepareStatement(req);

        ps.setString(1, u.getUsername());
        ps.setString(2, u.getCin_user());
        ps.setString(3, u.getAdresse_user());
        ps.setString(4, u.getPassword_user());
        ps.setString(5, u.getEmail_user());
        ps.setString(6, u.getRole());
        ps.setBoolean(7, u.isIs_pro());
         ps.setString(6, u.getImg_user());
        ps.executeUpdate();
        System.out.println("Utilisateur Modifié");

    }

    /**
     *
     * @param u
     * @throws SQLException
     */
    @Override
    public void supprimerUtilisateur(User u) throws SQLException {
        String req = "DELETE FROM user WHERE username=?";
        PreparedStatement ps = myconnex.prepareStatement(req);
        ps.setString(1, u.getUsername());
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
    public List<User> afficherUtilisateur() throws SQLException {

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
            u.setIs_pro(rs.getBoolean("is_pro"));
             u.setImg_user(rs.getString("img_user"));
            System.out.println(u);

            list.add(u);

        }

        return list;
    }

    @Override
    public Boolean loginUtilisateur(String ch1,String ch2) throws SQLException {
            Boolean ok_pour_avancer=false;
    Statement stmt ;
        ResultSet rset ;
     try {
         
         
                stmt=myconnex.createStatement();
                String query="select * from user where username='"+ch1+"' ;";
                rset = stmt.executeQuery (query);
                if(rset.next())
                {
                  if((ch1.equals(rset.getString("username")))&&ch2.equals(rset.getString("password_user")) )
                {ok_pour_avancer=true;}
                }
                } catch (SQLException ex) {
                
                }
        
    return ok_pour_avancer;
    
    }

}
