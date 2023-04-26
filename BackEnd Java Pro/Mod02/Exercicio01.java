/**
 * Fatorial é igual a multiplicação dele e dos elementos sempre diminuindo de 1
 * f3 = 3 * 2 * 1
 * f4 = 4 * 3 * 2 * 1
 */

public class Exercicio01 {

    public static long fatorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fatorial(n - 1);
    }

    public static void main(String[] args) {

        // int n = 101;
        /*
         * Não foi possível calcular o fatorial de 101 usando apenas a recursão.
         * Primeiro: por causa do limite de espaço na memoria da pilha (Stack overflow) e por isso quando o valor de N
         * é muito grande, ele explode o limite de memória disponível para a pilha causando um "StackOverflowError"!
         */

        int n = 7;
        long resultado = fatorial(n);

        System.out.println("Fatorial de " + n + " é: " + resultado);
    }

}
