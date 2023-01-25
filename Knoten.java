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
                nachfolgerLinks = nachfolgerLinks.einfuegen(d);
            }
            else {
                nachgolferRechts = nachgolferRechts.einfuegen(d);
            }
        }

        return this;
    }
}