package business;

import java.io.FileWriter;
import java.util.*;

public class Gerador {
    private static Random randomNum = new Random();

    /**
     * Gera grafo direcionado simples com valores aleatórios para vértices e arestas conforme
     * a quantidade recebida por parâmetro.
     *
     * @param qtdVertices Quantidade de vértices a serem gerados
     * @param qtdArestas Quantidade de arestas a serem gerados
     * @return  Grafo gerado
     */
    public static Grafo gerarGrafoSimples(int qtdVertices, int qtdArestas) {

        Grafo g = new Grafo(qtdVertices);

        if (qtdVertices < 0) {
            throw new IllegalArgumentException("Quantidade de vertices inválida");
        } else if (qtdArestas < 0 || qtdArestas > (qtdVertices * (qtdVertices - 1) / 2)) {
            throw new IllegalArgumentException("Quantidade de arestas inválida");
        } else {
            while (qtdArestas > g.arestas()) {
                int v = randomNum.nextInt(qtdVertices);
                int w = randomNum.nextInt(qtdVertices);

                if (v != w && !g.existeAresta(v, w)) {
                    g.adicionarArestas(v, w);
                }
            }

            return g;
        }
    }

    public static void escreverArquivo(Grafo g) {
        try {
            FileWriter graph100 = new FileWriter("./codigo/graph100.txt");

            try {
                graph100.append(g.toString());
                graph100.flush();
            } catch (Exception e) {
                System.out.println("Erro ao escrever em arquivo.");
            } finally {
                graph100.close();
            }

        } catch (Exception e) {
            System.out.println("Erro ao gerar arquivo.");
        }
    }
}