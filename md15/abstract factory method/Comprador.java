package aulas.exercicios.md15;

public class Comprador {
    public static void main(String[] args) {

        // cria uma inst�ncia da classe FabricaFiat, que � uma implementa��o da interface FabricaDeCarro
        FabricaDeCarros fabrica = new FabricaFord();

        // usa a f�brica criada acima para criar uma inst�ncia de CarroSedan e uma inst�ncia de CarroPopular
        CarroSedan sedan = fabrica.criarCarroSedan();
        CarroPopular popular = fabrica.criarCarroPopular();

        // exibe as informa��es dos carros criados acima, usando os m�todos exibirInfoSedan() e exibirInfoPopular()
        sedan.exibirInfoSedan();
        System.out.println();
        popular.exibirInfoPopular();
        System.out.println();

        // cria uma inst�ncia da classe FabricaFord, que tamb�m � uma implementa��o da interface FabricaDeCarro
        fabrica = new FabricaFiat();

        // usa a f�brica criada acima para criar uma nova inst�ncia de CarroSedan e uma nova inst�ncia de CarroPopular
        sedan = fabrica.criarCarroSedan();
        popular = fabrica.criarCarroPopular();

        // exibe as informa��es dos novos carros criados, usando os mesmos m�todos exibirInfoSedan() e exibirInfoPopular()
        sedan.exibirInfoSedan();
        System.out.println();
        popular.exibirInfoPopular();
    }
}
