package app;

import business.*;

public class App {
    public static void main(String[] args) throws Exception {
        GrafoDirecionado g = Gerador.gerarGrafoDirecionadoSimples(10, 30);
        System.out.println(g.toString());
    }
}
