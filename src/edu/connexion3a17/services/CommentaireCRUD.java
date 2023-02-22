/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a17.services;

import edu.connexion3a17.entities.commentaire;
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
public class CommentaireCRUD implements InterfaceCRUD<commentaire> {

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
    public void ajouterEntitee(commentaire c) {
        try {
            String requete = "INSERT INTO Commentaire(React, Id_com, Texte, Total_reac, Date_com)"
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setReact(1, c.getReact());
            pst.setInt(2, c.getId_com());
            pst.setString(3, c.getTexte());
            pst.setInt(4, c.getTotal_reac());
            pst.setString(5, c.getDate_com());

            pst.executeUpdate();
            System.out.println("Commentaire added!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<commentaire> listeDesEntites() {
        List<commentaire> myList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM personne";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                commentaire c = new commentaire();
                c.setReact(rs.getReact(1));
                c.setId_com(rs.getInt(2));
                c.setTexte(rs.getString(3));
                c.setTotal_reac(rs.getInt(4));
                c.setDate_com(rs.getString(5));
                myList.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }

    //String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
    public void Update(commentaire c) {
        try {
            String requete = "UPDATE Commentaire SET React=?, Texte=?, Total_reac=?, Date_com=? WHERE Id_com=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setReact(1, c.getReact());
            pst.setString(2, c.getTexte());
            pst.setInt(3, c.getTotal_reac());
            pst.setString(4, c.getDate_com());
            pst.setInt(5, c.getId_com());

            pst.executeUpdate();
            System.out.println("Commentaire updated!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void Delete(commentaire c) {
        try {
            String requete = "DELETE FROM Commentaire WHERE Id_com=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, c.getId_com());
            pst.executeUpdate();
            System.out.println("Commentaire deleted!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
