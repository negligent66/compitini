public class Prodotto implements Cloneable {
    private int codice;
    private float prezzo;
    private int quantita;
    private String descrizione;
    private int anno;
    private String titolo;

    public Prodotto() {
        this.codice = 0;
        this.prezzo = 0;
        this.quantita = 0;
        this.descrizione = "";
        this.anno = 0;
        this.titolo = "";
    }

    public Prodotto(int codice, String titolo, float prezzo, int quantita) {
        this.codice = codice;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.titolo = titolo;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    protected Prodotto clone() throws CloneNotSupportedException {
        return (Prodotto) super.clone();
    }

    @Override
    public String toString() {
        return "Prodotto: \nCodice: " + getCodice() + "\nPrezzo: " + getPrezzo() + "\nQuantità: " + getQuantita() +
                "\nDescrizione: " + getDescrizione() + "\nAnno: " + getAnno() + "\nTitolo: " + getTitolo();
    }
}
