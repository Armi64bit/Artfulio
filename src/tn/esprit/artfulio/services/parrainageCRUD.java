/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.services;

import tn.esprit.artfulio.entites.parrainage;
import tn.esprit.artfulio.entites.reclamation;
import tn.esprit.artfulio.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static tn.esprit.artfulio.services.ArtworkService.myconnex;

/**
 *
 * @author 21652
 */
public class parrainageCRUD {

    static Connection myconnex
            = MyConnection.getInstance().getConnection();

    public List<parrainage> listeDesEntites() {
        List<parrainage> myList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM parrainage";
            Statement st = myconnex.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                parrainage p = new parrainage();
                p.setId_parrainage(rs.getInt("id_parrainage"));
                p.setEmail(rs.getString("email"));
                p.setUsername(rs.getString("username"));
                p.setIs_pro(rs.getInt("is_pro"));
                p.setType_role(rs.getString("type_role"));

                myList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }

    
    public void add(parrainage p){
    //int id = -1;
        try {
  String sql = "INSERT INTO parrainage ( username, email, is_pro, type_role) VALUES (?,?,?,?)";
            PreparedStatement statement = myconnex.prepareStatement(sql);
            statement.setString(1, p.getUsername());
            statement.setString(2, p.getEmail());   
            statement.setInt(3, p.getIs_pro());   
            statement.setString(4, p.getType_role());   
          ;   
         
             statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       // return id;
    }
    
    public void ajouterEntitee(parrainage p) throws SQLException {
        String req = "INSERT INTO parrainage ( username, email, is_pro, type_role) VALUES ("
                + p.getUsername() + ",'" + p.getEmail() + "','" + p.getIs_pro() + "','" + p.getType_role() + "')";
        Statement st = myconnex.createStatement();
        st.executeUpdate(req);
        System.out.println("done");
    }

    public void Update(parrainage p) throws SQLException {
        String req = "UPDATE parrainage SET  is_pro= ? , username = ? , email= ?, type_role= ?  where id_parrainage = ?";
        PreparedStatement ps = myconnex.prepareStatement(req);
        ps.setInt(5, p.getId_parrainage());
        ps.setString(2, p.getUsername());
        ps.setInt(1, p.getIs_pro());
        ps.setString(3, p.getEmail());
        ps.setString(4, p.getType_role());

        ps.executeUpdate();
    }

    public void Delete(parrainage p) throws SQLException {
        try {
            PreparedStatement req = myconnex.prepareStatement("delete from parrainage where id_parrainage = ? ");
            req.setInt(1, p.getId_parrainage());
            req.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("error in delete " + ex);
        }
    }

}
