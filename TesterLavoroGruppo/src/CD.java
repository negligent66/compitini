public class CD extends Prodotto{
    private String autore;
    private String esecutore;
    private float durata;

    public CD() {
        this.autore = "";
        this.esecutore = "";
        this.durata = 0;
    }

    public CD(int codice, String titolo, float prezzo, int quantita, String autore, String esecutore, float durata) {
        super(codice, titolo, prezzo, quantita);
        this.autore = autore;
        this.esecutore = esecutore;
        this.durata = durata;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getEsecutore() {
        return esecutore;
    }

    public void setEsecutore(String esecutore) {
        this.esecutore = esecutore;
    }

    public float getDurata() {
        return durata;
    }

    public void setDurata(float durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "CD: " + getTitolo() + "\nAutore: " + getAutore() + "\nEsecutore: " + getEsecutore() + "\nDurata: " + getDurata() + " min";
    }
}
