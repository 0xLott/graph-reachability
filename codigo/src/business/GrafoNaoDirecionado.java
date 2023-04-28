package business;

public class GrafoNaoDirecionado extends Grafo {
    
    /**
     * Construtor: um grafo não direcionado com V vertices
     * @param vertices A quantidade de vertices do grafo
     */
    public GrafoNaoDirecionado (int vertices) {
        super(vertices);
    }
    
    /**
     * Adiciona uma aresta incidente a v e a w
     * @param v Vertice incidente a aresta
     * @param w Vertice incidente a aresta 
     */
    public void adicionarArestas(int v, int w) {
        arestas++;
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     * Retorna o grau do vertice indicado
     * @param v Vertice indicado
     * @return Retorna o grau do vertice indicado
     */
    public int grauDoVertice(int v) {
        return adj[v].size();
    }
}
