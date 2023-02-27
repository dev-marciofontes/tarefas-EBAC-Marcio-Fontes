package aulas.exercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExercicioColecoes {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("** Parte 1 - da Tarefa **");
        System.out.println("--  Digite o nome de diversas pessoas separados por virgula: --");
        // Captura a resposta removendo possíveis espaços em branco
        String resposta = entrada.nextLine().trim();

        // Cria um vetor de String, separando pela virgula
        String[] vetStr = resposta.split(",");

        // Remove espaços em branco antes e depois de cada nome
        for (int i = 0; i < vetStr.length; i++) {
            vetStr[i] = vetStr[i].trim();
        }

        Arrays.sort(vetStr, String.CASE_INSENSITIVE_ORDER);

        System.out.println("Nomes ordenados: ");
        for (String nome : vetStr) {
            System.out.println("- " + String.format("%-20s", nome));
        }

        System.out.println();
        System.out.println("** Parte 2 - da Tarefa **");

        // Para dar mais dinamismo ao código, deixo o usuário escolher quantos nomes ele
        // vai querer colocar
        System.out.print("Quantos nomes você deseja inserir? ");
        int qtdNomes = entrada.nextInt();
        // Para consumir o \n
        entrada.nextLine();

        List<String> nomesMasculinos = new ArrayList<>();
        List<String> nomesFemininos = new ArrayList<>();

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

        System.out.println("\nNomes masculinos:");
        for (String nome : nomesMasculinos) {
            System.out.println("- " + nome);
        }

        System.out.println("\nNomes femininos:");
        for (String nome : nomesFemininos) {
            System.out.println("- " + nome);
        }

        entrada.close();
    }


}

