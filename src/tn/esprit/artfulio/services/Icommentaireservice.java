package tn.esprit.artfulio.services;

import java.util.List;
import tn.esprit.artfulio.entites.commentaire;

/**
 *
 * @author msi
 */
public interface Icommentaireservice {
    public int ajoutercommentaire(commentaire p);
    public boolean modifiercommentaire(commentaire p);
    public boolean supprimercommentaire(commentaire p);
    public List<commentaire> affichercommentaire();
   
    
}
