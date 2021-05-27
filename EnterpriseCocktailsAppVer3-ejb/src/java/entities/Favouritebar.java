/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jesus Larez
 */
@Entity
@Table(name = "FAVOURITEBAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favouritebar.findAll", query = "SELECT f FROM Favouritebar f"),
    @NamedQuery(name = "Favouritebar.findByIdUser", query = "SELECT f FROM Favouritebar f WHERE f.favouritebarPK.idUser = :idUser"),
    @NamedQuery(name = "Favouritebar.findByIdBar", query = "SELECT f FROM Favouritebar f WHERE f.favouritebarPK.idBar = :idBar")})
public class Favouritebar implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FavouritebarPK favouritebarPK;

    public Favouritebar() {
    }

    public Favouritebar(FavouritebarPK favouritebarPK) {
        this.favouritebarPK = favouritebarPK;
    }

    public Favouritebar(int idUser, int idBar) {
        this.favouritebarPK = new FavouritebarPK(idUser, idBar);
    }

    public FavouritebarPK getFavouritebarPK() {
        return favouritebarPK;
    }

    public void setFavouritebarPK(FavouritebarPK favouritebarPK) {
        this.favouritebarPK = favouritebarPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (favouritebarPK != null ? favouritebarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favouritebar)) {
            return false;
        }
        Favouritebar other = (Favouritebar) object;
        if ((this.favouritebarPK == null && other.favouritebarPK != null) || (this.favouritebarPK != null && !this.favouritebarPK.equals(other.favouritebarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Favouritebar[ favouritebarPK=" + favouritebarPK + " ]";
    }
    
}
