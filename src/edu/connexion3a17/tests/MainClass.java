/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a17.tests;

import edu.connexion3a17.entities.Personne;
import edu.connexion3a17.services.PersonneCRUD;
import edu.connexion3a17.utils.MyConnection;

/**
 *
 * @author karra
 */
public class MainClass {
    public static void main(String[] args) {
        //MyConnection mc = new MyConnection();
        Personne p = new Personne(22, "Esprit", "Ariana");
        PersonneCRUD pcd = new PersonneCRUD();
        pcd.ajouterEntitee(p);
    }
}
