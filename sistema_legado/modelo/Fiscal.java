package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the fiscal database table.
 * 
 */
@Entity
@NamedQuery(name="Fiscal.findAll", query="SELECT f FROM Fiscal f")
public class Fiscal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="fiscal_idfiscal", sequenceName = "fiscal_idfiscal_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="fiscal_idfiscal")
	private Integer idfiscal;
	
	@NotNull(message="Status campo obrigatorio !")
	private Integer statusfiscal;

	private Integer numerotramitacao;
	
	private Integer responsavelfiscal;
	
	private Integer totalnotificacao;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	@NotNull(message="Usuario campo obrigatorio !")
	private Usuario usuario;

	public Fiscal() {
	}

	public Integer getIdfiscal() {
		return this.idfiscal;
	}

	public void setIdfiscal(Integer idfiscal) {
		this.idfiscal = idfiscal;
	}

	public Integer getNumerotramitacao() {
		return numerotramitacao;
	}

	public void setNumerotramitacao(Integer numerotramitacao) {
		this.numerotramitacao = numerotramitacao;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getStatusfiscal() {
		return statusfiscal;
	}

	public void setStatusfiscal(Integer statusfiscal) {
		this.statusfiscal = statusfiscal;
	}

	public Integer getResponsavelfiscal() {
		return responsavelfiscal;
	}

	public void setResponsavelfiscal(Integer responsavelfiscal) {
		this.responsavelfiscal = responsavelfiscal;
	}

	public Integer getTotalnotificacao() {
		return totalnotificacao;
	}

	public void setTotalnotificacao(Integer totalnotificacao) {
		this.totalnotificacao = totalnotificacao;
	}
	
	
	
}