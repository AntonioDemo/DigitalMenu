package digitalmenu.test;

import com.dlmc.digitalmenu_server.beans.CategoriaBean;
import com.dlmc.digitalmenu_server.dao.CategoriaDAO;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Anto
 */
public class CategoriaDAOTest extends TestCase {

    String oracolo;
    CategoriaBean catEsistente = new CategoriaBean();
    CategoriaBean catNonEsistente = new CategoriaBean();
    CategoriaBean catMinZero = new CategoriaBean();

    @Before
    @Override
    public void setUp() throws IOException {

        //BUONO
        catEsistente.setFoto("DigitalMenu_Server/foto/panini_menu.jpeg");
        catEsistente.setNomeCat("Panini");
        catEsistente.setCategoriaId(1);
        //CATEGORIA NON ESISTE
        catNonEsistente.setFoto("DigitalMenu_Server/foto/panini_menu.jpeg");
        catNonEsistente.setNomeCat("Panini");
        catNonEsistente.setCategoriaId(7);
        //CATEGORIA < 0
        catMinZero.setFoto("DigitalMenu_Server/foto/panini_menu.jpeg");
        catMinZero.setNomeCat("Panini");
        catMinZero.setCategoriaId(-1);

    }

    public void test_getAllPiattiByCat() {
        assertTrue(CategoriaDAO.getAllPiattiByCat(catNonEsistente.getCategoriaId()).isEmpty());
        assertTrue(CategoriaDAO.getAllPiattiByCat(catMinZero.getCategoriaId()).isEmpty());
        assertFalse(CategoriaDAO.getAllPiattiByCat(catEsistente.getCategoriaId()).isEmpty());
    }

    public void test_controlloCategoria() {
        assertFalse(CategoriaDAO.controlloCategoria(catMinZero.getCategoriaId()));
        assertFalse(CategoriaDAO.controlloCategoria(catNonEsistente.getCategoriaId()));
        assertTrue(CategoriaDAO.controlloCategoria(catEsistente.getCategoriaId()));
    }

    public void test_getAllCat() {
        //assertFalse(CategoriaDAO.getAllCat().contains(catNonEsistente));
        //assertFalse(CategoriaDAO.getAllCat().contains(catMinZero));
        assertFalse(CategoriaDAO.getAllCat().get(0).getCategoriaId() == catMinZero.getCategoriaId());
        assertFalse(CategoriaDAO.getAllCat().get(0).getCategoriaId() == catNonEsistente.getCategoriaId());
        assertTrue(CategoriaDAO.getAllCat().get(0).getCategoriaId() == catEsistente.getCategoriaId());
        
    }

    public static TestSuite suite() {
        return new TestSuite(CategoriaDAOTest.class);

    }
}
