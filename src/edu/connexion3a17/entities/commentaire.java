/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a17.entities;

import java.sql.Date;
import java.util.Scanner;


/**
 *
 * @author karra
 */

public class commentaire {
    
    private int Id_com;
    private String Date_com;
    private String Texte;
    private int Total_reac;
    
    enum React {
  JAIME,
  JADORE,
  WOW,
  JENAIMEPAS
}
    

    public commentaire() {
    }

    public commentaire(enum React ,int Id_com, String Texte, int Total_reac, String Date_com) {
        this.Id_com = Id_com;
        this.Date_com= Date_com;
        this.Texte = Texte;
        this.Total_reac = Total_reac;
    }
    
    public commentaire(String Texte, String Date_com) {
        
        this.Date_com= Date_com;
        this.Texte = Texte;
        
    }
    
    public commentaire(String Texte) {
        
        this.Texte = Texte;
        
    }

    public commentaire(int i, String esprit, String ariana) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_com() {
        return Id_com;
    }

    public void setId_com(int Id_com) {
        this.Id_com = Id_com;
    }

    public String getDate_com() {
        return Date_com; 
    }

    public void setDate_com(String Date_com) {
        this.Date_com = Date_com;
    }

    public String getTexte() {
        return Texte;
    }

    public void setTexte(String Texte) {
        this.Texte = Texte;
    }

    public int getTotal_reac() {
        return Total_reac;
    }

    public void setTotal_reac(int Total_rec) {
        this.Total_reac = Total_rec;
    }
    
    public enum getReact() {
        return React;
    }

    public void setReact(int React) {
        this.React = React;

    @Override
    public String toString() {
        return "Commentaire{""Reaction"+ React + "Id_com=" + Id_com + ", Date_com=" + Date_com + ", Texte=" + Texte + ", Total_com=" + Total_reac + '}';
    }

    
    
    

   

    
    
}
