/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmenu.test;

import com.dlmc.digitalmenu_server.beans.OrdineBean;
import com.dlmc.digitalmenu_server.dao.IngredienteDAO;
import com.dlmc.digitalmenu_server.dao.OrdineDAO;
import com.dlmc.digitalmenu_server.dao.ProdottoDAO;
import com.google.gson.Gson;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anto
 */
public class GestioneOrdineTest extends TestCase{

    String oracolo;
    OrdineBean b = new OrdineBean();
    OrdineBean b1 = new OrdineBean();
    OrdineBean b2 = new OrdineBean();
    OrdineBean b3 = new OrdineBean();
    OrdineBean b4 = new OrdineBean();
    OrdineBean b5 = new OrdineBean();
    OrdineBean b6 = new OrdineBean();
    OrdineBean b7 = new OrdineBean();
    OrdineBean b8 = new OrdineBean();
    OrdineBean b9 = new OrdineBean();
    OrdineBean b10 = new OrdineBean();

    public GestioneOrdineTest() {

    }

    @Before
    public void setUp() throws IOException {
        oracolo = FileUtils.readFileToString(new File("C:\\Users\\Administrator\\workspace\\Università\\DigitalMenuFileProgetto\\backendBrach\\DigitalMenu\\BackEnd\\DigitalMenu_Server\\src\\test\\java\\digitalmenu\\test\\jsonOrdine.json"), "utf-8");
        //ORDINE BUONO
        b = (OrdineBean) new Gson().fromJson(oracolo, OrdineBean.class);
        //ORDINE IDORDINE < 0
        b1 = (OrdineBean) new Gson().fromJson(oracolo, OrdineBean.class);
        b1.setOrdineId(-1);
        //ORDINE IDORDINE GIA ESISTENTE
        b2 = (OrdineBean) new Gson().fromJson(oracolo, OrdineBean.class);
        b2.setOrdineId(10);
        //ORDINE STATO < 0
        b3 = (OrdineBean) new Gson().fromJson(oracolo, OrdineBean.class);
        b3.setStato_c(-1);
        //ORDINE SENZA PRODOTTI
        b4 = (OrdineBean) new Gson().fromJson(oracolo, OrdineBean.class);
        b4.setListaProdotti(null);
        //ORDINE IDPRODOTTO < 0
        b5 = (OrdineBean) new Gson().fromJson(oracolo, OrdineBean.class);
        b5.getListaProdotti().get(0).getProdotto().setProdottoId(-1);
        //ORDINE IDPRODOTTO NON ESISTE
        b6 = (OrdineBean) new Gson().fromJson(oracolo, OrdineBean.class);
        b6.getListaProdotti().get(0).getProdotto().setProdottoId(30);
        //ORDINE QUANTITA < 1
        b7 = (OrdineBean) new Gson().fromJson(oracolo, OrdineBean.class);
        b7.getListaProdotti().get(0).setquantita(0);
        //ORDINE DELETEING LUNGHEZZA < 5
        b8 = (OrdineBean) new Gson().fromJson(oracolo, OrdineBean.class);
        b8.getListaProdotti().get(0).setIngerdienteRimosso("oo");
        //ORDINE DELETEING FORMATO
        b9 = (OrdineBean) new Gson().fromJson(oracolo, OrdineBean.class);
        b9.getListaProdotti().get(0).setIngerdienteRimosso("12345");
        //ORDINE DELETEING NON ESISTE NEL DB
        b10 = (OrdineBean) new Gson().fromJson(oracolo, OrdineBean.class);
        b10.getListaProdotti().get(0).setIngerdienteRimosso("origano");

    }

    @After
    public void tearDown() {
        OrdineDAO.deleteOrdine(b);
    }

    @Test
    public void test_http() {

        given()
                .contentType(ContentType.JSON)
                .body(oracolo)
                .post("http://localhost:8080/DigitalMenu_Server/GestioneOrdine?idPagamento=0")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test
    public void test_TC_UC_C_6_1() {
        assertFalse(b1.getOrdineId() > 0);
    }

    @Test
    public void test_TC_UC_C_6_2() {
        assertTrue(b2.getOrdineId() > 0);
        assertTrue(OrdineDAO.idEsiste(b2.getOrdineId()));
    }

    @Test
    public void test_TC_UC_C_6_3() {
        assertTrue(b3.getOrdineId() > 0);
        assertFalse(OrdineDAO.idEsiste(b3.getOrdineId()));
        assertFalse(b3.getStato() > 0);
    }

    @Test
    public void test_TC_UC_C_6_4() {
        assertTrue(b4.getOrdineId() > 0);
        assertFalse(OrdineDAO.idEsiste(b4.getOrdineId()));
        assertTrue(b4.getStato() > 0);
        assertFalse(b4.getListaProdotti() != null);
    }

    @Test
    public void test_TC_UC_C_6_5() {
        assertTrue(b5.getOrdineId() > 0);
        assertFalse(OrdineDAO.idEsiste(b5.getOrdineId()));
        assertTrue(b5.getStato() > 0);
        assertTrue(b5.getListaProdotti() != null);
        assertFalse(b5.getListaProdotti().get(0).getProdotto().getProdottoId() > 0);
    }

    @Test
    public void test_TC_UC_C_6_6() {
        assertTrue(b6.getOrdineId() > 0);
        assertFalse(OrdineDAO.idEsiste(b6.getOrdineId()));
        assertTrue(b6.getStato() > 0);
        assertTrue(b6.getListaProdotti() != null);
        assertTrue(b6.getListaProdotti().get(0).getProdotto().getProdottoId() > 0);
        assertFalse(ProdottoDAO.controlloProdotto(b6.getListaProdotti().get(0).getProdotto().getProdottoId()));
    }

    @Test
    public void test_TC_UC_C_6_7() {
        assertTrue(b7.getOrdineId() > 0);
        assertFalse(OrdineDAO.idEsiste(b7.getOrdineId()));
        assertTrue(b7.getStato() > 0);
        assertTrue(b7.getListaProdotti() != null);
        assertTrue(b7.getListaProdotti().get(0).getProdotto().getProdottoId() > 0);
        assertTrue(ProdottoDAO.controlloProdotto(b7.getListaProdotti().get(0).getProdotto().getProdottoId()));
        assertFalse(b7.getListaProdotti().get(0).getquantita() > 0);
    }

    @Test
    public void test_TC_UC_C_6_8() {
        assertTrue(b8.getOrdineId() > 0);
        assertFalse(OrdineDAO.idEsiste(b8.getOrdineId()));
        assertTrue(b8.getStato() > 0);
        assertTrue(b8.getListaProdotti() != null);
        assertTrue(b8.getListaProdotti().get(0).getProdotto().getProdottoId() > 0);
        assertTrue(ProdottoDAO.controlloProdotto(b8.getListaProdotti().get(0).getProdotto().getProdottoId()));
        assertTrue(b8.getListaProdotti().get(0).getquantita() > 0);
        assertFalse(b8.getListaProdotti().get(0).getIngedienteRimoso().length() > 4);
    }

    @Test
    public void test_TC_UC_C_6_9() {
        assertTrue(b9.getOrdineId() > 0);
        assertFalse(OrdineDAO.idEsiste(b9.getOrdineId()));
        assertTrue(b9.getStato() > 0);
        assertTrue(b9.getListaProdotti() != null);
        assertTrue(b9.getListaProdotti().get(0).getProdotto().getProdottoId() > 0);
        assertTrue(ProdottoDAO.controlloProdotto(b9.getListaProdotti().get(0).getProdotto().getProdottoId()));
        assertTrue(b9.getListaProdotti().get(0).getquantita() > 0);
        assertTrue(b9.getListaProdotti().get(0).getIngedienteRimoso().length() > 4);
        assertFalse(Pattern.matches("[a-zA-Z- ]+", (b9.getListaProdotti().get(0).getIngedienteRimoso())));
    }

    @Test
    public void test_TC_UC_C_6_10() {
        assertTrue(b10.getOrdineId() > 0);
        assertFalse(OrdineDAO.idEsiste(b10.getOrdineId()));
        assertTrue(b10.getStato() > 0);
        assertTrue(b10.getListaProdotti() != null);
        assertTrue(b10.getListaProdotti().get(0).getProdotto().getProdottoId() > 0);
        assertTrue(ProdottoDAO.controlloProdotto(b10.getListaProdotti().get(0).getProdotto().getProdottoId()));
        assertTrue(b10.getListaProdotti().get(0).getquantita() > 0);
        assertTrue(b10.getListaProdotti().get(0).getIngedienteRimoso().length() > 4);
        assertTrue(Pattern.matches("[a-zA-Z- ]+", (b10.getListaProdotti().get(0).getIngedienteRimoso())));
        assertFalse(IngredienteDAO.controlloDeleteIng(b10.getListaProdotti().get(0).getIngedienteRimoso(),
                b10.getListaProdotti().get(0).getProdotto().getProdottoId()));
    }
    
        public static TestSuite suite() {
        return new TestSuite(GestioneOrdineTest.class);

    }
}
