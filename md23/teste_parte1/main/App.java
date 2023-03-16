package aulas.exercicios.md23.teste_parte1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Márcio Fontes
 */

public class App {
    public static List<String> nomesMasculinos = new ArrayList<>();
    public static List<String> nomesFemininos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Para dar mais dinamismo ao código, deixo o usuário escolher quantos nomes ele
        // vai querer colocar
        System.out.print("Quantos nomes você deseja inserir? ");
        int qtdNomes = entrada.nextInt();
        // Para consumir o \n
        entrada.nextLine();

        for (int i = 1; i <= qtdNomes; i++) {
            System.out.print("Digite o " + i + "º nome e o sexo (separados por vírgula): ");
            String[] nomes = entrada.nextLine().split(",");

            if (nomes.length != 2) {
                System.out.println("Entrada inválida. Tente novamente.");
                // para manter a contagem correta de nomes inseridos caso você tente inserir
                // algo depois do sexo
                i--;
                continue;
            }

            // Para remover espaços em branco antes ou depois da String, caso o usuário
            // aperte sem querer
            String nome = nomes[0].trim();
            String sexo = nomes[1].trim();

            if (sexo.equalsIgnoreCase("M")) {
                nomesMasculinos.add(nome);
            } else if (sexo.equalsIgnoreCase("F")) {
                nomesFemininos.add(nome);
            } else {
                System.out.println("Sexo inválido. Tente novamente.");
                // para manter a contagem correta de nomes inseridos caso insira algo diferente
                // de M ou F
                i--;
                continue;
            }
        }

        entrada.close();

        nomesFemininos.stream()
                .forEach(nome -> System.out.println("Pessoa do Sexo Feminino: " + nome));


    }

}
