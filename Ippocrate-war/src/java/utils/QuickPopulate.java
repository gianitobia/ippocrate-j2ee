/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Controller.GestoreInserimentoDatiLocal;
import Entity.CartellaClinicaFacadeLocal;
import Entity.MedicoEsternoFacadeLocal;
import Entity.MedicoOspedalieroFacadeLocal;
import Entity.Ospedale;
import Entity.OspedaleFacadeLocal;
import Entity.PazienteFacadeLocal;
import Entity.RepartoFacadeLocal;
import Entity.SalaFacadeLocal;
import Entity.StudioMedicoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toby
 */
@WebServlet(name = "QuickPopulate", urlPatterns = {"/QuickPopulate"})
public class QuickPopulate extends HttpServlet {
    
    @EJB
    private GestoreInserimentoDatiLocal insert;

    @EJB
    private MedicoOspedalieroFacadeLocal medicoOspedalieroFacade;
    
    @EJB
    private MedicoEsternoFacadeLocal medicoEsternoFacade1;
    
    @EJB
    private OspedaleFacadeLocal ospedaleFacade;
    
    @EJB
    private PazienteFacadeLocal pazienteFacade;
    
    @EJB
    private RepartoFacadeLocal repartoFacade;
    
    @EJB
    private MedicoEsternoFacadeLocal medicoEsternoFacade;
    
    @EJB
    private CartellaClinicaFacadeLocal cartellaClinicaFacade;
    
    @EJB
    private StudioMedicoFacadeLocal studioMedicoFacade;
    
    @EJB
    private SalaFacadeLocal salaFacade;

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

        Ospedale[] ospedali = new Ospedale[4];

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*  String nome, String cognome, String cf, String password,
                String sesso, String indirizzo, Date data_nascita, String luogo_nascita */
            insert.addPaziente("Arrigo", "Toscano", "10000", "10000", "M", "via cocci, 7", new Date(1963,12,10), "Torino");
            insert.addPaziente("Raffaele", "Udinese", "11000", "11000", "M", "Via Acrone, 109", new Date(1980,8,6), "Sarezzano");
            insert.addPaziente("Francesco", "Arcuri", "11100", "11100", "M", "Corso Alcide De Gasperi, 32", new Date(1990,10,27), "Candide");
            insert.addPaziente("Macario", "Napolitano", "11110", "11110", "M", "Via Galvani, 74", new Date(1992,5,23), "Roma");
            insert.addPaziente("Teodata", "Lombardo", "11111", "11111", "F", "Via Nazionale, 131", new Date(1982,7,21), "Trafoi");
            insert.addPaziente("Maia", "Gallo", "10111", "10111", "F", "Via Venezia, 43", new Date(1992,3,21), "Trento");
            insert.addPaziente("Aldo", "Siciliano", "10011", "10011", "M", "Piazza Bovio, 71", new Date(1988,10,1), "Bologna");
            insert.addPaziente("Damiana", "Lorenzo", "20000", "20000", "F", "Vico Giganti, 68", new Date(1997,1,5), "Milano");
            insert.addPaziente("Simonetta", "Fiorentino", "20002", "20002", "F", "Via Agostino Depretis, 98", new Date(1987,10,5), "Prato");
            insert.addPaziente("Rosita", "Buccho", "20022", "20022", "F", "Piazza Trieste e Trento, 70", new Date(1988,10,16), "Prunetto");
            insert.addPaziente("Gaetana", "Panicucci", "20222", "20222", "F", "Viale Augusto, 10", new Date(1978,11,16), "Messina");
            insert.addPaziente("Siro", "Greco", "22222", "22222", "M", "Corso Vittorio Emanuele, 95", new Date(1986,12,11), "Roma");
            insert.addPaziente("Adelfina", "Pirozzi", "22000", "22000", "F", "Via Francesco Del Giudice, 109", new Date(1979,1,18), "Napoli");
            insert.addPaziente("Eligio", "Beneventi", "22200", "22200", "M", "Via Valpantena, 17", new Date(1985,2,29), "Genova");
            insert.addPaziente("Mara", "Rossi", "22220", "22220", "F", "Via Sergente Maggiore, 124", new Date(1989,5,5), "Cuneo");
            
            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet QuickPopulate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuickPopulate at " + request.getContextPath() + "</h1>");
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
