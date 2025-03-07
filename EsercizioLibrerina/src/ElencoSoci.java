import java.io.*;
import java.util.HashMap;
import java.util.TreeMap;

public class ElencoSoci implements Serializable{
    private TreeMap<String, Socio> elencoSoci;

    public ElencoSoci() {
        elencoSoci = new TreeMap<String, Socio>();
    }
    public void aggiungiSocio(Socio socio) {
        elencoSoci.put(socio.getcF(), socio);
    }
    public Socio cercaSocio(String cF) {
        return elencoSoci.get(cF);
    }
    public Socio rimuoviSocio(String cF) {
        return elencoSoci.remove(cF);
    }
    public void salvataggioSoci() {
        try{
            FileOutputStream salvaSoci = new FileOutputStream("Soci.ser");
            ObjectOutputStream sSoci = new ObjectOutputStream(salvaSoci);

            sSoci.writeObject(elencoSoci.clone());
            sSoci.flush();
            sSoci.close();

        }catch(IOException e){
            System.out.println("c'è un piccolo errorino nel salvataggio");
            e.printStackTrace();
        }
    }
    public void desalvataggioSoci(){
        try{
            FileInputStream desalvaSoci = new FileInputStream("Soci.ser");
            ObjectInputStream dSoci = new ObjectInputStream(desalvaSoci);

            elencoSoci = (TreeMap<String, Socio>) dSoci.readObject();
            dSoci.close();
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
        for (Socio socio : elencoSoci.values()) {
            s += socio.toString() + "\n\n";
        }
        return s;
    }
}
