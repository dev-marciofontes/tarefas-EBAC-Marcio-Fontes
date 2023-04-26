public class Exercicio01 {
    public static void gerarSubconjuntos(int[] S, int n, int index, int[] atual, int tamanhoAtual) {

        // Se o tamanho do subconjunto atual for igual a n, imprima o subconjunto
        if (tamanhoAtual == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(atual[i] + " ");
            }
            System.out.println();
            return;
        }

        // Se chegarmos ao final do conjunto S, retorne
        if (index == S.length) {
            return;
        }

        // Inclui o elemento atual no subconjunto
        atual[tamanhoAtual] = S[index];
        gerarSubconjuntos(S, n, index + 1, atual, tamanhoAtual + 1);

        // Remove o elemento atual e tentar sem incluí-lo
        gerarSubconjuntos(S, n, index + 1, atual, tamanhoAtual);
    }

    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        int n = 2;

        gerarSubconjuntos(S, n, 0, new int[n], 0);
    }


}
