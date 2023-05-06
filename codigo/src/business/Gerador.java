package business;

import java.util.*;

public class Gerador {
    private static Random randomNum = new Random();

    private Gerador() {
    };

    public static GrafoDirecionado gerarGrafoDirecionadoSimples(int qtdVertices, int qtdArestas) {

        GrafoDirecionado g = new GrafoDirecionado(qtdVertices);

        if (qtdVertices < 0) {
            throw new IllegalArgumentException("Quantidade de vertices inválida");
        } else if (qtdArestas < 0 || qtdArestas > (qtdVertices * (qtdVertices - 1) / 2)) {
            throw new IllegalArgumentException("Quantidade de arestas inválida");
        } else {
            while (qtdArestas > g.arestas) {
                int v = randomNum.nextInt(qtdVertices);
                int w = randomNum.nextInt(qtdVertices);

                if (v != w && !g.existeAresta(v, w)) {
                    g.adicionarArestas(v, w);
                }
            }

            return g;
        }
    }
}