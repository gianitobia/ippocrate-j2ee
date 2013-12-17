/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import Controller.GestoreLoginLocal;
import Entity.Paziente;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    @EJB
    private GestoreLoginLocal gestoreLogin;

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
            if(request.getParameter("action").equals("loginM")) {
                String user = request.getParameter("username-medico");
                String password = request.getParameter("password-medico");
                String pincode = request.getParameter("pincode-medico");
                if(gestoreLogin.verificaLoginMedico(user, password, pincode))
                    response.sendRedirect("home-medico.jsp");
                else
                    response.sendRedirect("errore.jsp");
            } 
            else if (request.getParameter("action").equals("loginP")) {
                String cf = request.getParameter("codfisc-paziente");
                String password = request.getParameter("password-paziente");
                Paziente p = gestoreLogin.verificaLoginPaziente(cf, password);
                if(p != null) {
                    request.getSession().setAttribute("paziente", p);
                    response.sendRedirect("home-paziente.jsp");           
                }
                else
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
