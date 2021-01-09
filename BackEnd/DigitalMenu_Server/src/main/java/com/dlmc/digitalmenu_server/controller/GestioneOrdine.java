/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlmc.digitalmenu_server.controller;

import com.dlmc.digitalmenu_server.beans.OrdineBean;
import com.dlmc.digitalmenu_server.beans.ProdottoBean;
import com.dlmc.digitalmenu_server.dao.OrdineDAO;
import com.dlmc.digitalmenu_server.dao.ProdottoDAO;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gerardo
 */
@WebServlet(name = "GestioneOrdine", urlPatterns = {"/GestioneOrdine"})
public class GestioneOrdine extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

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

        StringBuilder jb = new StringBuilder();
        String line = null;
           int i=0;
           
       response.setContentType("text/html;charset=UTF-8");

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (IOException e) {
        }
            PrintWriter out = response.getWriter();
                out.println("<h1>Servlet GestioneStatoOrdine at " + i+ "</h1>");
        try {
         
                i=OrdineDAO.getLastId()+1;
            
               
                out.println("<h1>Servlet GestioneStatoOrdine at " + i+ "</h1>");
                ListaOrdine.addOrdine(new Gson().fromJson(jb.toString(), OrdineBean.class));
                int pos=ListaOrdine.pos-1;
              ListaOrdine.returnOrdine(pos).setOrdineId(i);
              ListaOrdine.returnOrdine(pos).setStato_c(0);
       
           OrdineDAO.doSave(ListaOrdine.returnOrdine(pos));

        } catch (SQLException ex) {
            Logger.getLogger(GestioneOrdine.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       

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