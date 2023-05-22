package test;

import aplicacao.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    public void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    public void testarAdicionar() {
        int result = calculadora.adicionar(5, 3);
        Assertions.assertEquals(8, result);
    }

    @Test
    public void testarSubtrair() {
        int result = calculadora.subtrair(7, 2);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void testarMultiplicar() {
        int result = calculadora.multiplicar(4, 3);
        Assertions.assertEquals(12, result);
    }

    @Test
    public void testarDividir() {
        int result = calculadora.dividir(10, 2);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void testarDividirPorZero() {
        int result = calculadora.dividir(8, 0);
        Assertions.assertEquals(0, result);
    }

}
