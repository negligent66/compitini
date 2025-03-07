import java.io.Serializable;

public class Socio implements Serializable {
    private String cF;
    private String nome;

    public Socio() {
        cF = "";
        nome = "";
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public Socio(String cF) {
        this.cF = cF;
    }

    public String getcF() {
        return cF;
    }

    public void setcF(String cF) {
        this.cF = cF;
    }
    public String toString(){
        return "Codice fiscale: " + cF + "\nNome: " + nome;
    }
}
