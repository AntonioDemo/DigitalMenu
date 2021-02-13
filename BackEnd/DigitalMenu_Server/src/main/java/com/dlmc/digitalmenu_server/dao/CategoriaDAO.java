/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlmc.digitalmenu_server.dao;

import com.dlmc.digitalmenu_server.beans.CategoriaBean;
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
        if (!controlloCategoria(idCat)) {
            listaProdotti=null;
            return listaProdotti;
        } else {
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

    public static List<CategoriaBean> getAllCat() {
        List<CategoriaBean> listaCategoria = new ArrayList<CategoriaBean>();
        try {
            Connection con = DriverManagerConnectionPool.getConnection();
            String query = "SELECT digitalmenu.categoria.idCategoria,digitalmenu.categoria.nome,digitalmenu.categoria.foto FROM digitalmenu.categoria;";

            PreparedStatement p = con.prepareStatement(query);

            ResultSet answers = p.executeQuery();

            while (answers.next()) {

                CategoriaBean bean = new CategoriaBean();
                int id = Integer.parseInt(answers.getString(1));
                String nome = answers.getString(2);
                String immagine = answers.getString(3);

                bean.setCategoriaId(id);
                bean.setNomeCat(nome);
                bean.setFoto(immagine);

                listaCategoria.add(bean);

            }
            answers.close();
            p.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaCategoria;
    }

    public static boolean controlloCategoria(int id) {
        if (id < 0) {
            return false;
        } else {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            boolean retVal = false;
            try {
                String selectSQL = "SELECT * FROM categoria WHERE idCategoria = ?";
                connection = DriverManagerConnectionPool.getConnection();
                preparedStatement = connection.prepareStatement(selectSQL);
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    retVal = true;
                } else {
                    retVal = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
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
}
