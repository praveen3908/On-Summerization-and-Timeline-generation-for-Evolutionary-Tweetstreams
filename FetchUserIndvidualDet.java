/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieee.servlet;

import com.ieee.dao.FetchDAO;
import com.ieee.pojo.UserDetails;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Praveen
 */
@WebServlet(name = "FetchUserIndvidualDet", urlPatterns = {"/FetchUserIndvidualDet"})
public class FetchUserIndvidualDet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(false);
            int followedById = (Integer) session.getAttribute("userId");
            
            String userId = request.getParameter("userId");
            int follwer_Id = Integer.parseInt(userId);

            
            FetchDAO fd = new FetchDAO();
            UserDetails ud = fd.fetchUserDet(userId);
            request.setAttribute("ud", ud);
            
            String flag=fd.checkFollower(follwer_Id, followedById);
            request.setAttribute("follwer", flag);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewIndividualUserDet.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
