/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a17.services;

/**
 *
 * @author 21652
 */
import edu.connexion3a17.entities.reclamation;
import edu.connexion3a17.interfaces.InterfaceCRUD;
import edu.connexion3a17.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karra
 */
public class ReclamationCRUD implements InterfaceCRUD<reclamation> {

    @Override
//    public void ajouterEntitee(commentaire t) {
//        try {
//            String requete = "INSERT INTO personne(nom, prenom)"
//                    + "VALUES ('"+t.getNom()+"','"+t.getPrenom()+"')";
//            Statement st = new MyConnection().getCnx().createStatement();
//            st.executeUpdate(requete);
//            System.out.println("Done!");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
    public void ajouterEntitee(reclamation r) {
        try {
            String requete = "INSERT INTO Commentaire(id_rec, Titre, Date, Reclamation_sec, Num_tlf)"
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, r.getId_rec());
            pst.setString(2, r.getTitre());
            pst.setString(3, r.getDate());
            pst.setString(4, r.getReclamation_sec());
            pst.setInt(5, r.getNum_tlf());

            pst.executeUpdate();
            System.out.println("Reclamation added!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<reclamation> listeDesEntites() {
        List<reclamation> myList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM personne";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                reclamation r = new reclamation();
                r.setId_rec(rs.getInt(1));
                r.setTitre(rs.getString(2));
                r.setDate(rs.getString(3));
                r.setReclamation_sec(rs.getString(4));
                r.setNum_tlf(rs.getInt(5));
                myList.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }

    //String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
    public void Update(reclamation r) {
        try {
            String requete = "UPDATE Commentaire SET Titre=?, Date=?, Reclamation_sec=?, Num_tlf=? WHERE Id_rec=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, r.getId_rec());
            pst.setString(2, r.getTitre());
            pst.setString(3, r.getDate());
            pst.setString(4, r.getReclamation_sec());
            pst.setInt(5, r.getNum_tlf());

            pst.executeUpdate();
            System.out.println("Reclamation updated!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void Delete(reclamation r) {
        try {
            String requete = "DELETE FROM Commentaire WHERE Id_rec=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1,r.getId_rec());
            pst.executeUpdate();
            System.out.println("Reclamation deleted!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
