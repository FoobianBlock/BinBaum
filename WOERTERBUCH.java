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
        //Baum mit Daten füllen:
        einfuegen("Heilige", "saint");
        einfuegen("Hebamme", "midwife");
        einfuegen("Haftung", "liability");
        einfuegen("Haare", "hair");
        einfuegen("Hai", "shark");
        einfuegen("Heber", "lifter");
        einfuegen("Hefe", "yeast");
        einfuegen("Holz", "wood");
        einfuegen("Herz", "heart");
        einfuegen("Hilfe", "help");
        einfuegen("Hund", "dog");
        einfuegen("Huhn", "chicken");
        einfuegen("Husten", "cough");
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

    public void suchen(String wort){
        Datenelement w = woerterbuch.suchen(wort);
        System.out.println("*****************************");
        System.out.print("Der gesuchte Eintrag...");
        if(w == null){
            System.out.println("... wurde NICHT gefunden!");
        }else{
            w.infoAusgeben(); 
        }
        System.out.println("*****************************");
    }
    
    public void inorderAusgeben(){
        // TODO
        // woerterbuch.inorderAusgeben();
    }
}
