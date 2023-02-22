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
@Table(name = "image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i")
    , @NamedQuery(name = "Image.findByTypeImg", query = "SELECT i FROM Image i WHERE i.typeImg = :typeImg")})
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "type_img")
    private String typeImg;

    public Image() {
    }

    public Image(String typeImg) {
        this.typeImg = typeImg;
    }

    public String getTypeImg() {
        return typeImg;
    }

    public void setTypeImg(String typeImg) {
        this.typeImg = typeImg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeImg != null ? typeImg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Image)) {
            return false;
        }
        Image other = (Image) object;
        if ((this.typeImg == null && other.typeImg != null) || (this.typeImg != null && !this.typeImg.equals(other.typeImg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test2.Image[ typeImg=" + typeImg + " ]";
    }
    
}
