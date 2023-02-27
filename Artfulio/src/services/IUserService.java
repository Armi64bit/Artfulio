/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
import java.sql.SQLException;
import java.util.List;


public interface IUserService {

   
   public void ajouterUtilisateur(User u) ;
    public void modifierUtilisateur(User u) throws SQLException;
    public void supprimerUtilisateur(User u) throws SQLException;
    public List<User> afficherUtilisateur( )throws SQLException;
    public Boolean loginUtilisateur( String ch1,String ch2)throws SQLException;
}
