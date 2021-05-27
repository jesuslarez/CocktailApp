/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import entities.*;
import java.util.ArrayList;
import java.util.HashMap;
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
public class CmdViewStats extends FrontCommand {

    @Override
    public void process() {
        HttpSession session = request.getSession();/*
        StatsSingletonRemote statsSingleton = (StatsSingletonRemote) session.getAttribute("statsSingleton");

        if (statsSingleton == null) {
            try {
                statsSingleton = (StatsSingletonRemote) InitialContext.doLookup("java:global/EnterpriseCocktailsApp/EnterpriseCocktailsApp-ejb/StatsSingleton!entities.StatsSingletonRemote");
                session.setAttribute("singletonLog", statsSingleton);
            } catch (NamingException ex) {
                Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        HashMap<String, Integer> stats;
        stats = statsSingleton.getStats();
        session.setAttribute("stats", stats);*/
        forward("/stats_page.jsp");
    }
}
