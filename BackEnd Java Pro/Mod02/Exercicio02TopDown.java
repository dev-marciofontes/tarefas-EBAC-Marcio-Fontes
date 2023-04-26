import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/*
* Diferença entre a abordagem puramente recursiva com esta usando programação dinâmica topo-down:
* A função principal chama uma função auxiliar recursiva com o valor de n. A função auxiliar calcula o fatorial de n dividindo o problema em subproblemas menores (n-1, n-2, ...).
* A memoização é aplicada para armazenar os resultados dos subproblemas já resolvidos, evitando aquele tanto de recálculos desnecessários.
* Dessa forma, a abordagem top-down começa com o problema principal e trabalha para os problemas menores.
 */

public class Exercicio02TopDown {

    public static BigInteger fatorial(int n) {
        BigInteger[] memoria = new BigInteger[n + 1];
        return fatorialRecursivo(n, memoria);
    }

    private static BigInteger fatorialRecursivo(int n, BigInteger[] memo) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        // Verifica se o valor já foi calculado
        if (memo[n] != null) {
            return memo[n];
        }

        // Calcula o fatorial de n-1 de forma recursiva e armazena o resultado
        BigInteger resultado = BigInteger.valueOf(n).multiply(fatorialRecursivo(n - 1, memo));

        // Armazena o resultado no array para uso futuro
        memo[n] = resultado;
        return resultado;
    }

    public static void main(String[] args) {
        // int n = 101; // Exemplo de valor para n
        /*
         * Consegui calcular o fatorial acima de 101 usando a programação dinâmica top down,
         * mas para a correta apresentação dos números tive que usar o BigInteger e pesquisar sobre seus metodos!
         */


        // int n = 3;
        int n = 7;

        BigInteger resultado = fatorial(n);
        System.out.println("Fatorial de " + n + " é: " + resultado);
    }

}
