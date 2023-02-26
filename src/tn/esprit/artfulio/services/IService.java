/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author WINDOWS 10
 * @param <T>
 */
public interface IService<T> {

   
   public void ajouter(T t) ;
    public void modifier(T t) throws SQLException;
    public void supprimer(T r) throws SQLException;

    /**
     *
     * @param t
     * @return
     * @throws SQLException
     */
    public List<T> recuperer( )throws SQLException;
    
}
