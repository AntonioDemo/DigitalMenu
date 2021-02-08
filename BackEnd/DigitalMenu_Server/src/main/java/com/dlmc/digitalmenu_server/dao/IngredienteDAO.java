package com.dlmc.digitalmenu_server.dao;

import com.dlmc.digitalmenu_server.beans.IngredienteBean;
import com.dlmc.digitalmenu_server.beans.ProdottoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gerardo
 */
public class IngredienteDAO {

    public static List<IngredienteBean> getAllIngredientiByPro(int idProdotto) {
        List<IngredienteBean> ingrediente = new ArrayList<IngredienteBean>();

        try {

            String query = "SELECT ingrediente.*" + " FROM formato INNER JOIN ingrediente ON formato.idingrediente= ingrediente.idIngrediente WHERE formato.idprodot=?";
            Connection con = DriverManagerConnectionPool.getConnection();
            PreparedStatement p = con.prepareStatement(query);
            p.setInt(1, idProdotto);
            ResultSet answers = p.executeQuery();

            while (answers.next()) {

                IngredienteBean bean = new IngredienteBean();
                int id = Integer.parseInt(answers.getString(1));
                String nome = answers.getString(2);
                int prezzo = Integer.parseInt(answers.getString(3));

                bean.setIngredienteId(id);
                bean.setNome_Ing(nome);
                bean.setIsRimovibile(prezzo);

                ingrediente.add(bean);

            }

            answers.close();
            p.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ingrediente;
    }

    public static boolean controlloDeleteIng(String delete, int idP) {
        String p;
        int id = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        boolean retVal = false;
        try {
            String selectSQL = "SELECT idIngrediente FROM digitalmenu.ingrediente where nome=? and isRimovibile=1;";
            String selectSQL1 = "SELECT * FROM digitalmenu.formato where idingrediente=? and idprodot=?";
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, delete);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                id = rs.getInt(0);
                retVal=true;
            } else {
                retVal=false;
            }
           
            preparedStatement1 = connection.prepareStatement(selectSQL1);
            preparedStatement1.setInt(1, id);
            preparedStatement1.setInt(2, idP);
            ResultSet rs1 = preparedStatement.executeQuery();
            
            if (rs1.next()) {
                retVal=true;
            } else {
                retVal=false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null || preparedStatement1 != null) {
                    preparedStatement.close();
                    connection.close();
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    DriverManagerConnectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return retVal;
    }

}
