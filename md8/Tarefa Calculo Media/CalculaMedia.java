package br.com.marciofontes;

import java.util.Scanner;

public class CalculaMedia {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("--- Vamos calcular a média de 4 notas, tudo bem? ---");
		System.out.println("--- Digite a nota numero 1:");
		double nota1 = entrada.nextDouble();

		System.out.println("--- Digite a nota numero 2:");
		double nota2 = entrada.nextDouble();

		System.out.println("--- Digite a nota numero 3:");
		double nota3 = entrada.nextDouble();

		System.out.println("--- Digite a nota numero 4:");
		double nota4 = entrada.nextDouble();

		double media = (nota1 + nota2 + nota3 + nota4) / 4;
		System.out.printf("\n A média das suas notas é: %2.2f ", media);

		entrada.close();
	}

}
