import java.util.ArrayList;

public abstract class Baumelement {
    abstract Datenelement suchen(String vergleich);
    abstract Baumelement einfuegen(Datenelement d);
    abstract void inorderAusgeben(ArrayList<Datenelement> datenelements);
    abstract void preorderAusgeben(ArrayList<Datenelement> datenelements);
    abstract void postorderAusgeben(ArrayList<Datenelement> datenelements);
    abstract int tiefeGeben(String suchSchluessel);
}
