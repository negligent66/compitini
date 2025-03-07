import java.util.Scanner;

public class TesterLavorino {
    public enum MenuEnum{
        ESCI,
        AGGIUNGI_PRODOTTO_CATALOGO,
        ELIMINA_PRODOTTO_CATALOGO,
        CERCA_PRODOTTO_CATALOGO,
        ELENCA_PRODOTTI_CATALOGO,
        AGGIUNGI_PRODOTTO_CARRELLO,
        ELIMINA_PRODOTTO_CARRELLO,
        ELENCA_PRODOTTI_CARRELLO,
        CALCOLA_IMPORTO_CARRELLO
    }
    static Scanner sc = new Scanner(System.in);
    static Catalogo catalogo = new Catalogo();
    static Carrello carrello = new Carrello();

    public static void main(String[] args) {
        boolean continua = true;
        while (continua) {
            int scelta = menu();
            MenuEnum opzione = MenuEnum.values()[scelta];
            continua = scelta(opzione);
        }
    }
    public static boolean scelta(MenuEnum opzione){
        try {
            switch (opzione) {
                case AGGIUNGI_PRODOTTO_CATALOGO:
                    aggiungiProdotto(catalogo);
                    break;
                case ELIMINA_PRODOTTO_CATALOGO:
                    eliminaProdotto(catalogo);
                    break;
                case CERCA_PRODOTTO_CATALOGO:
                    cercaProdotto(catalogo);
                    break;
                case ELENCA_PRODOTTI_CATALOGO:
                    elencaProdotti(catalogo);
                    break;
                case AGGIUNGI_PRODOTTO_CARRELLO:
                    aggiungiAlCarrello(catalogo, carrello);
                    break;
                case ELIMINA_PRODOTTO_CARRELLO:
                    eliminaDalCarrello(carrello);
                    break;
                case ELENCA_PRODOTTI_CARRELLO:
                    elencaProdottiCarrello(carrello);
                    break;
                case CALCOLA_IMPORTO_CARRELLO:
                    calcolaImporto(carrello);
                    break;
                case ESCI:
                    System.out.println("Uscita...");
                    sc.close();
                    return false;
                default:
                    System.out.println("non puoi farlo");
                    return false;
            }
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
        return true;
    }
    public static int menu(){
        System.out.println("\nMenu:");
        System.out.println("\n1. Aggiungi prodotto al catalogo");
        System.out.println("2. Elimina prodotto dal catalogo");
        System.out.println("3. Cerca prodotto nel catalogo");
        System.out.println("4. Elenca prodotti nel catalogo");
        System.out.println("5. Aggiungi prodotto al carrello");
        System.out.println("6. Elimina prodotto dal carrello");
        System.out.println("7. Elenca prodotti nel carrello");
        System.out.println("8. Calcola importo totale del carrello");
        System.out.println("0. Esci");
        System.out.print("\nScelta: ");
        return sc.nextInt();
    }
    private static void aggiungiProdotto(Catalogo catalogo) throws Exception {
        System.out.print("\nScegli il prodotto:" + "\n1.Libro\n2.CD\n3.DVD\n");
        int prodottino = sc.nextInt();
        sc.nextLine();

        System.out.print("Codice: ");
        int codice = sc.nextInt();
        sc.nextLine();
        System.out.print("Titolo: ");
        String titolo = sc.nextLine();
        System.out.print("Prezzo: ");
        int prezzo = sc.nextInt();
        System.out.print("Quantità: ");
        int quantita = sc.nextInt();
        sc.nextLine();

        switch (prodottino) {
            case 1:
                System.out.print("Autore: ");
                String autore = sc.nextLine();
                System.out.print("Editore: ");
                String editore = sc.nextLine();
                System.out.print("Numero di pagine: ");
                int pagine = sc.nextInt();
                sc.nextLine();
                catalogo.aggiungiProdotto(new Libro(codice, titolo, prezzo, quantita, autore, editore, pagine));
                break;
            case 2:
                System.out.print("Autore: ");
                String autoreCD = sc.nextLine();
                System.out.print("Esecutore: ");
                String esecutore = sc.nextLine();
                System.out.print("Durata: ");
                float durataCD = sc.nextFloat();
                sc.nextLine();
                catalogo.aggiungiProdotto(new CD(codice, titolo, prezzo, quantita, autoreCD, esecutore, durataCD));
                break;
            case 3:
                System.out.print("Regista: ");
                String regista = sc.nextLine();
                System.out.print("Produttore: ");
                String produttore = sc.nextLine();
                System.out.print("Durata: ");
                float durataDVD = sc.nextFloat();
                sc.nextLine();
                catalogo.aggiungiProdotto(new DVD(codice, titolo, prezzo, quantita, regista, produttore, durataDVD));
                break;
            default:
                System.out.println("Tipo di prodotto non valido.");
        }
        System.out.println("Prodotto aggiunto al catalogo");
    }

    private static void eliminaProdotto(Catalogo catalogo) throws Exception {
        System.out.print("\nCodice del prodotto da eliminare: ");
        int codice = sc.nextInt();
        catalogo.eliminaProdotto(codice);
        System.out.println("Prodotto eliminato");
    }

    private static void cercaProdotto(Catalogo catalogo) throws Exception {
        System.out.print("\nTitolo del prodotto da cercare: ");
        String titolo = sc.nextLine();
        Prodotto prodotto = catalogo.cercaProdotto(titolo);
        System.out.println("Prodotto trovato: " + prodotto);
    }

    private static void elencaProdotti(Catalogo catalogo) {
        Prodotto[] prodotti = catalogo.elencaProdotti();
        System.out.println("\nProdotti nel catalogo:");
        for (Prodotto prodotto : prodotti) {
            System.out.println(prodotto);
        }
    }

    private static void aggiungiAlCarrello(Catalogo catalogo, Carrello carrello) throws Exception {
        System.out.print("\nCodice del prodotto da aggiungere al carrello: ");
        int codice = sc.nextInt();
        Prodotto prodotto = catalogo.cercaProdotto(codice);
        carrello.aggiungiProdotto(prodotto);
        System.out.println("Prodotto aggiunto al carrello");
    }

    private static void eliminaDalCarrello(Carrello carrello) {
        System.out.print("\nCodice del prodotto da eliminare dal carrello: ");
        int codice = sc.nextInt();
        carrello.eliminaProdotto(codice);
        System.out.println("Prodotto eliminato dal carrello");
    }

    private static void elencaProdottiCarrello(Carrello carrello) {
        Prodotto[] prodotti = carrello.elencaProdotti();
        System.out.println("\nProdotti nel carrello:");
        for (Prodotto prodotto : prodotti) {
            System.out.println(prodotto);
        }
    }

    private static void calcolaImporto(Carrello carrello) {
        double totale = carrello.calcolaImporto();
        System.out.println("\nImporto totale del carrello: €" + totale);
    }
}
