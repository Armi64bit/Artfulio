package tn.esprit.artfulio.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.artfulio.entites.Profile;
import tn.esprit.artfulio.entites.commentaire;
import static tn.esprit.artfulio.services.ProfileService.myconnex;

/**
 *
 * @author msi
 */
public class commentaireservice implements Icommentaireservice{

    @Override
    public int ajoutercommentaire(commentaire p) {
   int id = -1;
        try {
            String req1 = "INSERT INTO `commentaire` (`id_util`, `Texte`, `Id_com`, `id_artwork`, `Date_post`) VALUES ('"+p.getId_util()+"', '"+p.getTexte()+"', NULL, '"+p.getId_artwork()+"', CURRENT_TIMESTAMP);";
            
            Statement ste = myconnex.createStatement();
            id = ste.executeUpdate(req1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;    }

    @Override
    public boolean modifiercommentaire(commentaire p) {
try {
           // int id_util = 7;
            int id_util = p.getId_util();
            String Texte = p.getTexte();
            String Date_post = "CURRENT_TIMESTAMP";
            int Id_com = p.getId_com();
            int id_artwork = p.getId_artwork();

            String req = "  UPDATE `commentaire` SET  `Texte` = ?  WHERE `Id_com` = '"+Id_com+"';";

            PreparedStatement ps = myconnex
                    .prepareStatement(req);
           // ps.setInt(1, id_util);
           
            ps.setString(1, Texte);
         
            
            ps.executeUpdate();

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing commenent was updated successfully!");

            }

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }    }

    public boolean supprimercommentaire( int id) {
try {
            String req = "delete from commentaire where id_artwork= ? ";
            PreparedStatement ps = myconnex
                    .prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    @Override
    public boolean supprimercommentaire(commentaire p) {
try {
            String req = "delete from commentaire where Id_com= ? ";
            PreparedStatement ps = myconnex
                    .prepareStatement(req);
            ps.setInt(1, p.getId_com());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    @Override
    public List<commentaire> affichercommentaire() {
   List<commentaire> list = new ArrayList<>();
        try {
            String req = "select * from commentaire";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                commentaire p = new commentaire();
                p.setId_util(res.getInt("id_util"));
                p.setTexte(res.getString("Texte"));
                p.setId_artwork(res.getInt("id_artwork"));
                p.setDate_post(res.getString("Date_post"));
                p.setId_com(res.getInt("Id_com"));
              

                list.add(p);
            }
        } catch (SQLException ex) {
        }
        return list;    }
    
    public List<commentaire> affichercommentaire(int id) {
   List<commentaire> list = new ArrayList<>();
        try {
            String req = "select * from commentaire where id_artwork='"+id+"'";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                commentaire p = new commentaire();
                p.setId_util(res.getInt("id_util"));
                p.setTexte(res.getString("Texte"));
                p.setId_artwork(res.getInt("id_artwork"));
                p.setDate_post(res.getString("Date_post"));
                p.setId_com(res.getInt("Id_com"));
              

                list.add(p);
            }
        } catch (SQLException ex) {
        }
        return list;    }
    
 public commentaire affichercom(int id) {
         commentaire p = new commentaire();
        try {
            String req = "select * from commentaire where Id_com='"+id+"';";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                p.setId_util(res.getInt("id_util"));
                p.setTexte(res.getString("Texte"));
                p.setId_artwork(res.getInt("id_artwork"));
                p.setDate_post(res.getString("Date_post"));
                p.setId_com(res.getInt("Id_com"));
              
                
            }
        } catch (SQLException ex) {
        }
        return p;
    }

 public int numcom(int id){
        try {
            String req = "SELECT COUNT(*) FROM commentaire where id_artwork='"+id+"';";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
             res.next();
            int count = res.getInt(1);
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(commentaireservice.class.getName()).log(Level.SEVERE, null, ex);
        }
 return 0;}
}
