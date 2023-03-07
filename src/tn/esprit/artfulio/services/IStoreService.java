/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.services;
import tn.esprit.artfulio.entites.artwork;
import java.util.List;
/**
 *
 * @author Asus
 */
public interface IStoreService {
    public int ajouterArt(artwork a);
    public boolean modifierArt(artwork a);
    public boolean supprimerArt(artwork a);
    public List<artwork> afficherArts();
    
}
