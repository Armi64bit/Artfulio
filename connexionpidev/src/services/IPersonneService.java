/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Personne;
import java.util.List;

/**
 *
 * @author dell
 */
public interface IPersonneService {
    public int ajouterPersonne(Personne p);
    public boolean modifierPersonne(Personne p);
    public boolean supprimerPersonne(Personne p);
    public List<Personne> afficherPersonnes();

}
