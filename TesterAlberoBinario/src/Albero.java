public class Albero<E extends Comparable<E>> {
    private NodoAlbero<E> root;
    private int count;

    public Albero() {
        this.root = null;
        this.count = 0;
    }

    public Albero(NodoAlbero<E> root) {
        this.root = root;
        this.count = 1;
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
        else
//        String left = r.getLeft() != null ? "(" + print(r.getLeft()) + ")" : "";
//
//        String right = r.getRight() != null ? "(" + print(r.getRight()) + ")" : "";
//
//        return left + " " + r.getInfo() + " " + right;
        return "(" + print(r.getLeft()) + " " + r.getInfo() + " " + print(r.getRight()) + ")";
    }

    public boolean cerca(E val, NodoAlbero<E> r) {
        if (r == null) {
            return false;
        }

        if (r.getInfo().compareTo(val) == 0) {
            return true;
        }

        if (cerca(val, r.getLeft())) {
            return true;
        }

        return cerca(val, r.getRight());
    }
    public int contaFoglie(NodoAlbero<E> r) {
        if (r == null) {
            return 0;
        }

        if (r.getLeft() == null && r.getRight() == null) {
            return 1;
        }

        return contaFoglie(r.getLeft()) + contaFoglie(r.getRight());
    }


}
