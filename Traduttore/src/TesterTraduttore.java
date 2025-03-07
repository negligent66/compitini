import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TesterTraduttore {

    static ArrayList<String> paroleDelFileIta = new ArrayList<>();
    static ArrayList<String> paroleDelFileIng = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static AlberoDiRicerca<String> alberinoIng = new AlberoDiRicerca<>();
    static AlberoDiRicerca<String> alberinoIta = new AlberoDiRicerca<>();

    public static void main(String[] args) {
        inserimentoArraylistIng();
        inserimentoArrayListIta();
        alberinoIng.insertBalanced(paroleDelFileIng);
        alberinoIta.insertBalanced(paroleDelFileIta);
        System.out.println("-------------------------TRADUTTORE/TRANSLATOR-------------------------");
        int scelta = 1;
        do {
            scelta = menu();
            System.out.println();
            sceltaTraduzione(scelta);
        }while(scelta != 0);
    }

    public static void sceltaTraduzione(int risposta){
        if(risposta == 1) {
            System.out.println("insert an english word you wanna translate in italian:");
            String word = sc.next().trim();
            if(alberinoIng.cercaParola(word, alberinoIng.getRoot()) == null){
                System.out.println("Sorry, i can't translate this one yet :(\n");
                return;
            }
            System.out.print("translation -> " + alberinoIng.cercaParola(word, alberinoIng.getRoot()) + "\n");
        }
        if(risposta == 2){
            System.out.println("inserisci una parola italiana che vuoi tradurre in inglese:");
            String parola = sc.next().trim();
            if(alberinoIta.cercaParola(parola, alberinoIta.getRoot()) == null){
                System.out.println("Mi spiazie, non posso tradurlo :(\n");
                return;
            }
            System.out.print("traduzione -> " + alberinoIta.cercaParola(parola, alberinoIta.getRoot()) + "\n");
        }
    }
    public static int menu(){
        System.out.println();
        System.out.println("1.English -> Italiano");
        System.out.println("2.Italiano -> English");
        System.out.println("0.Esci\n");
        return sc.nextInt();
    }
    public static void inserimentoArraylistIng(){
        String csvFile = "IngleseItaliano.csv";
        String line = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                for (String token : tokens) {
                    paroleDelFileIng.add(token.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("not working");
            e.printStackTrace();
        }
        paroleDelFileIng.sort(String::compareTo);
    }
    public static void inserimentoArrayListIta() {
        String csvFile = "IngleseItaliano.csv";
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\n");
                for (String token : tokens) {
                    String []c = token.split(";");
                    paroleDelFileIta.add((c[1] + ";" + c[0]).trim());
                }
            }
        } catch (IOException ioe) {
            System.out.println("errorino");
            ioe.printStackTrace();
        }
        paroleDelFileIta.sort(String::compareTo);
    }


}
