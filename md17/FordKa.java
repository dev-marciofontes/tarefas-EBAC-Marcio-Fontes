package aulas.exercicios.md17;

public class FordKa extends Carro {

    FordKa() {
        this.nome = "FordKA";
        this.anoDeFabricacao = "1998";
    }


    public void apresentaCarro() {
        System.out.println("Carro : " + this.nome + " - Ano de fabricação: " + this.anoDeFabricacao);
    }

}
