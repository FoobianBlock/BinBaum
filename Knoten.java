public class Knoten extends Baumelement {
    private Baumelement nachfolgerLinks;
    private Baumelement nachgolferRechts;
    private Datenelement daten; 

    public Knoten(Datenelement d) {
        nachfolgerLinks = new Abschluss();
        nachgolferRechts = new Abschluss();
        this.daten = d;

    }

    /*
    public Knoten(Datenelement d, Baumelement LiNf, Baumelement RiNf) {

    }
    */

    @Override
    Datenelement suchen(String vergleich) {
        if(daten.schluesselIstGleich(vergleich)) {
            return daten;
        }
        else {
            if(daten.schluesselIstGroesserAls(vergleich)) {
                return nachfolgerLinks.suchen(vergleich);
            } 
            else {
                return nachgolferRechts.suchen(vergleich);
            }
        }
    }

    @Override
    Baumelement einfuegen(Datenelement d) {
        if(d.istGleich(daten)) {
            System.out.println("Datenelement ist bereits vorhanden und wird nicht eingefügt");
        }
        else {
            if(d.istGroesserAls(daten)) {
                nachgolferRechts = nachgolferRechts.einfuegen(d);
            }
            else {
                nachfolgerLinks = nachfolgerLinks.einfuegen(d);
            }
        }

        return this;
    }

    @Override
    void inorderAusgeben() {
        nachfolgerLinks.inorderAusgeben();
        daten.infoAusgeben();
        nachgolferRechts.inorderAusgeben();
    }

    @Override
    void preorderAusgeben() {
        daten.infoAusgeben();
        nachfolgerLinks.preorderAusgeben();
        nachgolferRechts.preorderAusgeben();
    }

    @Override
    void postorderAusgeben() {
        nachfolgerLinks.postorderAusgeben();
        nachgolferRechts.postorderAusgeben();
        daten.infoAusgeben();
    }

    @Override
    int tiefeGeben(String suchSchluessel) {
        if(daten.schluesselIstGleich(suchSchluessel)) {
            return 0;
        }
        else {
            if(daten.schluesselIstGroesserAls(suchSchluessel)) {
                int t = nachfolgerLinks.tiefeGeben(suchSchluessel);

                if(t == -1) {
                    return -1;
                }
                else {
                    return t + 1;
                }
            }
            else {
                int t = nachgolferRechts.tiefeGeben(suchSchluessel);

                if(t == -1) {
                    return -1;
                }
                else {
                    return t + 1;
                }
            }
        }
    }
}