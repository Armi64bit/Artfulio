/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Asus
 */

public class VenteProduit extends User {

    private int Id_Vente;
    private int Id_Piece_art;
    private int Prix;
    private int Id_Artist;
    private int Id_Client;
    private Paiement paiement;
    

    
    public VenteProduit() {
    }

    public VenteProduit(int Id_Vente, int Id_Artist, int Id_Client , Paiement paiement, int Prix ,int Id_Piece_art) {
        this.Id_Vente = Id_Vente;
        this.Id_Piece_art = Id_Piece_art;
        this.Prix = Prix;
        this.Id_Artist = Id_Artist;
        this.Id_Client = Id_Client;
        this.paiement = paiement;
    }

   

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }
   

    public int getId_Vente() {
        return Id_Vente;
    }

    public void setId_Vente(int Id_Vente) {
        this.Id_Vente = Id_Vente;
    }

    public int getId_Piece_art() {
        return Id_Piece_art;
    }

    public void setId_Piece_art(int Id_Piece_art) {
        this.Id_Piece_art = Id_Piece_art;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int Prix) {
        this.Prix = Prix;
    }

    public int getId_Artist() {
        return Id_Artist;
    }

    public void setId_Artist(int Id_Artist) {
        this.Id_Artist = Id_Artist;
    }

    public int getId_Client() {
        return Id_Client;
    }

    public void setId_Client(int Id_Client) {
        this.Id_Client = Id_Client;
    }

    @Override
    public String toString() {
        return "VenteProduit{" + "Id_Vente=" + Id_Vente + ", Id_Piece_art=" + Id_Piece_art + ", Prix=" + Prix + ", Id_Artist=" + Id_Artist + ", Id_Client=" + Id_Client + '}';
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
        final VenteProduit other = (VenteProduit) obj;
        if (this.Id_Vente != other.Id_Vente) {
            return false;
        }
        if (this.Id_Piece_art != other.Id_Piece_art) {
            return false;
        }
        if (this.Prix != other.Prix) {
            return false;
        }
        if (this.Id_Artist != other.Id_Artist) {
            return false;
        }
        if (this.Id_Client != other.Id_Client) {
            return false;
        }
        return true;
    }

}
