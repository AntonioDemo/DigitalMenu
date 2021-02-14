/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmenu.test;

import com.dlmc.digitalmenu_server.beans.IngredienteBean;
import com.dlmc.digitalmenu_server.beans.ProdottoBean;
import com.dlmc.digitalmenu_server.dao.IngredienteDAO;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anto
 */
public class IngredienteDAOTest {

      String oracolo;
    ProdottoBean proEsistente = new ProdottoBean();
    ProdottoBean proNonEsistente = new ProdottoBean();
    ProdottoBean proMinZero = new ProdottoBean();
    public IngredienteDAOTest() {
    }

    @Before
    public void setUp() {

        //BUONO
        //proEsistente.setPrezzo(4.0);
       // proEsistente.setFoto("DigitalMenu_Server\\foto\\patatine_bacon.png");
        //proEsistente.setNome("Patatine Barbeque");
       // proEsistente.addIngrediente(new ArrayList<IngredienteBean>());
        proEsistente.setProdottoId(9);

        //IDP NON ESIETE
       // proNonEsistente.setPrezzo(4.0);
       // proNonEsistente.setFoto("DigitalMenu_Server\\foto\\patatine_bacon.png");
       // proNonEsistente.setNome("Patatine Barbeque");
       // proNonEsistente.addIngrediente(new ArrayList<IngredienteBean>());
        proNonEsistente.setProdottoId(99999);

        //IDP < 0
       // proMinZero.setPrezzo(4.0);
       // proMinZero.setFoto("DigitalMenu_Server\\foto\\patatine_bacon.png");
       // proMinZero.setNome("Patatine Barbeque");
       // proMinZero.addIngrediente(new ArrayList<IngredienteBean>());
        proMinZero.setProdottoId(-1);
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void test_getAllIngredientiByPro() {
        assertTrue(IngredienteDAO.getAllIngredientiByPro(proMinZero.getProdottoId()).isEmpty());
        assertTrue(IngredienteDAO.getAllIngredientiByPro(proNonEsistente.getProdottoId()).isEmpty());
        assertFalse(IngredienteDAO.getAllIngredientiByPro(proEsistente.getProdottoId()).isEmpty());
    }
}
