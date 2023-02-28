/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import java.util.List;
import tn.esprit.artfulio.entites.artwork;

/**
 *
 * @author CALLO
 */
public interface IArtworkService {
     public int ajouterartwork(artwork p);
    public boolean modifierartwork(artwork p);
    public boolean supprimerartwork(artwork p);
    public List<artwork> afficherartwork();
    
}
