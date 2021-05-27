/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jesus Larez
 */
@Embeddable
public class FavouritebarPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_USER")
    private int idUser;
    @Basic(optional = false)
    @Column(name = "ID_BAR")
    private int idBar;

    public FavouritebarPK() {
    }

    public FavouritebarPK(int idUser, int idBar) {
        this.idUser = idUser;
        this.idBar = idBar;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdBar() {
        return idBar;
    }

    public void setIdBar(int idBar) {
        this.idBar = idBar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUser;
        hash += (int) idBar;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavouritebarPK)) {
            return false;
        }
        FavouritebarPK other = (FavouritebarPK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idBar != other.idBar) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FavouritebarPK[ idUser=" + idUser + ", idBar=" + idBar + " ]";
    }
    
}
