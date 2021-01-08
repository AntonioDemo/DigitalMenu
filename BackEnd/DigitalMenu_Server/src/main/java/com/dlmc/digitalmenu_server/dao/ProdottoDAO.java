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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gerardo
 */
public class ProdottoDAO {
    
    
    public static ProdottoBean getPrdotto (int idPro )
      
    
    {ProdottoBean prodotto = new ProdottoBean();
            
                    
           
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
         return prodotto ;
    }
    
 

}

    

                     
       
