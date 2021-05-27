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
public class CmdAddFavouriteBar extends FrontCommand {

    @Override
    public void process() {
        HttpSession session = request.getSession(true);
        /*
        FavouriteBarsRemote favouriteBars = null;
        try {
            favouriteBars = (FavouriteBarsRemote) InitialContext.doLookup("java:global/EnterpriseCocktailsApp/EnterpriseCocktailsApp-ejb/FavouriteBars!entities.FavouriteBarsRemote");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String barName = (String) request.getParameter("barName");
        ArrayList<Bar> barList = (ArrayList) session.getAttribute("barList");
        for (Bar bar : barList) {
            if (bar.getName().equals(barName)) {
                favouriteBars.addBar(bar);
            }
        }
        session.setAttribute("favouriteBarList", favouriteBars.getFavouriteList());
*/
        forward("/favourite_bar_list.jsp");
    }

}
