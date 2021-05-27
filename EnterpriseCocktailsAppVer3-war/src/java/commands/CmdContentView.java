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
public class CmdContentView extends FrontCommand {

    @Override
    public void process() {
        HttpSession session = request.getSession();/*
        ContentSingletonRemote content = null;
        try {
            content = (ContentSingletonRemote) InitialContext.doLookup("java:global/EnterpriseCocktailsApp/EnterpriseCocktailsApp-ejb/ContentSingleton!entities.ContentSingletonRemote");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<FavouriteBarsRemote> bars = content.getFavBars();
        ArrayList<FavouriteCocktailsRemote> cocktails = content.getFavCocktails();

        session.setAttribute("FavBars", bars);
        session.setAttribute("FavCocktails", cocktails);*/
        forward("/content_singlenton_view.jsp");
    }

}
