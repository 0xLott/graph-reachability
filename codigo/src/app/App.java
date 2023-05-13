package app;

import business.*;


public class App {

    public static void main(String[] args) {
        Grafo grafo100 = Gerador.gerarGrafoSimples(1000, 999);
        Warshall.imprimirFechoTransitivoDireto(grafo100);
    }
}
