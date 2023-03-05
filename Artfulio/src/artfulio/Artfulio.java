/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artfulio;

import entities.Artwork;
import services.StoreService;

/**
 *
 * @author Asus
 */
public class Artfulio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Artwork a = new Artwork(1111, "test1","test1", 111, 111, 11,"test1", 111,"test1");
        StoreService serviceStore = new  StoreService();
        System.out.println(serviceStore.ajouterArt(a));
        System.out.println(serviceStore.afficherArts());
        

}}
