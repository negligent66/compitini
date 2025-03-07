import java.io.*;
import java.util.HashMap;

public class ElencoLibri implements Serializable{
    private HashMap<String, Libro> elencoLibri;

    public ElencoLibri() {
        elencoLibri = new HashMap<String, Libro>();
    }
    public void aggiungiLibro(Libro libro) {
        elencoLibri.put(libro.getISBN(), libro);
    }
    public Libro cercaLibro(String ISBN) {
        return elencoLibri.get(ISBN);
    }
    public Libro eliminaLibro(String ISBN) {
        return elencoLibri.remove(ISBN);
    }
    public void salvataggioLibri() {
        try{
            FileOutputStream salvaLibri = new FileOutputStream("Libri.ser");
            ObjectOutputStream sLibri = new ObjectOutputStream(salvaLibri);

            sLibri.writeObject(elencoLibri.clone());
            sLibri.flush();
            sLibri.close();

        }catch(IOException e){
            System.out.println("c'è un piccolo errorino nel salvataggio");
            e.printStackTrace();
        }
    }
    public void desalvataggioLibri(){
        try{
            FileInputStream desalvaLibri = new FileInputStream("Libri.ser");
            ObjectInputStream dLibri = new ObjectInputStream(desalvaLibri);

            elencoLibri = (HashMap<String, Libro>) dLibri.readObject();
            dLibri.close();
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
        for (Libro libro : elencoLibri.values()) {
            s += libro.toString() + "\n\n";
        }
        return s;
    }
}
