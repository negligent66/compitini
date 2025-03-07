public class Lista {
    private Nodo head;
    private int count;

    public Lista(){
        this.head = null;
        this.count = 0;
    }

    public void inserimentoInTesta(Integer informazione){
        if(head == null){
            head = new Nodo(informazione);
        }else{
            Nodo nuovo = new Nodo(informazione);
            nuovo.setLink(head);
            head = nuovo;
        }
        count++;
    }
    public void inserimentoInCoda(Integer informazione){
        Nodo tmp = head;
        Nodo nuovo = new Nodo(informazione);
        if(head == null){
            head = new Nodo(informazione);
            count++;
            return;
        }
        while(tmp.getLink() != null){
            tmp = tmp.getLink();
        }
        tmp.setLink(nuovo);
        count++;
    }
    public void inserimentoInCentro(Integer informazione, int posizione){
        Nodo tmp = head;
        if(head == null){
            head = new Nodo(informazione);
            count++;
            return;
        }
        Nodo nuovo = new Nodo(informazione);
        int indice = 1;
        while(indice != posizione){
            tmp = tmp.getLink();
            indice++;
        }
        Nodo tmp2 = tmp.getLink();
        tmp.setLink(nuovo);
        nuovo.setLink(tmp2);
        count++;
    }
    public Integer rimozioneInTesta(){
        if (count == 0) {
            return null;
        }
        Integer c = null;
        if (count > 0){
            count--;
            c = head.getInfo();
            head = head.getLink();
        }
        return c;
    }
    public Integer rimozioneInCoda(){
        if (count == 0) {
            return null;
        }
        Integer c = null;
        Nodo tmp = head;
        if(tmp.getLink() == null){
            c = tmp.getInfo();
            return c;
        }
        while(tmp.getLink().getLink() != null){
            tmp = tmp.getLink();
        }
        c = tmp.getLink().getInfo();
        tmp.setLink(null);
        count--;
        return c;
    }
    public Integer rimozioneInCentro(int posizione){
        if (posizione < 1 || posizione > count) {
            return null;
        }

        if (posizione == 1) {
            return rimozioneInTesta();
        }

        Nodo tmp = head;
        for (int i = 1; i < posizione - 1; i++) {
            tmp = tmp.getLink();
        }

        Nodo nodoDaRimuovere = tmp.getLink();
        Integer c = nodoDaRimuovere.getInfo();
        tmp.setLink(nodoDaRimuovere.getLink());
        count--;
        return c;
    }
    public Integer visitaLista(int posizione) {
        if (posizione < 1 || posizione > count) {
            return null;
        }

        Nodo tmp = head;
        for (int i = 1; i < posizione; i++) {
            tmp = tmp.getLink();
        }

        return tmp.getInfo();
    }
    public Lista unisciListe(Lista lista) {
        Nodo tmp1 = this.head;
        Nodo tmp2 = lista.getHead();

        Lista nuovaListina = new Lista();

        while (tmp1 != null && tmp2 != null) {
            if (tmp1.getInfo() <= tmp2.getInfo()) {
                nuovaListina.inserimentoInCoda(tmp1.getInfo());
                tmp1 = tmp1.getLink();
            } else {
                nuovaListina.inserimentoInCoda(tmp2.getInfo());
                tmp2 = tmp2.getLink();
            }
        }

        while (tmp1 != null) {
            nuovaListina.inserimentoInCoda(tmp1.getInfo());
            tmp1 = tmp1.getLink();
        }
        while (tmp2 != null) {
            nuovaListina.inserimentoInCoda(tmp2.getInfo());
            tmp2 = tmp2.getLink();
        }
        return nuovaListina;
    }


    public int getCount(){
        return count;
    }

    public Nodo getHead() {
        return head;
    }

    public String mostraLista(){
        Nodo tmp = head;
        String s = "";
        for (int i = 1; i <= count; i++) {
            s = s + tmp.getInfo() + " ";
            tmp = tmp.getLink();
        }
        return s;
    }
}