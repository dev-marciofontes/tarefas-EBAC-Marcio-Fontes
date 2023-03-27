package br.com.marciofontes.domain;

public class Produto {
	
	private Long id;
	private String nomeProd;
	private String codigoProd;
	private Double preco;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeProd() {
		return nomeProd;
	}
	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}
	public String getCodigoProd() {
		return codigoProd;
	}
	public void setCodigoProd(String codigoProd) {
		this.codigoProd = codigoProd;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	

}
