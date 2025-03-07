public class AlberoDiRicerca<E extends Comparable<E>> extends Albero {

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

    public void delete(E val) {
        setRoot(deleteRec(getRoot(), val));
        setCount(getCount() - 1);
    }

    private NodoAlbero<E> deleteRec(NodoAlbero<E> current, E val) {
        if (current == null) {
            return null;
        }

        if (val.compareTo(current.getInfo()) < 0) {
            current.setLeft(deleteRec(current.getLeft(), val));
        } else if (val.compareTo(current.getInfo()) > 0) {
            current.setRight(deleteRec(current.getRight(), val));
        } else {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            if (current.getLeft() == null) {
                return current.getRight();
            } else if (current.getRight() == null) {
                return current.getLeft();
            }

            E minValue = findMin(current.getRight());
            current.setInfo(minValue);
            current.setRight(deleteRec(current.getRight(), minValue));
        }

        return current;
    }

    private E findMin(NodoAlbero<E> current) {
        E minValue = current.getInfo();
        while (current.getLeft() != null) {
            minValue = current.getLeft().getInfo();
            current = current.getLeft();
        }
        return minValue;
    }
}


