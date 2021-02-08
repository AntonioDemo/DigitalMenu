/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmenu.test;

import com.dlmc.digitalmenu_server.beans.CategoriaBean;
import com.dlmc.digitalmenu_server.dao.CategoriaDAO;
import com.google.gson.Gson;
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

    String oracolo;
    CategoriaBean catEsistente = new CategoriaBean();
    CategoriaBean catNonEsistente = new CategoriaBean();
    CategoriaBean catMinZero = new CategoriaBean();

    public GestioneCategoriaTest() {

    }

    @Before
    public void setUp() throws IOException {
        
        oracolo = FileUtils.readFileToString(new File("C:\\Users\\Administrator\\workspace\\Università\\DigitalMenuFileProgetto\\backendBrach\\DigitalMenu/Back"
                + "End/DigitalMenu_Server/src/test/java/digitalmenu/test/jsonCategorie.json"), "utf-8");
        
        //BUONO
        catEsistente = (CategoriaBean) new Gson().fromJson(oracolo, CategoriaBean.class);
        catEsistente.setCategoriaId(1);
        //CATEGORIA NON ESISTE
        catNonEsistente = (CategoriaBean) new Gson().fromJson(oracolo, CategoriaBean.class);
        catNonEsistente.setCategoriaId(7);
        //CATEGORIA < 0
        catMinZero = (CategoriaBean) new Gson().fromJson(oracolo, CategoriaBean.class);
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
                .get("http://localhost:8080/DigitalMenu_Server/GestioneCategoria?id=" + catEsistente.getCategoriaId())
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    
    @Test
    public void test__TC_UC_C_1_1() {
        assertFalse(catMinZero.getCategoriaId() > 0);
    }
     @Test
    public void test_TC_UC_C_1_2() {
        assertTrue(catEsistente.getCategoriaId() > 0);
        assertFalse(CategoriaDAO.controlloCategoria(catNonEsistente.getCategoriaId())); //non esiste
    }
    @Test
    public void test_TC_UC_C_1_3() {
        assertTrue(catEsistente.getCategoriaId() > 0);
        assertTrue(CategoriaDAO.controlloCategoria(catEsistente.getCategoriaId()));//esiste
    }
    
     
}
