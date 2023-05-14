/*
 * Classe adaptada de Sedgewick, Wayne(2014).
 * Disponível em: https://algs4.cs.princeton.edu/41graph/Graph.java.html
 */

package business;

import java.util.LinkedList;

public class Grafo {
    private final int vertices;
    private int arestas;
    LinkedList<Integer>[] adj;
    private int[] grauEntrada;

    /**
     * Construtor: grafo com v vertices
     * 
     * @param vertices Quantidade de vertices do grafo
     */
    public Grafo(int vertices) {
        this.vertices = vertices;
        this.arestas = 0;
        adj = new LinkedList[vertices];
        grauEntrada = new int[vertices];

        for (int v = 0; v < vertices; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }

    /**
     * Retorna a quantidade de vertices do grafo
     * 
     * @return A quantidade de vertices do grafo
     */
    public int vertices() {
        return vertices;
    }

    /**
     * Retorna a quantidade de arestas do grafo
     * 
     * @return A quantidade de arestas do grafo
     */
    public int arestas() {
        return arestas;
    }

    /**
     * Adiciona uma aresta partindo de v e chegando em w
     *
     * @param v Vertice de saída
     * @param w Vertice de chegada
     */
    public void adicionarArestas(int v, int w) {
        adj[v].add(w);
        grauEntrada[w]++;
        arestas++;
    }

    /**
     * Verifica se existe uma aresta entre v e w
     * 
     * @param v Vertice incidente a aresta
     * @param w Vertice incidente a aresta
     * @return Retorna verdadeiro se a aresta existe
     */
    public boolean existeAresta(int v, int w) {
        return adj[v].contains(w);
    }

    /**
     * Retorna os vertices adjacentes a v.
     * 
     * @param v Vertice de partida
     * @return Os vertices adjacentes ao vetice v
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * Retorna o número de arestas que saem de um vertice
     *
     * @param v O vertice
     * @return O grau de saída de V
     */
    public int grauSaida(int v) {
        return adj[v].size();
    }

    /**
     * Retorna o número de arestas que entram em um vertice
     *
     * @param v O vertice
     * @return O grau de entrada de V
     */
    public int grauEntrada(int v) {
        return grauEntrada(v);
    }

    /**
     * Retorna uma representação do grafo em string no seguinte formato:
     * 1ª linha: qtd. de vértices, qtd. de arestas
     * Demais linhas: vértice de origem + vértice de destino
     *
     * @return Retorna uma string que representa o grafo
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(vertices + "," + arestas + "\n");

        for (int v = 0; v < vertices; v++) {
            for (int e : adj[v]){
                s.append(v);
                s.append(" " + e);
                s.append("\n");
            }
        }
        return s.toString();
    }
}
