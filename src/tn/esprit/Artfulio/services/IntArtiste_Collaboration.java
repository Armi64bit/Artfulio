/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.services;

import java.util.List;
import tn.esprit.Artfulio.entites.Artiste_Collaboration;

/**
 *
 * @author lelou
 */
public interface IntArtiste_Collaboration {
      
    int ajouterArtister_Collaboration(int idArtiste, int idCollaboration);
    boolean deleteArtisteFromCollaboration(int idArtiste, int idCollaboration);
     List<Artiste_Collaboration> afficherCollaborationsUnArtiste(int idArtiste);
}
