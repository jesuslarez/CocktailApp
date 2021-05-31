package commands;

import control.CocktailFacade;
import entities.*;
import entities.Cocktail;
import java.util.List;
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
        CocktailFacade cocktail = null;
        try {
            cocktail = InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/CocktailFacade");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }        
        String cocktailName = (String) request.getParameter("cocktailName");
        List<Cocktail> favouritecocktails = cocktail.addFavourite(cocktailName, (Client) session.getAttribute("activeUser"));
        session.setAttribute("favouriteCocktails", favouritecocktails);
        forward("/favourite_list.jsp");
    }

}
