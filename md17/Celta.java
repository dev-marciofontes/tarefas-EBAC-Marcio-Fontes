package aulas.exercicios.md17;

public class Celta extends Carro {

    Celta() {
        this.nome = "Celta";
        this.anoDeFabricacao = "2000";
    }


    public void apresentaCarro() {
        System.out.println("Carro : " + this.nome + " - Ano de fabricação: " + this.anoDeFabricacao);
    }

}
