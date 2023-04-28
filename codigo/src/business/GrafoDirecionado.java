package business;

public class GrafoDirecionado extends Grafo {
    private int[] grauEntrada;
    
    /**
     * Construtor: um grafo direcionado com V vetices
     * @param vertices Quantidade de vertices do grafo
     */
    public GrafoDirecionado(int vertices) {
        super(vertices);
        grauEntrada = new int[vertices];
    }

    /**
     * Adiciona uma aresta partindo de v e chegando em w
     * @param v Vertice de saída
     * @param w Vertice de chegada
     */
    public void adicionarArestas(int v, int w) {
        adj[v].add(w);
        grauEntrada[w]++;
        arestas++;
    }

    /**
     * Retorna o número de arestas que saem de um vertice
     * @param v O vertice 
     * @return O garu de saída de V
     */
    public int grauSaida(int v) {
        return adj[v].size();
    }

    /**
     * Retorna o número de arestas que entram em um vertice
     * @param v O vertice
     * @return O grau de entrada de V
     */
    public int grauEntrada(int v) {
        return grauEntrada(v);
    }

   
    /**
     * Retorna um grafo direcionado com as arestas revertidas  
     * @return Novo grafo com as arestas do grafo original invertidas.
     */
    public GrafoDirecionado reverso() {
        GrafoDirecionado grafoReverso = new GrafoDirecionado(this.vertices);

        for(int v = 0; v < this.vertices; v++) {
            for(int w: adj(v)) {
                grafoReverso.adicionarArestas(w, v);
            }
        }

        return grafoReverso;
    }
}
