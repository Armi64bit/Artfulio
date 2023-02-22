/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;
import java.util.Objects;
/**
 *
 * @author CALLO
 */
public class CategoriePhysique extends TypeCategorie {
     
 private float dimension  ;
  
 
   
  public CategoriePhysique () {
      super ();
    }

public CategoriePhysique (int id,float dimension ) {
      
      super(id);
      
      this.dimension=dimension ; 
    }
//  public TypeCategorie(int id, String dimension) {
//        this.id = id;
//        this.dimension = dimension;
       
//    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

 
    
     @Override
    public String toString() {
        return "CategoriePhysique{" + "id=" + id + "," + "dimension=" + dimension + "}";
    }
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoriePhysique other = (CategoriePhysique) obj;
        if (this.id != other.id) {
            return false;
        }
       if (!Objects.equals(this.dimension, other.dimension)) {
           return false;
      }
        return true;
    }


 
}
