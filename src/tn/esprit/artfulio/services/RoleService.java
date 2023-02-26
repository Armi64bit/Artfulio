/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.services;

import tn.esprit.artfulio.utils.MyConnection;
import tn.esprit.artfulio.entites.Role;
import tn.esprit.artfulio.services.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WINDOWS 10
 */
public class RoleService implements IService<Role> {

    Connection myconnex
            = MyConnection.getInstance().getConnection();

    @Override
    public void ajouter(Role r) {
        try {
            String res = "INSERT INTO role (id_role,type_role) VALUES (?, ?)";

            PreparedStatement ps = myconnex.prepareStatement(res);
            ps.setInt(1, r.getId_role());
            ps.setString(2, r.getType_role());

            ps.executeUpdate();
            System.out.println("Role Ajouté");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Role r) throws SQLException {

        String req = "UPDATE role SET id_role=?, type_role=? WHERE id_role=?";
        PreparedStatement ps = myconnex.prepareStatement(req);
        ps.setInt(1, r.getId_role());
        ps.setString(2, r.getType_role());

        ps.executeUpdate();
        System.out.println("Role Modifié");

    }

    /**
     *
     * @param r
     * @throws SQLException
     */
    @Override
    public void supprimer(Role r) throws SQLException {
        String req = "DELETE FROM role WHERE id_role=?";
        PreparedStatement ps = myconnex.prepareStatement(req);
        ps.setInt(1, r.getId_role());
        ps.executeUpdate();
        System.out.println("Reservation Supprimé");
    }

    /**
     *
     * @param r
     * @return
     * @throws java.sql.SQLException
     */
    public List<Role> recuperer() throws SQLException {

        List<Role> list = new ArrayList<>();

        String s = "select * from role";
        Statement st = myconnex.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            Role r = new Role();
            r.setId_role(rs.getInt("id_role"));
            r.setType_role(rs.getString("type_role"));
                System.out.println(r);

            list.add(r);

        }

        return list;
    }

}
