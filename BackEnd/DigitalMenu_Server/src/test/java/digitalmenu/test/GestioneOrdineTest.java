/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmenu.test;

import com.dlmc.digitalmenu_server.beans.DettagliOrdineBean;
import com.dlmc.digitalmenu_server.beans.OrdineBean;
import com.dlmc.digitalmenu_server.beans.ProdottoBean;
import com.dlmc.digitalmenu_server.dao.OrdineDAO;
import com.google.gson.Gson;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 *
 * @author Anto
 */ 
public class GestioneOrdineTest {
    OrdineBean o = new OrdineBean();
    String oracolo ;
      OrdineBean c = new OrdineBean();
    public GestioneOrdineTest()  {
       
    }
    
  
    
    

    @Before
    public void setUp() throws IOException{
        oracolo=FileUtils.readFileToString(new File("C:\\Users\\Gerardo\\Desktop\\DigitalMenu\\BackEnd\\DigitalMenu_Server\\src\\test\\java\\digitalmenu\\test\\jsonOrdine.json"), "utf-8");
   //ORDINE BUONO
         o = (OrdineBean )new Gson().fromJson(oracolo, OrdineBean.class);
       //ORDINE IDORDINE < 0
         c = (OrdineBean )new Gson().fromJson(oracolo, OrdineBean.class);
        c.setOrdineId(-1);
     /*   //ORDINE IDORDINE GIA ESISTENTE
        OrdineBean b2 = (OrdineBean )new Gson().fromJson(oracolo, OrdineBean.class);
        b2.setOrdineId(10);
        //ORDINE STATO < 0
        OrdineBean b3 = (OrdineBean )new Gson().fromJson(oracolo, OrdineBean.class);
        b3.setStato_c(-1);
        //ORDINE SENZA PRODOTTI
        OrdineBean b4 = (OrdineBean )new Gson().fromJson(oracolo, OrdineBean.class);
        b4.setListaProdotti(null);
        //ORDINE IDPRODOTTO < 0
        OrdineBean b5 = (OrdineBean )new Gson().fromJson(oracolo, OrdineBean.class);
        b5.getListaProdotti().get(0).getProdotto().setProdottoId(-1);
        //ORDINE IDPRODOTTO NON ESISTE
        OrdineBean b6 = (OrdineBean )new Gson().fromJson(oracolo, OrdineBean.class);
         b6.getListaProdotti().get(0).getProdotto().setProdottoId(30);
        //ORDINE QUANTITA < 1
        OrdineBean b7 = (OrdineBean )new Gson().fromJson(oracolo, OrdineBean.class);
         b5.getListaProdotti().get(0).setquantita(0);
        //ORDINE DELETEING LUNGHEZZA < 5
        OrdineBean b8 = (OrdineBean )new Gson().fromJson(oracolo, OrdineBean.class);
        b8.getListaProdotti().get(0).setIngerdienteRimosso("oo");
        //ORDINE DELETEING FORMATO
        OrdineBean b9 = (OrdineBean )new Gson().fromJson(oracolo, OrdineBean.class);
        b9.getListaProdotti().get(0).setIngerdienteRimosso("12345");
        //ORDINE DELETEING NON ESISTE NEL DB
        OrdineBean b10 = (OrdineBean )new Gson().fromJson(oracolo, OrdineBean.class);
        b10.getListaProdotti().get(0).setIngerdienteRimosso("origano");
      System.out.println("dma"+b.getOrdineId());
        */
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
 

    @Test
    public void inserisciordine (){
        assertTrue(OrdineDAO.doSave(o));
        assertFalse(OrdineDAO.doSave(c));
}

        
}
