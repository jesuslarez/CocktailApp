package commands;

import control.CocktailFacade;
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
public class CmdOrderByName extends FrontCommand{

    @Override
    public void process() {
        HttpSession session = request.getSession(true);
        List<Cocktail> cocktails = (List) session.getAttribute("cocktailResults");
        CocktailFacade cocktailFacade = null;
        try {
            cocktailFacade = InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/CocktailFacade");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Cocktail> orderByName = cocktailFacade.orderByName(cocktails);
        session.setAttribute("cocktailResults", orderByName);
        forward("/search_cocktail.jsp");
    }
    
}
