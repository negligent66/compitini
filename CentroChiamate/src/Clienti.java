public class Clienti {
    private String codiceCliente;
    private String cognome;
    private String nome;
    private String indirizzo;
    private String citta;
    private String numeroTelefono;

    public Clienti(String codiceCliente, String cognome, String nome, String indirizzo, String citta, String numeroTelefono) {
        this.codiceCliente = codiceCliente;
        this.cognome = cognome;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.numeroTelefono = numeroTelefono;
    }

    public String getCodiceCliente() {
        return codiceCliente;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    @Override
    public String toString() {
        return "Cliente->" + "\n" +
                "codice cliente: " + codiceCliente + "\n" +
                "cognome: " + cognome + "\n" +
                "nome: " + nome + "\n" +
                "indirizzo: '" + indirizzo + "\n" +
                "città: " + citta + "\n" +
                "numero di telefono: " + numeroTelefono + "\n";
    }
}
