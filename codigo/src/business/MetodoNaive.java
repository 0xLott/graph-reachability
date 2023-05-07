/*
 * Este método utiliza a BFS (Breadth-First Search, ou Busca em Largura) para encontrar o fecho transitivo
 * de cada vértice de um grafo direcionado.
 */

package business;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class MetodoNaive {
    static LinkedList vertices;
    static int qtdVertices;
    static int qtdArestas;

    public static void lerArquivo(File file) {
        Scanner filereader = null;

        try {
            filereader = new Scanner(file);
        } catch (Exception e) {
            System.out.println("Erro: Arquivo não encontrado.");
        }

        qtdVertices = Integer.parseInt(filereader.nextLine().split(",")[0]);
        qtdArestas = Integer.parseInt(filereader.nextLine().split(",")[1]);

        // Inserir vértices na lista de vértices
        while (filereader.hasNextLine()) {
            int currentInput = Integer.parseInt(filereader.nextLine().split(" ")[0]);
            vertices.add(new Vertice(currentInput));
        }

        // Popular lista de sucessores
    }
}
