package aulas.exercicios.md23.teste_parte1.test;

import aulas.exercicios.md23.teste_parte1.main.App;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.junit.Assert.assertTrue;

public class AppTest {
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void testApp() {
        systemInMock.provideLines("4", "João,M", "Maria,F", "José,M", "Zila, f");
        App.main(new String[]{});
        assertTrue(App.nomesFemininos.contains("Maria"));
        assertTrue(App.nomesFemininos.contains("Zila"));
        assertEquals(2, App.nomesFemininos.size());
    }
}
