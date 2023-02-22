package exemplos;

import java.util.Scanner;

public class TarefaControleDeFluxo {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("-- Vamos ver se você foi aprovado(a)? --");
		System.out.println("Quantas notas você vai digitar? ");
		int numNotas = entrada.nextInt();
		double total = 0;
		String resposta = null;

		do {
			for (int i = 1; i <= numNotas; i++) {
				System.out.println("Digite a nota " + i);
				total += entrada.nextDouble();
			}

			double media = total / numNotas;

			System.out.println("\n**********");
			System.out.printf("A media das suas notas é: %.2f", media);

			if (media >= 7) {
				System.out.println("\nParabéns, você está aprovado(a)!!");
			} else if (media >= 5) {
				System.out.println("\nVocê ainda tem chance! Você está de recuperação!");
			} else {
				System.out.println("\nLamento muito! Você está reprovado(a)!!");
			}

			System.out.println("\n**********");
			System.out.println("Deseja calcular uma nova média? (Digite sim ou não)");
			resposta = entrada.next();

		} while (resposta.equalsIgnoreCase("Sim"));
		
		System.out.println("\nEncerrando...");
		System.out.println("Obrigado por usar o programa!!");

		entrada.close();

	}

}
