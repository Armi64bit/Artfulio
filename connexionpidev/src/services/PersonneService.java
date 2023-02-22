/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
public class PersonneService implements IPersonneService{
   Connection myconnex = 
           MyConnection.getInstance().getConnection();
    
//    MyConnection myconnex =new MyConnection();
    @Override
    public int ajouterPersonne(Personne p) {
     int id=-1;
        try {
           String req1 ="INSERT INTO `Personne` (`id`, `nom`, `age`)"
                   + " VALUES (NULL, '"+p.getNom()+" ', '"
                   + p.getAge()+"'); ";
           
           Statement ste = myconnex.createStatement();
          id= ste.executeUpdate(req1);
       } catch (SQLException ex) {
           System.out.println(ex);
       }
       return id;
    }

    @Override
    public boolean modifierPersonne(Personne p) {
      try  {
                        String nom="salwa";
                        int age=44;
			String req = "UPDATE personne SET nom = ?, age = ? WHERE personne.`nom` = '"+p.getNom()+"';";

			 PreparedStatement ps = myconnex
                   .prepareStatement(req);
			ps.setString(1, nom);
			ps.setInt(2, age);
                        
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
    public boolean supprimerPersonne(Personne p) {
       try {
           String req="delete from personne where id= ? ";
           PreparedStatement ps = myconnex
                   .prepareStatement(req);
           ps.setInt(1, 4);
           ps.executeUpdate();
      
       
        return true;
       } catch (SQLException ex) {
           System.out.println(ex);
            return false;
       }
       
      
    }

    @Override
    public List<Personne> afficherPersonnes() {
      List<Personne> list = new ArrayList<>();
        try {
           String req = "select * from personne";
           Statement ste = myconnex.createStatement();
           ResultSet res=  ste.executeQuery(req);
           while (res.next()) {
               Personne p = new Personne();
               p.setNom(res.getString("nom"));
               p.setAge(res.getInt("age"));
               list.add(p);           
           }
       } catch (SQLException ex) {
       }
        return list;
    }
    
}
