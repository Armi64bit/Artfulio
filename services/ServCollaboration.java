/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.arfulio.services;

import tn.esprit.arfulio.entites.Collaboration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.arfulio.utils.DBConnexion;
import java.util.*;

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
            String req = "delete from collaboration where id_collaboration=?";
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, c.getId_collaboration());

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
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, c.getTitre());
            preparedStatement.setString(2, c.getDescription());
            java.sql.Date sqlDate = java.sql.Date.valueOf(c.getDate_sortie());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setBoolean(4, c.isStatus());

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
            while (rs.next()) {
                Collaboration c = new Collaboration();
                c.setId_collaboration(rs.getInt("id_collaboration"));
                c.setTitre(rs.getString("titre"));
                c.setDescription(rs.getString("description"));
                java.sql.Date sqlDate = rs.getDate("date_sortie");
                LocalDate dateSortie = sqlDate.toLocalDate();
                c.setDate_sortie(dateSortie);
                c.setStatus(rs.getBoolean("status"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public boolean comapareDate(LocalDate date1, LocalDate date2) {
        if (date1.isBefore(date2)) {
            return true;
        }
        return false;
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
                c.setStatus(rs.getBoolean("status"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;    }

}
