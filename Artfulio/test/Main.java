
import entities.Paiement;
import entities.Piece_Art;
import entities.User;
import entities.VenteProduit;
import services.UserService;
import java.sql.*;
import services.PieceService;
import services.VenteService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class Main {
    public static void main(String[] args) {
         User a = new User("amine");
         Piece_Art p = new Piece_Art("monalisaa");
         VenteProduit v = new VenteProduit(0, 0, 0, Paiement.Paiment_by_card, 0, 0);
         UserService serviceUser = new UserService();
         PieceService servicePiece = new PieceService();
         VenteService serviceVente = new VenteService();
         System.out.println(serviceVente.ajouterVente(v));
         //System.out.println( serviceUser.ajouterUser(a));
         //System.out.println(servicePiece.ajouterArt(p));
          //System.out.println(servicePiece.modifierArt(p));
         //System.out.println( serviceUser.modifierUser(a));
         //System.out.println(servicePiece.supprimerArt(p));
         //System.out.println( serviceUser.supprimerUser(a));
          //System.out.println( serviceUser.afficherUsers());
          
          //System.out.println( servicePiece.afficherArts());
    }
}
