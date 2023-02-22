/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Categorie;
import entites.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;

/**
 *
 * @author dell
 */
public class CategorieService implements IServicec{
   Connection myconnex = 
           MyConnection.getInstance().getConnection();
    
//    MyConnection myconnex =new MyConnection();
    

   

   

    

    @Override
    public int ajouter(Categorie c) {
       int id=-1;
        try {
           String req1 ="INSERT INTO `categorie` (`id_categorie`, `nom_categorie`, `image_categorie`, `audio_categorie`, `video`)"
                   + " VALUES (NULL, '"+c.getNom_categorie()+" ', '"
                   + c.getImage_categorie()+"', '"+c.getAudio_categorie()+" ', '"+c.getVideo_categorie()+" '); ";
           
           Statement ste = myconnex.createStatement();
          id= ste.executeUpdate(req1);
       } catch (SQLException ex) {
           System.out.println(ex);
       }
       return id;
    }

    @Override
    public boolean modifier(Categorie c) {
        
        try  {
                        String nom="salwa";
                        int age=44;
			String req = "UPDATE personne SET nom_categorie = ?, image_categorie = ?, audio_categorie = ?, video = ? WHERE `id_categorie` = '"+c.getId_categorie()+"';";

			 PreparedStatement ps = myconnex
                   .prepareStatement(req);
			ps.setString(1, c.getNom_categorie());
			ps.setString(2,c.getImage_categorie() );
                        ps.setString(2,c.getAudio_categorie() );
                        ps.setString(2,c.getVideo_categorie() );
                        
			ps.executeUpdate();

			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			
                        }

return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
                   return false;    
		}
        
    }

    @Override
    public boolean supprimer(Categorie c) {
        try {
           String req="delete from categorie where id= ? ";
           PreparedStatement ps = myconnex
                   .prepareStatement(req);
           ps.setString(1, c.getNom_categorie());
           ps.executeUpdate();
      
       
        return true;
       } catch (SQLException ex) {
           System.out.println(ex);
            return false;
       }
       
    }

    @Override
    public List<Categorie> afficher() {
        List<Categorie> list = new ArrayList<>();
      

        try {
            //String requete = "SELECT * FROM article";
            String requete="SELECT * FROM `categorie`";
            Statement st = myconnex.createStatement();
          
            ResultSet rs = st.executeQuery(requete);
           
            while (rs.next()) {
               while (rs.next()) {
               Categorie p = new Categorie();
               p.setImage_categorie(rs.getString("image_categorie"));
               p.setNom_categorie(rs.getString("nom_categorie"));
               
               p.setAudio_categorie(rs.getString("audio_categorie"));
               p.setVideo_categorie(rs.getString("video"));
               
              
               System.out.println(p.getId_categorie());
               list.add(p);           
           }
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
}
