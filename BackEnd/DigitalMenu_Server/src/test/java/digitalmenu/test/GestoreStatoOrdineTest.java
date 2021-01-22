/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmenu.test;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
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
public class GestoreStatoOrdineTest {
    
    public GestoreStatoOrdineTest() {
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
         /*
     Response response = given()
                .when()
                .get("http://localhost:8080/DigitalMenu_Server/GestoreStatoOrdine?id=140")
                .then()
                .statusCode(200)
                .extract()
                .response();
        String jsonBody = response.getBody().asString();
        JSONObject data = new JSONObject(jsonBody);
        String oracolo = 
                "{\"prodottoId\":1,\"prezzo\":3.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_m.png\",\"nome\":\"Patatine\",\"listaIngredienti\":[]}";
        JSONAssert.assertEquals(oracolo, data, false);
*/
     }

}
