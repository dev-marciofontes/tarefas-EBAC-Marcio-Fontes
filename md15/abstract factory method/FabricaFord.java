package aulas.exercicios.md15;

public class FabricaFord implements FabricaDeCarros {

    @Override
    public CarroSedan criarCarroSedan() {
        return new Fusion();
    }

    @Override
    public CarroPopular criarCarroPopular() {
        return new FordKa();
    }

}
