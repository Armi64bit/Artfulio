/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface IUser {
    public int ajouterUser(User p);
    public boolean modifierUser(User p);
    public boolean supprimerUser(User p);
    public List<User> afficherUsers();
}
    

