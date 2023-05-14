package app;

import business.*;


public class App {

    public static void main(String[] args) {
        Grafo grafo = Gerador.gerarGrafoSimples(15, 30);
//        Warshall.imprimirFechoTransitivoDireto(grafo);

        MetodoNaive.imprimirFechoTransitivoDireto(grafo);


    }
}
