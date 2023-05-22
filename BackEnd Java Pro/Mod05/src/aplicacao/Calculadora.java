package aplicacao;

/**
 * Classe Calculadora que realiza operações matemáticas básicas.
 */
public class Calculadora {

    /**
     * Realiza a operação de adição entre dois números inteiros.
     *
     * @param a O primeiro número inteiro.
     * @param b O segundo número inteiro.
     * @return O resultado da adição entre os números.
     */
    public int adicionar(int a, int b) {
        return a + b;
    }

    /**
     * Realiza a operação de subtração entre dois números inteiros.
     *
     * @param a O primeiro número inteiro.
     * @param b O segundo número inteiro.
     * @return O resultado da subtração entre os números.
     */
    public int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Realiza a operação de multiplicação entre dois números inteiros.
     *
     * @param a O primeiro número inteiro.
     * @param b O segundo número inteiro.
     * @return O resultado da multiplicação entre os números.
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Realiza a operação de divisão entre dois números inteiros.
     *
     * @param a O dividendo.
     * @param b O divisor.
     * @return O resultado da divisão entre os números. Caso ocorra uma divisão por zero,
     * será exibida uma mensagem de erro e retornado o valor 0.
     */
    public int dividir(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Erro: Divisão por zero não é permitida!");
            return 0;
        }
    }
}