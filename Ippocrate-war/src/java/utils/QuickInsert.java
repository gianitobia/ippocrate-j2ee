/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package utils;

import Controller.GestoreInserimentoDatiLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marco
 */
public class QuickInsert extends HttpServlet {

    @EJB
    private GestoreInserimentoDatiLocal gestoreIns;

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

            switch (request.getParameter("action")) {
                case "crea_medico": {
                    String nome = request.getParameter("nome");
                    String cognome = request.getParameter("cognome");
                    String password = request.getParameter("password");
                    String pin_code = request.getParameter("pin_code");
                    String specializzazione = request.getParameter("specializzazione");
                    String username = request.getParameter("username");
                    String num_ufficio = request.getParameter("num_ufficio");
                    Date data_nascita = new Date(request.getParameter("data_nascita"));
                    String tipo = request.getParameter("tipo_medico");
                    switch (tipo) {
                        case "Medico ospedaliero":
                            gestoreIns.addMedicoOspedaliero(nome, cognome, specializzazione, data_nascita, username, password, pin_code, num_ufficio);
                            break;
                        case "Medico esterno":
                            gestoreIns.addMedicoEsterno(nome, cognome, specializzazione, data_nascita, username, password, pin_code);
                            break;
                    }
                    out.println("Inserimento avvenuto!");
                    break;
                }
                case "crea_paziente": {
                    String nome = request.getParameter("nome");
                    String cognome = request.getParameter("cognome");
                    String password = request.getParameter("password");
                    String cf = request.getParameter("cf");
                    String sesso = request.getParameter("sesso");
                    String indirizzo = request.getParameter("indirizzo");
                    String luogo_nascita = request.getParameter("luogo_nascita");
                    Date data_nascita = new Date(request.getParameter("data_nascita"));
                    gestoreIns.addPaziente(nome, cognome, password, cf, sesso,
                            indirizzo, data_nascita, luogo_nascita);
                    out.println("Inserimento avvenuto!");
                    break;
                }
                case "crea_prestazione": {
                    String nome = request.getParameter("nome");
                    String durata = request.getParameter("durata");
                    gestoreIns.addPrestazione(durata, nome);
                    out.println("Inserimento avvenuto!");
                    break;
                }
                case "crea_struttura": {
                    String tipo = request.getParameter("tipo_strutturaMedica");
                    String nome = request.getParameter("nome");
                    String indirizzo = request.getParameter("indirizzo");
                    switch (tipo) {
                        case "Ospedale":
                            gestoreIns.addOspedale(nome, indirizzo);
                            break;
                        case "Studio medico":
                            gestoreIns.addStudioMedico(nome, indirizzo);
                            break;
                    }
                    out.println("Inserimento avvenuto!");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("### errore creazione!, " + e);
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
