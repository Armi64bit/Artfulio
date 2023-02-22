/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a17.entities;

/**
 *
 * @author 21652
 */
import java.sql.Date;

/**
 *
 * @author karra
 */
public class reclamation {
    
    private int id_rec;
    private String Titre;
    private String Date;
    private String Reclamation_sec;
    private int Num_tlf;

    public reclamation() {
    }

    public reclamation(int id_rec, String Titre, String Date, String Reclamation_sec ,int Num_tlf) {
        this.id_rec = id_rec;
        this.Titre= Titre;
        this.Date = Date;
        this.Reclamation_sec = Reclamation_sec;
        this.Num_tlf=Num_tlf;
    }
    
    public reclamation(String Date) {
        this.Date = Date;
    }
    public reclamation( String Titre,  String Reclamation_sec ,int Num_tlf) {
        this.id_rec = id_rec;
        this.Titre= Titre;
        this.Date = Date;
        this.Reclamation_sec = Reclamation_sec;
        this.Num_tlf=Num_tlf;
    }
    
    public reclamation( String Titre,  String Reclamation_sec, String Date ,int Num_tlf) {
        this.id_rec = id_rec;
        this.Titre= Titre;
        this.Date = Date;
        this.Reclamation_sec = Reclamation_sec;
        this.Num_tlf=Num_tlf;
    }

    public reclamation(int i, String esprit, String ariana) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getReclamation_sec() {
        return Reclamation_sec;
    }

    public void setReclamation_sec(String Reclamation_sec) {
        this.Reclamation_sec = Reclamation_sec;
    }

    public int getNum_tlf() {
        return Num_tlf;
    }

    public void setNum_tlf(int Num_tlf) {
        this.Num_tlf = Num_tlf;
    }

    @Override
    public String toString() {
        return "reclamation{" + "id_rec=" + id_rec + ", Titre=" + Titre + ", Date=" + Date + ", Reclamation_sec=" + Reclamation_sec + ", Num_tlf=" + Num_tlf + '}';
    }
    
    

    }
