/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Asus
 */
public enum Paiement {
    Cash_on_delivery,
        Paiment_by_card;
        
        public Paiement fromString(String text){
            for(Paiement paie:Paiement.values()){
                if(paie.name().equalsIgnoreCase(text)){
                    return paie;}}
            return null;
                   
        }

}
