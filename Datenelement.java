public interface Datenelement {
    /**
        Ausgabe aller Daten eines Elements
    */
    public void infoAusgeben();

    /**
        Vergleichsmethode, um zwei Datenelemente auf Gleichheit zu prüfen
    */
    public boolean istGleich(Datenelement dvergleich);

    /**
        Vergleicht zwei Datenelemente bezüglich der Ordnungsrelation
    */
    public boolean istKleinerAls(Datenelement dvergleich);

    /**
        Vergleicht zwei Datenelemente bezüglich der Ordnungsrelation
    */
    public boolean istGroesserAls(Datenelement dvergleich);
    
    /**
        Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, auf Gleichheit
    */
    public boolean schluesselIstGleich(String vergleichsSchluessel);
    
    /**
        Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, 
        bezüglich der Ordnungsrelation
    */
    public boolean schluesselIstGroesserAls(String vergleichsSchluessel);
}