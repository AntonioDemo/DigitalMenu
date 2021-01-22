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
    public void hello() throws JSONException {
        Response response = given()
                .when()
                .post("http://localhost:8080/DigitalMenu_Server/VisualizzaOrdiniPagati")
                .then()
                .statusCode(200)
                .extract()
                .response();
        String jsonBody = response.getBody().asString();
        JSONArray data = new JSONArray(jsonBody);
        String oracolo
                = "[{\"ordineId\":24,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}}]},{\"ordineId\":26,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}}]},{\"ordineId\":38,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":7,\"prezzo\":5.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bronx_steakhouse.png\",\"nome\":\"Bronx Steakhouse\",\"listaIngredienti\":[]}}]},{\"ordineId\":39,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":7,\"prezzo\":5.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bronx_steakhouse.png\",\"nome\":\"Bronx Steakhouse\",\"listaIngredienti\":[]}}]},{\"ordineId\":40,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":3,\"prezzo\":4.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\galak.png\",\"nome\":\"Galak\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}}]},{\"ordineId\":41,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}}]},{\"ordineId\":42,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}}]},{\"ordineId\":43,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":7,\"prezzo\":5.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bronx_steakhouse.png\",\"nome\":\"Bronx Steakhouse\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":1,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_m.png\",\"nome\":\"Patatine\",\"listaIngredienti\":[]}}]},{\"ordineId\":44,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":1,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_m.png\",\"nome\":\"Patatine\",\"listaIngredienti\":[]}}]},{\"ordineId\":49,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":7,\"prezzo\":5.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bronx_steakhouse.png\",\"nome\":\"Bronx Steakhouse\",\"listaIngredienti\":[]}},{\"quantita\":2,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":1,\"prezzo\":10.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_m.png\",\"nome\":\"Patatine\",\"listaIngredienti\":[]}}]},{\"ordineId\":50,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":7,\"prezzo\":5.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bronx_steakhouse.png\",\"nome\":\"Bronx Steakhouse\",\"listaIngredienti\":[]}},{\"quantita\":2,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":1,\"prezzo\":10.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_m.png\",\"nome\":\"Patatine\",\"listaIngredienti\":[]}}]},{\"ordineId\":55,\"stato\":2,\"listaProdotti\":[{\"quantita\":5,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":7,\"prezzo\":27.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bronx_steakhouse.png\",\"nome\":\"Bronx Steakhouse\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}}]},{\"ordineId\":56,\"stato\":1,\"listaProdotti\":[{\"quantita\":5,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":7,\"prezzo\":27.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bronx_steakhouse.png\",\"nome\":\"Bronx Steakhouse\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}}]},{\"ordineId\":57,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":7,\"prezzo\":5.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bronx_steakhouse.png\",\"nome\":\"Bronx Steakhouse\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":1,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_m.png\",\"nome\":\"Patatine\",\"listaIngredienti\":[]}}]},{\"ordineId\":66,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":3,\"prezzo\":4.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\galak.png\",\"nome\":\"Galak\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":1,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_m.png\",\"nome\":\"Patatine\",\"listaIngredienti\":[]}}]},{\"ordineId\":70,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":3,\"prezzo\":4.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\galak.png\",\"nome\":\"Galak\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":1,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_m.png\",\"nome\":\"Patatine\",\"listaIngredienti\":[]}}]},{\"ordineId\":71,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":3,\"prezzo\":4.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\galak.png\",\"nome\":\"Galak\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":1,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_m.png\",\"nome\":\"Patatine\",\"listaIngredienti\":[]}}]},{\"ordineId\":72,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":3,\"prezzo\":4.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\galak.png\",\"nome\":\"Galak\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":1,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_m.png\",\"nome\":\"Patatine\",\"listaIngredienti\":[]}}]},{\"ordineId\":74,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":7,\"prezzo\":5.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bronx_steakhouse.png\",\"nome\":\"Bronx Steakhouse\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":1,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_m.png\",\"nome\":\"Patatine\",\"listaIngredienti\":[]}}]},{\"ordineId\":75,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":7,\"prezzo\":5.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bronx_steakhouse.png\",\"nome\":\"Bronx Steakhouse\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}}]},{\"ordineId\":76,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":7,\"prezzo\":5.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bronx_steakhouse.png\",\"nome\":\"Bronx Steakhouse\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":3,\"prezzo\":4.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\galak.png\",\"nome\":\"Galak\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":1,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_m.png\",\"nome\":\"Patatine\",\"listaIngredienti\":[]}}]},{\"ordineId\":77,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":7,\"prezzo\":5.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bronx_steakhouse.png\",\"nome\":\"Bronx Steakhouse\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":1,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_m.png\",\"nome\":\"Patatine\",\"listaIngredienti\":[]}}]},{\"ordineId\":78,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}}]},{\"ordineId\":79,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":2,\"prezzo\":6.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_bacon.png\",\"nome\":\"Patatine Barbeque\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":1,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\patatine_m.png\",\"nome\":\"Patatine\",\"listaIngredienti\":[]}}]},{\"ordineId\":80,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":21,\"prezzo\":3.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\king-fusion-nescafe-02-pl.png\",\"nome\":\"King Fusion Nescafe\",\"listaIngredienti\":[]}},{\"quantita\":2,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":17,\"prezzo\":9.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\insalata_di_pollo_croccante.png\",\"nome\":\"Insalata Pollo Croccante\",\"listaIngredienti\":[]}},{\"quantita\":2,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":16,\"prezzo\":8.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\king_nuggets_x9_v2.png\",\"nome\":\"King Nuggets\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":13,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\prodotto-scontornato-pollo.png\",\"nome\":\"Scontornato Pollo\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":11,\"prezzo\":4.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bbq_beef_wrap.png\",\"nome\":\"Barbeque Wrap\",\"listaIngredienti\":[]}}]},{\"ordineId\":84,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":8,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\cheeseburger.png\",\"nome\":\"Cheeseburger\",\"listaIngredienti\":[]}}]},{\"ordineId\":85,\"stato\":2,\"listaProdotti\":[{\"quantita\":4,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":9,\"prezzo\":28.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\big_king_nueva.png\",\"nome\":\"Big King Nueva\",\"listaIngredienti\":[]}}]},{\"ordineId\":87,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":11,\"prezzo\":4.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bbq_beef_wrap.png\",\"nome\":\"Barbeque Wrap\",\"listaIngredienti\":[]}}]},{\"ordineId\":88,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":10,\"prezzo\":6.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\whopper.png\",\"nome\":\"Whopper\",\"listaIngredienti\":[]}}]},{\"ordineId\":90,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":9,\"prezzo\":7.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\big_king_nueva.png\",\"nome\":\"Big King Nueva\",\"listaIngredienti\":[]}}]},{\"ordineId\":91,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":11,\"prezzo\":4.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bbq_beef_wrap.png\",\"nome\":\"Barbeque Wrap\",\"listaIngredienti\":[]}}]},{\"ordineId\":94,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":12,\"prezzo\":5.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\crunchicken.png\",\"nome\":\"Cruchicken\",\"listaIngredienti\":[]}}]},{\"ordineId\":96,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":10,\"prezzo\":6.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\whopper.png\",\"nome\":\"Whopper\",\"listaIngredienti\":[]}}]},{\"ordineId\":97,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":13,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\prodotto-scontornato-pollo.png\",\"nome\":\"Scontornato Pollo\",\"listaIngredienti\":[]}}]},{\"ordineId\":99,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":13,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\prodotto-scontornato-pollo.png\",\"nome\":\"Scontornato Pollo\",\"listaIngredienti\":[]}}]},{\"ordineId\":102,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":10,\"prezzo\":6.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\whopper.png\",\"nome\":\"Whopper\",\"listaIngredienti\":[]}}]},{\"ordineId\":103,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":13,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\prodotto-scontornato-pollo.png\",\"nome\":\"Scontornato Pollo\",\"listaIngredienti\":[]}}]},{\"ordineId\":104,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":11,\"prezzo\":4.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bbq_beef_wrap.png\",\"nome\":\"Barbeque Wrap\",\"listaIngredienti\":[]}}]},{\"ordineId\":109,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":13,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\prodotto-scontornato-pollo.png\",\"nome\":\"Scontornato Pollo\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":12,\"prezzo\":5.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\crunchicken.png\",\"nome\":\"Cruchicken\",\"listaIngredienti\":[]}}]},{\"ordineId\":112,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":13,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\prodotto-scontornato-pollo.png\",\"nome\":\"Scontornato Pollo\",\"listaIngredienti\":[]}}]},{\"ordineId\":117,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":13,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\prodotto-scontornato-pollo.png\",\"nome\":\"Scontornato Pollo\",\"listaIngredienti\":[]}}]},{\"ordineId\":136,\"stato\":2,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":13,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\prodotto-scontornato-pollo.png\",\"nome\":\"Scontornato Pollo\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":12,\"prezzo\":5.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\crunchicken.png\",\"nome\":\"Cruchicken\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":11,\"prezzo\":4.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\bbq_beef_wrap.png\",\"nome\":\"Barbeque Wrap\",\"listaIngredienti\":[]}}]},{\"ordineId\":137,\"stato\":1,\"listaProdotti\":[{\"quantita\":5,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":18,\"prezzo\":25.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\insalata_con_tonno_rio_di_mare.png\",\"nome\":\"Insalata Tonno\",\"listaIngredienti\":[]}},{\"quantita\":6,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":9,\"prezzo\":42.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\big_king_nueva.png\",\"nome\":\"Big King Nueva\",\"listaIngredienti\":[]}}]},{\"ordineId\":139,\"stato\":1,\"listaProdotti\":[{\"quantita\":22,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":23,\"prezzo\":110.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\birra_m.png\",\"nome\":\"Birra\",\"listaIngredienti\":[]}},{\"quantita\":4,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":15,\"prezzo\":12.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\chili_cheese_bites_x6.png\",\"nome\":\"Chili Cheese Bites\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":13,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\prodotto-scontornato-pollo.png\",\"nome\":\"Scontornato Pollo\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":9,\"prezzo\":7.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\big_king_nueva.png\",\"nome\":\"Big King Nueva\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":8,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\cheeseburger.png\",\"nome\":\"Cheeseburger\",\"listaIngredienti\":[]}}]},{\"ordineId\":140,\"stato\":1,\"listaProdotti\":[{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":21,\"prezzo\":3.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\king-fusion-nescafe-02-pl.png\",\"nome\":\"King Fusion Nescafe\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":20,\"prezzo\":3.5,\"foto\":\"DigitalMenu_Server\\\\foto\\\\king_fusion_oreo.png\",\"nome\":\"King Fusion Oreo\",\"listaIngredienti\":[]}},{\"quantita\":1,\"deleteing\":\"esempio ingrediente eliminato \",\"prodotto\":{\"prodottoId\":3,\"prezzo\":5.0,\"foto\":\"DigitalMenu_Server\\\\foto\\\\galak.png\",\"nome\":\"Galak\",\"listaIngredienti\":[]}}]}]";
        JSONAssert.assertEquals(oracolo, data, false);
    }
}
