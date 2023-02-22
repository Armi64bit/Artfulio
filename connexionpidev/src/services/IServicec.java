/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Categorie;
import java.util.List;

/**
 *
 * @author dell
 */
public interface IServicec {
    public int ajouter(Categorie c);
    public boolean modifier(Categorie c);
    public boolean supprimer(Categorie c);
    public List<Categorie> afficher();

}
