import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ElencoPrestiti implements Serializable {
    private ArrayList<Prestito> elencoPrestiti;
    private Scanner kbd = new Scanner(System.in);

    public ElencoPrestiti() {
        elencoPrestiti = new ArrayList<Prestito>();
    }
    public void aggiungiPrestito(Libro libro, Socio socio) {
        Prestito prestito = new Prestito();
        prestito.setCodiceLibroSocio(libro.getISBN(), socio.getcF());
        elencoPrestiti.add(prestito);
    }
    public void cercaPrestitoDaSocio(String codiceSocio){
        for (Prestito prestito : elencoPrestiti) {
            if (prestito.getCodiceSocio().equals(codiceSocio)) {
                System.out.println(prestito.toString() + "\n");
            }
        }
    }
    public Prestito restituzioneLibro(String codiceLibro, String codiceSocio){
        for (Prestito prestito : elencoPrestiti) {
            if (prestito.getCodiceLibroSocio().equals(codiceLibro + "-" + codiceSocio)) {
                elencoPrestiti.remove(prestito);
                return prestito;
            }
        }
        return null;
    }
    public void salvataggioPrestiti() {
        try{
            FileOutputStream salvaPrestiti = new FileOutputStream("Prestiti.ser");
            ObjectOutputStream sPrestiti = new ObjectOutputStream(salvaPrestiti);

            sPrestiti.writeObject(elencoPrestiti.clone());
            sPrestiti.flush();
            sPrestiti.close();

        }catch(IOException e){
            System.out.println("c'è un piccolo errorino nel salvataggio");
            e.printStackTrace();
        }
    }
    public void desalvataggioPrestiti(){
        try{
            FileInputStream desalvaPrestiti = new FileInputStream("Prestiti.ser");
            ObjectInputStream dPrestiti = new ObjectInputStream(desalvaPrestiti);

            elencoPrestiti = (ArrayList <Prestito>) dPrestiti.readObject();
            dPrestiti.close();
        }catch(IOException e){
            System.out.println("c'è un piccolo errorino nel desalvataggio");
            e.printStackTrace();

        }catch(ClassNotFoundException ex){
            System.out.println("non c'è questa classe");
            ex.printStackTrace();
        }
    }
    public String toString(){
        String s = "";
        for (Prestito prestito : elencoPrestiti) {
            s += prestito.getCodiceLibroSocio() + "\n\n";
        }
        return s;
    }

}
