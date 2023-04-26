import java.math.BigInteger;


/*
 * Diferença entre a abordagem puramente recursiva com esta usando programação dinâmica bottom-up:
 * Na abordagem bottom-up aplicada ao cálculo do fatorial, a função principal utiliza um loop para construir a solução de forma iterativa,
 * começando pelos problemas menores (fatoriais de 1, 2, ...) e avançando até o problema principal (fatorial de n).
 * Nesse caso, a solução do problema principal é construída a partir das soluções dos subproblemas menores.
 * Aqui, a memoização não é necessária, pois os resultados dos subproblemas menores foram armazenados nas iterações anteriores do loop.
 */


public class Exercicio02BottonUp {

    public static BigInteger fatorial(int n) {
        BigInteger[] memo = new BigInteger[n + 1];

        memo[0] = BigInteger.ONE;
        memo[1] = BigInteger.ONE;

        // Preenchendo o array memo de forma bottom-up
        for (int i = 2; i <= n; i++) {
            memo[i] = BigInteger.valueOf(i).multiply(memo[i - 1]);
        }

        // Retorna o resultado armazenado no array memo
        return memo[n];
    }

    public static void main(String[] args) {
        // int n = 101; // Exemplo de valor para n
        /*
         * Consegui calcular o fatorial acima de 101 usando a programação dinâmica botton up,
         * mas para a correta apresentação dos números tive também que usar o BigInteger.
         */

        //int n = 3; // Exemplo de valor para n
        int n = 7;
        BigInteger resultado = fatorial(n);
        System.out.println("Fatorial de " + n + " é: " + resultado);
    }

}
