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
@Table(name = "BARMENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barmenu.findAll", query = "SELECT b FROM Barmenu b"),
    @NamedQuery(name = "Barmenu.findByIdBar", query = "SELECT b FROM Barmenu b WHERE b.barmenuPK.idBar = :idBar"),
    @NamedQuery(name = "Barmenu.findByIdCocktail", query = "SELECT b FROM Barmenu b WHERE b.barmenuPK.idCocktail = :idCocktail")})
public class Barmenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BarmenuPK barmenuPK;

    public Barmenu() {
    }

    public Barmenu(BarmenuPK barmenuPK) {
        this.barmenuPK = barmenuPK;
    }

    public Barmenu(int idBar, int idCocktail) {
        this.barmenuPK = new BarmenuPK(idBar, idCocktail);
    }

    public BarmenuPK getBarmenuPK() {
        return barmenuPK;
    }

    public void setBarmenuPK(BarmenuPK barmenuPK) {
        this.barmenuPK = barmenuPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (barmenuPK != null ? barmenuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barmenu)) {
            return false;
        }
        Barmenu other = (Barmenu) object;
        if ((this.barmenuPK == null && other.barmenuPK != null) || (this.barmenuPK != null && !this.barmenuPK.equals(other.barmenuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Barmenu[ barmenuPK=" + barmenuPK + " ]";
    }
    
}
