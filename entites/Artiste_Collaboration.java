/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.arfulio.entites;

import java.time.LocalDate;

/**
 *
 * @author lelou
 */
public class Artiste_Collaboration {
    private int id_artiste ;
    private int id_collaboration ;
    private LocalDate date_entree ;

    public Artiste_Collaboration() {
    }

    public Artiste_Collaboration(int id_artiste, int id_collaboration, LocalDate date_entree) {
        this.id_artiste = id_artiste;
        this.id_collaboration = id_collaboration;
        this.date_entree = date_entree;
    }

 

    public int getId_artiste() {
        return id_artiste;
    }

    public int getId_collaboration() {
        return id_collaboration;
    }


    public void setId_artiste(int id_artiste) {
        this.id_artiste = id_artiste;
    }

    public void setDate_entree(LocalDate date_entree) {
        this.date_entree = date_entree;
    }

    public LocalDate getDate_entree() {
        return date_entree;
    }

    public void setId_collaboration(int id_collaboration) {
        this.id_collaboration = id_collaboration;
    }


    @Override
    public String toString() {
        return "Artiste_Collaboration{" + "id_artiste=" + id_artiste + ", id_collaboration=" + id_collaboration + '}';
    }
    
    
}
