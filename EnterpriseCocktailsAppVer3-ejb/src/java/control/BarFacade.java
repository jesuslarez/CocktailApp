/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Bar;
import entities.Client;
import entities.Cocktail;
import entities.CocktailRecipeAndDescription;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

    public List<Bar> addFavourite(String barName, Client user) {
        List<Bar> barCollection = em.createQuery("SELECT b FROM Bar b WHERE b.clientCollection IN (:user)")
                .setParameter("user", user)
                .getResultList();
        Bar bar = findByName(barName);
        barCollection.add(bar);
        user.setBarCollection(barCollection);
        em.merge(user);
        return barCollection;
    }

    public Bar findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Bar> cq = cb.createQuery(Bar.class);
        Root<Bar> b = cq.from(Bar.class);
        Predicate namePredicate = cb.like(b.get("name"), name);
        cq.select(b);
        cq.where(namePredicate);
        TypedQuery<Bar> q = em.createQuery(cq);
        return q.getSingleResult();
    }

    private int getId() {
        List<Bar> findAll = this.findAll();
        int i = 0;
        for (Bar bar : findAll) {
            i = bar.getId();
        }
        i++;
        return i;
    }

    public List<Bar> orderByName(Client user) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Bar> cq = cb.createQuery(Bar.class);
        Root<Bar> b = cq.from(Bar.class);
        cq.select(b);
        cq.orderBy(cb.asc(b.get("name")));
        TypedQuery<Bar> q = em.createQuery(cq);
        return q.getResultList();
    }

}
