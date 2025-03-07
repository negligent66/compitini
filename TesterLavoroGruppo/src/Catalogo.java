import java.util.*;

public class Catalogo {
    final static int NUMERO_MASSIMO_PRODOTTI = 100000;
    HashMap<Integer, Prodotto> prodotti; // tabella hash di prodotti

    // costruttore
    public Catalogo() {
        prodotti = new HashMap<Integer, Prodotto>(NUMERO_MASSIMO_PRODOTTI);
    }

    // aggiunta di un nuovo prodotto al catalogo
    public void aggiungiProdotto(Prodotto prodotto)
            throws TroppiProdotti, ProdottoEsistente, CloneNotSupportedException {
        if (prodotti.size() >= NUMERO_MASSIMO_PRODOTTI)
            throw new TroppiProdotti();
        if (prodotti.containsKey(prodotto.getCodice()))
            throw new ProdottoEsistente();
        prodotti.put(prodotto.getCodice(), prodotto.clone());
    }

    // eliminazione di un prodotto dal catalogo a partire dal codice
    public void eliminaProdotto(int codice) throws ProdottoInesistente {
        if (prodotti.isEmpty() || !prodotti.containsKey(codice))
            throw new ProdottoInesistente();
        prodotti.remove(codice);
    }

    // eliminazione di un prodotto dal catalogo a partire dal titolo
    public void eliminaProdotto(String titolo) throws ProdottoInesistente {
        for (Prodotto prodotto : prodotti.values())
            if (prodotto.getTitolo().equals(titolo))
                eliminaProdotto(prodotto.getCodice());
        throw new ProdottoInesistente();
    }

    // ricerca di un prodotto nel catalogo a partire dal codice
    public Prodotto cercaProdotto(int codice) throws ProdottoInesistente, CloneNotSupportedException {
        if (prodotti.isEmpty() || !prodotti.containsKey(codice))
            throw new ProdottoInesistente();
        return prodotti.get(codice).clone();
    }

    // ricerca di un prodotto nel catalogo a partire dal titolo
    public Prodotto cercaProdotto(String titolo) throws ProdottoInesistente, CloneNotSupportedException {
        for (Prodotto prodotto : prodotti.values())
            if (prodotto.getTitolo().equals(titolo))
                return prodotto.clone();
        throw new ProdottoInesistente();
    }

    // restituzione di un vettore contenente i prodotti del catalogo
    public Prodotto[] elencaProdotti() {
        return prodotti.values().toArray(new Prodotto[0]);
    }
}
