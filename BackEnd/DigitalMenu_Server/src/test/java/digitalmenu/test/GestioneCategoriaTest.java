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
import junit.framework.TestCase;
import junit.framework.TestSuite;
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
public class GestioneCategoriaTest extends TestCase{

    String oracolo;
    CategoriaBean catEsistente = new CategoriaBean();
    CategoriaBean catNonEsistente = new CategoriaBean();
    CategoriaBean catMinZero = new CategoriaBean();
    Response respEsistente, respNonEsistente, respMinZero;
   

    @Before
    @Override
    public void setUp() throws IOException {
        
        oracolo = FileUtils.readFileToString(new File("/home/alby/DigitalMenu/BackEnd/Digital"
                + "Menu_Server/src/test/java/digitalmenu/test/jsonCategorie.json"), "utf-8");
        
        //BUONO
        catEsistente = (CategoriaBean) new Gson().fromJson(oracolo, CategoriaBean.class);
        catEsistente.setCategoriaId(1);
        //CATEGORIA NON ESISTE
        catNonEsistente = (CategoriaBean) new Gson().fromJson(oracolo, CategoriaBean.class);
        catNonEsistente.setCategoriaId(7);
        //CATEGORIA < 0
        catMinZero = (CategoriaBean) new Gson().fromJson(oracolo, CategoriaBean.class);
        catMinZero.setCategoriaId(-1);
        
         respNonEsistente = given()
                .when()
                .get("http://localhost:8080/DigitalMenu_Server/GestioneCategoria?id=" + catNonEsistente.getCategoriaId())
                .then()
                .extract()
                .response();
        /* String jsonBody = response.getBody().asString();
JSONArray data = new JSONArray(jsonBody);
String oracolo = FileUtils.readFileToString(new File("C:\\Users\\Gerardo\\Desktop\\DigitalMenu\\BackEnd\\DigitalMenu_Server\\src\\test\\java\\digitalmenu\\test\\jsonIdCategoria.json"), "utf-8");
JSONAssert.assertEquals(oracolo, data, false);*/
         
         respMinZero = given()
                .when()
                .get("http://localhost:8080/DigitalMenu_Server/GestioneCategoria?id=" + catMinZero.getCategoriaId())
                .then()
                .extract()
                .response();
         
         respEsistente = given()
                .when()
                .get("http://localhost:8080/DigitalMenu_Server/GestioneCategoria?id=" + catEsistente.getCategoriaId())
                .then()
                .extract()
                .response();
         
         System.out.println("ooooooooooooooooooooooooooooooooooooooooo"+respEsistente.getBody().asString());
    }

    @After
    public void tearDown() {
    }

  

    @Test
    public void test_TC_UC_C_1_1() {
        assertFalse(respMinZero.body().toString().equals("Errore: id errato"));
    }
  /*   @Test
    public void test_TC_UC_C_1_2() {
        assertTrue(catEsistente.getCategoriaId() > 0);
        assertFalse(CategoriaDAO.controlloCategoria(catNonEsistente.getCategoriaId())); //non esiste
    }
    @Test
    public void test_TC_UC_C_1_3() {
        assertTrue(catEsistente.getCategoriaId() > 0);
        assertTrue(CategoriaDAO.controlloCategoria(catEsistente.getCategoriaId()));//esiste
    }
    
*/     
     public static TestSuite suite() {
        return new TestSuite(GestioneCategoriaTest.class);

    }

}
