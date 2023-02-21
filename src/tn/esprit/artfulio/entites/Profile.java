/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.artfulio.entites;

/**
 *
 * @author msi
 */
public class Profile {
    private int id_profil;
    private int id_util;
    private String bio;
    private String ig;
    private String fb;
    private String twitter;
    private String ytb;

    public Profile() {
    }

    public Profile(int id_profil, int id_util, String bio, String ig, String fb, String twitter, String ytb) {
        this.id_profil = id_profil;
        this.id_util = id_util;
        this.bio = bio;
        this.ig = ig;
        this.fb = fb;
        this.twitter = twitter;
        this.ytb = ytb;
    }

    public Profile(int id_util, String bio, String ig, String fb, String twitter, String ytb) {
        this.id_util = id_util;
        this.bio = bio;
        this.ig = ig;
        this.fb = fb;
        this.twitter = twitter;
        this.ytb = ytb;
    }

    public Profile(String bio, String ig, String fb, String twitter, String ytb) {
        this.bio = bio;
        this.ig = ig;
        this.fb = fb;
        this.twitter = twitter;
        this.ytb = ytb;
    }

    public int getId_profil() {
        return id_profil;
    }

    public int getId_util() {
        return id_util;
    }

    public String getBio() {
        return bio;
    }

    public String getIg() {
        return ig;
    }

    public String getFb() {
        return fb;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getYtb() {
        return ytb;
    }

    public void setId_util(int id_util) {
        this.id_util = id_util;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setIg(String ig) {
        this.ig = ig;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public void setYtb(String ytb) {
        this.ytb = ytb;
    }

    @Override
    public String toString() {
        return "Profile{" + "id_profil=" + id_profil + ", id_util=" + id_util + ", bio=" + bio + ", ig=" + ig + ", fb=" + fb + ", twitter=" + twitter + ", ytb=" + ytb + '}';
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
        final Profile other = (Profile) obj;
        if (this.id_profil != other.id_profil) {
            return false;
        }
        return this.id_util == other.id_util;
    }
    
    
    
    
    
    
}
