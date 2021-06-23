/**
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (23.06.2021)
 */
public class CD extends Artikel {

    private String interpret;
    private String titel;
    private int anzahlTitel;

    /**
     * Konstruktor der CD Klasse .
     * @param artikelNr Artikelnummer der CDs
     * @param bestand bestand von CDs
     * @param preis preis der CD
     * @param interpret interpert
     * @param titel titel namme der CD
     * @param anzahlTitel Anzahl der Titel der CDs
     */
    public CD(int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel){

        super(artikelNr, "Medien", bestand, preis);

        if (interpret == null || interpret.isBlank()) {
            throw new IllegalArgumentException("Interpret darf nicht null sein");
        }
        if (titel == null || titel.isBlank()) {
            throw new IllegalArgumentException("Titel darf nicht null sein");
        }
        if (anzahlTitel == 0) {
            throw new IllegalArgumentException("CD darf nicht leer sein");
        }
        this.interpret = interpret;
        this.titel = titel;
        this.anzahlTitel = anzahlTitel;
    }

    /**
     *
     * @return interpert  titel
     */
    public String getBeschreibung() {
        return interpret + ": " + titel;
    }

    /**
     *
     * @return interpret
     */
    public String getInterpret() {

        return interpret;
    }

    /**
     *
     * @return  titel
     *
     */
    public String getTitel() {
        return titel;
    }

    /**
     *
     * @return the anzahlTitel
     *
     */
    public int getAnzahlTitel() {

        return anzahlTitel;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(
                "Titel: %s Interpret: %s Anzahl Musiktitel: %d", titel, interpret, anzahlTitel);
    }
}
