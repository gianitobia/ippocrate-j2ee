/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Controller.GestorePrenotazioneLocal;
import Entity.Prestazione;
import Entity.StrutturaMedica;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marco
 */
public class PrenotazioneServlet extends HttpServlet {

    @EJB
    private GestorePrenotazioneLocal gestorePrenotazione;

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

            if (request.getParameter("action").equals("ottieniPr")) {
                long pazienteId = (long) s.getAttribute("user_id");
                s.setAttribute("prenotazioni", gestorePrenotazione.ottieniPrenotazioni(pazienteId));
                response.sendRedirect("mie-prenotazioni.jsp");
            } else if (request.getParameter("action").equals("nuovaPr")) {
                s.setAttribute("prestazioni", gestorePrenotazione.ottieniPrestazioniPrenotabili());
                response.sendRedirect("prenotazione.jsp");
            } else if (request.getParameter("action").startsWith("cercaStrutture_")) {
                int indexOfPrest = Integer.parseInt(request.getParameter("action").substring(15));
                Prestazione p = ((List<Prestazione>) s.getAttribute("prestazioni")).get(indexOfPrest);
                List<StrutturaMedica> lsm = gestorePrenotazione.ottieniStruttureMedichePerPrestazione(p);
                s.setAttribute("strutture", lsm);

                String fToCall;
                if (p.getClass().getName().equals("Entity.PrestazioneSala")) {
                    fToCall = "cercaAgendaSala";
                } else { //caso PrestazioneMedico
                    fToCall = "cercaMedico";
                }
                //stampa per l'aggiornamento della select struct
                String str = "";
                for (int i = 0; i < lsm.size(); i++) {
                    str = str + "<option onclick=\"" + fToCall + "(" + i + ")\">" + lsm.get(i).getNome() + "</option>";
                }
//                out.write("<%@page import=\"Entity.StrutturaMedica\"%><jsp:useBean id=\"strutture\" type=\"List<StrutturaMedica>\" scope=\"session\" />"
//                        + str);
                out.write(str);
            } else if (request.getParameter("action").startsWith("cercaAgendaSala_")) {

            } else if (request.getParameter("action").startsWith("cercaAgendaMedico_")) {
                
            } else if (request.getParameter("action").startsWith("cercaMedico_")) {
                //al click del medico devo invocare cercaAgendaMedico(indice medico)
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
