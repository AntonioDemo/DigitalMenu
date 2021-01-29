/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmenu.test;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
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
public class VisualizzaOrdiniPagatiTest {

    public VisualizzaOrdiniPagatiTest() {
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
    public void hello() throws JSONException, IOException {
        Response response = given()
                .when()
                .post("http://localhost:8080/DigitalMenu_Server/VisualizzaOrdiniPagati")
                .then()
                .statusCode(200)
                .extract()
                .response();
        String jsonBody = response.getBody().asString();
        JSONArray data = new JSONArray(jsonBody);
        
        String oracolo = FileUtils.readFileToString(new File("C:\\Users\\Administrator\\workspace\\Università\\DigitalMenuFileProgetto\\backendBrach\\DigitalMenu\\BackEnd\\DigitalMenu_Server\\src\\test\\java\\digitalmenu\\test\\jsonOrdiniPagati.json"),"utf-8");
        
        JSONAssert.assertEquals(oracolo, data, false);
    }
}
