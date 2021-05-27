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
public class CocktailandingredientPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_COCKTAIL")
    private int idCocktail;
    @Basic(optional = false)
    @Column(name = "ID_INGREDIENT")
    private int idIngredient;

    public CocktailandingredientPK() {
    }

    public CocktailandingredientPK(int idCocktail, int idIngredient) {
        this.idCocktail = idCocktail;
        this.idIngredient = idIngredient;
    }

    public int getIdCocktail() {
        return idCocktail;
    }

    public void setIdCocktail(int idCocktail) {
        this.idCocktail = idCocktail;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCocktail;
        hash += (int) idIngredient;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CocktailandingredientPK)) {
            return false;
        }
        CocktailandingredientPK other = (CocktailandingredientPK) object;
        if (this.idCocktail != other.idCocktail) {
            return false;
        }
        if (this.idIngredient != other.idIngredient) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CocktailandingredientPK[ idCocktail=" + idCocktail + ", idIngredient=" + idIngredient + " ]";
    }
    
}
