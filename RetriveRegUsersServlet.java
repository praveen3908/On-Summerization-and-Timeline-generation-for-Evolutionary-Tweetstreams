/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieee.servlet;

import com.ieee.dao.FetchDAO;
import com.ieee.pojo.UserDetails;
import java.io.IOException;
import java.util.Set;
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
@WebServlet(name = "RetriveRegUsersServlet", urlPatterns = {"/RetriveRegUsersServlet"})
public class RetriveRegUsersServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(false);
            int userId = (Integer) session.getAttribute("userId");
            FetchDAO dao = new FetchDAO();
            Set<UserDetails> set = dao.fetchUsers(userId);
            request.setAttribute("users_list", set);

            RequestDispatcher dispatcher = request.getRequestDispatcher("ViewUsers.jsp");
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
