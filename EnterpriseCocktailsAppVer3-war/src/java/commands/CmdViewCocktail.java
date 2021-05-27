package commands;

import entities.*;
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
public class CmdViewCocktail extends FrontCommand {

    @Override
    public void process() {
        HttpSession session = request.getSession(true);
        String cocktail = (String) request.getParameter("cocktailName");/*
        Catalog catalog = (Catalog) session.getAttribute("catalog");
        CocktailSearchByNameRemote cocktailSearch = null;
        try {
            cocktailSearch = (CocktailSearchByNameRemote) InitialContext.doLookup("java:global/EnterpriseCocktailsApp/EnterpriseCocktailsApp-ejb/CocktailSearchByName!entities.CocktailSearchByNameRemote");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cocktail result = cocktailSearch.search(cocktail, catalog);
        session.setAttribute("cocktail", result);*/
        forward("/view_cocktail.jsp");
    }

}
