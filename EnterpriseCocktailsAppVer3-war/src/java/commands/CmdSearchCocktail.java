package commands;

import entities.*;
import java.util.ArrayList;
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

    private ArrayList<String> ingredients = new ArrayList<>();

    @Override
    public void process() {
        HttpSession session = request.getSession(true);/*
        Catalog catalog = (Catalog) session.getAttribute("catalog");
        addIngredients(3);
        CocktailSearchByIngredientsRemote cocktailSearch = null;
        try {
            cocktailSearch = (CocktailSearchByIngredientsRemote) InitialContext.doLookup("java:global/EnterpriseCocktailsApp/EnterpriseCocktailsApp-ejb/CocktailSearchByIngredients!entities.CocktailSearchByIngredientsRemote");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<Cocktail> result = cocktailSearch.search(ingredients,catalog);
        if (result.isEmpty()) {
            try {
                FrontCommand command = (FrontCommand) UnknownCommand.class.newInstance();
                command.init(context, request, response);
                String message = "No cocktails found";
                session.setAttribute("errorMessage", message);
                command.init(context, request, response);
                command.process();
            } catch (InstantiationException ex) {
                Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        session.setAttribute("cocktailResults", result);
*/
        forward("/search_cocktail.jsp");
    }

    private void addIngredients(int size) {
        String n = "ingredient";
        for (int i = 1; i <= size; i++) {
            n += i;
            if (!request.getParameter(n).equals("Any")) {
                ingredients.add(request.getParameter(n));
            }
            n = "ingredient";
        }
    }
}
