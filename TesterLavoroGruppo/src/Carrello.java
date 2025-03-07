import java.util.*;

public class Carrello {
    LinkedList<Prodotto> prodotti; // lista di prodotti

    // costruttore
    public Carrello() {
        prodotti = new LinkedList<Prodotto>();
    }

    // aggiunta di un nuovo prodotto al carrello
    public void aggiungiProdotto(Prodotto prodotto) throws CloneNotSupportedException {
        prodotti.add(prodotto.clone());
    }

    // eliminazione di un prodotto dal carrello
    public void eliminaProdotto(int codice) {
        Iterator<Prodotto> i = prodotti.iterator();
        Prodotto prodotto;
        while (i.hasNext()) {
            prodotto = i.next();
            if (prodotto.getCodice() == codice)
                i.remove();
        }
    }

    // restituzione di un vettore contenente i prodotti del carrello
    public Prodotto[] elencaProdotti() {
        return prodotti.toArray(new Prodotto[0]);
    }
    // calcolo del costo totale dei prodotti del carrello
    public double calcolaImporto() {
        Iterator<Prodotto> i = prodotti.iterator();
        double totale = 0.0;
        Prodotto prodotto;
        while (i.hasNext()) {
            prodotto = i.next();
            totale += prodotto.getPrezzo()*prodotto.getQuantita();
        }
        return totale;
    }
}
