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

        StringBuffer jb = new StringBuffer();
        String line = null;
       

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        response.setContentType("text/html");
        int i=0;
        ListaOrdine.addOrdine(new Gson().fromJson(jb.toString(), OrdineBean.class),i);
        ListaOrdine.returnOrdine(i).setOrdineId(i++);
        out.println("<h1>Servlet GestioneOrdine at " + ListaOrdine.returnOrdine(i).getOrdineId()+ "</h1>");
        out.println("<h1>Servlet GestioneOrdine at " + ListaOrdine.returnOrdine(i).getListaProdotti().get(i).getProdottoId() + "</h1>");
        System.out.println("com.dlmc.digitalmenu_server.controller.GestioneOrdine.doPost()");
       
           OrdineDAO.doSave(ListaOrdine.returnOrdine(i));
      
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet GestioneOrdine</title>");
        out.println("</head>");
        /*   out.println("<body>");
        out.println("<h1>Servlet GestioneOrdine at " + p.getOrdineId() + "</h1>");
        out.println("<h1>Servlet GestioneOrdine at " + p.getStato() + "</h1>");
        out.println("<h1>Servlet GestioneOrdine at " + p.getListaProdotti().get(0).getNome() + "</h1>");
        out.println("<h1>Servlet GestioneOrdine at " + p.getListaProdotti().get(0).getNome() + "</h1>");
        out.println("<h1>Servlet GestioneOrdine at " + p.getListaProdotti().get(1).getListaIngredienti().get(0).getNome_Ing() + "</h1>");
        out.println("<h1>Servlet GestioneOrdine at " + p.getListaProdotti().get(1).getNome() + "</h1>");
        out.println("<h1>Servlet GestioneOrdine at " + p.getListaProdotti().get(1).getListaIngredienti().get(0).getNome_Ing() + "</h1>");
        /*    out.println("<h1>Servlet GestioneOrdine at " +p.get(1).getNome() +"</h1>");
              out.println("<h1>Servlet GestioneOrdine at " +p.get(2).getNome() +"</h1>");
         */
        //out.println("<h1>Servlet GestioneOrdine at " + request.getParameter("prezzo") + "</h1>");
        out.println("</body>");
        out.println("</html>");

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
