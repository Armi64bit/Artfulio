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
public class TypeCategorie {
  public int id ;
  public String nomType;
   
  public TypeCategorie () {
    }

public TypeCategorie (int id, String nomType) {
        this.id = id;
        this.nomType = nomType;
        
    }
//  public TypeCategorie(int id, String nomType) {
//        this.id = id;
//        this.nomType = nomType;
       
//    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }
    
     @Override
    public String toString() {
        return "TypeCategorie{" + "id=" + id + ", nom=" + nomType + ",}";
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
        final TypeCategorie other = (TypeCategorie) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nomType, other.nomType)) {
            return false;
        }
        return true;
    }


 
}

