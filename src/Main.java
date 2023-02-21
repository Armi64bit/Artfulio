
import static java.lang.System.out;
import tn.esprit.artfulio.entites.Profile;
import java.sql.*;
import tn.esprit.artfulio.services.ProfileService;
import tn.esprit.artfulio.services.skillsservice;
import tn.esprit.artfulio.entites.skills;

public class Main {
 
  
    public static void main (String []args){
        Profile p = new Profile("aaa","aaa","a","aaa","aaa");
        ProfileService profileService = new ProfileService();
        //skills s= new skills("deva","aaaaaaadaz");
       // skillsservice skillservice= new skillsservice();
        ////////////////profile////////////////////
// System.out.println( profileService.ajouterProfile(p));
      //  System.out.println(profileService.afficherProfile());
      System.out.println( profileService.modifierProfile(p));
        // System.out.println(profileService.afficherProfile());
       // System.out.println(profileService.supprimerProfile(p));
        ///////////////////////skill//////////////
        //System.out.println( skillservice.ajouterskills(s));
        //System.out.println( skillservice.afficherskills());
       // System.out.println( skillservice.supprimerskills(s));
         //System.out.println( skillservice.modifierskills(s));
        
        
}
    
}
