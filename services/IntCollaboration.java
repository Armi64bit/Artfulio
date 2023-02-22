/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Collaboration;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author lelou
 */
public interface IntCollaboration {
    
    int ajouterCollaboration(Collaboration c);
    boolean supprimerCollaboration(Collaboration c);
    boolean modifierCollaboration(Collaboration c);
    List<Collaboration> afficherCollaboration();
    int[] convertChaineEntier(String chaine);
    boolean comapareDate(LocalDate date1, LocalDate date2);
}
