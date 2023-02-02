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
    void inorderAusgeben() {
        
    }
}