/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmenu.test;

import com.dlmc.digitalmenu_server.beans.ProdottoBean;
import com.dlmc.digitalmenu_server.dao.ProdottoDAO;
import com.google.gson.Gson;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import java.io.File;
import java.io.IOException;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 *
 * @author Anto
 */
public class GestioneProdottoTest extends TestCase{

    String oracolo;
    ProdottoBean proEsistente = new ProdottoBean();
    ProdottoBean proNonEsistente = new ProdottoBean();
    ProdottoBean proMinZero = new ProdottoBean();

    public GestioneProdottoTest() {
    }

    @Before
    public void setUp() throws IOException {

        oracolo =FileUtils.readFileToString(new File("C:\\Users\\Administrator\\workspace\\Università\\DigitalMenuFileProgetto\\backendBrach\\DigitalMenu/Back"
                + "End/DigitalMenu_Server/src/test/java/digitalmenu/test/jsonProdotto.json"), "utf-8");
        //BUONO
        proEsistente = (ProdottoBean) new Gson().fromJson(oracolo, ProdottoBean.class);
        proEsistente.setProdottoId(2);
        //IDP NON ESIETE
        proNonEsistente = (ProdottoBean) new Gson().fromJson(oracolo, ProdottoBean.class);
        proNonEsistente.setProdottoId(100);
        //IDP < 0
        proMinZero = (ProdottoBean) new Gson().fromJson(oracolo, ProdottoBean.class);
        proMinZero.setProdottoId(-1);

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void test_visualizzaDettagliProdotto() throws JSONException, IOException {

        Response response = given()
                .when()
                .get("http://localhost:8080/DigitalMenu_Server/GestioneProdotto?idP=" + proEsistente.getProdottoId())
                .then()
                .statusCode(200)
                .extract()
                .response();
        String jsonBody = response.getBody().asString();
        JSONObject data = new JSONObject(jsonBody);
      JSONAssert.assertEquals(oracolo, data, false);
    }

    @Test
    public void test_TC_UC_C_2_1() {
        assertFalse(proMinZero.getProdottoId() > 0);
    }

    @Test
    public void test_TC_UC_C_2_2() {
        assertTrue(proEsistente.getProdottoId() > 0);
        assertFalse(ProdottoDAO.controlloProdotto(proNonEsistente.getProdottoId())); //non esiste
    }

    @Test
    public void test_TC_UC_C_2_3() {
        assertTrue(proEsistente.getProdottoId() > 0);
        assertTrue(ProdottoDAO.controlloProdotto(proEsistente.getProdottoId()));//esiste
    }
    
        public static TestSuite suite() {
        return new TestSuite(GestioneProdottoTest.class);

    }
}
