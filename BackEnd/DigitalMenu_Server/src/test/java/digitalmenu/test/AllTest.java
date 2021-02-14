package digitalmenu.test;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class AllTest {

    public static TestSuite suite() {
        TestSuite suit = new TestSuite();
        suit.addTest(GestioneOrdineTest.suite());
        suit.addTest(GestioneCategoriaTest.suite());
        suit.addTest(GestioneProdottoTest.suite());
        suit.addTest(GestoreStatoOrdineTest.suite());
        suit.addTest(VisualizzaOrdiniPagatiTest.suite());
        return suit;
    }

    public static void main(String args[]) {
        TestRunner.run(suite());
    }
}
