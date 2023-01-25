/*
 * TEST-Klasse
 */
public class WOERTERBUCH
{
    /**
     * Implementierung des Wörterbuchs als geordneter Binärbaum 
     */
     private Binbaum woerterbuch;

    /**
     * Konstruktor für Objekte der Klasse WOERTERBUCH, erzeugt ein Wörterbuch mit 12 Einträgen
     */
    public WOERTERBUCH(){
        woerterbuch = new Binbaum();
    }

     /**
     * Einfuegen erzeugt ein Objekt der Klasse WOERTERBUCHEINTRAG mit den Eingabewerten und
     * fügt diesen Wörterbucheintrag sortiert in die Liste woerterbuch ein. Es wird verhindert, 
     * dass ein deutsches Wort mehrfach im Wörterbuch abgespeichert werden kann.
     * @param wort deutsches Wort
     * @param bedeutung die englische Bedeutung.
     */
    public void einfuegen(String wort, String bedeutung){
        woerterbuch.einfuegen(new WOERTERBUCHEINTRAG(wort, bedeutung));
    }

    public void testen()
    {
        einfuegen("Kuchen", "cake");
        einfuegen("Fürsorge", "care");
        einfuegen("Manschette", "cuff");
        einfuegen("Auto", "car");
        einfuegen("Höle", "cave");
        einfuegen("Vorwahl", "code");
        einfuegen("Anruf", "call");
        einfuegen("Münze", "coin");

        woerterbuch.suchen("Manschette").infoAusgeben();
        woerterbuch.suchen("Kuchen").infoAusgeben();
    }
}
