/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entites.Profile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyConnection;

/**
 *
 * @author msi
 */
public class ProfileService implements IProfileService {

    Connection myconnex
            = MyConnection.getInstance().getConnection();

    @Override
    public int ajouterProfile(Profile p) {
        int id = -1;
        try {
            String req1 = "INSERT INTO `profile` (`id_profil`, `id_util`, `bio`, `ig`, `fb`, `twitter`, `ytb`)VALUES (NULL, '" + p.getId_util() + "','" + p.getIg() + "','" + p.getIg() + "' , '" + p.getFb() + "', '" + p.getTwitter() + "', '" + p.getYtb() + "');";

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
            int id_util = 7;
            String bio = "salwa";
            String ig = "salwa";
            String fb = "salwa";
            String twitter = "salwa";
            String ytb = "salwa";

            String req = "  UPDATE `profile` SET `id_util`=? ,`bio` = ?, `ig` = ?, `fb` = ?, `twitter` =? , `ytb` = ? WHERE `profile`.`id_util` = '" + p.getId_util() + "';";

            PreparedStatement ps = myconnex
                    .prepareStatement(req);
            ps.setInt(1, id_util);
            ps.setString(2, bio);
            ps.setString(3, ig);
            ps.setString(4, fb);
            ps.setString(5, twitter);
            ps.setString(6, ytb);

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
            String req = "delete from profile where id_profil= ? ";
            PreparedStatement ps = myconnex
                    .prepareStatement(req);
            ps.setInt(1, 2);
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

}
