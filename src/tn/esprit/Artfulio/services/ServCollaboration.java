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
import tn.esprit.Artfulio.utils.DBConnexion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;

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
            String req = "insert into collaboration(id_collaboration,type_collaboration, titre, description, date_sortie,status,nom_user,email_user) values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, c.getType_collaboration());
            preparedStatement.setString(3, c.getTitre());
            preparedStatement.setString(4, c.getDescription());
            java.sql.Date sqlDate = java.sql.Date.valueOf(c.getDate_sortie());
            preparedStatement.setDate(5, sqlDate);
            // preparedStatement.setBoolean(5, c.isStatus());
            preparedStatement.setString(6, c.getStatus());
            preparedStatement.setString(7, c.getNom_user());
            preparedStatement.setString(8, c.getEmail_user());
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
            String req = "update collaboration set titre=?, description=?, date_sortie=?, status=? ,type_collaboration=? where id_collaboration=?";
            //  ,nom_user?, email_user=? ";
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, c.getTitre());
            preparedStatement.setString(2, c.getDescription());
            java.sql.Date sqlDate = java.sql.Date.valueOf(c.getDate_sortie());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, c.getStatus());
            preparedStatement.setString(5, c.getType_collaboration());
            preparedStatement.setInt(6, c.getId_collaboration());

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
                c.setType_collaboration(rs.getString("type_collaboration"));
                c.setDescription(rs.getString("description"));
                java.sql.Date sqlDate = rs.getDate("date_sortie");
                LocalDate dateSortie = sqlDate.toLocalDate();
                c.setDate_sortie(dateSortie);
                c.setStatus(rs.getString("status"));
                list.add(c);
                //       System.out.println("service collaboration");
                //       System.out.println(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n la liste qui est renvoyer\n " + list.toString() + "\n\n\n");
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
                c.setStatus(rs.getString("status"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Collaboration recherche(String titre, String typec) {

        List<Collaboration> listcol = new ArrayList<Collaboration>();
        String req = "SELECT * FROM collaboration WHERE titre LIKE ? and type_collaboration LIKE ? ";

        Collaboration cc = new Collaboration();
        // Création d'un objet PreparedStatement
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(req);
            stmt.setString(1, "%" + titre + "%");
            stmt.setString(2, "%" + typec + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Récupération des données de chaque ligne
                cc.setId_collaboration(rs.getInt("id_collaboration"));
                cc.setTitre(rs.getString("titre"));
                cc.setType_collaboration(rs.getString("type_collaboration"));
                cc.setDescription(rs.getString("description"));
                java.sql.Date sqlDate = rs.getDate("date_sortie");
                LocalDate dateSortie = sqlDate.toLocalDate();
                cc.setDate_sortie(dateSortie);
                cc.setStatus(rs.getString("status"));
                cc.setNom_user(rs.getString("nom_user"));
                cc.setEmail_user(rs.getString("email_user"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ServCollaboration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cc;
// Fermeture de l'objet ResultSet, de l'objet PreparedStatement et de la connexion à la base de données
// Attribution des valeurs de recherche aux paramètres de la requête préparée
    }

    //----------------- statistique ----------------------
    public void createChart(AnchorPane anchorPane) {
                // Créer le graphique de type camembert
        PieChart chart = new PieChart();
        anchorPane.getChildren().add(chart);
        
        // Créer une tâche pour récupérer les données en arrière-plan
        Task<List<PieChart.Data>> task = new Task<List<PieChart.Data>>() {
            @Override
            protected List<PieChart.Data> call() throws Exception {
                List<PieChart.Data> dataList = new ArrayList<>();
                PreparedStatement stmt;
                // Récupérer les données depuis la base de données
                try {
                    String req = "SELECT type_collaboration, COUNT(*) FROM collaboration GROUP BY type_collaboration";
                    stmt = connection.prepareStatement(req);
                    //    PreparedStatement stmt = conn.prepareStatement();
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        String type = rs.getString("type_collaboration");
                        int count = rs.getInt(2);
                        dataList.add(new PieChart.Data(type, count));
                    }
                    
                    
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
                return dataList;
            }
        };

        // Mettre à jour le graphique lorsque la tâche est terminée
        task.setOnSucceeded(event -> chart.getData().setAll(task.getValue()));

        // Lancer la tâche pour récupérer les données
        new Thread(task).start();
    }

}
