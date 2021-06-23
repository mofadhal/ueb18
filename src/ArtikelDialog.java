import java.util.*;
/**
 * Write a description of class ArtikelTest here.
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (23.06.2021)
 */
public class ArtikelDialog
{
    private Artikel artikel1;
    private Scanner input = new Scanner(System.in);
    private static final int Enden = 0 ;
    private static final int artikelAnlegen = 1 ;
    private static final int zuBestand = 2 ;
    private static final int abBestand = 3 ;
    private static final int setArtikelNr = 4 ;
    private static final int setArt = 5 ;
    private static final int setPreis = 6;

    /**
     *
     * Menü ausgeben und Funktion einlesen
     *
     * @return eingelesene Funktion als ganzzahliger Wert
     */
    private int einlesenFunktion(){
        int funktion ;
        System.out.println( artikelAnlegen+":artikelNrAnlegen"+" "+
                zuBestand + ":zuBestand"+" "+
                abBestand + ":abBestand"+" "+
                setArtikelNr + ":setArtikelNr"+" "+
                setArt + ":setArt"+" "+
                setPreis  + ":setPreis"+" "+
                Enden+":Enden:");
        funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }

    /**
     * Ausführen der ausgewählten Funktion
     * @param funktion auszuführende Funktion als ganze Zahl
     */
    public void ausfuehrungFunktion(int funktion) {
        switch (funktion){
            case Enden:          System.out.println("Programm Ende"); break;
            case artikelAnlegen: artikel1 = artikelAnlegen();break;
            case zuBestand : {
                if (artikel1 == null ) {
                    throw new IllegalArgumentException("Legen Sie zuerst einen Artiel");
                }
                artikel1.bucheZugang(einlesenMenge());
                break;
            }
            case abBestand : {
                if (artikel1 == null ) {
                    throw new IllegalArgumentException("Legen Sie zuerst einen Artiel");

                }
                artikel1.bucheAbgang(einlesenMenge());
                break;
            }
            case setArtikelNr : {
                if (artikel1 == null ) {
                    throw new IllegalArgumentException("Legen Sie zuerst einen Artiel");

                }
                artikel1.setArtikelNr(einlesenArtikelNr());
                break;
            }
            case setArt : {
                if (artikel1 == null ) {
                    throw new IllegalArgumentException("Legen Sie zuerst einen Artiel");

                }
                artikel1.setArt(einlesenArt());
                break;
            }
            case setPreis :{
                if (artikel1 == null ) {
                    throw new IllegalArgumentException("Legen Sie zuerst einen Artiel");

                }
                    artikel1.setPreis(einlesenPreis());
                    break;
                }


            default:
                throw new IllegalArgumentException("Unexpected value: " + funktion);
        }
        System.out.println(artikel1);
    }

    /**
     * diese Methode legt neuen Artikel an.
     * @return neu Artikel konstruktor .
     */
    private Artikel artikelAnlegen (){
        int artikelNr ;
        int bestand ;
        String art;
        double preis;
        //--------------artielnumber--------------------------------
        System.out.println("Geben Sie artikelNr ein");
        artikelNr= input.nextInt();
        input.nextLine();
        //--------------Bezeichnung---------------------------------
        System.out.println("Geben Sie Bezeichnung ein");
        art= input.nextLine();
        //--------------Bestand-------------------------------------
        System.out.println("Geben Sie bestand ein");
        bestand= input.nextInt();
        //--------------Preis---------------------------------------
        System.out.println("Geben Sie Preis ein");
        preis= input.nextInt();
        //---------------------------------------------------------
        return new Artikel( artikelNr ,  art ,  bestand , preis);
    }

    private int einlesenMenge (){
        System.out.println("Geben Sie ein Menge");
        return input.nextInt();
    }

    private String einlesenArt(){
        System.out.println("Geben Sie ein Bezeichnung ein");
        return input.nextLine();
    }

    private int einlesenArtikelNr (){
        System.out.println("Geben Sie ArtikelNr ein");
        return input.nextInt();
    }

    private int einlesenPreis(){
        System.out.println("Geben Sie Preis ein");
        return input.nextInt();
    }

    public void Start(){
        artikel1 = null;
        int funktion = -1;
        while(funktion != Enden ){
            try{
                funktion = einlesenFunktion();
                ausfuehrungFunktion(funktion);
            }catch (IllegalArgumentException e){
                System.out.print(e);
                input.nextLine();
            }catch (Exception e){
                System.out.print(e);
                input.nextLine();}
        }
    }


    public static void main(String[] args){
        new ArtikelDialog().Start();
    }
}
