public class Binbaum {
    private Baumelement Wurzel;

    public Binbaum() {
        Wurzel = new Abschluss();
    }

    public Datenelement suchen(String vergleich) {
        return Wurzel.suchen(vergleich);
    }

    public void einfuegen(Datenelement d) {
        Wurzel = Wurzel.einfuegen(d);
    }

    public void inorderAusgeben() {
        Wurzel.inorderAusgeben();
    }

    public int tiefeGeben(String suchSchluessel) {
        return Wurzel.tiefeGeben(suchSchluessel);
    }
}
