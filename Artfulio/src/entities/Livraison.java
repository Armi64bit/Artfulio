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
public class Livraison {

    private int id_vente;
    private int Id_Artist;
    private int Id_Client;
    private String destination;

    enum Statut {
        Ready_to_deliver,
        In_Progress,
        Delivered;

    }

    public Livraison() {
    }

    public Livraison(int id_vente, int Id_Artist, int Id_Client, String destination) {
        this.id_vente = id_vente;
        this.Id_Artist = Id_Artist;
        this.Id_Client = Id_Client;
        this.destination = destination;
    }

    public int getId_vente() {
        return id_vente;
    }

    public void setId_vente(int id_vente) {
        this.id_vente = id_vente;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id_vente=" + id_vente + ", Id_Artist=" + Id_Artist + ", Id_Client=" + Id_Client + ", destination=" + destination + '}';
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
        final Livraison other = (Livraison) obj;
        if (this.id_vente != other.id_vente) {
            return false;
        }
        if (this.Id_Artist != other.Id_Artist) {
            return false;
        }
        if (this.Id_Client != other.Id_Client) {
            return false;
        }
        if (!Objects.equals(this.destination, other.destination)) {
            return false;
        }
        return true;
    }

}
