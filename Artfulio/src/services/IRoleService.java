/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Role;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author WINDOWS 10
 */
public interface IRoleService {

    /**
     *
     * @param r
     * @return
     * @throws SQLException
     */
    public void ajouterRole(Role r) throws SQLException ;
    public void modifierRole(Role r) throws SQLException;
    public void supprimerRole(Role r) throws SQLException;
    public List<Role> afficherRole( )throws SQLException;
}
