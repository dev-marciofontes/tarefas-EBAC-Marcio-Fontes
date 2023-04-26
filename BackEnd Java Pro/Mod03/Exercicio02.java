import java.util.Arrays;
import java.util.Collections;

public class Exercicio02 {

    public static int[] calcularTroco(int quantia, Integer[] moedas) {
        int[] resultado = new int[moedas.length];

        // Para cada moeda, tentar usá-la o máximo de vezes possível
        for (int i = 0; i < moedas.length; i++) {
            while (quantia >= moedas[i]) {
                quantia -= moedas[i];
                resultado[i]++;
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        int quantia = 18;
        Integer[] moedas = {5, 2, 1};

        // Ordenar o array de moedas em ordem decrescente
        Arrays.sort(moedas, Collections.reverseOrder());

        int[] resultado = calcularTroco(quantia, moedas);

        // Imprimir a quantidade total de moedas
        int totalMoedas = 0;
        for (int j : resultado) {
            totalMoedas += j;
        }
        System.out.println("Total de moedas: " + totalMoedas);

        // Imprimir a quantidade de cada moeda usada
        for (int i = 0; i < moedas.length; i++) {
            System.out.println("Moedas de " + moedas[i] + ": " + resultado[i]);
        }
    }


}
