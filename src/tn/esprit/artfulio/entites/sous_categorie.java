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
public class sous_categorie {
      private int id_sous_categorie;
    private String nom_sous_categorie;
    private String type_sous_categorie;

    public sous_categorie() {
    }

    public sous_categorie(int id_sous_categorie, String nom_sous_categorie, String type_sous_categorie) {
        this.id_sous_categorie = id_sous_categorie;
        this.nom_sous_categorie = nom_sous_categorie;
        this.type_sous_categorie = type_sous_categorie;
    }

    public int getId_sous_categorie() {
        return id_sous_categorie;
    }

    public void setId_sous_categorie(int id_sous_categorie) {
        this.id_sous_categorie = id_sous_categorie;
    }

    public String getNom_sous_categorie() {
        return nom_sous_categorie;
    }

    public void setNom_sous_categorie(String nom_sous_categorie) {
        this.nom_sous_categorie = nom_sous_categorie;
    }

    public String getType_sous_categorie() {
        return type_sous_categorie;
    }

    public void setType_sous_categorie(String type_sous_categorie) {
        this.type_sous_categorie = type_sous_categorie;
    }

    @Override
    public String toString() {
        return "sous_categorie{" + "id_sous_categorie=" + id_sous_categorie + ", nom_sous_categorie=" + nom_sous_categorie + ", type_sous_categorie=" + type_sous_categorie + '}';
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
        final sous_categorie other = (sous_categorie) obj;
        if (this.id_sous_categorie != other.id_sous_categorie) {
            return false;
        }
        return true;
    }
    
    
    
    
}
