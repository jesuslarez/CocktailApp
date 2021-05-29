/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import control.ClientFacade;
import entities.Client;
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
       // DAOMenu daoMenu = new DAOMenu();
      //  List<Menu> byUser = daoMenu.findByUser(u.getId());
        
        if (user != null){
            session.setAttribute("user", user);
            forward("/main.jsp");
        }else{
            forward("/unknown.jsp");
        }
    }
    
}
