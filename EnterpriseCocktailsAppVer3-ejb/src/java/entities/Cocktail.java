package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "Cocktail.findByName", query = "SELECT c FROM Cocktail c WHERE c.name = :name")})
public class Cocktail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    private CocktailRecipeAndDescription cocktailRecipeAndDescription;
    
    @ManyToMany(mappedBy = "cocktailCollection")
    private Collection<Client> clientCollection;
    @JoinTable(name = "COCKTAILANDINGREDIENT", joinColumns = {
        @JoinColumn(name = "ID_COCKTAIL", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_INGREDIENT", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Ingredient> ingredientCollection;
    @JoinTable(name = "BARMENU", joinColumns = {
        @JoinColumn(name = "ID_COCKTAIL", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_BAR", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Bar> barCollection;

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

    public CocktailRecipeAndDescription getCocktailRecipeAndDescription() {
        return cocktailRecipeAndDescription;
    }

    public void setCocktailRecipeAndDescription(CocktailRecipeAndDescription cocktailRecipeAndDescription) {
        this.cocktailRecipeAndDescription = cocktailRecipeAndDescription;
    }
    

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    @XmlTransient
    public Collection<Ingredient> getIngredientCollection() {
        return ingredientCollection;
    }

    public void setIngredientCollection(Collection<Ingredient> ingredientCollection) {
        this.ingredientCollection = ingredientCollection;
    }

    @XmlTransient
    public Collection<Bar> getBarCollection() {
        return barCollection;
    }

    public void setBarCollection(Collection<Bar> barCollection) {
        this.barCollection = barCollection;
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
