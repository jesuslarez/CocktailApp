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
public class BarmenuPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_BAR")
    private int idBar;
    @Basic(optional = false)
    @Column(name = "ID_COCKTAIL")
    private int idCocktail;

    public BarmenuPK() {
    }

    public BarmenuPK(int idBar, int idCocktail) {
        this.idBar = idBar;
        this.idCocktail = idCocktail;
    }

    public int getIdBar() {
        return idBar;
    }

    public void setIdBar(int idBar) {
        this.idBar = idBar;
    }

    public int getIdCocktail() {
        return idCocktail;
    }

    public void setIdCocktail(int idCocktail) {
        this.idCocktail = idCocktail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idBar;
        hash += (int) idCocktail;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BarmenuPK)) {
            return false;
        }
        BarmenuPK other = (BarmenuPK) object;
        if (this.idBar != other.idBar) {
            return false;
        }
        if (this.idCocktail != other.idCocktail) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BarmenuPK[ idBar=" + idBar + ", idCocktail=" + idCocktail + " ]";
    }
    
}
