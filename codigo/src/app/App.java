package app;

import business.*;

public class App {
    public static void main(String[] args) {
        Grafo grafo100 = Gerador.gerarGrafoSimples(100, 300);
        Gerador.escreverArquivo(grafo100);
    }
}
