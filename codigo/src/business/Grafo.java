/*
 * Classe adaptada de Sedgewick, Wayne(2014).
 * Disponível em: https://algs4.cs.princeton.edu/41graph/Graph.java.html
 */

package business;

import java.util.LinkedList;

public abstract class Grafo {
    protected final int vertices;
    protected int arestas;
    protected LinkedList<Integer>[] adj;

    /**
     * Construtor: grafo com v vertices
     * @param vertices Quantidade de vertices do grafo
     */
    public Grafo(int vertices) {
        this.vertices = vertices;
        this.arestas = 0;
        adj = new LinkedList[vertices];
        
        for(int v = 0; v < vertices; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }
    
     /**
     * Retorna a quantidade de vertices do grafo
     * @return A quantidade de vertices do grafo
     */
    public int vertices() {
        return vertices;
    }

    /**
     * Retorna a quantidade de arestas do grafo
     * @return A quantidade de arestas do grafo
     */
    public int arestas() {
        return arestas;
    }

    public abstract void adicionarArestas(int v, int w);

    /**
     * Verifica se existe uma aresta entre v e w
     * @param v Vertice incidente a aresta  
     * @param w Vertice incidente a aresta
     * @return Retorna verdadeiro se a aresta existe
     */
    public boolean existeAresta(int v, int w) {
        return adj[v].contains(w);
    }

    /**
     * Retorna uma representação do grafo em string
     * @return Retorna uma string que representa o grafo
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " vertices, " + arestas + " edges \n");
        for (int v = 0; v < vertices; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

     /**
     * Retorna os vertices adjacentes a v.
     * @param v Vertice de partida
     * @return Os vertices adjacentes ao vetice v
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

}
