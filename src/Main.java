
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
import tn.esprit.artfulio.entites.artwork;
import tn.esprit.artfulio.services.ArtworkService;
import tn.esprit.artfulio.services.UserService;
public class Main {
 
  
    public static void main (String []args){
//        Profile p = new Profile("aaa","aaa","a","aaa","aaa");
//        ProfileService profileService = new ProfileService();
//        skills s= new skills("deva","aaaaaaadaz");
//       skillsservice skillservice= new skillsservice();
//       
       
        ////////////////profile////////////////////
// System.out.println( profileService.ajouterProfile(p));
      //  System.out.println(profileService.afficherProfile());
      //System.out.println( profileService.modifierProfile(p));
        // System.out.println(profileService.afficherProfile());
       // System.out.println(profileService.supprimerProfile(p));
        ///////////////////////skill//////////////
        //System.out.println( skillservice.ajouterskills(s));
        //System.out.println( skillservice.afficherskills());
      //  System.out.println( skillservice.supprimerskills(s));
        // System.out.println( skillservice.modifierskills(s));
              //  System.out.println( skillservice.afficherskills("fb"));
// p=profileService.afficherProfilefb("z");
//        System.out.println(p.getId_profil());



        ArtworkService as =new ArtworkService();
        artwork a = new artwork();
         //     a=  as.afficherartwork().get(0));
 UserService us = new UserService();
       User list = new User();
       list=us.afficherProfilefb(10);
           System.out.println(list.toString());
     
}
    
}
