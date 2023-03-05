/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import java.util.List;
import entities.Artwork;

/**
 *
 * @author CALLO
 */
public interface IArtworkService {
     public int ajouterartwork(Artwork p);
    public boolean modifierartwork(Artwork p);
    public boolean supprimerartwork(Artwork p);
    public List<Artwork> afficherartwork();
    
}
