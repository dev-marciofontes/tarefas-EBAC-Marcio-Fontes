package br.com.marciofontes;

import java.util.Scanner;

public class TarefaWrapper {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite um valor numérico: ");
		int valor = entrada.nextInt();
		System.out.println("\nO valor digitado foi: " + valor);

		Integer novoValor = Integer.valueOf(valor);
		System.out.println("\nImprimindo depois do Wrapper em um tipo Integer e pode usar métodos de Classe -> " + novoValor);
		
		// ou poderia ser feito também de outra forma
		System.out.println("Digite um valor numérico: ");
		int valor2 = entrada.nextInt();
		
		Integer novoValor2 = valor2;
		System.out.println("\nImprimindo depois do Wrapper em um tipo Integer e pode usar métodos de Classe -> " + novoValor2);

		
		// também poderia jogar um outro tipo através do Casting
		System.out.println("Digite um valor numérico do tipo Double: ");
		double valor3 = entrada.nextDouble();
		
		Integer novoValor3 = (int) valor3;
		System.out.println("\nImprimindo o Terceiro Valor agora já como Integer -> " + novoValor3);
		

		entrada.close();

	}

}
