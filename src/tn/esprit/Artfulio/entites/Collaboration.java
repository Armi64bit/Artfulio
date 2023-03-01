/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.Artfulio.entites;

import java.time.LocalDate;

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
    private int status;
     private String nom_user;
    private String email_user;
    
        public Collaboration() {
            
    }

    public Collaboration(String type_collaboration, LocalDate date_sortie, String titre, String description, String nom_user, String email_user) {
       
        this.type_collaboration = type_collaboration;
        this.date_sortie = date_sortie;
        this.titre = titre;
        this.description = description;
        this.status = 0;
        this.nom_user = nom_user;
        this.email_user = email_user;
    }

    @Override
    public String toString() {
        return "Collaboration{" + "id_collaboration=" + id_collaboration + ", type_collaboration=" + type_collaboration + ", date_sortie=" + date_sortie + ", titre=" + titre + ", description=" + description + ", status=" + status + ", nom_user=" + nom_user + ", email_user=" + email_user + '}';
    }

    public int getId_collaboration() {
        return id_collaboration;
    }

    public String getType_collaboration() {
        return type_collaboration;
    }

    public LocalDate getDate_sortie() {
        return date_sortie;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public int getStatus() {
        return status;
    }

    public String getNom_user() {
        return nom_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setId_collaboration(int id_collaboration) {
        this.id_collaboration = id_collaboration;
    }

    public void setType_collaboration(String type_collaboration) {
        this.type_collaboration = type_collaboration;
    }

    public void setDate_sortie(LocalDate date_sortie) {
        this.date_sortie = date_sortie;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

 
    
}
