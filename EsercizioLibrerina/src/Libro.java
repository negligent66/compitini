import java.io.Serializable;

public class Libro implements Serializable {
    private String ISBN;
    private String titolo;
    private String autore;

    public Libro(String ISBN, String titolo, String autore) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.autore = autore;
    }

    public Libro() {
        ISBN = "";
        titolo = "";
        autore = "";
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }
    public String toString(){
        return "Titolo: " + titolo + "\nAutore: " + autore + "\nISBN: " + ISBN;
    }
}
