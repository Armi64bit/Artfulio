/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.arfulio.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.arfulio.entites.Artiste_Collaboration;
import tn.esprit.arfulio.utils.DBConnexion;

/**
 *
 * @author lelou
 */
public class ServArtiste_collaboration implements IntArtiste_Collaboration {

    private Connection connection;

    public ServArtiste_collaboration() {
        this.connection = DBConnexion.getInstance().getConnexion();
    }

    @Override
    public int ajouterArtister_Collaboration(int idArtiste, int idCollaboration) {
 int etat = -1;
        try {
            String req = "insert into Artiste_Collaboration(id_artiste_fk,id_collaboration_fk,date_entree) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, idArtiste);
            preparedStatement.setInt(2, idCollaboration);
            java.sql.Date sqlDate = java.sql.Date.valueOf(LocalDate.now());
            preparedStatement.setDate(3, sqlDate);
            etat = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etat;    }

    @Override
    public boolean deleteArtisteFromCollaboration(int idArtiste, int idCollaboration) {
        String sql = "DELETE FROM artiste_collaboration WHERE ID_ARTISTE_FK = ? AND ID_COLLABORATION_FK + = ?";
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idArtiste);
            stmt.setInt(2, idCollaboration);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("Aucun artiste n'a été supprimé de la collaboration");
                stmt.close();
                return false;
            } else {
                System.out.println(rowsAffected + " artistes ont été supprimés de la collaboration");
                stmt.close();
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    @Override
    public List<Artiste_Collaboration> afficherCollaborationsUnArtiste(int idArtiste) {
        List<Artiste_Collaboration> list = new ArrayList<Artiste_Collaboration>();
        try {
            String req = "SELECT * FROM collaboration INNER JOIN artiste_collaboration "
                    + "ON collaboration.id_collaboration = artiste_collaboration.id_collaboration_fk"
                    + "WHERE id_artiste_fk=?";
            PreparedStatement preparedStatement = connection
                    .prepareStatement(req);
            preparedStatement.setInt(1, idArtiste);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Artiste_Collaboration c = new Artiste_Collaboration();
                c.setId_collaboration(rs.getInt("id_collaboration"));
                c.setId_artiste(rs.getInt("id_artiste"));
                java.sql.Date sqlDate = rs.getDate("date_entree");
                LocalDate dateEntree = sqlDate.toLocalDate();
                c.setDate_entree(dateEntree);
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
