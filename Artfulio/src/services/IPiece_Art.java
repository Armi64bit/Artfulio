/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Piece_Art;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface IPiece_Art {
     public int ajouterArt(Piece_Art a);
    public boolean modifierArt(Piece_Art a);
    public boolean supprimerArt(Piece_Art a);
    public List<Piece_Art> afficherArts();
    
}
