/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.entites;

/**
 *
 * @author CALLO
 */
public class categorie {
    
    
    
     private int id_categorie;
    private String nom_categorie;
    private String type_categorie;

    public categorie(int id_categorie, String nom_categorie, String type_categorie) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
        this.type_categorie = type_categorie;
    }

    public categorie(String nom_categorie, String type_categorie) {
        this.nom_categorie = nom_categorie;
        this.type_categorie = type_categorie;
    }

    public categorie() {
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public String getType_categorie() {
        return type_categorie;
    }

    public void setType_categorie(String type_categorie) {
        this.type_categorie = type_categorie;
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
        final categorie other = (categorie) obj;
        if (this.id_categorie != other.id_categorie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "categorie{" + "id_categorie=" + id_categorie + ", nom_categorie=" + nom_categorie + ", type_categorie=" + type_categorie + '}';
    }
    
  
    
}
