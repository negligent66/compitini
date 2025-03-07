import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivio implements Serializable {
    private Scanner kbd = new Scanner(System.in);
    private ArrayList<Motoveicolo> archivio;

    public Archivio() {
        this.archivio = new ArrayList<>();
    }

    public void aggiungiVeicolo(){
        Motoveicolo mV = new Motoveicolo();
        System.out.println("inserisci la targa: ");
        mV.setTarga(kbd.next());
        System.out.println("inserisci il tipo di veicolo: ");
        mV.setTipoVeicolo(kbd.next());
        archivio.add(mV);
    }
    public void rimuoviVeicolo(String targa){
        if (!archivio.isEmpty()) {
            for (int i = 0; i < archivio.size(); i++) {
                if (archivio.get(i).getTarga().equals(targa)) {
                    archivio.remove(i);
                    return;
                }
            }
        }
    }

    public void moficaDatiVeicolo(String targa) {
        if (!archivio.isEmpty()) {
            for (int i = 0; i < archivio.size(); i++) {
                if (archivio.get(i).getTarga().equals(targa)) {
                    System.out.println("vuoi modificare targa(1) o tipo di veicolo(2): ");
                    if (kbd.nextInt() == 1) {
                        System.out.println("Targa nuova:");
                        archivio.get(i).setTarga(kbd.next());
                    }
                    if (kbd.nextInt() == 2) {
                        System.out.println("Tipo veicolo nuovo:");
                        archivio.get(i).setTarga(kbd.next());
                    }
                    return;
                }
            }
        }
    }
    public void salvaArchivio(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Archivio caricaArchivio(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Archivio) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
