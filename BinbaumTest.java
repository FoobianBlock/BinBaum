import static java.lang.System.nanoTime;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinbaumTest {

    Binbaum binbaum;
    long starttime;
    long endtime;
    public BinbaumTest() {

    }

    private Binbaum vollenBinbaumErstellen() {
        Binbaum binbaum = new Binbaum();

        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Heilige", "saint"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Hebamme", "midwife"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Haftung", "liability"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Haare", "hair"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Hai", "shark"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Heber", "lifter"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Hefe", "yeast"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Holz", "wood"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Hilfe", "help"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Hund", "dog"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Huhn", "chicken"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Husten", "cough"));

        return binbaum;
    }

    @Before
    public void setUp() {
        binbaum = vollenBinbaumErstellen();
        starttime = nanoTime();
        System.out.println("===== STARTE JUNIT TEST =====");
    }

    @After
    public void tearDown() {
        endtime = nanoTime();
        System.out.println("\n\nDie Methode hat " + (endtime - starttime)/1000000 + " ms benötigt.\n");
    }

    private boolean existiertElement(String wort) {
        Datenelement d = binbaum.suchen(wort);
        if (d!=null) {
            return true;
        }
        return false;
    }

    /*
    In dieser Methode wollen wir das einfuegen von einzelnen Woertbucheintraegen testen.
    */
    @Test // Hier sagen wir JUnit, das die folgende Funktion eine Test-Funktion ist
    public void einzelnEinfuegen() { // Test Funktionen sollten keine Argumente annehmen und void zurückgeben.
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Haselnuss", "hazelnutt")); // Einen Wörterbucheintrag in den Binbaum einfügen
        assertTrue("Das Element wurde nicht in den Binbaum eingefügt!", existiertElement("Hasselnuss")); // Überprüfen ob das Element eingefügt wurde
    }

    @Test
    public void suchen() {
        String suchtext = "Hund";

        Datenelement d = binbaum.suchen(suchtext);
        assertNotNull("Das Datenelement wurde nicht gefunden", d);
        d.infoAusgeben();
    }

    @Test
    public void tiefe() {
        String suchen = "Hai";
        assertEquals("Falsche Tiefe.", binbaum.tiefeGeben(suchen), 3);
    }

}
