/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CALLO
 */
@Entity
@Table(name = "audio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Audio.findAll", query = "SELECT a FROM Audio a")
    , @NamedQuery(name = "Audio.findByTypeAudio", query = "SELECT a FROM Audio a WHERE a.typeAudio = :typeAudio")})
public class Audio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "type_audio")
    private String typeAudio;

    public Audio() {
    }

    public Audio(String typeAudio) {
        this.typeAudio = typeAudio;
    }

    public String getTypeAudio() {
        return typeAudio;
    }

    public void setTypeAudio(String typeAudio) {
        this.typeAudio = typeAudio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeAudio != null ? typeAudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Audio)) {
            return false;
        }
        Audio other = (Audio) object;
        if ((this.typeAudio == null && other.typeAudio != null) || (this.typeAudio != null && !this.typeAudio.equals(other.typeAudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test2.Audio[ typeAudio=" + typeAudio + " ]";
    }
    
}
