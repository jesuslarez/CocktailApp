/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import entities.*;
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
public class CmdSetTimer extends FrontCommand {

    @Override
    public void process() {
        HttpSession session = request.getSession();/*
        ProgrammableTimerRemote timer = (ProgrammableTimerRemote) session.getAttribute("timer");

        if (timer == null) {
            try {
                timer = (ProgrammableTimerRemote) InitialContext.doLookup("java:global/EnterpriseCocktailsApp/EnterpriseCocktailsApp-ejb/ProgrammableTimer!entities.ProgrammableTimerRemote");
                
                session.setAttribute("timer", timer);
            } catch (NamingException ex) {
                Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String message = (String) request.getParameter("TimerText");
        String TimerDuration = (String) request.getParameter("TimerDuration");
        if (TimerDuration == null) {
        } else {
            int duration = Integer.valueOf(TimerDuration);
            timer.setTimer(duration, message);
            System.out.println("Message = " + message + " duration = " + duration);
        }
        session.setAttribute("timerSet", "successfull");*/
        forward("/timer.jsp");

    }

}
