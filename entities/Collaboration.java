/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author lelou
 */
public class Collaboration {
        private int id;
    private LocalDate date_debut;
    private LocalDate date_fin;
    private boolean status;
    private String user1;
    private String user2;

    
    public Collaboration() {
    }

    public Collaboration(String user1, String user2, LocalDate date_debut, LocalDate date_fin) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.user1 = user1;
        this.user2 = user2;
        this.status = true;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public String getUser1() {
        return user1;
    }

    public String getUser2() {
        return user2;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public boolean isStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ""+id+"  "+ user1 + " ---> " + user2 + "\t  Debut: " + date_debut + " / Fin: " + date_fin +  '.';
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

}
