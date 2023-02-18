
import entites.Profile;
import java.sql.*;
import services.ProfileService;
import services.skillsservice;
import entites.skills;

public class Main {
 
  
    public static void main (String []args){
        Profile p = new Profile(11,1,"aaa","aaa","aaa","aaa","aaa");
        ProfileService profileService = new ProfileService();
        skills s= new skills("deva","aaaaaaadaz");
        skillsservice skillservice= new skillsservice();
        ////////////////profile////////////////////
// System.out.println( profileService.ajouterProfile(p));
      //  System.out.println(profileService.afficherProfile());
      // System.out.println(profileService.modifierProfile(p));
        // System.out.println(profileService.afficherProfile());
       // System.out.println(profileService.supprimerProfile(p));
        ///////////////////////skill//////////////
        //System.out.println( skillservice.ajouterskills(s));
        //System.out.println( skillservice.afficherskills());
       // System.out.println( skillservice.supprimerskills(s));
         System.out.println( skillservice.modifierskills(s));
        
        
}
    
}
