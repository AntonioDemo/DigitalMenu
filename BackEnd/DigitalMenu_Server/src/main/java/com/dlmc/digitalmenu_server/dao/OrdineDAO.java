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
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Gerardo
 */
public class OrdineDAO {

    public static void doSave(OrdineBean bean) {

        int id = bean.getOrdineId();

        int stato = bean.getStato();
        List<ProdottoBean> p = bean.getListaProdotti();

        String sql = "INSERT INTO digitalmenu.ordine (idordine ) values"
                + "(?);";

        Connection currentCon = null;
        ResultSet rs = null;
        try {
            // Connessione al database
            currentCon = DriverManagerConnectionPool.getConnection();

            PreparedStatement ps = currentCon.prepareStatement(sql, Statement.NO_GENERATED_KEYS);

            ps.setInt(1, id);

            //System.out.println(ps.toString());
            ps.executeUpdate();

            currentCon.commit();

            //System.out.println(ps);
            //System.out.println(auto_id);
            int i = 0;

            while (!p.isEmpty()) {
               
                sql = "INSERT INTO digitalmenu.agginto(idprodotto,idordine,prezzo ) values"
                        + "(?,?,?);";

                ps = currentCon.prepareStatement(sql);
                ps.setInt(1, p.get(i).getProdottoId());
                ps.setInt(2, id);
                ps.setDouble(3, p.get(i).getPrezzo());
                ps.executeUpdate();

                currentCon.commit();
                 i++;
            }

            // if user does not exist set the isValid variable to false
            if (rs != null) {
                System.out.println("aggiunto" + rs);
            } // if user exists set the isValid variable to true
            else if (rs == null) {
                System.out.println("Non aggiunto");
            }
        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } // some exception handling
        finally {

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
