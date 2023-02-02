public class BaumProjekt {
    public static void main(String[] args) {
        WOERTERBUCH woerterbaum = new WOERTERBUCH();
        woerterbaum.inorderAusgeben();
        woerterbaum.suchen("Hilfe");
        woerterbaum.suchen("Holz");
    }
}
