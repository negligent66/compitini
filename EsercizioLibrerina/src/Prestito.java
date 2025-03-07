import java.io.Serializable;

public class Prestito implements Serializable {
    private String codiceLibroSocio;

    public Prestito() {
        codiceLibroSocio = "";
    }

    public void setCodiceLibroSocio(String codiceLibro, String codiceSocio) {
        this.codiceLibroSocio = codiceLibro + "-" + codiceSocio;
    }
    public String getCodiceLibroSocio() {
        return codiceLibroSocio;
    }
    public String getCodiceLibro() {
        return codiceLibroSocio.split("-")[0];
    }
    public String getCodiceSocio() {
        return codiceLibroSocio.split("-")[1];
    }
    public String toString(){
        return "Codice libro: " + getCodiceLibro() + "\nCodice socio: " + getCodiceSocio();
    }
}
