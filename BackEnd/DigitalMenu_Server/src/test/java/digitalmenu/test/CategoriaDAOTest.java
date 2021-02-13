
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
public class CategoriaDAOTest extends TestCase{

    String oracolo;
    CategoriaBean catEsistente = new CategoriaBean();
    CategoriaBean catNonEsistente = new CategoriaBean();
    CategoriaBean catMinZero = new CategoriaBean();

    @Before
    @Override
    public void setUp() throws IOException {
        
        oracolo = FileUtils.readFileToString(new File("/home/alby/Documenti/DigitalMenu_Server/src/test/ja"
                + "va/digitalmenu/test/jsonCategorie.json"), "utf-8");
        
        //BUONO
        catEsistente = (CategoriaBean) new Gson().fromJson(oracolo, CategoriaBean.class);
        catEsistente.setCategoriaId(1);
        //CATEGORIA NON ESISTE
        catNonEsistente = (CategoriaBean) new Gson().fromJson(oracolo, CategoriaBean.class);
        catNonEsistente.setCategoriaId(7);
        //CATEGORIA < 0
        catMinZero = (CategoriaBean) new Gson().fromJson(oracolo, CategoriaBean.class);
        catMinZero.setCategoriaId(-1);

    }

    public void test_getAllPiattiByCat() {
        assertFalse(CategoriaDAO.getAllPiattiByCat(catNonEsistente.getCategoriaId()) != null);
        assertFalse(CategoriaDAO.getAllPiattiByCat(catMinZero.getCategoriaId()) != null);
        assertTrue(CategoriaDAO.getAllPiattiByCat(catEsistente.getCategoriaId()) !=null);
    }
    
    public void test_controlloCategoria() {
        assertFalse(CategoriaDAO.controlloCategoria(catMinZero.getCategoriaId()));
        assertFalse(CategoriaDAO.controlloCategoria(catNonEsistente.getCategoriaId()));
        assertTrue(CategoriaDAO.controlloCategoria(catEsistente.getCategoriaId()));
    }

    public void test_getAllCat() {
        assertFalse(CategoriaDAO.getAllCat().contains(catNonEsistente));
        assertFalse(CategoriaDAO.getAllCat().contains(catMinZero));
        assertTrue(CategoriaDAO.getAllCat().contains(catEsistente));
    }
     public static TestSuite suite() {
        return new TestSuite(CategoriaDAOTest.class);

    }
}
