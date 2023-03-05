/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tn.esprit.artfulio.entites.Profile;
import tn.esprit.artfulio.entites.artwork;
import static tn.esprit.artfulio.services.ProfileService.myconnex;
import tn.esprit.artfulio.utils.MyConnection;

/**
 *
 * @author CALLO
 */
public class ArtworkService implements IArtworkService {
static Connection myconnex
           = MyConnection.getInstance().getConnection();



    public int ajouterartwork2(artwork p) {
   
        int id = -1;
        try {
  String sql = "INSERT INTO artwork (nom_artwork, description_artwork,prix_artwork,id_type,date,id_artist,lien_artwork,dimension_artwork,img_artwork) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = myconnex.prepareStatement(sql);
            statement.setString(1, p.getNom_artwork());
            statement.setString(2, p.getDescription_artwork());   
            statement.setFloat(3, p.getPrix_artwork());   
            statement.setInt(4, p.getId_type());   
            statement.setDate(5,(java.sql.Date)  p.getDate());   
            statement.setInt(6, p.getId_artist());   
            statement.setString(7, p.getLien_artwork());   
            statement.setFloat(8, p.getDimension_artwork());   
            statement.setString(9, p.getImg_artwork());   
         
            id = statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }
          
    @Override
    public int ajouterartwork(artwork p) {
   
        int id = -1;
        try {
            String req1 = "INSERT INTO `artwork` (`id_artwork`, `nom_artwork`, `nom_artwork`, `prix_artwork`, `id_type`, `date`, `id_artist`, `lien_artwork`, `dimension_artwork`, `img_artwork`) VALUES (NULL, '"+p.getNom_artwork()+"', '"+p.getDescription_artwork()+"', '"+p.getPrix_artwork()+"', '"+p.getId_type()+"', '"+p.getDate()+"', '"+p.getId_artist()+"', '"+p.getLien_artwork()+"', '"+p.getDimension_artwork()+"', '"+p.getImg_artwork()+"');";

            Statement ste = myconnex.createStatement();
            id = ste.executeUpdate(req1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }
    @Override
    public boolean modifierartwork(artwork p) {
         try {
           int id_artwork = 7;
           String nom = p.getNom_artwork();
          String lien_artwork = p.getLien_artwork();
          String img_artwork = p.getImg_artwork();
          String description_artwork = p.getDescription_artwork();
          int id_type = p.getId_type();
          int id_artist =p.getId_artist();
          float prix_artwork = p.getPrix_artwork();
          float dimension_artwork = p.getDimension_artwork();
          Date date = p.getDate();
         





          


       String req =" UPDATE `artwork` SET ,`nom_artwork`=?,`description_artwork`=?,`prix_artwork`=?,`id_type`=?,`id_artist`=?,`lien_artwork`=?,`dimension_artwork`=?,`img_artwork`=? WHERE `id_artwork` = '" + p.getId_artwork()+ "'";

     //  String req = "  UPDATE `categorie` SET  `type_categorie` = ?, `nom_categorie` = ? WHERE `id_categorie` = '" + p.getId_categorie()+ "';";
    

           PreparedStatement ps = myconnex
                  .prepareStatement(req);
       
            ps.setString(1, nom);
            ps.setString(2, lien_artwork);
            ps.setString(3, img_artwork);
            ps.setString(4, description_artwork);
            ps.setInt(5, id_type);
            ps.setFloat(6, prix_artwork);
            ps.setFloat(7, dimension_artwork);
            ps.setDate(8, (java.sql.Date) date);
            ps.setInt(9, id_artist);

            
            


            
    

           ps.executeUpdate();

       int rowsUpdated = ps.executeUpdate();
           if (rowsUpdated > 0) {
                System.out.println("An existing artwork  was updated successfully!");

           }
           return true;
      } catch (SQLException ex) {
           return false;
   }
    }

    @Override
    public boolean supprimerartwork(artwork p) {
        try {
          String req = "DELETE FROM `artwork` WHERE id_artwork= ? ";
          PreparedStatement ps = myconnex
                  .prepareStatement(req);
         ps.setInt(1, p.getId_artwork());
        ps.executeUpdate();
       return true;

       } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    @Override
    public List<artwork> afficherartwork() {
          List<artwork> list = new ArrayList<>();
    try {
            String req = "SELECT * FROM `artwork`";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                artwork s = new artwork();
                s.setId_artwork(res.getInt("id_artwork"));
                s.setNom_artwork(res.getString("nom_artwork"));
                s.setDescription_artwork(res.getString("description_artwork"));
                s.setLien_artwork(res.getString("lien_artwork"));
                s.setImg_artwork(res.getString("img_artwork"));
                s.setPrix_artwork(res.getFloat("prix_artwork"));
                s.setId_artist(res.getInt("id_artist"));
                s.setDimension_artwork(res.getFloat("dimension_artwork"));
                s.setDate(res.getDate("date"));
                s.setId_type(res.getInt("id_type"));

  

               list.add(s);
            }
       } catch (SQLException ex) {
        }
        return list;
    }

   
    
}
