package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "BAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bar.findAll", query = "SELECT b FROM Bar b"),
    @NamedQuery(name = "Bar.findById", query = "SELECT b FROM Bar b WHERE b.id = :id"),
    @NamedQuery(name = "Bar.findByName", query = "SELECT b FROM Bar b WHERE b.name = :name"),
    @NamedQuery(name = "Bar.findByAddress", query = "SELECT b FROM Bar b WHERE b.address = :address")})
public class Bar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @ManyToMany(mappedBy = "barCollection")
    private Collection<Client> clientCollection;
    @ManyToMany(mappedBy = "barCollection")
    private Collection<Cocktail> cocktailCollection;

    public Bar() {
    }

    public Bar(Integer id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    @XmlTransient
    public Collection<Cocktail> getCocktailCollection() {
        return cocktailCollection;
    }

    public void setCocktailCollection(Collection<Cocktail> cocktailCollection) {
        this.cocktailCollection = cocktailCollection;
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
        if (!(object instanceof Bar)) {
            return false;
        }
        Bar other = (Bar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bar[ id=" + id + " ]";
    }
    
}
