import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static CallCenter callCenter = new CallCenter();

    public enum Scelte {
        ESCI,
        AGGIUNGI_DIPENDENTI,
        AGGIUNGI_CLIENTI,
        REGISTRA_TELEFONATE,
        CERCA_CHIAMATA,
        VISUALIZZA_ELENCO_DIPENDENTI,
        VISUALIZZA_ELENCO_CLIENTI,
        VISUALIZZA_STORICO_TELEFONATE,
    }
    public static void main(String[] args) {
        ciclo();
    }
    public static void ciclo(){
        boolean continua = true;
        do{
            int scelta = menu();
            scanner.nextLine();
            System.out.println();
            Scelte sceltine = Scelte.values()[scelta];
            continua = conseguenze(sceltine);
        }while(continua);
    }
    public static boolean conseguenze(Scelte scelta){
        switch (scelta) {
            case AGGIUNGI_DIPENDENTI:
                System.out.println("Inserisci i dettagli del Dipendenti->");
                System.out.print("Codice Dipendente: ");
                String codiceDipendenti = scanner.nextLine();
                System.out.print("Cognome: ");
                String cognomeDipendenti = scanner.nextLine();
                System.out.print("Nome: ");
                String nomeDipendenti = scanner.nextLine();

                Dipendenti dipendenti = new Dipendenti(codiceDipendenti, cognomeDipendenti, nomeDipendenti);
                try {
                    callCenter.aggiungiDipendenti(dipendenti);
                    System.out.println("Dipendente aggiunto con successino");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case AGGIUNGI_CLIENTI:
                System.out.println("Inserisci i dati del Clienti->");
                System.out.print("Codice Cliente: ");
                String codiceClienti = scanner.nextLine();
                System.out.print("Cognome: ");
                String cognome = scanner.nextLine();
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Indirizzo: ");
                String indirizzo = scanner.nextLine();
                System.out.print("Città: ");
                String citta = scanner.nextLine();
                System.out.print("Numero di telefono: ");
                String numeroTelefono = scanner.nextLine();

                Clienti clienti = new Clienti(codiceClienti, cognome, nome, indirizzo, citta, numeroTelefono);
                try {
                    callCenter.aggiungiClienti(clienti);
                    System.out.println("Cliente aggiunto con successo");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case REGISTRA_TELEFONATE:
                System.out.println("Registra una Telefonata->");
                System.out.print("Numero di telefono del Cliente: ");
                String numeroPerTelefonate = scanner.nextLine();


                if (callCenter.getElencoDipendenti().isEmpty()) {
                    System.out.println("Errore: non ci sono dipendenti");
                    break;
                }

                System.out.println("\nSeleziona il Dipendente:");
                int i = 1;
                for (Dipendenti dip : callCenter.getElencoDipendenti()) {
                    System.out.println(i + ". " + dip);
                    i++;
                }
                System.out.print("Scegli: ");
                int dipendentiScelta = scanner.nextInt();
                scanner.nextLine();

                if (dipendentiScelta < 1 || dipendentiScelta > callCenter.getElencoDipendenti().size()) {
                    System.out.println("Scelta non valida");
                    break;
                }

                Dipendenti dipendentiSelezionato = callCenter.getElencoDipendenti().get(dipendentiScelta - 1);

                System.out.print("Inserisci la data (AAAA-MM-GG): ");
                String data = scanner.nextLine();
                System.out.print("Inserisci l'ora (HH:MM): ");
                String ora = scanner.nextLine();

                Telefonate telefonate = new Telefonate(data, ora, dipendentiSelezionato);
                try {
                    callCenter.registraTelefonate(numeroPerTelefonate, telefonate);
                    System.out.println("Telefonata registrata con successo");
                } catch (IllegalArgumentException e) {
                    System.out.println("Errore: " + e.getMessage());
                }
                break;

            case CERCA_CHIAMATA:
                System.out.print("Inserisci il numero di telefono della chiamata: ");
                String numeroDaCercare = scanner.nextLine();
                callCenter.chiamata(numeroDaCercare);
                break;
            case VISUALIZZA_ELENCO_DIPENDENTI:
                if(callCenter.getElencoDipendenti().isEmpty()){
                    System.out.println("Non ci sono dipendenti");
                    break;
                }
                System.out.println("Elenco Dipendenti->");
                for (Dipendenti dip : callCenter.getElencoDipendenti()) {
                    System.out.println(dip + "\n");
                }
                break;
            case VISUALIZZA_ELENCO_CLIENTI:
                if(callCenter.getClienti().isEmpty()){
                    System.out.println("Non ci sono clienti");
                    break;
                }
                System.out.println("Elenco Clienti->");
                for (Clienti cli : callCenter.getClienti().values()) {
                    System.out.println(cli + "\n");
                }
                break;
            case VISUALIZZA_STORICO_TELEFONATE:
                if(callCenter.getStoriciTelefonate().isEmpty()){
                    System.out.println("Non ci sono telefonate");
                    break;
                }
                System.out.println("Storico Telefonate->");
                for (String numero : callCenter.getStoriciTelefonate().keySet()) {
                    System.out.println("Numero di telefono: " + numero);
                    System.out.println(callCenter.getStoriciTelefonate().get(numero));
                }
                break;
            case ESCI:
                return false;
            default:
                System.out.println("Metti un altro numero");
        }
        return true;
    }
    public static int menu(){
        System.out.println("\n--- Benvenuto al Call Center ---");
        System.out.println("1. Aggiungi Dipendenti");
        System.out.println("2. Aggiungi Clienti");
        System.out.println("3. Registra Telefonate");
        System.out.println("4. Cerca chiamata");
        System.out.println("5. Visualizza elenco dipendenti");
        System.out.println("6. Visualizza elenco clienti");
        System.out.println("7. Visualizza storico telefonate");
        System.out.println("0. Esci\n");
        System.out.print("Fai una scelta: ");

        return scanner.nextInt();
    }
}