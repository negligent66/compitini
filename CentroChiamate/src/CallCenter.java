import java.util.ArrayList;
import java.util.HashMap;

public class CallCenter {
    private HashMap<String, Clienti> clienti;
    private HashMap<String, Telefonate> storiciTelefonate;
    private ArrayList<Dipendenti> elencoDipendenti;

    public CallCenter() {
        this.clienti = new HashMap<>();
        this.storiciTelefonate = new HashMap<>();
        this.elencoDipendenti = new ArrayList<>();
    }

    public void aggiungiClienti(Clienti clienti) {
        if (this.clienti.containsKey(clienti.getNumeroTelefono())) {
            throw new IllegalArgumentException("Numero del cliente già presente.");
        }
        this.clienti.put(clienti.getNumeroTelefono(), clienti);
    }


    public void aggiungiDipendenti(Dipendenti dipendenti) {
        for (Dipendenti d : elencoDipendenti) {
            if (d.getCodiceDipendenti().equals(dipendenti.getCodiceDipendenti())) {
                throw new IllegalArgumentException("Codice del dipendente già presente.");
            }
        }
        elencoDipendenti.add(dipendenti);
    }


    public void registraTelefonate(String numeroTelefono, Telefonate Telefonate) {
        if (!clienti.containsKey(numeroTelefono)) {
            throw new IllegalArgumentException("Non c'è un cliente con questo numero.");
        }
        storiciTelefonate.put(numeroTelefono, Telefonate);
    }


    public void chiamata(String numeroTelefono) {
        try {
            if (!clienti.containsKey(numeroTelefono)) {
                throw new IllegalArgumentException("Numero di telefono non presente.");
            }

            Clienti clienti1 = clienti.get(numeroTelefono);
            Telefonate ultimaTelefonata = storiciTelefonate.get(numeroTelefono);

            System.out.println("Info chiamata->");
            System.out.println(clienti1);
            if (ultimaTelefonata != null) {
                System.out.println("Ultima Telefonata: \n" + ultimaTelefonata);
            } else {
                System.out.println("Non presente la telefonata");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public ArrayList<Dipendenti> getElencoDipendenti() {
        return elencoDipendenti;
    }
    public HashMap<String, Clienti> getClienti() {
        return clienti;
    }
    public HashMap<String, Telefonate> getStoriciTelefonate() {
        return storiciTelefonate;
    }
}
