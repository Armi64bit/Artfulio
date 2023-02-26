/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.arfulio.services;

import tn.esprit.arfulio.entites.Collaboration;
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
    List<Collaboration> afficherCollaborationsUnArtiste(int idArtiste);
    boolean comapareDate(LocalDate date1, LocalDate date2);
}
