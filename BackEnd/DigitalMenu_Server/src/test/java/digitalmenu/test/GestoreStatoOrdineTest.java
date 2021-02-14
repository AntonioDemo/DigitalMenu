/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmenu.test;

import com.dlmc.digitalmenu_server.beans.OrdineBean;
import com.dlmc.digitalmenu_server.dao.OrdineDAO;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anto
 */
public class GestoreStatoOrdineTest extends TestCase{
    int oracolo=1;
    OrdineBean b = new OrdineBean();
    OrdineBean b1 = new OrdineBean();
    OrdineBean b2 = new OrdineBean();
    OrdineBean b3 = new OrdineBean();
    
    public GestoreStatoOrdineTest() {
    }
    
    
    @Before
    public void setUp() {
        //IDORDINE < 0
        b.setOrdineId(-3);
        //IDORDINE NON ESISTE
        b1.setOrdineId(200);
        //STATO < 0
        b2.setOrdineId(1);
        b2.setStato_c(-5);        
        //BUONO
        b3.setOrdineId(1);
        b3.setStato_c(1);
        oracolo=b3.getStato();
    }
    
    @After
    public void tearDown() {
       OrdineDAO.setstato(b3.getOrdineId(), 1);
    }

    
    @Test
     public void test_setStato() throws JSONException {
         
     Response response = given()
                .when()
                .get("http://localhost:8080/DigitalMenu_Server/GestoreStatoOrdine?id="+b3.getOrdineId())
                .then()
                .statusCode(200)
                .extract()
                .response();
     }
     @Test
     public void test_TC_UC_AC_2_1(){
         assertFalse(b.getOrdineId()>0);
     }
     
     @Test
     public void test_TC_UC_AC_2_2(){
         assertTrue(b1.getOrdineId()>0);
         assertFalse(OrdineDAO.idEsiste(b1.getOrdineId()));
     }
     
     @Test
     public void test_TC_UC_AC_2_3(){
         assertTrue(b2.getOrdineId()>0);
         assertTrue(OrdineDAO.idEsiste(b2.getOrdineId()));
         assertFalse(b2.getStato()>0 && b2.getStato()<3 && b2.getStato()==oracolo);
     }
     
     @Test
     public void test_TC_UC_AC_2_4(){
         assertTrue(b3.getOrdineId()>0);
         assertTrue(OrdineDAO.idEsiste(b3.getOrdineId()));
         assertTrue(b3.getStato()>0 && b3.getStato()<3 && b3.getStato()==oracolo);
     }
     

         public static TestSuite suite() {
        return new TestSuite(GestoreStatoOrdineTest.class);

    }
}
