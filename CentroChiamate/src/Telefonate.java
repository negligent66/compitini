public class Telefonate {
    private String data;
    private String ora;
    private Dipendenti dipendente;

    public Telefonate(String data, String ora, Dipendenti dipendente) {
        this.data = data;
        this.ora = ora;
        this.dipendente = dipendente;
    }

    public String getData() {
        return data;
    }

    public String getOra() {
        return ora;
    }

    public Dipendenti getDipendente() {
        return dipendente;
    }

    @Override
    public String toString() {
        return "Telefonata->" + "\n" +
                "data: " + data + "\n" +
                "ora: " + ora + "\n" +
                "dipendente: " + dipendente + "\n";
    }
}
