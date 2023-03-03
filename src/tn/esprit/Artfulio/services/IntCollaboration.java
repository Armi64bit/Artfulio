/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.Artfulio.services;

import java.util.List;
import tn.esprit.Artfulio.entites.Collaboration;

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
    Collaboration recherche(String titre, String typec);
}
