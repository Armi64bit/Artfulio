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
@Table(name = "video")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v")
    , @NamedQuery(name = "Video.findByTypeVideo", query = "SELECT v FROM Video v WHERE v.typeVideo = :typeVideo")})
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "type_video")
    private String typeVideo;

    public Video() {
    }

    public Video(String typeVideo) {
        this.typeVideo = typeVideo;
    }

    public String getTypeVideo() {
        return typeVideo;
    }

    public void setTypeVideo(String typeVideo) {
        this.typeVideo = typeVideo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeVideo != null ? typeVideo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Video)) {
            return false;
        }
        Video other = (Video) object;
        if ((this.typeVideo == null && other.typeVideo != null) || (this.typeVideo != null && !this.typeVideo.equals(other.typeVideo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test2.Video[ typeVideo=" + typeVideo + " ]";
    }
    
}
