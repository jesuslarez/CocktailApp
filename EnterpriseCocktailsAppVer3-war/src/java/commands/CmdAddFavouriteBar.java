package commands;

import control.BarFacade;
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
public class CmdAddFavouriteBar extends FrontCommand {

    @Override
    public void process() {
        HttpSession session = request.getSession(true);
        BarFacade bar = null;
        try {
            bar = InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/BarFacade");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }        
        String barName = (String) request.getParameter("barName");
        List<Bar> favouriteBars = bar.addFavourite(barName, (Client) session.getAttribute("activeUser"));
        session.setAttribute("favouriteBars", favouriteBars);
        forward("/favourite_bar_list.jsp");
    }

}
