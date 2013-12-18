/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Controller.GestoreUtenteLocal;
import Entity.Medico;
import Entity.PazienteTransient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author toby
 */
@WebServlet(name = "Utente", urlPatterns = {"/Utente"})
public class UtenteServlet extends HttpServlet {

    @EJB
    private GestoreUtenteLocal gestoreUtente;

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
            HttpSession s = request.getSession();
            String type = (String) s.getAttribute("type");
            long user = (long) s.getAttribute("user_id");
            if (type != null && user != -1) {
                if (request.getParameter("action").equals("pagina_personale")) {
                    if (type.equals("paziente")) {
                        PazienteTransient p = gestoreUtente.ottieniPaziente(user);
                        s.setAttribute("paziente", p);
                        response.sendRedirect("home_paziente.jsp");
                    } else if (type.equals("medico")) {
                        Medico m = gestoreUtente.ottieniMedico(user);
                        response.sendRedirect("home_medico.jsp");
                    } else {
                        s.setAttribute("error", "Tipo di utente non riconosciuto");
                        response.sendRedirect("errore.jsp");
                    }

                }
            } else {
                s.setAttribute("error", "Accesso negato per la risorsa richiesta");
                response.sendRedirect("errore.jsp");
            }

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
