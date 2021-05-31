package commands;

import control.BarFacade;
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
public class CmdViewBar extends FrontCommand {

    @Override
    public void process() {
        HttpSession session = request.getSession(true);
        String barName = (String) request.getParameter("barName");
        BarFacade bar = null;
        try {
            bar = InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/BarFacade");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }        
        Bar findByName = bar.findByName(barName);
        session.setAttribute("bar", findByName);
        forward("/view_bar.jsp");
    }
}
