package com.dlmc.digitalmenu_server.dao;

import com.dlmc.digitalmenu_server.beans.OrdineBean;
import com.dlmc.digitalmenu_server.beans.ProdottoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gerardo
 */
public class ProdottoDAO {

    public static ProdottoBean getPrdotto(int idPro) {
        if(idPro < 0) return null;
        ProdottoBean prodotto = new ProdottoBean();

        try {

            String query = "SELECT prodotto.* FROM  prodotto WHERE idProdotto=?";
            Connection con = DriverManagerConnectionPool.getConnection();
            PreparedStatement p = con.prepareStatement(query);
            p.setInt(1, idPro);
            ResultSet answers = p.executeQuery();

            while (answers.next()) {

                int id = Integer.parseInt(answers.getString(1));
                String nome = answers.getString(2);
                double prezzo = Double.parseDouble(answers.getString(3));
                String immagine = answers.getString(4);

                prodotto.setProdottoId(id);
                prodotto.setNome(nome);
                prodotto.setPrezzo(prezzo);
                prodotto.setFoto(immagine);

            }
            answers.close();
            p.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return prodotto;
    }

    public static boolean controlloProdotto(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean retVal = false;
        try {
            String selectSQL = "SELECT * FROM prodotto WHERE idProdotto= ?";
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
