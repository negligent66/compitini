import java.util.Scanner;

public class Main {
    static Scanner kbd = new Scanner(System.in);

    public static void main(String[] args) {
        Archivio archivio = new Archivio();
        archivio.salvaArchivio("archivio.ser");
        archivio = Archivio.caricaArchivio("archivio.ser");

        int scelta;
        do {
            scelta = menu();
            switch (scelta) {
                case 1:
                    archivio.aggiungiVeicolo();
                    break;
                case 2:
                    System.out.println("Inserisci la targa del veicolo da rimuovere: ");
                    archivio.rimuoviVeicolo(kbd.next());
                    break;
                case 3:
                    System.out.println("Inserisci la targa del veicolo da modificare: ");
                    archivio.moficaDatiVeicolo(kbd.next());
                    break;
                case 4:
                    archivio.salvaArchivio("archivio.ser");
                    break;
                case 5:
                    archivio = Archivio.caricaArchivio("archivio.ser");
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        } while (scelta != 6);

    }

    public static int menu() {
        System.out.println("1. Aggiungi veicolo");
        System.out.println("2. Rimuovi veicolo");
        System.out.println("3. Modifica dati veicolo");
        System.out.println("4. Salva archivio");
        System.out.println("5. Carica archivio");
        System.out.println("6. Esci");
        return kbd.nextInt();
    }
}