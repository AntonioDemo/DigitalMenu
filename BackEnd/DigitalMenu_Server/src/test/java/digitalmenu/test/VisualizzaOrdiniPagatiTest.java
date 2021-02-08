/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmenu.test;

import com.dlmc.digitalmenu_server.beans.OrdineBean;
import com.dlmc.digitalmenu_server.dao.OrdineDAO;
import com.google.gson.Gson;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 *
 * @author Anto
 */
public class VisualizzaOrdiniPagatiTest {

    String oracolo;
    OrdineBean o = new OrdineBean();
    OrdineBean o1 = new OrdineBean();
    OrdineBean o2 = new OrdineBean();
    OrdineBean o3 = new OrdineBean();

    public VisualizzaOrdiniPagatiTest() {
    }

    @Before
    public void setUp() throws IOException {
        oracolo = FileUtils.readFileToString(new File("C:\\Users\\Administrator\\workspace\\Università\\DigitalMenuFileProgetto\\backendBrach\\DigitalMenu/"
                + "BackEnd/DigitalMenu_Server/src/test/java/digitalmenu/test/jsonOrdiniPagati.json"), "utf-8");

        //IDORDINE NEGATIVO
        o = (OrdineBean) new Gson().fromJson(oracolo, OrdineBean.class);
        o.setOrdineId(-1);
        //IDORDINE NON ESISTE
        o1 = (OrdineBean) new Gson().fromJson(oracolo, OrdineBean.class);
        o1.setOrdineId(1000);
        //STATO < 1
        o2 = (OrdineBean) new Gson().fromJson(oracolo, OrdineBean.class);
        o2.setStato_c(0);
        //BUONO
        o3 = (OrdineBean) new Gson().fromJson(oracolo, OrdineBean.class);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() throws JSONException, FileNotFoundException, IOException {
        Response response = given()
                .when()
                .post("http://localhost:8080/DigitalMenu_Server/VisualizzaOrdiniPagati")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test
    public void TC_UC_AC_1_1() {
        assertFalse(o.getOrdineId() > 0);
    }

    @Test
    public void TC_UC_AC_1_2() {
        assertTrue(o1.getOrdineId() > 0);
        assertFalse(OrdineDAO.idEsiste(o1.getOrdineId()));
    }

    @Test
    public void TC_UC_AC_1_3() {
        assertTrue(o2.getOrdineId() > 0);
        assertTrue(OrdineDAO.idEsiste(o2.getOrdineId()));
        assertFalse(o2.getStato() > 0 && o2.getStato() < 4);
    }

    @Test
    public void TC_UC_AC_1_4() {
        assertTrue(o3.getOrdineId() > 0);
        assertTrue(OrdineDAO.idEsiste(o3.getOrdineId()));
        assertTrue(o3.getStato() > 0 && o3.getStato() < 4);
    }
}
