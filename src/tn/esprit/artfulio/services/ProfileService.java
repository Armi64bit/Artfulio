/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.artfulio.services;

import tn.esprit.artfulio.entites.Profile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.artfulio.utils.MyConnection;

/**
 *
 * @author msi
 */
public class ProfileService implements IProfileService {

    static Connection myconnex
            = MyConnection.getInstance().getConnection();

    @Override
    public int ajouterProfile(Profile p) {
        int id = -1;
        try {
            String req1 = "INSERT INTO `profile` (`id_profil`, `id_util`, `bio`, `ig`, `fb`, `twitter`, `ytb`)VALUES (NULL, '" + p.getId_util() + "','" + p.getBio()+ "','" + p.getIg() + "' , '" + p.getFb() + "', '" + p.getTwitter() + "', '" + p.getYtb() + "');";

            Statement ste = myconnex.createStatement();
            id = ste.executeUpdate(req1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    @Override
    public boolean modifierProfile(Profile p) {
        try {
           // int id_util = 7;
            String bio = p.getBio();
            String ig = p.getIg();
            String fb = p.getFb();
            String twitter = p.getTwitter();
            String ytb = p.getYtb();

            String req = "  UPDATE `profile` SET  `bio` = ?, `ig` = ?, `fb` = ?, `twitter` =? , `ytb` = ? WHERE `profile`.`fb` = '" + p.getFb() + "';";

            PreparedStatement ps = myconnex
                    .prepareStatement(req);
           // ps.setInt(1, id_util);
            ps.setString(1, bio);
            ps.setString(2, ig);
            ps.setString(3, fb);
            ps.setString(4, twitter);
            ps.setString(5, ytb);

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
    public boolean supprimerProfile(Profile p) {
        try {
            String req = "delete from profile where fb= ? ";
            PreparedStatement ps = myconnex
                    .prepareStatement(req);
            ps.setString(1, p.getFb());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }

    @Override
    public List<Profile> afficherProfile() {
        List<Profile> list = new ArrayList<>();
        try {
            String req = "select * from profile";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                Profile p = new Profile();
                p.setId_util(res.getInt("id_util"));
                p.setBio(res.getString("bio"));
                p.setIg(res.getString("ig"));
                p.setFb(res.getString("fb"));
                p.setTwitter(res.getString("twitter"));
                p.setYtb(res.getString("ytb"));

                list.add(p);
            }
        } catch (SQLException ex) {
        }
        return list;
    }
    public Profile afficherProfilefb(String fb) {
         Profile p = new Profile();
        try {
            String req = "select * from profile where fb='"+fb+"'";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
               
                p.setId_util(res.getInt("id_util"));
                p.setBio(res.getString("bio"));
                p.setIg(res.getString("ig"));
                p.setFb(res.getString("fb"));
                p.setTwitter(res.getString("twitter"));
                p.setYtb(res.getString("ytb"));
                p.setId_profil(res.getInt("id_profil"));

                
            }
        } catch (SQLException ex) {
        }
        return p;
    }
     public Profile getprofileuser(int id) {
         Profile p = new Profile();
        try {
            String req = "select * from profile where id_util='"+id+"'";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
               
                p.setId_util(res.getInt("id_util"));
                p.setBio(res.getString("bio"));
                p.setIg(res.getString("ig"));
                p.setFb(res.getString("fb"));
                p.setTwitter(res.getString("twitter"));
                p.setYtb(res.getString("ytb"));
                p.setId_profil(res.getInt("id_profil"));

                
            }
        } catch (SQLException ex) {
        }
        return p;
    }

     public static int checkRedonnondance (String ig,String fb,String twitter,String ytb){
   // Connection Conx =  ConnectionUtil.getInstance().getConnection();
 
     String sql ="SELECT * FROM profile WHERE ig=? and fb=? and twitter=? and ytb=?" ;
     try {
         PreparedStatement prst  = myconnex.prepareStatement(sql) ;
         prst.setString(1,ig) ;
         prst.setString(2,fb) ;
         prst.setString(3,twitter) ;
         prst.setString(4,ytb) ;
         
       ResultSet rs =prst.executeQuery() ;
       
       while(rs.next()){
           return 0;
       }
     }catch (SQLException se ){
         
     }
           return 1 ;
 
 }
}
