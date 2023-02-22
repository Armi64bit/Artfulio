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
public class Piece_Art {

    private int id_piece_art;
    private String nom;

    public Piece_Art() {
    }

    public Piece_Art(String nom) {
        this.nom = nom;
    }

    public Piece_Art(int id_piece_art, String nom) {
        this.id_piece_art = id_piece_art;
        this.nom = nom;
    }

    public int getId_piece_art() {
        return id_piece_art;
    }

    public void setId_piece_art(int id_piece_art) {
        this.id_piece_art = id_piece_art;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Piece_Art{" + "id_piece_art=" + id_piece_art + ", nom=" + nom + '}';
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
        final Piece_Art other = (Piece_Art) obj;
        if (this.id_piece_art != other.id_piece_art) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

}
