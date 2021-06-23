import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * Write a description of class Lager here.
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (23.06.2021)
 */
public class Lager {
    private final int MAX_ARTIKEL_NR = 10000;
    private final int MIN_ARTIKEL_NR = 999;
    private Artikel elmenteInLager[];
    private int counterListe;
    private int grosse;


    /**
     * @param grosse
     */
    public Lager(int grosse) {
        if (grosse <= 0) {
            throw new IllegalArgumentException();
        }
        this.grosse = grosse;
        elmenteInLager = new Artikel[grosse];
        counterListe = 0;
    }

    /**
     * methode zum anlegen einen Artikel
     * @param artikel
     */
    public void legeAnArtikel(Artikel artikel) {
        if (artikel == null || counterListe > grosse) {
            throw new IllegalArgumentException();
        }
        elmenteInLager[counterListe] = artikel;
        counterListe++;
    }

    /** Methode zum Loeschen einer artikel
     * @param artikelNr
     */
    public void entferneArtikel(int artikelNr) {
        if (artikelNr > MAX_ARTIKEL_NR || artikelNr < MIN_ARTIKEL_NR ||
                !istVorhanden(artikelNr)) {
            throw new IllegalArgumentException();
        }
        for (int i = sucheArtikelNr(artikelNr); i < counterListe; i++) {
            elmenteInLager[i] = elmenteInLager[i + 1];
        }
        elmenteInLager[counterListe] = null;
        counterListe--;
    }

    /** diese Methode ist zum Buchen einen Zugang
     * @param artikelNr
     * @param menge
     */
    public void bucheZugang(int artikelNr, int menge) {
        if (artikelNr > MAX_ARTIKEL_NR || artikelNr < MIN_ARTIKEL_NR || menge < 0
                || !istVorhanden(artikelNr)) {
            throw new IllegalArgumentException();
        }
        int sucheIndex = sucheArtikelNr(artikelNr);
        elmenteInLager[sucheIndex].bucheZugang(menge);

    }


    /** diese Methode ist zum Buchen einen Abgang
     * @param artikelNr
     * @param menge
     */
    public void bucheAbgang(int artikelNr, int menge) {
        if (artikelNr > MAX_ARTIKEL_NR || artikelNr < MIN_ARTIKEL_NR || menge < 0
                || !istVorhanden(artikelNr)) {
            throw new IllegalArgumentException();
        }
        int sucheIndex = sucheArtikelNr(artikelNr);
        elmenteInLager[sucheIndex].bucheAbgang(menge);
    }

    /** diese Methode aendert den Preis aller Artikel
     * @param prozent
     */
    public void aenderePreisAllerArtikel(double prozent) {
        for (int i = 0; i < counterListe; i++) {
            elmenteInLager[i].setPreis(prozent * 100);
        }
    }

    /** diese Methode gibt die Artikel zurück
     * @param index der gesuchte Element
     * @return der Element in der Stelle index
     */
    public Artikel getArtikel(int index) {
        if (index > counterListe || index < 0) {
            throw new IllegalArgumentException();
        }
        return elmenteInLager[index];
    }

    /**
     * diese Methode ist zum Suchen einer Artikelnummer
     */
    public int sucheArtikelNr(int artikelNr) {
        if (artikelNr > MAX_ARTIKEL_NR || artikelNr < MIN_ARTIKEL_NR) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < counterListe; i++) {
            if (elmenteInLager[i].getArtikelNr() == artikelNr) {

                return i;
            }
        }
        return -1;
    }

    /**
     * diese Methode überprüft, ob der Artikel vorhanden ist
     */
    public boolean istVorhanden(int artikelNr) {
        return sucheArtikelNr(artikelNr) > -1;

    }

    /** diese Methode gibt die Artikelanzahl zurück
     * @return Anzahl der Elemente in der Liste
     */
    public int getArtikelAnzahl() {

        return counterListe;
    }

    /** diese Methode gibt die Lagergroesse zurück
     * @return grosse der Lage
     */
    public int getLagerGroesse() {

        return this.grosse;
    }

    /** diese Methode ändert die Lagergroesse
     * @return neue grosse
     */
    public int setLagerGrosse(int grosse) {
        if (grosse <= 0) {
            throw new IllegalArgumentException();
        }
        return this.grosse = grosse;
    }


    @Override
    public String toString() {
        String s = "Lager Elemente";
        for (int i = 0; i < counterListe; i++) {
            s += elmenteInLager[i].toString();
        }

        return s;
    }

    /** diese Methode gibt die Artikel im Lager als sortiertes Array zurück
     * @param // predicate
     * @return die gesortete Artikel
     */
    public Artikel[] getSorted(BiPredicate<Artikel, Artikel> funk) {
        int in, out;

        //Divide the array of elements by marking an element
        for (out = 1; out < elmenteInLager.length; out++) {
            //remove marked student
            Artikel temp = elmenteInLager[out];

            //start shifting at out
            in = out;

            //until smaller one is found, shift element to the right
            //and go one position left
            while (in > 0 && funk.test(elmenteInLager[in - 1], temp)) {
                //shift element to the right
                elmenteInLager[in] = elmenteInLager[in - 1];

                //go one position left
                --in;

            }
            //insert marked element
            elmenteInLager[in] = temp;
        }
        return elmenteInLager;
    }

    /** diese Methode anwendet eine an die Methode übergebene Operation auf alle Artikel im Lager .
     * @param f ist die übergebene Operation
     */
    public void applyToArticles(Consumer<Artikel> f) {
        for (Artikel x: elmenteInLager){
            if(x == null) continue;
            f.accept(x);
        }
    }

    /**
     * diese Methode anwendet eine Operation auf die Artikel, welche ein bestimmtes Kriterium erfüllen
     *
     */
    public void applyToSomeArticles( Predicate<Artikel> filter, Consumer<Artikel> apply ) {

        for (Artikel a: elmenteInLager) {
            if ( a == null) continue;
            if(filter.test(a)){
                apply.accept(a);
            }
        }

    }

    /**  diese Methode gibt alle Artikel des Lagers zurück, welche ein bestimmtes Filterkriterium erfüllen
     * @param  // typ Artikel
     */
    public Artikel[] filter(Predicate<Artikel> toFilter) {
        List<Artikel> temp = new ArrayList<>();
        for (Artikel a: elmenteInLager) {
            if ( a == null) continue;
            if(toFilter.test(a)){
                temp.add(a);
            }
        }
        Artikel[] resutl = new Artikel[temp.size()];
        for (int i = 0; i < temp.size() ; i++) {
            resutl[i] = temp.get(i);
        }

        return resutl;
    }

    /**
     * diese Methode nimmt eine beliebige Menge an Filterkriterien als Parameter entgegen und gibt die Artikel des Lagers  *zurück
     */
    public Artikel[] filterAll(Predicate<Artikel>... filters) {
        Artikel[] temp = elmenteInLager.clone();

        for (Predicate<Artikel> f : filters) {
            this.elmenteInLager = filter(f);
        }
        Artikel[] result = this.elmenteInLager.clone();

        this.elmenteInLager = temp;

        return result;
    }

    /**
     *  diese Methode gibt eine sortierte Liste der Artikel zurück, welche ein bestimmtes Suchkriterium erfüllen
     */
    public Artikel[] getArticles( Predicate<Artikel> suchArtikel ,BiPredicate<Artikel , Artikel> sortArtikel ) {
        Artikel[] copyOrginalListe = elmenteInLager.clone();
        this.elmenteInLager =  filter(suchArtikel);
        Artikel[] result =  getSorted(sortArtikel);

        this.elmenteInLager = copyOrginalListe;

        return result;

    }

}
