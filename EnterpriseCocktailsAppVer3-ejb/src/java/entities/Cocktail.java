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
@Table(name = "COCKTAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cocktail.findAll", query = "SELECT c FROM Cocktail c"),
    @NamedQuery(name = "Cocktail.findById", query = "SELECT c FROM Cocktail c WHERE c.id = :id"),
    @NamedQuery(name = "Cocktail.findByName", query = "SELECT c FROM Cocktail c WHERE c.name = :name"),
    @NamedQuery(name = "Cocktail.findByDescription", query = "SELECT c FROM Cocktail c WHERE c.description = :description"),
    @NamedQuery(name = "Cocktail.findByRecipe", query = "SELECT c FROM Cocktail c WHERE c.recipe = :recipe")})
public class Cocktail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "RECIPE")
    private String recipe;

    public Cocktail() {
    }

    public Cocktail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cocktail)) {
            return false;
        }
        Cocktail other = (Cocktail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cocktail[ id=" + id + " ]";
    }
    
}
