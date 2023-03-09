package aulas.exercicios.md18;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // a anota��o ser� retida em tempo de execu��o.
@Target(ElementType.TYPE) // Essa anota��o ser� aplicada em tipos (classes, interfaces, enums)
public @interface Tabela {
    String value();
}
