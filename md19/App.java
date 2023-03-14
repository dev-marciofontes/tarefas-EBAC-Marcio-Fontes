package aulas.exercicios.md18;

public class App {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();

        // Utilizando o aprendido na aula de Reflections
        // para obter a classe do objeto cliente
        Class<?> classe = cliente.getClass();

        // Criando uma verificação simples para checar
        // se a anotação Tabela está presente na classe
        if (classe.isAnnotationPresent(Tabela.class)) {
            // Obtém a anotação Tabela
            Tabela tabela = classe.getAnnotation(Tabela.class);

            // Imprime o nome da tabela conforme solicitado no exercício
            System.out.println("Nome da tabela: " + tabela.value());
        } else {
            System.out.println("A classe não possui a anotação Tabela.");
        }
    }
}
