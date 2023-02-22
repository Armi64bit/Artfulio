/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author CALLO
 */
public class Categorie {
    
    private int id_categorie;
    private String nom_categorie;
    private String image_categorie ;
    private String audio_categorie ;
     private String video_categorie ;

    public Categorie() {
    }

    public Categorie(int id_categorie, String nom_categorie, String image_categorie, String audio_categorie, String video_categorie) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
        this.image_categorie = image_categorie;
        this.audio_categorie = audio_categorie;
        this.video_categorie = video_categorie;
    }

    public Categorie(String nom_categorie, String image_categorie, String audio_categorie, String video_categorie) {
        this.nom_categorie = nom_categorie;
        this.image_categorie = image_categorie;
        this.audio_categorie = audio_categorie;
        this.video_categorie = video_categorie;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public String getImage_categorie() {
        return image_categorie;
    }

    public void setImage_categorie(String image_categorie) {
        this.image_categorie = image_categorie;
    }

    public String getAudio_categorie() {
        return audio_categorie;
    }

    public void setAudio_categorie(String audio_categorie) {
        this.audio_categorie = audio_categorie;
    }

    public String getVideo_categorie() {
        return video_categorie;
    }

    public void setVideo_categorie(String video_categorie) {
        this.video_categorie = video_categorie;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id_categorie=" + id_categorie + ", nom_categorie=" + nom_categorie + ", image_categorie=" + image_categorie + ", audio_categorie=" + audio_categorie + ", video_categorie=" + video_categorie + '}';
    }
     
     
     
     
     
     
     
     

    
    
    
}
