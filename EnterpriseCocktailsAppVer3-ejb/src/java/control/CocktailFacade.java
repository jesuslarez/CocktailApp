package control;

import entities.Bar;
import entities.Client;
import entities.Cocktail;
import entities.CocktailRecipeAndDescription;
import java.util.Collection;
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

    public List<Cocktail> addFavourite(String cocktailName, Client user) {
        List cocktailCollection = em.createQuery("SELECT c FROM Cocktail c WHERE c.clientCollection IN (:user)")
                .setParameter("user", user)
                .getResultList();
        Cocktail cocktail = findByName(cocktailName);
        cocktailCollection.add(cocktail);
        user.setCocktailCollection(cocktailCollection);
        em.merge(user);
        return cocktailCollection;
    }

    public Cocktail add(String name, String description, String recipe) {
        CocktailRecipeAndDescription rd = new CocktailRecipeAndDescription(description, recipe);
        int id = getId();
        Cocktail newCocktail = new Cocktail();
        newCocktail.setId(id);
        newCocktail.setName(name);
        newCocktail.setCocktailRecipeAndDescription(rd);
        em.persist(newCocktail);
        return newCocktail;
    }

    private int getId() {
        List<Cocktail> findAll = this.findAll();
        int i = 0;
        for (Cocktail cocktail : findAll) {
            i = cocktail.getId();
        }
        i++;
        return i;
    }

    public Cocktail merge(String oldName, String name, String description, String recipe) {
        Cocktail cocktail = this.findByName(oldName);
        CocktailRecipeAndDescription rd = new CocktailRecipeAndDescription();
        if (name != null) {
            cocktail.setName(name);
        }
        if (description != null) {
            rd.setDescription(description);
        } else {
            rd.setDescription(cocktail.getCocktailRecipeAndDescription().getDescription());
        }
        if (recipe != null) {
            rd.setRecipe(recipe);
        } else {
            rd.setRecipe(cocktail.getCocktailRecipeAndDescription().getRecipe());
        }
        cocktail.setCocktailRecipeAndDescription(rd);
        cocktail.setName(name);
        em.merge(cocktail);
        return cocktail;
    }

    public List<Cocktail> orderByName(List<Cocktail> cocktails) {
        List<Cocktail> resultList = em.createQuery("SELECT c FROM Cocktail c ORDER BY c.name").getResultList();
        List<Cocktail> resultCopy = em.createQuery("SELECT c FROM Cocktail c ORDER BY c.name").getResultList();
        resultCopy.clear();
        for (Cocktail cocktail : resultList) {
            if (cocktails.contains(cocktail)) {
                resultCopy.add(cocktail);
            }
        }
        return resultCopy;
    }

    public List<Cocktail> getByIngredient(String ingredient, int start) {
        if (ingredient.equals("Any")) {
            return em.createQuery("SELECT c FROM Cocktail c")
                    .setFirstResult(start)
                    .setMaxResults(5)
                    .getResultList();
        }
        return em.createQuery("SELECT c FROM Cocktail c inner join c.ingredientCollection i WHERE i.name LIKE :ingredient")
                .setParameter("ingredient", ingredient)
                .setFirstResult(start)
                .setMaxResults(5)
                .getResultList();
    }

    public Cocktail findByName(String name) {
        return (Cocktail) em.createNamedQuery("Cocktail.findByName").setParameter("name", name).getSingleResult();
    }

    public int deleteCocktail(int id) {
        return em.createQuery("DELETE FROM Cocktail c WHERE c.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
