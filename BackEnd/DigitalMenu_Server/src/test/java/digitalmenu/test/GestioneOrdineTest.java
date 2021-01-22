/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmenu.test;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
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
    
    public GestioneOrdineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() throws JSONException {
       Response response = given()
                .when()
                .post("http://localhost:8080/DigitalMenu_Server/VisualizzaCat")
                .then()
                .statusCode(200)
                .extract()
                .response();
        String jsonBody = response.getBody().asString();
        JSONArray data = new JSONArray(jsonBody);
        String oracolo = "[{\"categoriaId\":1,\"nomeCat\":\"Panini\",\"foto\":\"DigitalMenu_Server/foto/panini_thumb_menu_0.jpg\"},{\"categoriaId\":2,\"nomeCat\":\"Gelati e  dessert\",\"foto\":\"DigitalMenu_Server/foto/gelati_dessert--header-icon-2003.jpg\"},{\"categoriaId\":3,\"nomeCat\":\"Patatine\",\"foto\":\"DigitalMenu_Server/foto/patatine_thumb_menu.jpg\"},{\"categoriaId\":4,\"nomeCat\":\"Bibite\",\"foto\":\"DigitalMenu_Server/foto/bibite_menu.png\"},{\"categoriaId\":5,\"nomeCat\":\"Insalate\",\"foto\":\"DigitalMenu_Server/foto/insalata_menu.png\"},{\"categoriaId\":6,\"nomeCat\":\"Fritti\",\"foto\":\"DigitalMenu_Server/foto/fritti_menu.jpeg\"}]";
        JSONAssert.assertEquals(oracolo, data, false);
    }
}
