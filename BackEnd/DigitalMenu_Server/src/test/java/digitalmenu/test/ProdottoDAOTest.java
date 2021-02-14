/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmenu.test;

import com.dlmc.digitalmenu_server.beans.IngredienteBean;
import com.dlmc.digitalmenu_server.beans.ProdottoBean;
import com.dlmc.digitalmenu_server.dao.CategoriaDAO;
import com.dlmc.digitalmenu_server.dao.ProdottoDAO;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anto
 */
public class ProdottoDAOTest {

    String oracolo;
    ProdottoBean proEsistente = new ProdottoBean();
    ProdottoBean proNonEsistente = new ProdottoBean();
    ProdottoBean proMinZero = new ProdottoBean();

    public ProdottoDAOTest() {
    }

    @Before
    public void setUp() {

        //BUONO
        proEsistente.setPrezzo(4.0);
        proEsistente.setFoto("DigitalMenu_Server\\foto\\patatine_bacon.png");
        proEsistente.setNome("Patatine Barbeque");
        proEsistente.addIngrediente(new ArrayList<IngredienteBean>());
        proEsistente.setProdottoId(2);

        //IDP NON ESIETE
        proNonEsistente.setPrezzo(4.0);
        proNonEsistente.setFoto("DigitalMenu_Server\\foto\\patatine_bacon.png");
        proNonEsistente.setNome("Patatine Barbeque");
        proNonEsistente.addIngrediente(new ArrayList<IngredienteBean>());
        proNonEsistente.setProdottoId(99999);

        //IDP < 0
        proMinZero.setPrezzo(4.0);
        proMinZero.setFoto("DigitalMenu_Server\\foto\\patatine_bacon.png");
        proMinZero.setNome("Patatine Barbeque");
        proMinZero.addIngrediente(new ArrayList<IngredienteBean>());
        proMinZero.setProdottoId(-1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test_getPrdotto() {
        assertFalse(ProdottoDAO.getPrdotto(proMinZero.getProdottoId()) != null);
        assertTrue(ProdottoDAO.getPrdotto(proNonEsistente.getProdottoId()).getNome() == null);
        assertTrue(ProdottoDAO.getPrdotto(proEsistente.getProdottoId()) != null);
    }
    
    @Test
    public void test_controlloProdotto() {
        assertFalse(ProdottoDAO.controlloProdotto(proMinZero.getProdottoId()) );
        assertFalse(ProdottoDAO.controlloProdotto(proNonEsistente.getProdottoId()) );
        assertTrue(ProdottoDAO.controlloProdotto(proEsistente.getProdottoId()) );
    }

}
