/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Controller.GestoreListeDatiLocal;
import Entity.Ospedale;
import Entity.Paziente;
import Entity.StudioMedico;
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
 * @author toby
 */
public class QuickList extends HttpServlet {

    @EJB
    private GestoreListeDatiLocal gestoreListeDati;

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
            switch (request.getParameter("action")) {
                case "Pazienti":
                    List<Paziente> pazienti = gestoreListeDati.ottieniListaPazienti();
//                    for (Paziente o : pazienti) {
//                        out.print(" > ");
//                        out.print(o.getNome());
//                        out.println(o.toString());
//                    }
                    s.setAttribute("pazienti", pazienti);
                    response.sendRedirect("quicklist-pazienti.jsp");

                    break;
                case "Ospedali":
                    List<Ospedale> ospedali = gestoreListeDati.ottieniListaOspedali();
//                    for (Ospedale o : ospedali) {
//                        out.print(" > ");
//                        out.print(o.getNome());
//                        out.println(o.toString());
//                    }
                    s.setAttribute("ospedali", ospedali);
                    response.sendRedirect("quicklist-strutturemediche.jsp");

                    break;
                case "StudiMedici":
                    List<StudioMedico> studi = gestoreListeDati.ottieniListaStudiMedici();
//                    for (StudioMedico o : studi) {
//                        out.print(" > ");
//                        out.print(o.getNome());
//                        out.println(o.toString());
//                    }
                    s.setAttribute("studimedici", studi);
                    response.sendRedirect("quicklist-strutturemediche.jsp");

                    break;
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
