package aulas.exercicios.md17;

public class Cronos extends Carro {

    Cronos() {
        this.nome = "Cronos";
        this.anoDeFabricacao = "2018";
    }


    public void apresentaCarro() {
        System.out.println("Carro : " + this.nome + " - Ano de fabricação: " + this.anoDeFabricacao);
    }

}
