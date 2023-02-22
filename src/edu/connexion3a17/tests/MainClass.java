/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a17.tests;

import edu.connexion3a17.entities.commentaire;
import edu.connexion3a17.services.CommentaireCRUD;
import edu.connexion3a17.utils.MyConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author karra
 */
public class MainClass {

    public static void main(String[] args) {
        //MyConnection mc = new MyConnection();
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate = DateFor.format(date);
        commentaire c = new commentaire(22, "Esprit", 11, stringDate);
        commentaire c1 = new commentaire(22, "Esprit202", 115, stringDate);

        CommentaireCRUD ccd = new CommentaireCRUD();
        ccd.ajouterEntitee(c);
        ccd.Delete(c);
        ccd.ajouterEntitee(c);
        ccd.Update(c1);
       

    }
}
