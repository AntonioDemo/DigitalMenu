/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmenu.test;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
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
    private static String payload = "{\n" +
"    \"prezzoTotale\": 6,\n" +
"    \"listaProdotti\": [\n" +
"        {\n" +
"            \"prodotto\": {\n" +
"                \"nome\": \"Gran Crispy McBacon\",\n" +
"                \"prodottoId\": 2,\n" +
"                \"prezzo\": 6\n" +
"            },\n" +
"            \"quantita\": 1,\n" +
"            \"deleteing\": \"esempio ingrediente eliminato \"\n" +
"        }\n" +
"    ]\n" +
"}";

    @Test
    public void hello() throws JSONException {

        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("http://localhost:8080/DigitalMenu_Server/GestioneOrdine?idPagamento=0")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}
