package tn.esprit.artfulio.entites;

/**
 *
 * @author msi
 */
public class skills {
 
    private int id_skill;
    private String titre_skill;
    private String desc_skill;
    private int id_profil;

    
    

    public skills() {
    }
    public void setId_profil(int id_profil) {
        this.id_profil = id_profil;
    }

    public skills( String titre_skill, String desc_skill) {
        this.titre_skill = titre_skill;
        this.desc_skill = desc_skill;
    }

    public int getId_skill() {
        return id_skill;
    }

    public String getTitre_skill() {
        return titre_skill;
    }

    public String getDesc_skill() {
        return desc_skill;
    }

    public void setTitre_skill(String titre_skill) {
        this.titre_skill = titre_skill;
    }

    public void setDesc_skill(String desc_skill) {
        this.desc_skill = desc_skill;
    }

    @Override
    public String toString() {
        return "skills{" + "id_skill=" + id_skill + ", titre_skill=" + titre_skill + ", desc_skill=" + desc_skill + '}';
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
        final skills other = (skills) obj;
        return this.id_skill == other.id_skill;
    }
    
    
}
