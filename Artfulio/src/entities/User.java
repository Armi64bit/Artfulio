/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author Asus
 */
public class User {

    private int Id_util;
    private String nom;

    public User() {
    }

    public User(String nom) {
        this.nom = nom;
    }

    public User(int Id_util, String nom) {
        this.Id_util = Id_util;
        this.nom = nom;
    }

    public int getId_util() {
        return Id_util;
    }

    public void setId_util(int Id_util) {
        this.Id_util = Id_util;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "User{" + "Id_util=" + Id_util + ", nom=" + nom + '}';
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
        final User other = (User) obj;
        if (this.Id_util != other.Id_util) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

}
