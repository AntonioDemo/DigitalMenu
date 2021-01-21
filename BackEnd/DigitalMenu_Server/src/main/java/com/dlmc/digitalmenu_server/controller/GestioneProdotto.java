/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlmc.digitalmenu_server.controller;

import com.dlmc.digitalmenu_server.beans.IngredienteBean;
import com.dlmc.digitalmenu_server.beans.ProdottoBean;
import com.dlmc.digitalmenu_server.dao.IngredienteDAO;
import com.dlmc.digitalmenu_server.dao.ProdottoDAO;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import java.io.IOException;
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

/**
 *
 * @author alby
 */
@WebServlet("/GestioneProdotto")
public class GestioneProdotto extends HttpServlet {

    /**
     *
     */
    static Connection currentCon = null;

    /**
     *
     */
    static ResultSet rs;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @custom.precondition
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
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
        List<IngredienteBean> ingredienteBean = new ArrayList<IngredienteBean>();
        ingredienteBean = IngredienteDAO.getAllIngredientiByPro(Integer.parseInt(request.getParameter("idP")));
        ProdottoBean pro = new ProdottoBean();
        pro = ProdottoDAO.getPrdotto(Integer.parseInt(request.getParameter("idP")));
        pro.addIngrediente(ingredienteBean);
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(pro);

        response.getWriter().write(json);
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
