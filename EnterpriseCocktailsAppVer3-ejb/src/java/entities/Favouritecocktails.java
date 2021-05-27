/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
 * @author Jesus Larez
 */
@Entity
@Table(name = "FAVOURITECOCKTAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favouritecocktails.findAll", query = "SELECT f FROM Favouritecocktails f"),
    @NamedQuery(name = "Favouritecocktails.findByIdUser", query = "SELECT f FROM Favouritecocktails f WHERE f.idUser = :idUser"),
    @NamedQuery(name = "Favouritecocktails.findByIdCocktail", query = "SELECT f FROM Favouritecocktails f WHERE f.idCocktail = :idCocktail")})
public class Favouritecocktails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_USER")
    private Integer idUser;
    @Column(name = "ID_COCKTAIL")
    private Integer idCocktail;

    public Favouritecocktails() {
    }

    public Favouritecocktails(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdCocktail() {
        return idCocktail;
    }

    public void setIdCocktail(Integer idCocktail) {
        this.idCocktail = idCocktail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favouritecocktails)) {
            return false;
        }
        Favouritecocktails other = (Favouritecocktails) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Favouritecocktails[ idUser=" + idUser + " ]";
    }
    
}
