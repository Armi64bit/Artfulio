/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.services;

import java.util.List;
import tn.esprit.artfulio.entites.Artiste_Collaboration;

/**
 *
 * @author lelou
 */
public interface IntArtiste_Collaboration {
      
    int ajouterArtister_Collaboration(Artiste_Collaboration art_col);
    boolean deleteArtisteFromCollaboration(int idArtiste, int idCollaboration);
     List<Artiste_Collaboration> afficherCollaborationsUnArtiste(int idArtiste);
}
