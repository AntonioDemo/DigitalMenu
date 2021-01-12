/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlmc.digitalmenu_server.dao;

import com.dlmc.digitalmenu_server.beans.DettagliOrdineBean;

import com.dlmc.digitalmenu_server.beans.OrdineBean;
import com.dlmc.digitalmenu_server.beans.ProdottoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

        List<DettagliOrdineBean> p = b.getListaProdotti();

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

                
            for (DettagliOrdineBean bean : p) {
                PreparedStatement pss = currentCon.prepareStatement(sqll);
                pss.setInt(1, bean.getProdotto().getProdottoId());
                pss.setInt(2, id);
                pss.setDouble(3, bean.getProdotto().getPrezzo());
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
  
    public static int getstato(int id) {

        int stat = -1;
        String sql = "SELECT stato FROM digitalmenu.ordine WHERE (`idordine` = ?);";
        Connection con;
        try {
            con = DriverManagerConnectionPool.getConnection();

            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet answers = p.executeQuery();
            if (answers.next() == false) {
                stat = -1;
            } else {
                stat = Integer.parseInt(answers.getString(1));
            }
            answers.close();
            p.close();
            con.close();

            return stat;
        } catch (SQLException ex) {
            Logger.getLogger(OrdineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stat;
    }

    public static void setstato(int id, int stato) {

        String sql = "UPDATE `digitalmenu`.`ordine` SET `stato` = ? WHERE (`idordine` = ?);";

        Connection con;
        try {
            con = DriverManagerConnectionPool.getConnection();

            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(2, id);
            p.setInt(1, stato);
            p.executeUpdate();
            con.commit();
            p.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(OrdineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<OrdineBean> caricaordini() {
        int i = 0;
        List<OrdineBean> ListOrdi = new ArrayList<OrdineBean>();
        List<ProdottoBean> ListProdotti = new ArrayList<ProdottoBean>();
        String sql = "SELECT stato, idordine, idprodo, quantita, deleteing, nome, comanda.prezzo,foto from "
                + "(SELECT * from(SELECT * FROM ordine where stato < 4)as ordine\n"
                + "inner join aggiunto on (idordi=idordine)) as comanda\n"
                + "inner join prodotto on idprodo = idProdotto ;";
        try {

            Connection con;
            con = DriverManagerConnectionPool.getConnection();
            PreparedStatement p;
            p = con.prepareStatement(sql);
            ResultSet answers = p.executeQuery();

            while (answers.next()) {
                OrdineBean ordine = new OrdineBean(answers.getInt(2), answers.getInt(1));
                List<DettagliOrdineBean> ListDett = new ArrayList<DettagliOrdineBean>();
                ProdottoBean prodo = new ProdottoBean(answers.getInt(3), answers.getDouble(7), answers.getString(8), answers.getString(6));
                DettagliOrdineBean dettagliordine = new DettagliOrdineBean(answers.getInt(4), answers.getString(5), prodo);
                ListDett.add(dettagliordine);
                if (ListOrdi.size() > 0)
                    if (answers.getInt(2) == ListOrdi.get(ListOrdi.size() - 1).getOrdineId()) {
                        for (int v = 0; v < (ListOrdi.get(ListOrdi.size() - 1).getListaProdotti().size()); v++)
                            ListDett.add(ListOrdi.get(ListOrdi.size() - 1).getListaProdotti().get(v));
                        ListOrdi.remove(ListOrdi.size() - 1);
                    }
                ordine.setListaProdotti(ListDett);
                ListOrdi.add(ordine);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrdineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListOrdi;

    }
}
