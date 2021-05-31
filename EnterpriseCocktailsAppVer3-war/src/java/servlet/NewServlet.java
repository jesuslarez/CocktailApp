/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import control.CocktailFacade;
import control.ClientFacade;
import control.*;
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
public class NewServlet extends HttpServlet {

    @EJB
    CocktailFacade cocktailFacade;

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
            System.out.println("<h2> " + cocktailFacade.findAll() + " </h2>");
            out.println("<h2> " + cocktailFacade.findAll() + " </h2>");

            ClientFacade client = null;
            try {
                // java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/ClientFacade
                // java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/ClientFacade!control.ClientFacade
                client = (ClientFacade) InitialContext.doLookup("java:global/EnterpriseCocktailsAppVer3/EnterpriseCocktailsAppVer3-ejb/ClientFacade");
            } catch (NamingException ex) {
                Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*
            List<Client> findAll = client.findAll();
            for (Client client1 : findAll) {

                System.out.println("<h2> " + client1.getNickname() + " </h2>");
                out.println("<h2> " + client1.getNickname() + " </h2>");
            }
             */
            List<Cocktail> findAll1 = cocktailFacade.findAll();
            for (Cocktail cocktail : findAll1) {
                System.out.println("<h3> " + cocktail.getName() + "</h3>");
                out.println("<h3> " + cocktail.getName() + "</h3>");
            }
            out.println("<br>");
            /*
            // add cocktail funciona,
            Cocktail added = cocktailFacade.add("newCocktail", "Description", "Recipe");
            System.out.println("Added: " + added.getName() + ", id:" + added.getId());
            out.println("Added: " + added.getName() + ", id:" + added.getId());
            findAll1 = cocktailFacade.findAll();
            for (Cocktail cocktail : findAll1) {
            if (cocktail.getId() == 99) {
            System.out.println("<h3> FOUND IT: " + cocktail.getName() + " " + cocktail.getId() + "</h3>");
            out.println("<h3> FOUND IT: " + cocktail.getName() + " " + cocktail.getId() + "</h3>");
            } else {
            System.out.println("<h3> " + cocktail.getName() + "</h3>");
            out.println("<h3> " + cocktail.getName() + "</h3>");
            }
            }
             */
            /*
            // remove cocktail funciona,
            cocktailFacade.remove(6);
            System.out.println("removed: id: 6");
            out.println("removed: id: 6");
            findAll1 = cocktailFacade.findAll();
            for (Cocktail cocktail : findAll1) {
            if (cocktail.getId() == 6) {
            System.out.println("<h3> FOUND IT: " + cocktail.getName() + "</h3>");
            out.println("<h3> FOUND IT: " + cocktail.getName() + "</h3>");
            } else {
            System.out.println("<h3> " + cocktail.getName() + "</h3>");
            out.println("<h3> " + cocktail.getName() + "</h3>");
            }
            }
             */
            /*
            //merge
            cocktailFacade.merge(6, "ModifiedCocktail", "This has been changed", "This is the new Recipe");
            findAll1 = cocktailFacade.findAll();
            for (Cocktail cocktail : findAll1) {
            System.out.println("<h3> " + cocktail.getName() + "</h3>");
            out.println("<h3> " + cocktail.getName() + "</h3>");
            }
             */
            /*
            //Find by name
            List findByName = cocktailFacade.findByName("Mojito");
            out.println("<h2> Cocktails Found: </h2>");
            for (Object object : findByName) {
            Cocktail cocktail = (Cocktail) object;
            out.println("<h2>" + cocktail.getName() +"</h2>");
            }
             */
            /*
            List<Cocktail> orderByName = cocktailFacade.orderByName();
            out.println("<h2> Cocktails Found ordered by NAME: </h2>");
            for (Cocktail cocktail : orderByName) {
            System.out.println("<h3> " + cocktail.getName() + "</h3>");
            out.println("<h3> " + cocktail.getName() + "</h3>");
            }
             */
            List<Cocktail> byIngredient = cocktailFacade.getByIngredient("lime");
            out.println("<h3> BY INGREDIENT LIME</h3>");
            for (Cocktail cocktail : byIngredient) {
                System.out.println("<h3> " + cocktail.getName() + "</h3>");
                out.println("<h3> " + cocktail.getName() + "</h3>");
            }
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
