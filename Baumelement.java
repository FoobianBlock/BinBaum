import java.util.ArrayList;

public abstract class Baumelement {
    public abstract Datenelement suchen(String vergleich);
    public abstract Baumelement einfuegen(Datenelement d);
    public abstract void inorderAusgeben(ArrayList<Datenelement> datenelements);
    public abstract void preorderAusgeben(ArrayList<Datenelement> datenelements);
    public abstract void postorderAusgeben(ArrayList<Datenelement> datenelements);
    public abstract int tiefeGeben(String suchSchluessel);
}