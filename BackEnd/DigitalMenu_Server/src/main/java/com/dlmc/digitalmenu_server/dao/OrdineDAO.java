/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlmc.digitalmenu_server.dao;

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

    public static void doSave(OrdineBean b) {
        List<ProdottoBean> p = b.getListaProdotti();
        int id = b.getOrdineId();
        String sqll = "INSERT INTO digitalmenu.aggiunto(idprodo,idordi,prezzo ) values"
                + "(?,?,?);";
        String sql = "INSERT INTO digitalmenu.ordine (idordine) values"
                + "(?);";
        Connection currentCon = null;
        try {
            currentCon = DriverManagerConnectionPool.getConnection();

            PreparedStatement ps = currentCon.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            for (ProdottoBean bean : p) {
                PreparedStatement pss = currentCon.prepareStatement(sqll);
                pss.setInt(1, bean.getProdottoId());
                pss.setInt(2, id);
                pss.setDouble(3, bean.getPrezzo());
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

}
