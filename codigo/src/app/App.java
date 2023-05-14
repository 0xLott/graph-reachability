package app;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import business.*;


public class App {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();    // Início: Contador do tempo de execução 


        Grafo grafo = Gerador.gerarGrafoSimples(10000, 1);

        Warshall.imprimirFechoTransitivoDireto(grafo);
        // Warshall.imprimirFechoTransitivoInverso(grafo);

        // MetodoNaive.imprimirFechoTransitivoDireto(grafo);
        // MetodoNaive.imprimirFechoTransitivoInverso(grafo);


        long end = System.currentTimeMillis();  // Fim: Contador do tempo de execução 
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");      

    }
}
