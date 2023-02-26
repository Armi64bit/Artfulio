/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tn.esprit.arfulio.services;

import java.util.List;
import tn.esprit.arfulio.entites.Artiste_Collaboration;
import tn.esprit.arfulio.entites.Collaboration;

/**
 *
 * @author lelou
 */
public interface IntArtiste_Collaboration {
    
    int ajouterArtister_Collaboration(int idArtiste, int idCollaboration);
    boolean deleteArtisteFromCollaboration(int idArtiste, int idCollaboration);
     List<Artiste_Collaboration> afficherCollaborationsUnArtiste(int idArtiste);
    
}
