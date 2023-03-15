
import static java.lang.System.out;
import tn.esprit.artfulio.entites.Profile;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.artfulio.entites.User;
import tn.esprit.artfulio.services.ProfileService;
import tn.esprit.artfulio.services.skillsservice;
import tn.esprit.artfulio.entites.skills;
import tn.esprit.artfulio.entites.sous_categorie;
import tn.esprit.artfulio.entites.reclamation;
import tn.esprit.artfulio.entites.parrainage;



import tn.esprit.artfulio.entites.commentaire;
import tn.esprit.artfulio.entites.artwork;
import tn.esprit.artfulio.services.ArtworkService;
import tn.esprit.artfulio.services.UserService;
import tn.esprit.artfulio.services.commentaireservice;
import tn.esprit.artfulio.services.SouscategorieService;
import tn.esprit.artfulio.services.ReclamationCRUD;
import tn.esprit.artfulio.services.parrainageCRUD;
import tn.esprit.artfulio.api.QR;




public class Main {
 
  
    public static void main (String []args){
//       UserService us=new UserService();
//       commentaireservice cs= new commentaireservice();
//       commentaire c= new commentaire("nice", 42, 14);
//        System.out.println(cs.affichercommentaire(42));
//         System.out.println(User.getCurrent_User().getUsername());
//        UserService us=new UserService();
//        User u=new User("username", "cin_user", "adresse_user", "pwd", "mail", "img", "artiste");
//        us.ajouteruser(u);
//        
        
        
//        try {
//            ReclamationCRUD rs=new ReclamationCRUD();
//            parrainageCRUD ps=new parrainageCRUD();
//            parrainage pr=new parrainage( 4, 1,"sofien","sofien@mail.com","artiste");
//            ps.Update(pr);
////reclamation r=new reclamation( 9,"hh", 9, "aaaaaa", "bahaa2000lol@gmail.com");
////rs.ajouterEntitee(r);
////SouscategorieService scs=new SouscategorieService();
//// System.out.print(scs.affichersouscategorie("image"));
////SouscategorieService sc=new SouscategorieService();
////sous_categorie liss =new sous_categorie();
//
////sous_categorie liss2 =new sous_categorie();
////   liss= sc.affichersouscategorienom(3);
////   System.out.print(scs.affichersouscategorie(sc.affichersouscategorienom(liss.getNom_sous_categorie()).getNom_sous_categorie()));
////        QR qr= new QR();
////        qr.Create_QR("path", "2");
////        commentaire c= new commentaire( "nice", 5, 9);
////        commentaireservice cs= new commentaireservice();
////      //  txtcommentpost.getText(),id, User.Current_User.getId_user()
////       // cs.modifiercommentaire(c);
////        System.out.println(cs.numcom(5));
////        //Profile p = new Profile("aaa","aaa","a","aaa","aaa");
////ProfileService profileService = new ProfileService();
//// profileService.ajouterProfile(p);
////        skills s= new skills("deva","aaaaaaadaz");
////       skillsservice skillservice= new skillsservice();
////
//
//////////////////profile////////////////////
//// System.out.println( profileService.ajouterProfile(p));
////  System.out.println(profileService.afficherProfile());
////System.out.println( profileService.modifierProfile(p));
//// System.out.println(profileService.afficherProfile());
//// System.out.println(profileService.supprimerProfile(p));
/////////////////////////skill//////////////
////System.out.println( skillservice.ajouterskills(s));
////System.out.println( skillservice.afficherskills());
////  System.out.println( skillservice.supprimerskills(s));
//// System.out.println( skillservice.modifierskills(s));
////  System.out.println( skillservice.afficherskills("fb"));
//// p=profileService.afficherProfilefb("z");
////        System.out.println(p.getId_profil());
//
//
//
       ArtworkService as =new ArtworkService();
        artwork a=new artwork(46, "hamza");
////        
as.modifierartwork(a);
//////Date d=new Date(2);
////        //a = new artwork ("", "", 0, 4, d, 10, "", 0, "aa");
////          //     as.ajouterartwork(a);
//// //UserService us = new UserService();
//// //User u = new User(9,"bahaa", "");
////   //     us.update(u);
//////       User list = new User();
//////       list=us.afficherProfilefb(10);
////       System.out.println("a");
//////
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//}
    
}}
