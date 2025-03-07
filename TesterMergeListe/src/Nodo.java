public class Nodo {
    private Nodo link;
    private Integer info;

    public Nodo(Integer info){
        this.link = null;
        this.info = info;
    }

    public void setLink(Nodo link) {
        this.link = link;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public Nodo getLink() {
        return link;
    }

    public Integer getInfo() {
        return info;
    }
}
