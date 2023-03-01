package aulas.exercicios.md15;

public class Comprador {
    public static void main(String[] args) {

        // cria uma instância da classe FabricaFiat, que é uma implementação da interface FabricaDeCarro
        FabricaDeCarros fabrica = new FabricaFord();

        // usa a fábrica criada acima para criar uma instância de CarroSedan e uma instância de CarroPopular
        CarroSedan sedan = fabrica.criarCarroSedan();
        CarroPopular popular = fabrica.criarCarroPopular();

        // exibe as informações dos carros criados acima, usando os métodos exibirInfoSedan() e exibirInfoPopular()
        sedan.exibirInfoSedan();
        System.out.println();
        popular.exibirInfoPopular();
        System.out.println();

        // cria uma instância da classe FabricaFord, que também é uma implementação da interface FabricaDeCarro
        fabrica = new FabricaFiat();

        // usa a fábrica criada acima para criar uma nova instância de CarroSedan e uma nova instância de CarroPopular
        sedan = fabrica.criarCarroSedan();
        popular = fabrica.criarCarroPopular();

        // exibe as informações dos novos carros criados, usando os mesmos métodos exibirInfoSedan() e exibirInfoPopular()
        sedan.exibirInfoSedan();
        System.out.println();
        popular.exibirInfoPopular();
    }
}
