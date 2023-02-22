/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.VenteProduit;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface IVenteProduit {
     public int ajouterVente(VenteProduit v);
    public boolean modifierVente(VenteProduit v);
    public boolean supprimerVente(VenteProduit v);
    public List<VenteProduit> afficheventes();
}
