package business;

import java.util.LinkedList;

public class Vertice {
    boolean visitado;
    public int value;
    public LinkedList<Vertice> sucessores;

    public Vertice(int value) {
        this.visitado = false;
        this.value = value;
        sucessores = new LinkedList<>();
    }

}
