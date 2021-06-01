package control;

import entities.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jesus Larez
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> {

    @PersistenceContext(unitName = "EnterpriseCocktailsAppVer3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
    
    public Client login(String name, String password) {
        List <Client> resultList = em.createQuery("SELECT c FROM Client c WHERE c.nickname = :nickname AND c.password = :password")
                .setParameter("nickname", name)
                .setParameter("password", password)
                .getResultList();
        if (!resultList.isEmpty()) return resultList.get(0);
        return null;
    }
    public int editClient(int id, String name, String password) {
        return em.createQuery("UPDATE Client c SET c.nickname = :name, c.password = :password WHERE c.id = :id")
                .setParameter("id", id)
                .setParameter("name", name)
                .setParameter("password", password)
                .executeUpdate();
    }
    
}
