package aplicacao;

public class Fibonacci {

    public static long encontrarElemento(int n) {
        if (n <= 1) {
            return n;
        }

        long[] memo = new long[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        preencherMemo(memo, n);

        return memo[n];
    }

    private static void preencherMemo(long[] memo, int n) {
        long a = 0;
        long b = 1;

        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
            memo[i] = temp;
        }
    }

}
