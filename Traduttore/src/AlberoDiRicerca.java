import java.util.ArrayList;

public class AlberoDiRicerca<E extends Comparable<E>>{
    private NodoAlbero<E> root;
    private int count;

    public AlberoDiRicerca() {
        this.root = null;
        this.count = 0;
    }

    public NodoAlbero<E> getRoot() {
        return root;
    }

    public int getCount() {
        return count;
    }

    public void setRoot(NodoAlbero<E> root) {
        this.root = root;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String print(NodoAlbero<E> r) {
        if (r == null) {
            return "";
        }
        else {
            String left = r.getLeft() != null ? "(" + print(r.getLeft()) + ")" : "";

            String right = r.getRight() != null ? "(" + print(r.getRight()) + ")" : "";

            return left + " " + r.getInfo() + " " + right;
        }
    }

    public String cercaParola(String val, NodoAlbero<String> r) {
        if (r == null) {
            return null;
        }

        String[] arrayino = r.getInfo().split(";");

        if (arrayino[0].equalsIgnoreCase(val)) {
            return arrayino[1];
        }

        if (arrayino[0].compareToIgnoreCase(val) < 0) {
            return cercaParola(val, r.getRight());
        } else {
            return cercaParola(val, r.getLeft());
        }
    }
    public void insert(E val) {
        setRoot(insertRec(getRoot(), val));
        setCount(getCount() + 1);
    }

    private NodoAlbero<E> insertRec(NodoAlbero<E> current, E val) {
        if (current == null) {
            return new NodoAlbero<E>(val);
        }

        if (val.compareTo(current.getInfo()) < 0) {
            current.setLeft(insertRec(current.getLeft(), val));
        } else if (val.compareTo(current.getInfo()) > 0) {
            current.setRight(insertRec(current.getRight(), val));
        }

        return current;
    }
    public void insertBalanced(ArrayList<String> list) {
        root = insertBalancedHelper(list, 0, list.size() - 1);
    }

    private NodoAlbero insertBalancedHelper(ArrayList<String> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        NodoAlbero node = new NodoAlbero(list.get(mid));
        node.setLeft(insertBalancedHelper(list, start, mid - 1));
        node.setRight(insertBalancedHelper(list, mid + 1, end));
        return node;
    }

}
