package commands;

import control.CocktailFacade;
import entities.*;
import java.util.ArrayList;
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
public class CmdSearchCocktail extends FrontCommand {

    @Override
    public void process() {
        HttpSession session = request.getSession(true);
        CocktailFacade cocktailFacade = null;
        try {
            cocktailFacade = InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/CocktailFacade");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Cocktail> byIngredient = cocktailFacade.getByIngredient(request.getParameter("ingredient1"));
        List<Cocktail> byIngredient2 = cocktailFacade.getByIngredient(request.getParameter("ingredient2"));

        //Hacer un select the where ingredient1 and ingredient2
        
        if (byIngredient != null) {
            if (byIngredient2 != null) {
                for (Cocktail cocktai11 : byIngredient2) {
                    for (Cocktail cocktai12 : byIngredient) {
                        if (cocktai11.getId() == cocktai12.getId()) {
                            
                        }
                    }
                }
                session.setAttribute("cocktailResults", byIngredient);
                forward("/search_cocktail.jsp");
            } else {
                session.setAttribute("cocktailResults", byIngredient);
                forward("/search_cocktail.jsp");
            }
        } else if (byIngredient2 != null) {
            session.setAttribute("cocktailResults", byIngredient2);
            forward("/search_cocktail.jsp");
        }
    }
}
