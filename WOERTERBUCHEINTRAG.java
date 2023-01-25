
public class WOERTERBUCHEINTRAG implements Datenelement{
    private String deutsch; 
    private String englisch;

    public WOERTERBUCHEINTRAG(String deutsch, String englisch){
        this.deutsch = deutsch;
        this.englisch = englisch;
    }

    public void infoAusgeben(){
        System.out.println(deutsch + ":"+"\t"+ englisch);
    }

    public boolean istKleinerAls(Datenelement dvergleich){
       WOERTERBUCHEINTRAG vergleichsWBE;
       vergleichsWBE = (WOERTERBUCHEINTRAG) dvergleich;
       
       if(deutsch.compareTo(vergleichsWBE.gibDeutschesWort()) < 0){
           return true;
       }else{
           return false;
       }       
    }

    public boolean istGleich(Datenelement dvergleich){
       // Überprüfung, ob der Eingabewert vom Typ WOERTERBUCHEINTRAG (WBE) ist
       WOERTERBUCHEINTRAG vergleichsWBE;
       vergleichsWBE = (WOERTERBUCHEINTRAG) dvergleich;
       
       if(deutsch.compareTo(vergleichsWBE.gibDeutschesWort()) == 0){
           return true;
       }else{
           return false;
       }       
    }
  
    public boolean istGroesserAls(Datenelement dvergleich){
       // Überprüfung, ob der Eingabewert vom Typ WOERTERBUCHEINTRAG (WBE) ist
       WOERTERBUCHEINTRAG vergleichsWBE;
       vergleichsWBE = (WOERTERBUCHEINTRAG) dvergleich;
       
       if(deutsch.compareTo(vergleichsWBE.gibDeutschesWort()) > 0){
           return true;
       }else{
           return false;
       }       
    }
    
    
    /*
     *    Vergleicht mit dem deutschen Wort
     */
    public boolean schluesselIstGleich (String vergleichsSchluessel){
        return (deutsch.compareTo(vergleichsSchluessel)==0);
    }

    /*
     *    ist das deutsche Wort > vergleich -> true
     */
    public boolean schluesselIstGroesserAls(String vergleichsSchluessel){
       if(deutsch.compareTo(vergleichsSchluessel) > 0){
           return true;
       }else{
           return false;
       }     
    }
    
    public String gibDeutschesWort(){
        return deutsch;
    }
    
    public String gibEnglischesWort(){
        return englisch;
    }
}
