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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Marco
 */
@WebServlet(name = "MedicoServlet")
@MultipartConfig
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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession s = request.getSession();

            if (request.getParameter("action").equals("mieiPazienti")) {
                Long medicoId = (Long) s.getAttribute("user_id");
                s.setAttribute("pazienti", gestoreMedico.ottieniMieiPazienti(medicoId));
                response.sendRedirect("miei-pazienti.jsp");
            } else if (request.getParameter("action").startsWith("ottieniCC_")) {
                int paziente = Integer.parseInt(request.getParameter("action").substring(10));
                List<Paziente> lp = ((List<Paziente>) s.getAttribute("pazienti"));
                s.setAttribute("CCpaziente", gestoreMedico.ottieniCCPaziente(lp.get(paziente).getId()));
                response.sendRedirect("cc-paziente.jsp");
            } else if (request.getParameter("action").equals("modificaAnamnesi")) {
                String nuovaAnamnesi = request.getParameter("anamnesi");
                CartellaClinica cc = (CartellaClinica) s.getAttribute("CCpaziente");
                s.setAttribute("CCpaziente", gestoreMedico.modificaAnamnesi(cc.getId(), nuovaAnamnesi));
                response.sendRedirect("cc-paziente.jsp");
            } else if (request.getParameter("action").equals("creaReferto")) {
                String[] v = request.getParameterValues("prest");
                int indexOfPrest = Integer.parseInt(v[0]);
                String dataVisita = request.getParameter("data");
                String diagnosi = request.getParameter("diagn");
                Part filePart = request.getPart("multim");
                String fileName = getFileName(filePart);
                String medic = request.getParameter("medic");
                int numConf = Integer.parseInt(request.getParameter("numConf"));
                String dataScad = request.getParameter("dataScad");
                CartellaClinica cc = (CartellaClinica) s.getAttribute("CCpaziente");
                Medico m = (Medico) s.getAttribute("medico");
                List<RefertoMedico> lrm = gestoreMedico.aggiungiReferto(m, indexOfPrest, diagnosi,
                        cc.getPaziente(), filePart, fileName, dataVisita, medic, numConf, dataScad);
                cc.setLista_referti(lrm);
                s.setAttribute("CCpaziente", cc);
                response.sendRedirect("cc-paziente.jsp");
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

    private String getFileName(Part filePart) {
        String partHeader = filePart.getHeader("content-disposition");
        for (String content : filePart.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
