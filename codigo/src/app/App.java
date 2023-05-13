package app;
import business.*;

import java.io.File;

public class App {
    public static void imprimirFechoTransitivoDiretoFloydWarshall(Grafo g) {
        boolean fechoTransitivo[][] = FloydWarshall.fechoTransitivo(g);
        
        System.out.println("Fecho transitivo direto de todos os vertices do grafo: ");
        
        for(int i = 0; i < g.vertices(); i++) {
            System.out.print("[" + i + "]: ");
            
            for(int j = 0; j < g.vertices(); j++) {
                if(fechoTransitivo[i][j]) {
                    System.out.print(j + " ");
                }
            }

            System.out.println(" ");
        }
    } 
    
    public static void imprimirFechoTransitivoInversoFloydWarshall(Grafo g) {
        boolean fechoInverso[][] = FloydWarshall.fechoTransitivo(g);
        System.out.println("Fecho transitivo inverso de todos os vertices do grafo: ");

        for(int i = 0; i < g.vertices(); i++) {
            System.out.print("["+i+"]: ");
            for(int j = 0; j < g.vertices(); j++) {
                if(fechoInverso[j][i]) {
                    System.out.print(j + " ");
                }
            }

            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        Grafo grafo100 = Gerador.gerarGrafoSimples(100, 300);
        imprimirFechoTransitivoDiretoFloydWarshall(grafo100);
        imprimirFechoTransitivoInversoFloydWarshall(grafo100);

       Gerador.escreverArquivo(grafo100);
        MetodoNaive.lerArquivo(new File("./codigo/graph100.txt"));


    }
}
