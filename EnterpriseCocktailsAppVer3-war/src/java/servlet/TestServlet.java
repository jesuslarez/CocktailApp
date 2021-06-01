/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import control.CocktailFacade;
import control.ClientFacade;
import control.*;
import entities.Bar;
import entities.Client;
import entities.Cocktail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesus Larez
 */
public class TestServlet extends HttpServlet {

    @EJB
    CocktailFacade cocktailFacade;
    @EJB
    BarFacade barFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            ClientFacade client = null;
            try {
                client = (ClientFacade) InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/ClientFacade");
            } catch (NamingException ex) {
                Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<Bar> findAll1 = barFacade.findAll();
            for (Bar bar : findAll1) {
                System.out.println("<h3> " + bar.getName() + "</h3>");
                out.println("<h3> " + bar.getName() + "</h3>");
            }
            out.println("<br>");

            Client user = client.login(request.getParameter("nickname"), request.getParameter("password"));
            List<Bar> orderByName = barFacade.orderByName(user);
            for (Bar bar : orderByName) {
                System.out.println("<h3> " + bar.getName() + "</h3>");
                out.println("<h3> " + bar.getName() + "</h3>");
            }
            
            CocktailFacade cocktailFacade = null;
            try {
                cocktailFacade = InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/CocktailFacade");
            } catch (NamingException ex) {
                Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //int deleteCocktail = cocktailFacade.deleteCocktail(16);
            
            client.editClient(2, "javier", "AS");
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
