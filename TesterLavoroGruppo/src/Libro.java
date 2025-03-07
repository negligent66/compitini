public class Libro extends Prodotto{
    private String autore;
    private String editore;
    private int pagine;

    public Libro() {
        this.autore = "";
        this.editore = "";
        this.pagine = 0;
    }

    public Libro(int codice, String titolo, int prezzo, int quantita, String autore, String editore, int pagine) {
        super(codice, titolo, prezzo, quantita);
        this.autore = autore;
        this.editore = editore;
        this.pagine = pagine;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getEditore() {
        return editore;
    }

    public void setEditore(String editore) {
        this.editore = editore;
    }

    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }

    @Override
    public String toString() {
        return "Libro: " + getTitolo() + "\nAutore: " + getAutore() + "\nEditore: " + getEditore() + "\nPagine: " + getPagine();
    }
}
