package control;

import entities.Client;
import entities.Cocktail;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jesus Larez
 */
@Stateless
public class CocktailFacade extends AbstractFacade<Cocktail> {

    @PersistenceContext(unitName = "EnterpriseCocktailsAppVer3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CocktailFacade() {
        super(Cocktail.class);
    }

    public List<Cocktail> getFavouriteCocktails(Client user) {
        return em.createQuery("SELECT c FROM Cocktail c WHERE c.clientCollection IN (:user)")
                .setParameter("user", user)
                .getResultList();
        
    }
    
}
