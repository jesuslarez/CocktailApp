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
        List<Client> users = this.findAll();
        Client u = null;
        for (Client user : users) {
            if (user.getNickname().equals(name)) {
                u = user;
            }
        }
        Client user = em.find(Client.class, u.getId());
        System.out.println("CLIENT FOUND: " + user.getNickname());
        if (checkPassword(user, password)) return user;
        return null;
    }

    private boolean checkPassword(Client user, String password) {
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

}
