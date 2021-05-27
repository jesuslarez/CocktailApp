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
@Table(name = "COCKTAILANDINGREDIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cocktailandingredient.findAll", query = "SELECT c FROM Cocktailandingredient c"),
    @NamedQuery(name = "Cocktailandingredient.findByIdCocktail", query = "SELECT c FROM Cocktailandingredient c WHERE c.cocktailandingredientPK.idCocktail = :idCocktail"),
    @NamedQuery(name = "Cocktailandingredient.findByIdIngredient", query = "SELECT c FROM Cocktailandingredient c WHERE c.cocktailandingredientPK.idIngredient = :idIngredient")})
public class Cocktailandingredient implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CocktailandingredientPK cocktailandingredientPK;

    public Cocktailandingredient() {
    }

    public Cocktailandingredient(CocktailandingredientPK cocktailandingredientPK) {
        this.cocktailandingredientPK = cocktailandingredientPK;
    }

    public Cocktailandingredient(int idCocktail, int idIngredient) {
        this.cocktailandingredientPK = new CocktailandingredientPK(idCocktail, idIngredient);
    }

    public CocktailandingredientPK getCocktailandingredientPK() {
        return cocktailandingredientPK;
    }

    public void setCocktailandingredientPK(CocktailandingredientPK cocktailandingredientPK) {
        this.cocktailandingredientPK = cocktailandingredientPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cocktailandingredientPK != null ? cocktailandingredientPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cocktailandingredient)) {
            return false;
        }
        Cocktailandingredient other = (Cocktailandingredient) object;
        if ((this.cocktailandingredientPK == null && other.cocktailandingredientPK != null) || (this.cocktailandingredientPK != null && !this.cocktailandingredientPK.equals(other.cocktailandingredientPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cocktailandingredient[ cocktailandingredientPK=" + cocktailandingredientPK + " ]";
    }
    
}
