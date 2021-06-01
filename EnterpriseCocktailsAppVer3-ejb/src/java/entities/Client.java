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
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id"),
    @NamedQuery(name = "Client.findByNickname", query = "SELECT c FROM Client c WHERE c.nickname = :nickname"),
    @NamedQuery(name = "Client.findByPassword", query = "SELECT c FROM Client c WHERE c.password = :password")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NICKNAME")
    private String nickname;
    @Column(name = "PASSWORD")
    private String password;
    @JoinTable(name = "FAVOURITECOCKTAILS", joinColumns = {
        @JoinColumn(name = "ID_USER", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_COCKTAIL", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Cocktail> cocktailCollection;
    @JoinTable(name = "FAVOURITEBAR", joinColumns = {
        @JoinColumn(name = "ID_USER", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_BAR", referencedColumnName = "ID")})
    @ManyToMany 
    private Collection<Bar> barCollection;

    public Client() {
    }

    public Client(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Cocktail> getCocktailCollection() {
        return cocktailCollection;
    }

    public void setCocktailCollection(Collection<Cocktail> cocktailCollection) {
        this.cocktailCollection = cocktailCollection;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Client[ id=" + id + " ]";
    }
    
}
