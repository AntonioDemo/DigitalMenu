/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmenu.test;

import com.dlmc.digitalmenu_server.beans.CategoriaBean;
import com.dlmc.digitalmenu_server.dao.CategoriaDAO;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 *
 * @author Anto
 */
public class GestioneCategoriaTest {

    CategoriaBean catEsistente = new CategoriaBean();
    CategoriaBean catNonEsistente = new CategoriaBean();
    CategoriaBean catMinZero = new CategoriaBean();

    public GestioneCategoriaTest() {

    }

    @Before
    public void setUp() {
        catEsistente.setCategoriaId(1);
        catNonEsistente.setCategoriaId(7);
        catMinZero.setCategoriaId(-1);

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    @Test
    public void getAllPiattiByCat() throws JSONException, IOException {

        Response response = given()
                .when()
                .get("http://localhost:8000/DigitalMenu_Server/GestioneCategoria?id=" + catEsistente.getCategoriaId())
                .then()
                .statusCode(200)
                .extract()
                .response();
        String jsonBody = response.getBody().asString();
        JSONArray data = new JSONArray(jsonBody);
        String oracolo = FileUtils.readFileToString(new File("C:\\Users\\Gerardo\\Desktop\\DigitalMenu\\BackEnd\\DigitalMenu_Server\\src\\test\\java\\digitalmenu\\test\\jsonIdCategoria.json"), "utf-8");
        JSONAssert.assertEquals(oracolo, data, false);
    }

    @Test
    public void testControlloCategoria() {
        assertTrue(CategoriaDAO.controlloCategoria(catEsistente.getCategoriaId()));//esiste
        assertFalse(CategoriaDAO.controlloCategoria(catNonEsistente.getCategoriaId())); //non esiste
        assertTrue(catEsistente.getCategoriaId() > 0);
        assertTrue(catMinZero.getCategoriaId() < 0);

    }

}
