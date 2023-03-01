/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.Artfulio.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.Artfulio.entites.Collaboration;
import tn.esprit.Artfulio.entites.utils.DBConnexion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lelou
 */
public class ServCollaboration implements IntCollaboration {

    private Connection connection;

    public ServCollaboration() {
        this.connection = DBConnexion.getInstance().getConnexion();
    }

    @Override
    public int ajouterCollaboration(Collaboration c) {
        int etat = -1;
        try {
            String req = "insert into collaboration(id_collaboration,type_collaboration, titre, description, date_sortie,status) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, c.getType_collaboration());
            preparedStatement.setString(3, c.getTitre());
            preparedStatement.setString(4, c.getDescription());
            java.sql.Date sqlDate = java.sql.Date.valueOf(c.getDate_sortie());
            preparedStatement.setDate(5, sqlDate);
            // preparedStatement.setBoolean(5, c.isStatus());
            preparedStatement.setBoolean(6, true);
            etat = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etat;
    }

    @Override
    public boolean supprimerCollaboration(Collaboration c) {

        boolean status = false;
        try {
            //   String req = "delete from collaboration where id_collaboration=?";
            String req = "delete from collaboration where type_collaboration=? and titre=?";
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            //  preparedStatement.setInt(1, c.getId_collaboration());

            preparedStatement.setString(1, c.getType_collaboration());
            preparedStatement.setString(2, c.getTitre());

            status = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean modifierCollaboration(Collaboration c) {
        boolean status = false;
        try {
            String req = "update collaboration set titre=?, description=?, date_sortie=?, status=? where id_collaboration=?";
            // String req = "update collaboration set titre=?, description=?, date_sortie=? where titre=? and description=?";
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, c.getTitre());
            preparedStatement.setString(2, c.getDescription());
            java.sql.Date sqlDate = java.sql.Date.valueOf(c.getDate_sortie());
            preparedStatement.setDate(3, sqlDate);
            //    preparedStatement.setInt(4, c.getStatus());

            status = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Collaboration> afficherCollaboration() {

        List<Collaboration> list = new ArrayList<Collaboration>();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from collaboration");
            ResultSet rs = preparedStatement.executeQuery();
            Collaboration c = new Collaboration();
            while (rs.next()) {
                
                c.setId_collaboration(rs.getInt("id_collaboration"));
                c.setTitre(rs.getString("titre"));
                c.setType_collaboration(rs.getString("type_collaboration"));
                c.setDescription(rs.getString("description"));
                java.sql.Date sqlDate = rs.getDate("date_sortie");
                LocalDate dateSortie = sqlDate.toLocalDate();
                c.setDate_sortie(dateSortie);
                c.setStatus(rs.getInt("status"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Collaboration> afficherCollaborationsUnArtiste(int idArtiste) {

        List<Collaboration> list = new ArrayList<Collaboration>();
        try {
            String req = "SELECT * FROM collaboration INNER JOIN artiste_collaboration "
                    + "ON collaboration.id_collaboration = artiste_collaboration.id_collaboration_fk"
                    + "WHERE id_artiste_fk=?";
            PreparedStatement preparedStatement = connection
                    .prepareStatement(req);
            preparedStatement.setInt(1, idArtiste);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Collaboration c = new Collaboration();
                c.setId_collaboration(rs.getInt("id_collaboration"));
                c.setTitre(rs.getString("titre"));
                c.setDescription(rs.getString("description"));
                java.sql.Date sqlDate = rs.getDate("date_sortie");
                LocalDate dateSortie = sqlDate.toLocalDate();
                c.setDate_sortie(dateSortie);
                c.setStatus(rs.getInt("status"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Collaboration> recherche(Collaboration c) {
        
        List<Collaboration> listcol= new ArrayList<Collaboration>();
        String req = "SELECT * FROM ma_table WHERE type_collaboration LIKE ? OR titre LIKE ? OR description LIKE ? ";

        Collaboration cc = new Collaboration();
        // Création d'un objet PreparedStatement
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(req);
            stmt.setString(1, "%" + c.getType_collaboration() + "%");
            stmt.setString(2, "%" + c.getTitre() + "%");
            stmt.setString(3, "%" + c.getDescription() + "%");
            

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Récupération des données de chaque ligne
                c.setId_collaboration(rs.getInt("id_collaboration"));
                c.setTitre(rs.getString("titre"));
                c.setType_collaboration(rs.getString("type_collaboration"));
                c.setDescription(rs.getString("description"));
                java.sql.Date sqlDate = rs.getDate("date_sortie");
                LocalDate dateSortie = sqlDate.toLocalDate();
                c.setDate_sortie(dateSortie);
                c.setStatus(rs.getInt("status"));
                listcol.add(c);
                // Traitement des données récupérées
                // ...
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServCollaboration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listcol;
// Fermeture de l'objet ResultSet, de l'objet PreparedStatement et de la connexion à la base de données
// Attribution des valeurs de recherche aux paramètres de la requête préparée
    }

}
