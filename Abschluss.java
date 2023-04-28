import java.util.ArrayList;

public class Abschluss extends Baumelement {
    public Abschluss() {
        
    }

    @Override
    Datenelement suchen(String vergleich) {
        return null;
    }

    @Override
    Baumelement einfuegen(Datenelement d) {        
        return new Knoten(d);
    }

    @Override
    void inorderAusgeben(ArrayList<Datenelement> datenelements) { }

    @Override
    void preorderAusgeben(ArrayList<Datenelement> datenelements) { }

    @Override
    void postorderAusgeben(ArrayList<Datenelement> datenelements) { }

    @Override
    int tiefeGeben(String suchSchluessel) {
        return -1;
    }
}