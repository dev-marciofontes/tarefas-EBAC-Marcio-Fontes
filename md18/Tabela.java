package aulas.exercicios.md18;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // a anotação será retida em tempo de execução.
@Target(ElementType.TYPE) // Essa anotação será aplicada em tipos (classes, interfaces, enums)
public @interface Tabela {
    String value();
}
