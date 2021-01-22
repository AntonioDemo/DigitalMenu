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
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;


/**
 *
 * @author Anto
 */
public class GestioneCategoriaTest {

    public GestioneCategoriaTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    @Test
    public void getAllPiattiByCat() throws JSONException {

        Response response = given()
                .when()
                .get("http://localhost:8080/DigitalMenu_Server/GestioneCategoria?id=2")
                .then()
                .statusCode(200)
                .extract()
                .response();
        String jsonBody = response.getBody().asString();
        JSONArray data = new JSONArray(jsonBody);
        String oracolo = "[{\"prodottoId\":3,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\galak.png\",\"nome\":\"Galak\",\"listaIngredienti\":null},{\"prodottoId\":20,\"prezzo\":3.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\king_fusion_oreo.png\",\"nome\":\"King Fusion Oreo\",\"listaIngredienti\":null},{\"prodottoId\":21,\"prezzo\":3.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\king-fusion-nescafe-02-pl.png\",\"nome\":\"King Fusion Nescafe\",\"listaIngredienti\":null}]";
        JSONAssert.assertEquals(oracolo, data, false);
    }
}
