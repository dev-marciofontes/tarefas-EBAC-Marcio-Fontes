package test;

import aplicacao.Fibonacci;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciTest {
    @Test
    public void testEncontrarElemento() {
        Assertions.assertEquals(0, Fibonacci.encontrarElemento(0));
        Assertions.assertEquals(1, Fibonacci.encontrarElemento(1));
    }

    @Test
    public void testaNumerosMaioresQueDez() {
        Assertions.assertEquals(89, Fibonacci.encontrarElemento(11));
        Assertions.assertEquals(144, Fibonacci.encontrarElemento(12));
    }

    @Test
    public void testaNumerosMaioresQueCinquenta() {
        Assertions.assertEquals(225851433717L, Fibonacci.encontrarElemento(56));
    }
}
