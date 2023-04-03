package br.com.marciofontes;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Márcio Fontes
 *
 */
@Entity
@Table(name = "TB_MATRICULA")
public class Matricula {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CODIGO", length = 10, nullable = false, unique = true)
	private String codigo;

	@Column(name = "DATA_MATRICULA", nullable = false)
	private Instant dataMatricula;

	@Column(name = "VALOR", nullable = false)
	private Double valor;

	@Column(name = "STATUS", nullable = false)
	private String status;

	public Matricula() {
		super();
	}

	public Matricula(String codigo, Instant dataMatricula, Double valor, String status) {
		super();
		this.codigo = codigo;
		this.dataMatricula = dataMatricula;
		this.valor = valor;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Instant getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Instant dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
