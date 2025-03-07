public class DVD extends Prodotto{
    private String regista;
    private String produttore;
    private float durata;

    public DVD() {
        this.regista = "";
        this.produttore = "";
        this.durata = 0;
    }

    public DVD(int codice, String titolo, float prezzo, int quantita, String regista, String produttore, float durata) {
        super(codice, titolo, prezzo, quantita);
        this.regista = regista;
        this.produttore = produttore;
        this.durata = durata;
    }

    public String getRegista() {
        return regista;
    }

    public void setRegista(String regista) {
        this.regista = regista;
    }

    public String getProduttore() {
        return produttore;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public float getDurata() {
        return durata;
    }

    public void setDurata(float durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "DVD: " + getTitolo() + "\nRegista: " + getRegista() + "\nProduttore: " + getProduttore() + "\nDurata: " + getDurata() + " minuto/i";
    }
}
