/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.services;
import java.util.List;
import tn.esprit.artfulio.entites.sous_categorie;
/**
 *
 * @author CALLO
 */
public interface ISouscategorieService  {
    
      public int ajoutersouscategorie(sous_categorie p);
    public boolean modifiersouscategorie(sous_categorie p);
    public boolean supprimersouscategorie(sous_categorie p);
    public List<sous_categorie> affichersouscategorie () ;
}
