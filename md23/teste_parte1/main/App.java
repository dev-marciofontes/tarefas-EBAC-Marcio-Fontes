package aulas.exercicios.md23.teste_parte1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author M�rcio Fontes
 */

public class App {
    public static List<String> nomesMasculinos = new ArrayList<>();
    public static List<String> nomesFemininos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Para dar mais dinamismo ao c�digo, deixo o usu�rio escolher quantos nomes ele
        // vai querer colocar
        System.out.print("Quantos nomes voc� deseja inserir? ");
        int qtdNomes = entrada.nextInt();
        // Para consumir o \n
        entrada.nextLine();

        for (int i = 1; i <= qtdNomes; i++) {
            System.out.print("Digite o " + i + "� nome e o sexo (separados por v�rgula): ");
            String[] nomes = entrada.nextLine().split(",");

            if (nomes.length != 2) {
                System.out.println("Entrada inv�lida. Tente novamente.");
                // para manter a contagem correta de nomes inseridos caso voc� tente inserir
                // algo depois do sexo
                i--;
                continue;
            }

            // Para remover espa�os em branco antes ou depois da String, caso o usu�rio
            // aperte sem querer
            String nome = nomes[0].trim();
            String sexo = nomes[1].trim();

            if (sexo.equalsIgnoreCase("M")) {
                nomesMasculinos.add(nome);
            } else if (sexo.equalsIgnoreCase("F")) {
                nomesFemininos.add(nome);
            } else {
                System.out.println("Sexo inv�lido. Tente novamente.");
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
