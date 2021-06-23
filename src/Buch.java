/**
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (23.06.2021)
 */
public class Buch extends Artikel {

    private String titel;
    private String autor;
    private String verlag;

    /**
     * Konstruktor der Buch Klasse .
     * @param artikelNr Artikelnummer
     * @param bestand  Bestand
     * @param preis Preis
     * @param autor Der Autor
     * @param titel Buch's titel
     * @param verlag Buch' Verlag
     */
    public Buch(int artikelNr, int bestand, double preis, String autor, String titel, String verlag) {
        super(artikelNr, "Medien", bestand, preis);
        if (titel == null || titel.isBlank()) {
            throw new IllegalArgumentException("Titel darf nicht null sein");
        }
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("Autor darf nicht null sein");
        }
        if (verlag == null || verlag.isBlank()) {
            throw new IllegalArgumentException("Verlag darf nicht null sein");
        }
        this.titel = titel;
        this.autor = autor;
        this.verlag = verlag;
    }

    /**
     *
     * @return autor  title
     */
    public String getBeschreibung() {
        return autor + ": " + titel;
    }

    /**
     *
     * @return titel
     *
     */
    public String getTitel() {
        return titel;
    }

    /**
     *
     * @return the autor
     *
     */
    public String getAutor() {
        return autor;
    }

    /**
     *
     * @return the verlag
     *
     */
    public String getVerlag() {
        return verlag;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Titel: %s Autor: %s Verlag: %s", titel, autor, verlag);
    }
}
