package commands;

import control.ClientFacade;
import control.*;
import entities.Client;
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
public class CmdLogin extends FrontCommand{

    
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
        if (user != null){
            session.setAttribute("activeUser", user);
            List<Cocktail> favouriteCocktails = getFavouriteCocktails(user);
            if (favouriteCocktails != null) {
                session.setAttribute("favouriteCocktails", favouriteCocktails);
            }
            getFavouriteBars();
            forward("/main.jsp");
        }else{
            forward("/unknown.jsp");
        }
    }

    private List<Cocktail> getFavouriteCocktails(Client user) {
        CocktailFacade cocktail = null;
        try {
            cocktail =  InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/CocktailFacade");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Cocktail> favouriteCocktails = cocktail.getFavouriteCocktails(user);
        for (Cocktail favouriteCocktail : favouriteCocktails) {
            System.out.println("Los ninios: " + favouriteCocktail.getName());
        }
       return favouriteCocktails;
    }

    private void getFavouriteBars() {
       
        
    }
    
}
