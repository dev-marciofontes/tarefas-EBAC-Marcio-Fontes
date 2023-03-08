package aulas.exercicios.md17;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Carro> carros = new ArrayList<>();

        Carro celta = new Celta();
        carros.add(celta);

        Carro fusion = new Fusion();
        carros.add(fusion);

        Carro cronos = new Cronos();
        carros.add(cronos);

        Carro fordKa = new FordKa();
        carros.add(fordKa);

        carros.forEach(Carro::apresentaCarro);


    }

}
