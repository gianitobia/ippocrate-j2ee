/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Controller.GestoreMedicoLocal;
import Entity.CartellaClinica;
import Entity.Medico;
import Entity.Paziente;
import Entity.RefertoMedico;
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
public class MedicoServlet extends HttpServlet {

    @EJB
    private GestoreMedicoLocal gestoreMedico;

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

            if (request.getParameter("action").equals("mieiPazienti")) {
                long medicoId = (long) s.getAttribute("user_id");
                s.setAttribute("pazienti", gestoreMedico.ottieniMieiPazienti(medicoId));
                response.sendRedirect("miei-pazienti.jsp");
            } else if (request.getParameter("action").startsWith("ottieniCC_")) {
                int paziente = Integer.parseInt(request.getParameter("action").substring(10));
                List<Paziente> lp = ((List<Paziente>) s.getAttribute("pazienti"));
                s.setAttribute("CCpaziente", gestoreMedico.ottieniCCPaziente(lp.get(paziente).getId().longValue()));
                response.sendRedirect("cc-paziente.jsp");
            } else if (request.getParameter("action").startsWith("modificaAnamnesi_")) {
                String nuovaAnamnesi = request.getParameter("action").substring(17);
                CartellaClinica cc = (CartellaClinica) s.getAttribute("CCpaziente");
                s.setAttribute("CCpaziente", gestoreMedico.modificaAnamnesi(cc.getId().longValue(), nuovaAnamnesi));
                out.write(nuovaAnamnesi);
            } else if (request.getParameter("action").startsWith("creaReferto_")) {
                String temp = request.getParameter("action").substring(12);
                String[] tempArray = temp.split("_");
                int indexOfPrest = Integer.parseInt(tempArray[0]);
                String dataVisita = tempArray[1];
                String diagnosi = tempArray[2];
                String file = tempArray[3];
                String medic = tempArray[4];
                int numConf = Integer.parseInt(tempArray[5]);
                String dataScad = tempArray[6];
                CartellaClinica cc = (CartellaClinica) s.getAttribute("CCpaziente");
                Medico m = (Medico) s.getAttribute("medico");
                List<RefertoMedico> lrm = gestoreMedico.aggiungiReferto(m, indexOfPrest, diagnosi, 
                        cc.getPaziente(), file, dataVisita, medic, numConf, dataScad);
                cc.setLista_referti(lrm);
                s.setAttribute("CCpaziente",cc);
                
                //stampa per l'aggiornamento della table dei referti
                String risp = "<tr><td>" + lrm.size() + "</td><td>" + m.getMiePrestazioni().get(indexOfPrest).getNome() + 
                        "</td><td>" + dataVisita + "</td><td>" + diagnosi + 
                        "</td><td><a href=\"rm-paziente.jsp?num=" + (lrm.size() - 1) + "\">visualizza</a></td></tr>";
                
                out.write(risp);
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