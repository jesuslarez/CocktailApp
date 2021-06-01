package commands;

import control.BarFacade;
import control.CocktailFacade;
import entities.Bar;
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
public class CmdAddCocktail extends FrontCommand {

    @Override
    public void process() {
        HttpSession session = request.getSession(true);
        CocktailFacade cocktailFacade = null;
        try {
            cocktailFacade = InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/CocktailFacade");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cocktail added = cocktailFacade.add(request.getParameter("name"),
                request.getParameter("description"),
                request.getParameter("recipe"));
        Cocktail findByName = cocktailFacade.findByName(request.getParameter("name"));
        session.setAttribute("cocktail", findByName);
        forward("/view_cocktail.jsp");
    }

}
