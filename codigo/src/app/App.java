package app;

import business.*;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws Exception {
        GrafoDirecionado g = Gerador.gerarGrafoDirecionadoSimples(100, 300);

        try {
            FileWriter graph100 = new FileWriter("./codigo/graph100.txt");

            try {
                graph100.append(g.toString());
                graph100.flush();
            } catch (Exception e) {
                System.out.println("Erro ao escrever em arquivo.");
            } finally {
                graph100.close();
            }

        } catch (Exception e) {
            System.out.println("Erro ao gerar arquivo.");
        }

        System.out.println(g);
    }
}
