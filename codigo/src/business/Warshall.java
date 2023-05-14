package business;

public class Warshall {
    private Warshall() {
    };

    /**
     * Calcula o fecho transitivo em um grafo conforme do método de Warshall (1962).
     * O valor da matriz[i][j] é verdadeiro se existe um caminho direcionado do vértice i ao vértice j no grafo.
     *
     * @param grafo Grafo a ser utilizado para calcular o fecho transitivo.
     * @return Matriz booleana que indica se há caminho de um vértice a outro no grafo.
     */
    public static boolean[][] fechoTransitivo(Grafo grafo) {
        int qtdVertices = grafo.vertices();
        boolean alcancabilidade[][] = new boolean[qtdVertices][qtdVertices];

        for (int i = 0; i < qtdVertices; i++) {
            for (int j = 0; j < qtdVertices; j++) {
                if (i == j || grafo.existeAresta(i, j)) {
                    alcancabilidade[i][j] = true;
                } else {
                    alcancabilidade[i][j] = false;
                }
            }
        }

        for (int k = 0; k < qtdVertices; k++) {
            for (int i = 0; i < qtdVertices; i++) {
                for (int j = 0; j < qtdVertices; j++) {
                    if (alcancabilidade[i][j] || ((alcancabilidade[i][k]) && (alcancabilidade[k][j]))) {
                        alcancabilidade[i][j] = true;
                    } else {
                        alcancabilidade[i][j] = false;
                    }
                }
            }
        }

        return alcancabilidade;
    }

    /**
     * Calcula e imprime o fecho transitivo direto de todos os vértices de um grafo
     *
     * @param g Grafo a ser utilizado para calcular o fecho transitivo.
     */
    public static void imprimirFechoTransitivoDireto(Grafo g) {
        boolean fechoTransitivo[][] = Warshall.fechoTransitivo(g);

        System.out.println("Fecho transitivo direto de todos os vertices do grafo: ");

        for (int i = 0; i < g.vertices(); i++) {
            System.out.print("[" + i + "]: ");

            for (int j = 0; j < g.vertices(); j++) {
                if (fechoTransitivo[i][j]) {
                    System.out.print(j + " ");
                }
            }

            System.out.println(" ");
        }
    }

    /**
     * Calcula e imprime o fecho transitivo direto de determinado vértice de um
     * grafo.
     *
     * @param g Grafo a ser utilizado para calcular o fecho transitivo.
     * @param v vértice selecionado
     */
    public static void imprimirFechoTransitivoDireto(Grafo g, int v) {
        boolean fechoTransitivo[][] = Warshall.fechoTransitivo(g);

        System.out.println("Fecho transitivo direto de : " + v);
        System.out.print("[" + v + "]: ");
        for (int i = 0; i < g.vertices(); i++) {
            if (fechoTransitivo[v][i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println(" ");
    }

    /**
     * Calcula e imprime o fecho transitivo inverso de todos os vértices de um grafo.
     *
     * @param g Grafo a ser utilizado para calcular o fecho transitivo.
     */
    public static void imprimirFechoTransitivoInverso(Grafo g) {
        boolean fechoInverso[][] = Warshall.fechoTransitivo(g);
        System.out.println("Fecho transitivo inverso de todos os vertices do grafo: ");

        for (int i = 0; i < g.vertices(); i++) {
            System.out.print("[" + i + "]: ");
            for (int j = 0; j < g.vertices(); j++) {
                if (fechoInverso[j][i]) {
                    System.out.print(j + " ");
                }
            }

            System.out.println(" ");
        }
    }

    /**
     * Calcula e imprime o fecho transitivo inverso de determinado vértice de um
     * grafo
     *
     * @param g Grafo a ser utilizado para calcular o fecho transitivo.
     * @param v vértice selecionado
     */
    public static void imprimirFechoTransitivoInverso(Grafo g, int v) {
        boolean fechoInverso[][] = Warshall.fechoTransitivo(g);

        System.out.println("Fecho transitivo inverso de : " + v);
        System.out.print("[" + v + "]: ");
        for (int i = 0; i < g.vertices(); i++) {
            if (fechoInverso[i][v]) {
                System.out.print(i + " ");
            }
        }

        System.out.println(" ");
    }
}
