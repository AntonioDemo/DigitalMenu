/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlmc.digitalmenu_server.dao;

import com.dlmc.digitalmenu_server.beans.ProdottoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gerardo
 */
public class CategoriaDAO {

    public static List<ProdottoBean> getAllPiattiByCat(int idCat) {
        List<ProdottoBean> listaProdotti = new ArrayList<ProdottoBean>();

        try {
            Connection con = DriverManagerConnectionPool.getConnection();
            String query = "SELECT digitalmenu.prodotto.* FROM contiene INNER JOIN prodotto ON contiene.idpro= prodotto.idProdotto WHERE contiene.idcat=?;";
            
            PreparedStatement p = con.prepareStatement(query);
            p.setInt(1, idCat);
            ResultSet answers = p.executeQuery();

            while (answers.next()) {
                 
                ProdottoBean bean = new ProdottoBean();
                int id = Integer.parseInt(answers.getString(1));
                String nome = answers.getString(2);
                double prezzo = Double.parseDouble(answers.getString(3));
                String immagine = answers.getString(4);

                bean.setProdottoId(id);
                bean.setNome(nome);
                bean.setPrezzo(prezzo);
                bean.setFoto(immagine);

                listaProdotti.add(bean);

            }
            answers.close();
            p.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        return listaProdotti;
    }

}
