import java.util.*;

public class TesterAlberoBinario {

    static Scanner sc = new Scanner(System.in);

    static AlberoDiRicerca alberoRicerchina = new AlberoDiRicerca();

    public static void main(String args[]){

        Boolean continua = true;
        do{
            System.out.println("\n1. inserisci nodo" +
                    "\n2. elimina nodo" +
                    "\n3. controlla presenza valore" +
                    "\n4. conta foglie" +
                    "\n5. stampa albero" +
                    "\n0. esci");
            System.out.print("\nscegli cosa fare: ");
            int scelta = sc.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("\ninserisci il nodo che vuoi aggiungere:");
                    alberoRicerchina.insert(sc.nextInt());
                    break;
                case 2:
                    System.out.println("\ninserisci il nodo che vuoi eliminare:");
                    alberoRicerchina.delete(sc.nextInt());
                    break;
                case 3:
                    System.out.println("\ninserisci il valore da controllare: ");
                    int val = sc.nextInt();
                    if(alberoRicerchina.cerca(val, alberoRicerchina.getRoot())) System.out.println(val + " ESISTE!!!");
                    else System.out.println(val + " NON ESISTE!!!");
                    break;
                case 4:
                    System.out.println("\nci sono " + alberoRicerchina.contaFoglie(alberoRicerchina.getRoot()) + " foglie");
                    break;
                case 5:
                    System.out.println(alberoRicerchina.print(alberoRicerchina.getRoot()));
                    break;
                case 0:
                    continua = false;
                    break;
            }
        }while (continua);
    }
}