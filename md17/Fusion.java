package aulas.exercicios.md17;

public class Fusion extends Carro {
    Fusion() {
        this.nome = "Fusion";
        this.anoDeFabricacao = "2020";
    }


    public void apresentaCarro() {
        System.out.println("Carro : " + this.nome + " - Ano de fabricação: " + this.anoDeFabricacao);
    }

}
