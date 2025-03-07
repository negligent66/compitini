public class TesterMergeListe {
    static Lista listina1 = new Lista();
    static Lista listina2 = new Lista();
    static Lista listina3;
    static int [] popola1 = {5, 34, 65, 88, 3443};
    static int [] popola2 = {12, 32, 42,67, 456};
    public static void main(String[] args) {
        riempiListe(listina1, popola1);
        riempiListe(listina2, popola2);
        listina3 = listina1.unisciListe(listina2);
        System.out.printf(listina3.mostraLista());
    }
    public static void riempiListe(Lista lista, int [] popola){
        for (int i = 0; i < popola.length; i++){
            lista.inserimentoInCoda(popola[i]);
        }
    }

}