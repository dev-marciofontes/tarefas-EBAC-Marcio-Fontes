package aulas.exercicios.md18;

public class App {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();

        // Utilizando o aprendido na aula de Reflections
        // para obter a classe do objeto cliente
        Class<?> classe = cliente.getClass();

        // Criando uma verifica��o simples para checar
        // se a anota��o Tabela est� presente na classe
        if (classe.isAnnotationPresent(Tabela.class)) {
            // Obt�m a anota��o Tabela
            Tabela tabela = classe.getAnnotation(Tabela.class);

            // Imprime o nome da tabela conforme solicitado no exerc�cio
            System.out.println("Nome da tabela: " + tabela.value());
        } else {
            System.out.println("A classe n�o possui a anota��o Tabela.");
        }
    }
}
