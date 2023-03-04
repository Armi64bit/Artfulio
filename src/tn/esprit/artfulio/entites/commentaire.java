package tn.esprit.artfulio.entites;

/**
 *
 * @author msi
 */
public class commentaire {
   
    
    private int Id_com ;
    private String Date_post;
    private String Texte;
    private int id_artwork;
    private int id_util;

    public commentaire() {
    }

    public commentaire(int Id_com, String Date_post, String Texte, int id_artwork, int id_util) {
        this.Id_com = Id_com;
        this.Date_post = Date_post;
        this.Texte = Texte;
        this.id_artwork = id_artwork;
        this.id_util = id_util;
    }

    public commentaire(int Id_com, String Texte, int id_artwork, int id_util) {
        this.Id_com = Id_com;
        this.Texte = Texte;
        this.id_artwork = id_artwork;
        this.id_util = id_util;
    }

    public commentaire(String Texte, int id_artwork, int id_util) {
        this.Texte = Texte;
        this.id_artwork = id_artwork;
        this.id_util = id_util;
    }

    public commentaire(String Date_post, String Texte, int id_artwork, int id_util) {
        this.Date_post = Date_post;
        this.Texte = Texte;
        this.id_artwork = id_artwork;
        this.id_util = id_util;
    }

    public int getId_com() {
        return Id_com;
    }

    public void setId_com(int Id_com) {
        this.Id_com = Id_com;
    }

    public String getDate_post() {
        return Date_post;
    }

    public void setDate_post(String Date_post) {
        this.Date_post = Date_post;
    }

    public String getTexte() {
        return Texte;
    }

    public void setTexte(String Texte) {
        this.Texte = Texte;
    }

    public int getId_artwork() {
        return id_artwork;
    }

    public void setId_artwork(int id_artwork) {
        this.id_artwork = id_artwork;
    }

    public int getId_util() {
        return id_util;
    }

    public void setId_util(int id_util) {
        this.id_util = id_util;
    }

    @Override
    public String toString() {
        return "commentaire{" + "Id_com=" + Id_com + ", Date_post=" + Date_post + ", Texte=" + Texte + ", id_artwork=" + id_artwork + ", id_util=" + id_util + '}';
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
        final commentaire other = (commentaire) obj;
        return this.Id_com == other.Id_com;
    }
    
    
 
}
