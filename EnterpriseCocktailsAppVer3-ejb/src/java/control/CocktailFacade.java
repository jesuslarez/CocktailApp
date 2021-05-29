/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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

    public Cocktail add(String name, String description, String recipe) {

        Cocktail newCocktail = new Cocktail(99, name, description, recipe);
        em.persist(newCocktail);
        return newCocktail;
    }

    public void remove(int id) {
        Cocktail cocktail = em.find(Cocktail.class, id);
        em.remove(cocktail);
    }

    public Cocktail merge(int id, String name, String description, String recipe) {

        Cocktail cocktail = em.find(Cocktail.class, id);
        if (name != null) {
            cocktail.setName(name);
        }
        if (description != null) {
            cocktail.setDescription(description);
        }
        if (recipe != null) {
            cocktail.setRecipe(recipe);
        }
        em.merge(cocktail);
        return cocktail;
    }
    
    public List findByName(String name){
        return em.createQuery("SELECT c FROM Cocktail c WHERE c.name LIKE :cocktailName")
                .setParameter("cocktailName", name)
                .setMaxResults(10)
                .getResultList();
    }
}
