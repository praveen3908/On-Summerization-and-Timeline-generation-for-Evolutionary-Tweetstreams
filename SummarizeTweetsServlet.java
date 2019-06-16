/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieee.servlet;

import com.ieee.dao.FetchDAO;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Praveen
 */
@WebServlet(name = "SummarizeTweetsServlet", urlPatterns = {"/SummarizeTweetsServlet"})
public class SummarizeTweetsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String clusterData = request.getParameter("clusterData");
            String fdt = request.getParameter("fdt");
            String tdt = request.getParameter("tdt");

            //cluster mathced data
            FetchDAO fd = new FetchDAO();
            Map<String, List<String>> map_list = fd.fetchTweetsForCluster(clusterData, fdt, tdt);
            List<String> list_tweet = map_list.get("list_tweet");
            List<String> list_retweet = map_list.get("list_retweet");

            String cluster_data_tweet = "";
            for (String string : list_tweet) {
                cluster_data_tweet = cluster_data_tweet+ "" + string.trim()+ "|";
            }

            String cluster_data_retweet = "";
            for (String string : list_retweet) {
                cluster_data_retweet = cluster_data_retweet+ "" + string.trim()+ "|";
            }

            request.setAttribute("cluster_data_tweet", cluster_data_tweet);
            request.setAttribute("cluster_data_retweet", cluster_data_retweet);
            request.setAttribute("clusterData", clusterData);

            RequestDispatcher dispatcher = request.getRequestDispatcher("viewClusteredData.jsp");
            dispatcher.forward(request, response);
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
