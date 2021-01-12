/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlmc.digitalmenu_server.dao;

import com.dlmc.digitalmenu_server.beans.DettaglioOrdineBean;
import com.dlmc.digitalmenu_server.beans.OrdineBean;
import com.dlmc.digitalmenu_server.beans.ProdottoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gerardo
 */
public class OrdineDAO {
static Connection currentCon = null;

    public static void doSave(OrdineBean b) {
        List<DettaglioOrdineBean> p = b.getListaProdotti();
        int id = b.getOrdineId();
        int  stato=b.getStato();
        String sqll = "INSERT INTO digitalmenu.aggiunto(idprodo,idordi,prezzo,deleteing,quantità ) values"
                + "(?,?,?,?,?);";
        String sql = "INSERT INTO digitalmenu.ordine (idordine,stato) values"
                + "(?,?);";
    
        try {
            currentCon = DriverManagerConnectionPool.getConnection();

            PreparedStatement ps = currentCon.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, stato);
            ps.executeUpdate();
                
            for (DettaglioOrdineBean bean : p) {
                PreparedStatement pss = currentCon.prepareStatement(sqll);
                pss.setInt(1, bean.getProdotto().getProdottoId());
                pss.setInt(2, id);
                pss.setDouble(3, bean.getProdotto().    getPrezzo());
                pss.setString(4, bean.getRimIng());
                pss.setInt(5, bean.getQuantita());
                pss.executeUpdate();
            }
            currentCon.commit();
        } catch (SQLException ex) {
            Logger.getLogger(OrdineDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }
    }

    public static int getLastId()  {

        String sql = "  SELECT max(idordine) FROM ordine;";
           int id = 0;
           Connection con =null;
     try{
         con = DriverManagerConnectionPool.getConnection();
            PreparedStatement p = con.prepareStatement(sql);
           ResultSet answers = p.executeQuery();
           if(answers.next()==false)
               return 0;
         id = Integer.parseInt(answers.getString(1));
           answers.close();
            p.close();
            con.close();
     }
     catch (SQLException ex) {
            Logger.getLogger(OrdineDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 

           
    
        return id;
    }
}
