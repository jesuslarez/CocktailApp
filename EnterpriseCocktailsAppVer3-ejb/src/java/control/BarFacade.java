/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Bar;
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
public class BarFacade extends AbstractFacade<Bar> {

    @PersistenceContext(unitName = "EnterpriseCocktailsAppVer3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BarFacade() {
        super(Bar.class);
    }

    public List<Bar> getFavouriteBars(Client user) {
        return em.createQuery("SELECT b FROM Bar b WHERE b.clientCollection IN (:user)")
                .setParameter("user", user)
                .getResultList();
        
    }
    public Bar findByName(String name){
        return (Bar) em.createNamedQuery("Bar.findByName").setParameter("name", name).getSingleResult();
    }
    

}
