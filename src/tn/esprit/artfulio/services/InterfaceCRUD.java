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
 * @author karra
 */
public interface InterfaceCRUD<T> {
    public void ajouterEntitee(T t) throws SQLException;
    public List<T> listeDesEntites() throws SQLException;
    public void Update(T t) throws SQLException;
    public void Delete(T t) throws SQLException;
}
