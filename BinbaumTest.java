// Import zum Zeitmessen
import static java.lang.System.nanoTime;
// Hier impotieren wir alle Methoden und Klassen für JUnit (JUNIT 4.1.3)
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

    // Die folgenden Zweimethoden sind Hilfsmethoden.
    // Diese Methode erstellt einen vollen Binbaum (sprich einen Binbaum, der schon mehrere Datenelemente enthält)
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

    // Diese Methode überprüft, ob ein Datenelement in einem Binbaum existiert
    // Wir verwenden hierfür die eingebaute Suche und geben jenachdem einen boolean (true/false) zurück.
    private boolean existiertElement(String wort) {
        Datenelement d = binbaum.suchen(wort);
        // d.infoAusgeben();
        return d != null;
    }

    // Diese Methode wird vor jeder Test Methode ausgeführt
    @Before // Hier sagen wir Java, das eine JUnit Methode folgt, die vor der eigentlichen Test Methode ausgeführt wird.
    public void setUp() {
        binbaum = vollenBinbaumErstellen(); // Hier erstellen wir für jede Test Methode einen vollen Binbaum
        starttime = nanoTime(); // Zum Zeitmessen - Wir setzen die Startzeit der Test Methode auf die jetzige Zeit in Nanosekunden
        System.out.println("===== STARTE JUNIT TEST =====");
    }

    // Diese Methode wird nach jeder Test Methode ausgeführt
    @After
    public void tearDown() {
        // Zeitmessen - Wir setzen nun die Endzeit der Methode auf die jetzige Zeit in Nanosekunden
        endtime = nanoTime();
        // Wir setzen nun die Endzeit der Methode auf die jetzige Zeit in Nanosekunden.
        // Um auf die Zeit zu kommen, die die Test Methode benötigt hat müssen wir die Startzeit von der Endzeit subtrahieren.
        System.out.println("\n\nDie Methode hat " + (endtime - starttime)/1000000 + " ms benötigt.\n");
    }

    // In dieser Methode testen wir das Einfuegen von einzelnen WOERTERBUCHEINTRAEGEN in den Binbaum
    @Test // Hier sagen wir JUnit, das die folgende Funktion eine Test-Funktion ist
    public void einzelnEinfuegen() { // Test Funktionen sollten keine Argumente annehmen und void zurückgeben.
        // Einen Wörterbucheintrag in den Binbaum einfügen
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Haselnuss", "hazelnut"));
        // Überprüfen ob das Element eingefügt wurde
        // Zum überprüfen benutzen wir assertTrue, eine Methode die von JUnit zur Verfügung gestellt wird
        assertTrue("Das Element wurde nicht in den Binbaum eingefügt!", existiertElement("Haselnuss"));
    }

    // In dieser Methode testen wir das mehrfache einfügen von WOERTERBUCHEINTRAGEN in den Binbaum
    @Test
    public void mehrereEinfuegen() {

        // Einfügen mehrerer Wörterbucheinträge in den Binbaum
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Haus", "House"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Hand", "Hand"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Himmel", "Heaven"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Hoffnung", "Hope"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Heimat", "Home"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Herz", "Heart"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Haltung", "Posture"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Hoffnungslosigkeit", "Hopelessness"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Hölle", "Hell"));
        binbaum.einfuegen(new WOERTERBUCHEINTRAG("Höhe", "Height"));
        // Hier testen wir ob alle Elemente vorhanden sind
        assertTrue("Element Haus wurde nicht gefunden", existiertElement("Haus"));
        assertTrue("Element Hand wurde nicht gefunden", existiertElement("Hand"));
        assertTrue("Element Himmel wurde nicht gefunden", existiertElement("Himmel"));
        assertTrue("Element Hoffnung wurde nicht gefunden", existiertElement("Hoffnung"));
        assertTrue("Element Heimat wurde nicht gefunden", existiertElement("Heimat"));
        assertTrue("Element Herz wurde nicht gefunden", existiertElement("Herz"));
        assertTrue("Element Haltung wurde nicht gefunden", existiertElement("Haltung"));
        assertTrue("Element Hoffnungslosigkeit wurde nicht gefunden", existiertElement("Hoffnungslosigkeit"));
        assertTrue("Element Hölle wurde nicht gefunden", existiertElement("Hölle"));
        assertTrue("Element Höhe wurde nicht gefunden", existiertElement("Höhe"));
    }

    // In dieser Methode testen wir das suchen einzelner WOERTERBUCHEINTRAEGE des Binbaums
    @Test
    public void suchen() {
        String suchtext = "Hund"; // Das Wort nach dem wir suchen wollen
        // Hier rufen wir die eigentliche Suchmethode auf
        Datenelement d = binbaum.suchen(suchtext);
        /*
        * Mithilfe der Methode assertNotNull (Rückgabewert ungleich NULL) testen wir nun ob das Datenelement gefunden wurde
        * Falls das Datenelement nicht gefunden wird meldet die Methode einen Fehler
        * -> Der Test gilt als fehlgeschlagen
        */
        assertNotNull("Das Datenelement wurde nicht gefunden", d);
        // Falls das Datenelement existiert zeigen wir die Informationen zum dem Datenelement an.
        d.infoAusgeben();
    }

    // Hier testen wir ob die Tiefe funktioniert
    @Test
    public void tiefe() {
        String suchen = "Hai"; // Das Wort von dem wir die Tiefe haben woll
        // Hier überprüfen wir mithilfe assertEquals ob der WOERTERBUCHEINTRAG "Hai" die Tiefe 3 hat.
        assertEquals("Falsche Tiefe.", binbaum.tiefeGeben(suchen), 3);
    }

}
