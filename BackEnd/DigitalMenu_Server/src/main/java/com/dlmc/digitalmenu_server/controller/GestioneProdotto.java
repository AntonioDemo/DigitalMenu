/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlmc.digitalmenu_server.controller;


import com.dlmc.digitalmenu_server.beans.IngredienteBean;
import com.dlmc.digitalmenu_server.beans.ProdottoBean;
import com.dlmc.digitalmenu_server.dao.DriverManagerConnectionPool;
import com.dlmc.digitalmenu_server.dao.IngredienteDAO;
import com.dlmc.digitalmenu_server.dao.ProdottoDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
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


@WebServlet("/GestioneProdotto")
public class GestioneProdotto extends HttpServlet {

    static Connection currentCon = null;
	static ResultSet rs;
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
            throws ServletException, IOException, SQLException {
     //  int idcat = Integer.parseInt(   request.getParameter("id"));
     //  try (PrintWriter out = response.getWriter()) {

      List<ProdottoBean> prodottoBean = new ArrayList<ProdottoBean>();
          prodottoBean=ProdottoDAO.getAllPiattiByCat(1);
            List<IngredienteBean> ingredienteBean = new ArrayList<IngredienteBean>();
          ingredienteBean=IngredienteDAO.getAllIngredientiByPro(1);
         prodottoBean.get(0).addIngrediente(ingredienteBean);
           //System.out.println( DriverManagerConnectionPool.getConnection().toString());
              response.setContentType("text/html");
              PrintWriter out= response.getWriter();
              out.println("<h1>"+ingredienteBean.get(0).getNome_Ing() +"</h1>");
               out.println("<h1>"+ingredienteBean.get(1).getNome_Ing() +"</h1>");
                out.println("<h1>"+ingredienteBean.get(2).getNome_Ing() +"</h1>");
         //     out.println("<h1>"+prodottoBean.get(0).getFoto() +"</h1>");
 
     /*  String json =new Gson ().toJson(prodottoBean);
         response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");*/
       
      Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(prodottoBean);
        
    response.getWriter().write(json);
 
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GestioneProdotto.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GestioneProdotto.class.getName()).log(Level.SEVERE, null, ex);
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