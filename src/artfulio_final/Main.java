
import static java.lang.System.out;
import tn.esprit.artfulio.entites.categorie;
import java.sql.*;
import tn.esprit.artfulio.services.CategorieService;


public class Main {
 
  
    public static void main (String []args){
        categorie c = new categorie( 1,"salwa", "numerique");
        CategorieService cc = new CategorieService();
        
        
        //cc.ajoutercategorie(c);
       // cc.modifiercategorie(c);
      // cc.supprimercategorie(c);
        System.out.println(cc.affichercategorie());
        
    
}
    
}
