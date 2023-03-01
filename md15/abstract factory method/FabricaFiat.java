package aulas.exercicios.md15;

public class FabricaFiat implements FabricaDeCarros {

    @Override
    public CarroSedan criarCarroSedan() {
        return new Cronos();
    }

    @Override
    public CarroPopular criarCarroPopular() {
        return new Celta();
    }

}
