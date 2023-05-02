import java.util.ArrayList;

public class Binbaum {
    private Baumelement wurzel;

    public Binbaum() {
        wurzel = new Abschluss();
    }

    public Datenelement suchen(String vergleich) {
        return wurzel.suchen(vergleich);
    }

    public void einfuegen(Datenelement d) {
        wurzel = wurzel.einfuegen(d);
    }

    public ArrayList<Datenelement> inorderAusgeben() {
        ArrayList<Datenelement> datenelements = new ArrayList<>();
        wurzel.inorderAusgeben(datenelements);
        return datenelements;
    }

    public ArrayList<Datenelement> preorderAusgeben() {
        ArrayList<Datenelement> datenelements = new ArrayList<>();
        wurzel.preorderAusgeben(datenelements);
        return datenelements;
    }

    public ArrayList<Datenelement> postorderAusgeben() {
        ArrayList<Datenelement> datenelements = new ArrayList<>();
        wurzel.postorderAusgeben(datenelements);
        return datenelements;
    }

    public int tiefeGeben(String suchSchluessel) {
        return wurzel.tiefeGeben(suchSchluessel);
    }
}