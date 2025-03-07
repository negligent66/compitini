import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static ElencoPrestiti elencoPrestiti = new ElencoPrestiti();
    static ElencoLibri elencoLibri = new ElencoLibri();
    static ElencoSoci elencoSoci = new ElencoSoci();
    static Scanner kbd = new Scanner(System.in);

    public enum Scelte {
        ESCI,
        AGGIUNGI_LIBRO,
        CERCA_LIBRO,
        ELIMINA_LIBRO,
        AGGIUNGI_SOCIO,
        CERCA_SOCIO,
        ELIMINA_SOCIO,
        AGGIUNGI_PRESTITO,
        CERCA_PRESTITO,
        RESTITUIZIONE_LIBRO,
        VISUALIZZA_ELENCO_LIBRI,
        VISUALIZZA_ELENCO_SOCI,
        VISUALIZZA_ELENCO_PRESTITI,
    }

    public static void main(String[] args) {
        desalvaTutto();
        ciclo();
    }

    public static void ciclo() {
        boolean continua = true;
        do {
            int scelta = menu();
            kbd.nextLine();
            Scelte sceltine = Scelte.values()[scelta];
            continua = conseguenze(sceltine);

            elencoPrestiti.salvataggioPrestiti();
            elencoLibri.salvataggioLibri();
            elencoSoci.salvataggioSoci();
        } while (continua);
    }

    public static int menu() {
        System.out.println("\n1) Aggiungi libro");
        System.out.println("2) Cerca libro");
        System.out.println("3) Elimina libro");
        System.out.println("4) Aggiungi socio");
        System.out.println("5) Cerca socio");
        System.out.println("6) Elimina socio");
        System.out.println("7) Aggiungi prestito");
        System.out.println("8) Cerca prestito");
        System.out.println("9) Restituzione libro");
        System.out.println("10) Visualizza elenco libri");
        System.out.println("11) Visualizza elenco soci");
        System.out.println("12) Visualizza elenco prestiti");
        System.out.println("0) Esci\n");
        System.out.print("Scelta: ");

        return kbd.nextInt();
    }

    public static Boolean conseguenze(Scelte scelte) {
        switch (scelte) {
            case ESCI -> {
                return false;
            }
            case AGGIUNGI_LIBRO -> {
                Libro libro = new Libro();
                System.out.println("Inserisci il titolo del libro: ");
                libro.setTitolo(kbd.nextLine());
                System.out.println("Inserisci l'autore del libro: ");
                libro.setAutore(kbd.nextLine());
                System.out.println("Inserisci l'ISBN del libro: ");
                libro.setISBN(kbd.nextLine());
                elencoLibri.aggiungiLibro(libro);
            }
            case CERCA_LIBRO -> {
                System.out.println("Inserisci l'ISBN del libro da cercare: ");
                System.out.println(elencoLibri.cercaLibro(kbd.nextLine()).toString());
            }
            case ELIMINA_LIBRO -> {
                System.out.println("Inserisci l'ISBN del libro da eliminare: ");
                System.out.println(elencoLibri.eliminaLibro(kbd.nextLine()).toString());
            }
            case AGGIUNGI_SOCIO -> {
                Socio socio = new Socio();
                System.out.println("Inserisci il codice fiscale del socio: ");
                socio.setcF(kbd.nextLine());
                System.out.println("Inserisci il nome del socio: ");
                socio.setNome(kbd.nextLine());
                elencoSoci.aggiungiSocio(socio);
            }
            case CERCA_SOCIO -> {
                System.out.println("Inserisci il codice fiscale del socio da cercare: ");
                System.out.println(elencoSoci.cercaSocio(kbd.nextLine()).toString());
            }
            case ELIMINA_SOCIO -> {
                System.out.println("Inserisci il codice fiscale del socio da eliminare: ");
                System.out.println(elencoSoci.rimuoviSocio(kbd.nextLine()).toString());
            }
            case AGGIUNGI_PRESTITO -> {
                System.out.println("Inserisci l'ISBN del libro da prestare: ");
                Libro libro = elencoLibri.cercaLibro(kbd.nextLine());
                System.out.println("Inserisci il codice fiscale del socio: ");
                Socio socio = elencoSoci.cercaSocio(kbd.nextLine());
                elencoPrestiti.aggiungiPrestito(libro, socio);
            }
            case CERCA_PRESTITO -> {
                System.out.println("Inserisci il codice fiscale del socio: ");
                elencoPrestiti.cercaPrestitoDaSocio(kbd.nextLine());
            }
            case RESTITUIZIONE_LIBRO -> {
                System.out.println("Inserisci l'ISBN del libro da restituire: ");
                String ISBN = kbd.nextLine();
                System.out.println("Inserisci il codice fiscale del socio: ");
                String cF = kbd.nextLine();
                System.out.println(elencoPrestiti.restituzioneLibro(ISBN, cF).toString());
            }
            case VISUALIZZA_ELENCO_LIBRI -> {
                System.out.println(elencoLibri.toString());
            }
            case VISUALIZZA_ELENCO_SOCI -> {
                System.out.println(elencoSoci.toString());
            }
            case VISUALIZZA_ELENCO_PRESTITI -> {
                System.out.println(elencoPrestiti.toString());
            }
        }
        return true;
    }

    public static void desalvaTutto() {
        File salvataggioPrestiti = new File("Prestiti.ser");
        creaFile(salvataggioPrestiti);

        File salvataggioLibri = new File("Libri.ser");
        creaFile(salvataggioLibri);

        File salvataggioSoci = new File("Soci.ser");
        creaFile(salvataggioSoci);

        if (salvataggioPrestiti.length() != 0) {
            elencoPrestiti.desalvataggioPrestiti();
        }
        if (salvataggioLibri.length() != 0) {
            elencoLibri.desalvataggioLibri();
        }
        if (salvataggioSoci.length() != 0) {
            elencoSoci.desalvataggioSoci();
        }
        System.out.println();
    }

    public static void creaFile(File salvataggio) {
        try {
            if (salvataggio.createNewFile()) {
                System.out.println("È stato creato un file di salvataggio");
            } else {
                System.out.println("Il file di salvataggio esiste già");
            }
        } catch (IOException e) {
            System.out.println("C'è stato un errore nella creazione del file.");
            e.printStackTrace();
        }
    }
}
