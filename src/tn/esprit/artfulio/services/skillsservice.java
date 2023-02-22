package tn.esprit.artfulio.services;

import tn.esprit.artfulio.entites.skills;
import tn.esprit.artfulio.entites.Profile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static tn.esprit.artfulio.services.ProfileService.myconnex;
import tn.esprit.artfulio.utils.MyConnection;

/**
 *
 * @author msi
 */
public class skillsservice implements iskillsservice {

    Connection myconnex
            = MyConnection.getInstance().getConnection();

    @Override
    public int ajouterskills(skills s) {

        int id = -1;
        try {
            String req1 = "INSERT INTO `skills` (`id_skill`, `titre_skill`, `desc_skill`,`id_profile`) VALUES (NULL, '" + s.getTitre_skill() + "', '" + s.getDesc_skill() + "',10);";

            Statement ste = myconnex.createStatement();
            id = ste.executeUpdate(req1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    @Override
    public boolean modifierskills(skills s) {
        try {
            String titre_skill = "salwa";
            String desc_skill = "salwa";

            String req = "UPDATE `skills` SET `titre_skill` = ?, `desc_skill` = ? WHERE `skills`.`titre_skill` = '" + s.getTitre_skill() + "';";
            PreparedStatement ps = myconnex
                    .prepareStatement(req);
            ps.setString(1, titre_skill);
            ps.setString(2, desc_skill);

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
    public boolean supprimerskills(skills s) {
        try {
            String req = "delete from skills where id_skill= ? ";
            PreparedStatement ps = myconnex
                    .prepareStatement(req);
            ps.setInt(1, 4);
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    @Override
    public List<skills> afficherskills() {
        List<skills> list = new ArrayList<>();
        try {
            String req = "select * from skills";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                skills s = new skills();
                s.setTitre_skill(res.getString("titre_skill"));
                s.setDesc_skill(res.getString("desc_skill"));

                list.add(s);
            }
        } catch (SQLException ex) {
        }
        return list;
    }

    public List<skills> afficherskills(String fb) {
        List<skills> list = new ArrayList<>();
        ProfileService ps = new ProfileService();
        Profile p = new Profile();
        p=ps.afficherProfilefb(fb);
        
        
        try {
            String req = "select * from skills where id_profile='"+p.getId_profil()+"'";
           
            Statement ste = myconnex.createStatement();
            
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                skills s = new skills();
                s.setTitre_skill(res.getString("titre_skill"));
                s.setDesc_skill(res.getString("desc_skill"));
                s.setId_profil(res.getInt("id_profile"));

                list.add(s);
            }
        } catch (SQLException ex) {
        }
        return list;
    }

    public skills findskill(String ig, String fb, String twitter, String ytb) {
        String sql = "SELECT * FROM profile WHERE ig=? and fb=? and twitter=? and ytb=? ";//zid where id_profile == w a3ml fn yjiblk id el profile
        skills s = new skills();
        Profile p = new Profile();
        try {
            PreparedStatement prst = myconnex.prepareStatement(sql);
            prst.setString(1, ig);
            prst.setString(2, fb);
            prst.setString(3, twitter);
            prst.setString(4, ytb);

            ResultSet rs = prst.executeQuery();

            while (rs.next()) {

                return null;
            }
        } catch (SQLException se) {

        }
        return null;
    }
}
