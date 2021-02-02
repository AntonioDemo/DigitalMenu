/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmenu.test;

import com.dlmc.digitalmenu_server.beans.CategoriaBean;
import com.dlmc.digitalmenu_server.beans.ProdottoBean;
import com.dlmc.digitalmenu_server.dao.CategoriaDAO;
import com.dlmc.digitalmenu_server.dao.ProdottoDAO;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
public class GestioneProdottoTest {
      ProdottoBean proEsistente = new ProdottoBean();
   ProdottoBean proNonEsistente = new ProdottoBean();
    ProdottoBean proMinZero = new ProdottoBean();

    public GestioneProdottoTest() {
    }

 

    @Before
    public void setUp() {
        proEsistente.setProdottoId(2);
        proNonEsistente.setProdottoId(100);
        proMinZero.setProdottoId(-1);
        
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void visualizzaDettagliProdotto()  throws JSONException, IOException {

        Response response = given()
                .when()
                .get("http://localhost:8000/DigitalMenu_Server/GestioneProdotto?idP="+proEsistente.getProdottoId())
                .then()
                .statusCode(200)
                .extract()
                .response();
        String jsonBody = response.getBody().asString();
        JSONObject data = new JSONObject(jsonBody);
        String oracolo = FileUtils.readFileToString(new File("C:\\Users\\Gerardo\\Desktop\\DigitalMenu\\BackEnd\\DigitalMenu_Server\\src\\test\\java\\digitalmenu\\test\\jsonProdotto.json"),"utf-8");
        JSONAssert.assertEquals(oracolo, data, false);
    }

            @Test
    public void testControlloProdotto() {
                
        assertTrue(ProdottoDAO.controlloProdotto(proEsistente.getProdottoId()));//esiste
        assertFalse(ProdottoDAO.controlloProdotto(proNonEsistente.getProdottoId())); //non esiste
        assertTrue(proEsistente.getProdottoId()  > 0);
        assertTrue(proMinZero.getProdottoId() < 0);

    }
}
