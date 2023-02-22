
import entites.Personne;
import java.sql.*;
import services.PersonneService;
public class Main {
 
  
    public static void main (String []args){      
        Personne p = new Personne("hamza", 22);
        PersonneService personneService = new PersonneService();
    // System.out.println( personneService.ajouterPersonne(p));
        
          System.out.println( personneService.afficherPersonnes());
         System.out.println( personneService.modifierPersonne(p));
        //  System.out.println( personneService.supprimerPersonne(p));
          System.out.println( personneService.afficherPersonnes());
                    

}
    
}
