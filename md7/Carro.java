package br.com.marciofontes;

/**
 * 
 * @author marcio.fontes
 *
 */

public class Carro {

	private String nome;
	private String marca;
	private int qtdPortas;
	private double potencia;
	private int anoFabricacao;
	private boolean funcionando = false; // True para carro ligado, False para carro desligado

	Carro(String nome, String marca, int qtdPortas, double potencia, int anoFabricacao) {
		this.setNome(nome);
		this.setMarca(marca);
		this.setQtdPortas(qtdPortas);
		this.setPotencia(potencia);
		this.setAnoFabricacao(anoFabricacao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getQtdPortas() {
		return qtdPortas;
	}

	public void setQtdPortas(int qtdPortas) {
		this.qtdPortas = qtdPortas;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public void ligarCarro() {
		if(this.funcionando == false) {
			this.funcionando = true;
			System.out.println("Ligando o carro...");
			System.out.println("Pronto! O carro está ligado.");
		} else {
			System.out.println("Eita! O carro já está ligado!");
		}
	}
	
	public void desligaCarro() {
		if(this.funcionando == true) {
			this.funcionando = false;
			System.out.println("Desligando o carro...");
			System.out.println("Pronto! O carro está desligado");
		} else {
			System.out.println("Eita! O carro já está desligado!");
		}
	}
	
	
}
