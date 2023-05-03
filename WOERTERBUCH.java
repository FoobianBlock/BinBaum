import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
    TEST-Klasse
*/
public class WOERTERBUCH {
    /**
        Implementierung des Wörterbuchs als geordneter Binärbaum
    */
    private Binbaum woerterbuch;

    /**
        Konstruktor für Objekte der Klasse WOERTERBUCH, erzeugt ein Wörterbuch mit 12
        Einträgen
    */
    public WOERTERBUCH() {
        woerterbuch = new Binbaum();

        /*
            Bitte entferne die Kommentare
        */

        // Baum mit Daten füllen:
        /*
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
        */
    }

    /**
        Einfuegen erzeugt ein Objekt der Klasse WOERTERBUCHEINTRAG mit den
        Eingabewerten und
        fügt diesen Wörterbucheintrag sortiert in die Liste woerterbuch ein. Es wird
        verhindert,
        dass ein deutsches Wort mehrfach im Wörterbuch abgespeichert werden kann.

        @param wort      deutsches Wort
        @param bedeutung die englische Bedeutung.
    */
    public void einfuegen(String wort, String bedeutung) {
        woerterbuch.einfuegen(new WOERTERBUCHEINTRAG(wort, bedeutung));
    }

    public void suchen(String wort) {
        Datenelement w = woerterbuch.suchen(wort);
        System.out.println("*****************************");
        System.out.print("Der gesuchte Eintrag...");

        if(w == null) {
            System.out.println("... wurde NICHT gefunden!");
        } else {
            w.infoAusgeben();
        }

        System.out.println("*****************************");
    }

    public void inorderAusgeben() {
        woerterbuch.inorderAusgeben();
    }

    public void preorderAusgeben() {
        woerterbuch.preorderAusgeben();
    }

    public void postorderAusgeben() {
        woerterbuch.postorderAusgeben();
    }

    public void tiefeTesten() {
        String suche = "Heilige";
        System.out.println(suche + " - " + woerterbuch.tiefeGeben(suche));
    }

    // ------ SQL ------

    public void datenSpeichern() throws Exception {
        // Verbindung zur Datenbank herstellen
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:sqlite:woerterbuch.db");
        PreparedStatement ps;

        // Tabelle erstellen falls sie noch nicht existiert
        ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS woerter (id INTEGER PRIMARY KEY AUTOINCREMENT, de VARCHAR(255) not null, en VARCHAR(255) not null)");
        ps.executeUpdate();

        // Datenbank vor dem neuen Eintragen der BinBaum Daten leeren
        ps = connection.prepareStatement("DELETE FROM woerter");
        ps.executeUpdate();

        // Daten aus dem BinBaum erhalten
        ArrayList<Datenelement> datenelements = woerterbuch.preorderAusgeben();

        
        // In Datenbank einfügen
        ps = connection.prepareStatement("INSERT INTO woerter(de, en) VALUES(?,?)");

        for (int i = 0; i < datenelements.size(); i++) {
            ps.setString(1, ((WOERTERBUCHEINTRAG) datenelements.get(i)).gibDeutschesWort());
            ps.setString(2, ((WOERTERBUCHEINTRAG) datenelements.get(i)).gibEnglischesWort());
            ps.executeUpdate();
        }

        connection.close();
    }

    public void datenLaden() throws Exception {
        // Verbindung zur Datenbank herstellen
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:sqlite:woerterbuch.db");
        PreparedStatement ps;

        // Tabelle erstellen falls sie noch nicht existiert
        ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS woerter (id INTEGER PRIMARY KEY AUTOINCREMENT, de VARCHAR(255) not null, en VARCHAR(255) not null)");
        ps.executeUpdate();

        // Alle Einträge der Datenbank in einem ResultSet speichern
        ps = connection.prepareStatement("SELECT * FROM woerter");
        ResultSet rs = ps.executeQuery();

        // Daten in BinBaum übertragen
        while(rs.next()) {
            einfuegen(rs.getString("de"), rs.getString("en"));
        }

        connection.close();
    }

    public void baumLeeren() {
        woerterbuch.baumLeeren();
    }
}