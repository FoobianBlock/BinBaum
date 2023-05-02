import java.util.ArrayList;

public class Abschluss extends Baumelement {
    public Abschluss() { }

    @Override
    public Datenelement suchen(String vergleich) {
        return null;
    }

    @Override
    public Baumelement einfuegen(Datenelement d) {        
        return new Knoten(d);
    }

    @Override
    public void inorderAusgeben(ArrayList<Datenelement> datenelements) { }

    @Override
    public void preorderAusgeben(ArrayList<Datenelement> datenelements) { }

    @Override
    public void postorderAusgeben(ArrayList<Datenelement> datenelements) { }

    @Override
    public int tiefeGeben(String suchSchluessel) {
        return -1;
    }
}