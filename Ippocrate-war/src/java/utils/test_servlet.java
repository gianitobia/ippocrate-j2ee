/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Entity.Ospedale;
import Entity.PrenotazioneSala;
import Entity.PrenotazioneSalaFacadeLocal;
import Entity.Sala;
import Entity.StrutturaMedica;
import Entity.StrutturaMedicaFacadeLocal;
import HttpClient.HttpCalendarClient;
import Utility.Gestore_Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
public class test_servlet extends HttpServlet {
    
    @EJB
    private PrenotazioneSalaFacadeLocal pSala;
    @EJB
    private StrutturaMedicaFacadeLocal sM;
    
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
            out.println("<title>Servlet test_servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet test_servlet at " + request.getContextPath() + "</h1>");

            out.println(Gestore_Date.generateStringFromDate(Gestore_Date.generateDateFromString("12/10/1988", '/'), '/'));
            Date[] ds = Gestore_Date.generateDateInterval(365);
            out.println(Gestore_Date.generateStringFromDate(ds[0], '-'));
            out.println(Gestore_Date.generateStringFromDate(ds[1], '-'));
            
            List<StrutturaMedica> str = sM.findAll();
            HttpCalendarClient agenda = new HttpCalendarClient();            
            //out.println(agenda.createAllCalendars(str));
            
            PrenotazioneSala nuovo = new PrenotazioneSala();
            nuovo.setId(new Long(567));
            
            Sala m = new Sala();
            m.setId(new Long(1234));
            m.setTipoLaboratorio("radiologia");
            
            StrutturaMedica sm = new Ospedale();
            sm.setNome("Maria Vittoria");
            
            nuovo.setSala(m);
            
            nuovo.setStruttura_medica(sm);
            nuovo.setData_prenotazione(Gestore_Date.generateReservationFromString("2014-04-02T10:00:00.000+02:00"));
            
            
            
            out.println(agenda.create_event(nuovo));
            
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
