/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Collaboration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utils.DBConnexion;
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
            //   String req = "INSERT INTO `collaboration` (`id`, `user1`, `user2`, `dateDebut`, `dateFin`, `status`) VALUES (NULL, ++, 'moussa', '2023-02-01', '2023-02-02', '1')";
            String req = "insert into collaboration(id, user1,user2,dateDebut,dateFin,status) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, c.getUser1());
            preparedStatement.setString(3, c.getUser2());

            //------------- verification -----------------
            String date1 = c.getDate_debut().toString();
            String date2 = c.getDate_fin().toString();
            //-----------------------------------------------
            preparedStatement.setString(4, date1);
            preparedStatement.setString(5, date2);
            preparedStatement.setInt(6, 1);

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
            String req = "delete from collaboration where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, c.getId());

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
            String req = "update collaboration set user1=?, user2=?, dateDebut=?,dateFin=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, c.getUser1());
            preparedStatement.setString(2, c.getUser2());
            preparedStatement.setString(3, c.getDate_debut().toString());
            preparedStatement.setString(4, c.getDate_fin().toString());
            preparedStatement.setInt(5, c.getId());

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
                c.setId(rs.getInt("id"));
                c.setUser1(rs.getString("user1"));
                c.setUser2(rs.getString("user2"));

                int[] tabDate = this.convertChaineEntier(rs.getString("dateDebut"));
                LocalDate date1 = LocalDate.of(tabDate[0], tabDate[1], tabDate[2]);
                c.setDate_debut(date1);

                int[] tabDate2 = this.convertChaineEntier(rs.getString("dateFin"));
                LocalDate date2 = LocalDate.of(tabDate2[0], tabDate2[1], tabDate2[2]);
                c.setDate_fin(date2);

                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int[] convertChaineEntier(String chaine) {

        String[] strArr = chaine.split("-"); // ou "," si séparés par une virgule
        int[] intArr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    @Override
    public boolean comapareDate(LocalDate date1, LocalDate date2) {
        if (date1.isBefore(date2)) {
            return true;
        }
        return false;
    }

}
