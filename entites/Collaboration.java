/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.arfulio.entites;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author lelou
 */
public class Collaboration {

    private int id_collaboration;
    private String type_collaboration;
    private LocalDate date_sortie;
    private String titre;
    private String description;
    private boolean status;

    public void setType_collaboration(String type_collaboration) {
        this.type_collaboration = type_collaboration;
    }

    public String getType_collaboration() {
        return type_collaboration;
    }

    public Collaboration(String type_collaboration, LocalDate date_sortie, String titre, String description) {
        this.type_collaboration = type_collaboration;
        this.date_sortie = date_sortie;
        this.titre = titre;
        this.description = description;
        this.status = false;
    }

    public Collaboration() {
    }

    public void setId_collaboration(int id_collaboration) {
        this.id_collaboration = id_collaboration;
    }

    public void setDate_sortie(LocalDate date_sortie) {
        this.date_sortie = date_sortie;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /* public LocalDate saisirDate(){
        int[] tabDate = new int[3];
        Scanner sc = new Scanner(System.in);
        System.out.println("saisir jour");
        tabDate[0] = sc.nextInt();
        System.out.println("saisir mois");
        tabDate[1] = sc.nextInt();
        System.out.println("saisir Annee");
        tabDate[2] = sc.nextInt();
        
    LocalDate date1 = LocalDate.of(tabDate[2], tabDate[1],tabDate[0]);
    return date1;
    } */
    public int getId_collaboration() {
        return id_collaboration;
    }

    public LocalDate getDate_sortie() {
        return date_sortie;
    }

    public boolean isStatus() {
        return status;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Collaboration{" + "id_collaboration=" + id_collaboration + ", type_collaboration=" + type_collaboration + ", date_sortie=" + date_sortie + ", titre=" + titre + ", description=" + description + ", status=" + status + '}';
    }

}
