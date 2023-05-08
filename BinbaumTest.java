import static java.lang.System.nanoTime;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinbaumTest {

    long starttime;
    long endtime;
    public BinbaumTest() {



    }

    @BeforeEach
    public void setUp() {
        starttime = nanoTime();
        System.out.println("Starte Test...");
    }

    @AfterEach
    public void tearDown() {
        endtime = nanoTime();
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

    private boolean existiertElement(Binbaum binbaum, String wort) {
        Datenelement d = binbaum.suchen(wort);
        if (d!=null) {
            return d.schluesselIstGleich(wort);
        }
        return false;
    }

    private Binbaum leerenBinbaumErstellen() {
        return new Binbaum();
    }

    /*
    In dieser Methode wollen wir das einfuegen von einzelnen Woertbucheintraegen testen.
    */
    @Test // Hier sagen wir JUnit, das die folgende Funktion eine Test-Funktion ist
    public void einzelnEinfuegen() { // Test Funktionen sollten keine Argumente annehmen und void zurückgeben.
        Binbaum binbaum = leerenBinbaumErstellen(); // Neuen Binbaum erstellen
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Hefe", "yeast")); // Einen Wörterbucheintrag in den Binbaum einfügen
        assertTrue(existiertElement(binbaum, "Hefe"), () -> "Das Element wurde nicht in den Binbaum eingefügt!"); // Überprüfen ob das Element eingefügt wurde
    }

    @Test
    public void suchen() {
        Binbaum binbaum = vollenBinbaumErstellen();
        String suchtext = "Haftung";
        assertTrue(existiertElement(binbaum, suchtext), () -> "Das Element wurde nicht gefunden!");
    }

    @Test
    public void tiefe() {
        Binbaum binbaum = vollenBinbaumErstellen();
        String suchen = "Hai";
        assertEquals(binbaum.tiefeGeben(suchen), "Hai - 3", () -> "Falsche Tiefe.");
    }




}
