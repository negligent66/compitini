class NodoAlbero<E extends Comparable<E>> {
    private E info;
    private NodoAlbero<E> left;
    private NodoAlbero<E> right;

    public NodoAlbero(E info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public NodoAlbero<E> getLeft() {
        return left;
    }

    public void setLeft(NodoAlbero<E> left) {
        this.left = left;
    }

    public NodoAlbero<E> getRight() {
        return right;
    }

    public void setRight(NodoAlbero<E> right) {
        this.right = right;
    }
    @Override
    public String toString() {
        return "Informazione: " + info;
    }
}
