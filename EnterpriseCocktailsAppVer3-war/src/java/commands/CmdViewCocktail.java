package commands;

import control.CocktailFacade;
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
        String cocktailName = (String) request.getParameter("cocktailName");
        CocktailFacade cocktail = null;
        try {
            cocktail = InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/CocktailFacade");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cocktail findByName = cocktail.findByName(cocktailName);
        session.setAttribute("cocktail", findByName);
        
        forward("/view_cocktail.jsp");
    }

}
