/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieee.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
@WebServlet(name = "SummarizeCoreLevelServlet", urlPatterns = {"/SummarizeCoreLevelServlet"})
public class SummarizeCoreLevelServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String t_msg1 = request.getParameter("tweet_msg");
            String t_msg2 = request.getParameter("tweet_msg1");
            String key = request.getParameter("key");

            String t_msg = t_msg1 + "" + t_msg2;
            String data[] = t_msg.split("\\|");
            Set<String> set = new HashSet<String>();
            //removing the duplicate data
            //set will remove duplicates
            for (String str : data) {
                set.add(str);
            }


            //removing the sentences which doesn't found key
            Set<String> contain_kay_set = new HashSet();
            for (String string : set) {
                if (string.contains(key)) {
                    contain_kay_set.add(string);
                }
            }

//counting the no of occurences of each word in sentence
            List<Map<String, Integer>> occurance_list = new ArrayList();
            for (String word : contain_kay_set) {
                Map<String, Integer> occurrences = new HashMap<String, Integer>();
                String da[] = word.split(" ");
                for (String string : da) {
                    Integer oldCount = occurrences.get(string);
                    if (oldCount == null) {
                        oldCount = 0;
                    }
                    occurrences.put(string, oldCount + 1);
                }
                occurance_list.add(occurrences);
                // System.out.println("occurrences:" + occurrences.toString());               
            }
            System.out.println("set:" + contain_kay_set.toString());
            System.out.println("occurance_list:" + occurance_list.toString());


            Set<String> summarize_set = new HashSet();
            int size = occurance_list.size();
            if (size == 1) {
                for (String string : contain_kay_set) {
                    summarize_set.add(string);

                }
            }

            if (size == 2) {
                Map m1 = occurance_list.get(0);
                Map m2 = occurance_list.get(1);
                Set<String> s = new HashSet<String>(m1.keySet());
                s.retainAll(m2.keySet());
                System.out.println("s:" + s.toString());
                if (s.size() > 1) {
                    for (String string : contain_kay_set) {
                        summarize_set.add(string);
                        break;
                    }
                } else {
                    for (String string : contain_kay_set) {
                        summarize_set.add(string);
                    }
                }
            }


            if (size == 3 || size > 3) {
                Map m1 = occurance_list.get(0);
                Map m2 = occurance_list.get(1);
                Map m3 = occurance_list.get(2);
                Set<String> s = new HashSet<String>(m1.keySet());
                s.retainAll(m2.keySet());
                System.out.println("s:" + s.toString());
                if (s.size() > 1) {
                    for (String string : contain_kay_set) {
                        summarize_set.add(string);
                        break;
                    }
                } else {
                    List<String> list = new ArrayList(contain_kay_set);
                    summarize_set.add(list.get(0));
                    summarize_set.add(list.get(1));
                }

                Set<String> ss = new HashSet<String>(m1.keySet());
                ss.retainAll(m3.keySet());
                System.out.println("ss:" + ss.toString());
                if (ss.size() > 1) {
                    //no add
                } else {
                    for (String string : contain_kay_set) {
                        List<String> list = new ArrayList(contain_kay_set);
                        summarize_set.add(list.get(3));
                    }
                }
            }

            String Summarized_string="";
            
            for (String string : summarize_set) {
                Summarized_string=Summarized_string+" "+string;
            }



            request.setAttribute("Final_clusterData", Summarized_string.toString());
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewFinalClusteredData.jsp");
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
