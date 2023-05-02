public class BaumProjekt {
    public static void main(String[] args) {
        WOERTERBUCH woerterbaum = new WOERTERBUCH();

        try {
            woerterbaum.datenLaden();
            woerterbaum.datenSpeichern();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        /*
            Bitte entferne die Kommentare und die Tests
        */

        //System.out.println("\n-- Inorder Test --");
        //woerterbaum.inorderAusgeben();
        //System.out.println("\n-- Postorder Test --");
        //woerterbaum.postorderAusgeben();

        System.out.println("\n-- Preorder Test --");
        woerterbaum.preorderAusgeben();

        //System.out.println("\n-- Suchen Test --");
        //woerterbaum.suchen("Hilfe");
        //woerterbaum.suchen("Holz");

        //System.out.println("\n-- Tiefe Test --");
        //woerterbaum.tiefeTesten();
    }
}