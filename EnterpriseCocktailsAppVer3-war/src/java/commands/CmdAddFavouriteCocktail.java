package commands;

import entities.*;
import entities.Cocktail;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import servlet.FrontController;

/**
 *
 * @author Jesus Larez
 */
public class CmdAddFavouriteCocktail extends FrontCommand {

    @Override
    public void process() {
        HttpSession session = request.getSession(true);
        /*
        Catalog catalog = (Catalog) session.getAttribute("catalog");
        FavouriteCocktailsRemote favouriteCocktails = null;
        try {
            favouriteCocktails = (FavouriteCocktailsRemote) InitialContext.doLookup("java:global/EnterpriseCocktailsApp/EnterpriseCocktailsApp-ejb/FavouriteCocktails!entities.FavouriteCocktailsRemote");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String cocktail = (String) request.getParameter("cocktailName");
        CocktailSearchByNameRemote cocktailSearch = null;
        try {
            cocktailSearch = (CocktailSearchByNameRemote) InitialContext.doLookup("java:global/EnterpriseCocktailsApp/EnterpriseCocktailsApp-ejb/CocktailSearchByName!entities.CocktailSearchByNameRemote");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cocktail result = cocktailSearch.search(cocktail, catalog);
        favouriteCocktails.addCocktail(result);
        session.setAttribute("favouriteCocktailsList", favouriteCocktails.getFavouriteList());
*/
        forward("/favourite_list.jsp");
    }

}
