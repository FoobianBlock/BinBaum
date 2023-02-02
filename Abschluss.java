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
    void inorderAusgeben() { }

    @Override
    void preorderAusgeben() { }

    @Override
    void postorderAusgeben() { }

    @Override
    int tiefeGeben(String suchSchluessel) {
        return -1;
    }
}