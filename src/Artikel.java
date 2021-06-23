
/**
 * Eine Klasse zur Verwaltung eines Artikels
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (23.06.2021)
 */
public class Artikel
{
    private String art ;
    private int artikelNr ;
    private int bestand ;
    private double preis ;
    protected final int MIN_ARTIKELNR = 999;
    protected final int MAX_ARTIKELNR = 10000;
    protected final int MIN_BESTAND = 0;

    /**
     * Konstruktoren: um Objekte anlegen zu können.
     *
     * @param  artikelNr  --> eine 4-stellige positive Zahl ist
     * @param  art        --> String, der dei Art der Artikeln beschreibt darf nicht leer sein
     * @param  bestand    --> muss >=  0 sein
     * @param preis       --> muss grosser als 0 sein.
     */
    public Artikel(int artikelNr , String art , int bestand , double preis) {
        if(artikelNr <= MIN_ARTIKELNR || artikelNr >= MAX_ARTIKELNR || art.isBlank() || bestand < MIN_BESTAND
                || preis < 0){
            throw new IllegalArgumentException("Ein fehler beim konstruktor");
        }
        this.art = art ;
        this.bestand = bestand ;
        this.artikelNr = artikelNr ;
        this.preis = preis ;
    }

    /**
     * Konstruktoren: um Objekte anlegen zu können.
     *
     * @param artikelNr  --> eine 4-stellige positive Zahl ist
     * @param  art        --> String, der dei Art der Artikeln beschreibt darf nicht leer sein
     * @param preis   --> muss grosser als 0 sein.
     */
    public Artikel(int artikelNr , String art , double preis){
        if(artikelNr <= MIN_ARTIKELNR || artikelNr >= MAX_ARTIKELNR || art.isBlank() || preis < 0){
            throw new IllegalArgumentException("Ein fehler beim konstruktor (ohne Bestand)");
        }
        this.art = art ;
        this.artikelNr = artikelNr ;
        this.preis = preis ;
    }

    /**
     * diese Funktion erhöht den Bestand um eine bestimmte Menge
     * @param menge die eingegbene Menge , die mann verringern muss.
     */
    public void bucheZugang (int menge){
        if(menge < MIN_BESTAND ){
            throw new IllegalArgumentException("Menge muss < 0 sein");
        }
        bestand += menge ;
    }

    /**
     *diese Funktion vermindert den Bestand um eine bestimmte Menge
     * @param menge die eingegbene Menge , die man verringern muss.
     */
    public void bucheAbgang (int menge){
        if(menge < MIN_BESTAND || bestand < menge){
            throw new IllegalArgumentException("Menge muss < 0 sein");
        }
        bestand -= menge ;
    }


    /**
     *  Methode gibt die Artikelnummer zurück
     * @return Artikel in die Klasse
     */
    public int getArtikelNr(){
        return this.artikelNr ;
    }

    /**
     * Diese Methode gibt die Artikelart zurück
     * @return art in die Klasse
     */
    public String getArt(){
        return this.art;
    }


    /**
     * Diese Methode gibt den aktuellen Bestand zurück
     * @return bestand in die Klasse
     */
    public int getBestand(){
        return this.bestand;
    }

    /**
     *Diese Methode gibt den aktuellen Preis zurück
     * @return Preis in die Klasse
     */
    public int getPreis(){
        return this.bestand;
    }

    /**
     *  ArtikelNr ändern
     *  Prüfen ob ArtikelNr eine 4-stellige positive Zahl ist
     * @param artikelNr Neu Artikel
     * @return die gespeicherte artikel Nummber
     */
    public int setArtikelNr(int artikelNr){
        if(artikelNr < MIN_ARTIKELNR || artikelNr >= MAX_ARTIKELNR){
            throw new IllegalArgumentException();
        }else {
            return this.artikelNr = artikelNr;
        }
    }




    /**
     *  Art ändern
     *  Prüfen ob Art nicht null und nicht leer ist
     * @param stArt  neu art
     * @return die neu art
     */
    public String setArt(String stArt){
        if(stArt == null || stArt.isEmpty()){
            throw new IllegalArgumentException("Art cann't be Empty");
        } else{
            return this.art = stArt;
        }
    }

    /**
     * diese Methode ändert den Preis .
     * @param preis  die neuen Wert .
     * @return speichert den neuen Wert statt die altes .
     */
    public double setPreis (double preis){
        if(preis < 0){
            throw new IllegalArgumentException("Preis must be bigger than 0");
        }else{
            return this.preis = preis ;
        }
    }

    /** @param prozent der Prozentsatz um den der Preis geändert werden soll */
    public void aenderePreis(double prozent) {
        double change = (prozent * getPreis()) / 100;
        double preise = getPreis() + change;
        if (preise > 0) {
            getPreis(preis);
        }
    }

    private double getPreis(double preis) {
        return this.preis;
    }

    @Override
    public String toString(){
        return "Artikel: "+artikelNr+" Bezeichnung: "+art+" Bestand: "+bestand +" Preis:"+preis;
    }
}
