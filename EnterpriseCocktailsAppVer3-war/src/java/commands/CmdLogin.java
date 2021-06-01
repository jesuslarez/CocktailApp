package commands;

import control.ClientFacade;
import control.*;
import entities.*;
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
public class CmdLogin extends FrontCommand {

    @Override
    public void process() {
        HttpSession session = request.getSession(true);

        ClientFacade client = null;
        try {
            client = (ClientFacade) InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/ClientFacade");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Client user = client.login(request.getParameter("nickname"), request.getParameter("password"));
        if (user != null) {
            session.setAttribute("activeUser", user);
            List<Cocktail> favouriteCocktails = getFavouriteCocktails(user);
            if (favouriteCocktails != null) {
                session.setAttribute("favouriteCocktails", favouriteCocktails);
            }

            List<Bar> favouriteBars = getFavouriteBars(user);
            if (favouriteBars != null) {
                session.setAttribute("favouriteBars", favouriteBars);
            }

            List<Cocktail> catalog = findAllCocktails();
            List<Bar> bars = findAllBars();
            List<Ingredient> ingredients = findAllIngredients();
            session.setAttribute("catalog", catalog);
            session.setAttribute("bars", bars);
            session.setAttribute("ingredients", ingredients);
            session.setAttribute("start", 0);
            forward("/main.jsp");
        } else {
            forward("/unknown.jsp");
        }
    }

    private List<Cocktail> getFavouriteCocktails(Client user) {
        CocktailFacade cocktail = null;
        try {
            cocktail = InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/CocktailFacade");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cocktail.getFavouriteCocktails(user);
    }

    private List<Bar> getFavouriteBars(Client user) {
        BarFacade bar = null;
        try {
            bar = InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/BarFacade");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bar.getFavouriteBars(user);
    }

    private List<Cocktail> findAllCocktails() {
        CocktailFacade cocktail = null;
        try {
            cocktail = InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/CocktailFacade");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cocktail.findAll();
    }

    private List<Bar> findAllBars() {
        BarFacade bar = null;
        try {
            bar = InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/BarFacade");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bar.findAll();
    }

    private List<Ingredient> findAllIngredients() {
        IngredientFacade ingredients = null;
        try {
            ingredients = InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/IngredientFacade");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ingredients.findAll();
    }

}
