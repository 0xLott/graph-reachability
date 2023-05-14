/*
 * Este método utiliza a BFS (Breadth-First Search, ou Busca em Largura) para encontrar o fecho transitivo
 * de cada vértice de um grafo direcionado.
 */

package business;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

public class MetodoNaive {

    // public static void lerArquivo(File file) {
    // Scanner filereader = null;
    //
    // try {
    // filereader = new Scanner(file);
    // } catch (Exception e) {
    // System.out.println("Erro: Arquivo não encontrado.");
    // }
    //
    // qtdVertices = Integer.parseInt(filereader.nextLine().split(",")[0]);
    // qtdArestas = Integer.parseInt(filereader.nextLine().split(",")[1]);
    //
    // // Inserir vértices na lista de vértices
    // while (filereader.hasNextLine()) {
    // int currentInput = Integer.parseInt(filereader.nextLine().split(" ")[0]);
    // vertices.add(new Vertice(currentInput));
    // }
    //
    // // Popular lista de sucessores
    // }

    public static LinkedList BFS(Grafo g, int v) {
        LinkedList<Integer> fechoTransitivo = new LinkedList<>();

        boolean visitado[] = new boolean[g.vertices()];
        LinkedQueue<Integer> fila = new LinkedQueue<Integer>();

        visitado[v] = true;
        fila.enqueue(v);

        for (int i = 0; !fila.isEmpty(); i++) {
            v = fila.dequeue();

            fechoTransitivo.add(v); // Adiciona vértice ao array do fecho transitivo

            Iterator<Integer> iterator = g.adj[v].listIterator();
            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visitado[n]) {
                    visitado[n] = true;
                    fila.enqueue(n);
                }
            }
        }

        return fechoTransitivo;
    }

    public static Grafo gerarGrafoInverso (Grafo g) {
    	Grafo inverso = new Grafo(g.vertices());
    	
    	String grafoString = g.toString();
    	String[] grafoInverso = grafoString.split("\n");
    	
    	for(int i = 1; i <= g.arestas(); i++) {
    		String[] vertices = grafoInverso[i].split(" ");
    		inverso.adicionarArestas(Integer.parseInt(vertices[1]), Integer.parseInt(vertices[0]));
    	}
    
    	return inverso;
    }

    /**
     * Calcula e imprime o fecho transitivo direto de determinado vértice de um
     * grafo
     *
     * @param g Grafo a ser utilizado para calcular o fecho transitivo.
     * @param v vértice selecionado
     */
    public static void imprimirFechoTransitivoDireto(Grafo g, int v) {
        Object[] fecho = BFS(g, v).toArray();

        System.out.print("r+(" + v + ") = [");

        for (int i = 0; i < fecho.length; i++) {
            System.out.printf(fecho[i] + " ");
        }

        System.out.print("]");
    }

    /**
     * Calcula e imprime o fecho transitivo direto de todos os vértices de um
     * grafo.
     *
     * @param g Grafo a ser utilizado para calcular o fecho transitivo.
     */
    public static void imprimirFechoTransitivoDireto(Grafo g) {

        for (int v = 0; v < g.vertices(); v++) {

            Object[] fecho = BFS(g, v).toArray();

            System.out.print("r+(" + v + ") = [");

            for (int i = 0; i < fecho.length; i++) {
                System.out.printf(fecho[i] + " ");
            }

            System.out.print("]\n");
        }
    }

    /**
     * Calcula e imprime o fecho transitivo inverso de todos os vértices de um
     * grafo.
     *
     * @param g Grafo a ser utilizado para ser invertido e calcular o fecho transitivo.
     */
    public static void imprimirFechoTransitivoInverso(Grafo g) {

        for (int v = 0; v < g.vertices(); v++) {

            Object[] fecho = BFS(MetodoNaive.gerarGrafoInverso(g), v).toArray();

            System.out.print("r-(" + v + ") = [");

            for (int i = 0; i < fecho.length; i++) {
                System.out.printf(fecho[i] + " ");
            }

            System.out.print("]\n");
        }
    }
    
    /**
     * Calcula e imprime o fecho transitivo inverso de determinado vértice de um
     * grafo
     *
     * @param g Grafo a ser utilizado para ser invertido e calcular o fecho transitivo.
     * @param v vértice selecionado
     */
    public static void imprimirFechoTransitivoInverso(Grafo g, int v) {
        Object[] fecho = BFS(MetodoNaive.gerarGrafoInverso(g), v).toArray();

        System.out.print("r-(" + v + ") = [");

        for (int i = 0; i < fecho.length; i++) {
            System.out.printf(fecho[i] + " ");
        }

        System.out.print("]");
    }

}
