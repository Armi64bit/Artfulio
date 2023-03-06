/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.entites;

/**
 *
 * @author 21652
 */
import java.sql.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author karra
 */
public class reclamation {

    private int id_rec;
    private String Titre;
    private int id_user ;
    private String Reclamation_sec;
    private String email;

    public reclamation() {
    }

    public reclamation(int id_rec, String Titre, int id_user, String Reclamation_sec, String email) {
        this.id_rec = id_rec;
        this.Titre = Titre;
        this.id_user = id_user;
        this.Reclamation_sec = Reclamation_sec;
        this.email=email;
    }

    public reclamation(String Titre, int id_user, String Reclamation_sec, String email) {
        this.Titre = Titre;
        this.id_user = id_user;
        this.Reclamation_sec = Reclamation_sec;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getReclamation_sec() {
        return Reclamation_sec;
    }

    public void setReclamation_sec(String Reclamation_sec) {
        this.Reclamation_sec = Reclamation_sec;
    }

    

    

}
