/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import entities.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import servlet.FrontController;

/**
 *
 * @author Jesus Larez
 */
public class CmdViewLog extends FrontCommand {

    @Override
    public void process() {
        HttpSession session = request.getSession();/*
        SingletonLogRemote singletonLog = null;
        try {
            singletonLog = (SingletonLogRemote) InitialContext.doLookup("java:global/EnterpriseCocktailsApp/EnterpriseCocktailsApp-ejb/SingletonLog!entities.SingletonLogRemote");
        } catch (NamingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<String> log = singletonLog.getLog();
        session.setAttribute("log", log);*/
        forward("/log_view.jsp");
    }
}
