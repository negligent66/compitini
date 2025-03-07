public class Dipendenti {
    private String codiceDipendente;
    private String cognome;
    private String nome;

    public Dipendenti(String codiceDipendente, String cognome, String nome) {
        this.codiceDipendente = codiceDipendente;
        this.cognome = cognome;
        this.nome = nome;
    }

    public String getCodiceDipendenti() {
        return codiceDipendente;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Dipendente->" + "\n" +
                "codice dipendente: " + codiceDipendente + "\n" +
                "cognome: " + cognome + "\n" +
                "nome: " + nome + "\n";
    }
}
