/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieee.servlet;

import com.ieee.dao.InsertDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "StoreReTweetsServlet", urlPatterns = {"/StoreReTweetsServlet"})
public class StoreReTweetsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String re_tweet_msg = request.getParameter("tweet_msg");
            HttpSession session = request.getSession(false);
            int userId = (Integer) session.getAttribute("userId");
            int tweetId = Integer.parseInt((String) session.getAttribute("tweetId"));
            InsertDAO dao = new InsertDAO();
            int flag = dao.insertReTweets( tweetId, re_tweet_msg, userId);
            if (flag == 1) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("tweetSuccessPost.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
