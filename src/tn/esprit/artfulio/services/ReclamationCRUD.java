/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.services;

/**
 *
 * @author 21652
 */
import tn.esprit.artfulio.entites.reclamation;
import tn.esprit.artfulio.services.InterfaceCRUD;
import tn.esprit.artfulio.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karra
 */
public class ReclamationCRUD implements InterfaceCRUD<reclamation> {

    static Connection myconnex
            = MyConnection.getInstance().getConnection();

    public List<reclamation> listeDesEntites() {
        List<reclamation> myList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM reclamation";
            Statement st = myconnex.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                reclamation r = new reclamation();
                r.setId_rec(rs.getInt("id_rec"));
                r.setTitre(rs.getString("Titre"));
                r.setId_user(rs.getInt("id_user"));
                r.setReclamation_sec(rs.getString("Reclamation_sec"));
                r.setEmail(rs.getString("email"));

                myList.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }

    
    
    
        @Override
    public void ajouterEntitee(reclamation t) throws SQLException {
        String req = "INSERT INTO reclamation ( id_user, Titre, Reclamation_sec, email) VALUES ("
                  + t.getId_user() + ",'" + t.getTitre() + "','" + t.getReclamation_sec() + "','" + t.getEmail() + "')";
        Statement st = myconnex.createStatement();
        st.executeUpdate(req);
        System.out.println("done");
    }

    @Override
    public void Update(reclamation t) throws SQLException {
        String req = "UPDATE reclamation SET  id_user= ? , Titre = ? , Reclamation_sec= ?   where id_rec = ?";
        PreparedStatement ps = myconnex.prepareStatement(req);
        ps.setInt(4, t.getId_rec());
        ps.setInt(1, t.getId_user());
        ps.setString(2, t.getTitre());
        ps.setString(3, t.getReclamation_sec());
        

        ps.executeUpdate();
    }

    @Override
    public void Delete(reclamation t) throws SQLException {
        try {
            PreparedStatement req = myconnex.prepareStatement("delete from reclamation where id_rec = ? ");
            req.setInt(1, t.getId_rec());
            req.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("error in delete " + ex);
        }
    }

}
