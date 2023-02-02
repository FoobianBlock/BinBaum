public abstract class Baumelement {
    abstract Datenelement suchen(String vergleich);
    abstract Baumelement einfuegen(Datenelement d);
    abstract void inorderAusgeben();
}
