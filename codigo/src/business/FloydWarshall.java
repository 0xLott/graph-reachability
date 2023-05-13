package business;

public class FloydWarshall {
    private FloydWarshall(){};

    public static boolean[][] fechoTransitivo(Grafo grafo) {
        int qtdVertices = grafo.vertices();
        boolean alcancabilidade[][] = new boolean[qtdVertices][qtdVertices];

        /* */
        for(int i = 0; i < qtdVertices; i++) {
            for(int j = 0; j < qtdVertices; j++) {
                if (i==j || grafo.existeAresta(i, j)) {
                    alcancabilidade[i][j] = true;
                } else {
                    alcancabilidade[i][j] = false;
                }
            }
        }

        for (int k = 0; k < qtdVertices; k++) {
            for(int i = 0; i < qtdVertices; i++) {
                for(int j = 0; j < qtdVertices; j++) {
                    if(alcancabilidade[i][j] || ((alcancabilidade[i][k]) && (alcancabilidade[k][j]))) {
                        alcancabilidade[i][j] = true;
                    } else {
                        alcancabilidade[i][j] = false;
                    }
                }
            }
        }

        return alcancabilidade;
    }
}
