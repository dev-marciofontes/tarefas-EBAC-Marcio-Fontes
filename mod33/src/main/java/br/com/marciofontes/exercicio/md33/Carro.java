package br.com.marciofontes.exercicio.md33;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "MODELO", length = 10, nullable = false)
	private String modelo;

	@Column(name = "ANO_FABRICACAO", length = 10, nullable = false)
	private String anoFabricacao;

	@ManyToOne
	@JoinColumn(name = "id_marca_fk", foreignKey = @ForeignKey(name = "fk_marca_carro"), referencedColumnName = "id", nullable = false)
	private Marca marca;
	
	@ManyToMany
	@JoinTable(name = "TB_CARRO_ACESSORIOS",
		joinColumns = @JoinColumn(name = "ID_CARRO", referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name = "ID_ACESSORIO", referencedColumnName = "ID"))
	private List<Acessorio> acessorios;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}