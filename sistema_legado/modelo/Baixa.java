package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the baixa database table.
 * 
 */
@Entity
@NamedQuery(name="Baixa.findAll", query="SELECT b FROM Baixa b")
public class Baixa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date databaixa;
	
	@Id
	@SequenceGenerator(name="baixa_idbaixa", sequenceName = "baixa_idbaixa_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="baixa_idbaixa")
	private Integer idbaixa;
	
	@ManyToOne
	@JoinColumn(name="idestabelecimento")
	private Estabelecimento estabelecimento;

	@ManyToOne
	@JoinColumn(name="idresponsavel")
	@NotNull(message="Responsável Técnico campo obrigatorio !")
	private Responsaveltecnico responsaveltecnico;

	private String numprocesso;

	public Baixa() {
	}

	public Date getDatabaixa() {
		return this.databaixa;
	}

	public void setDatabaixa(Date databaixa) {
		this.databaixa = databaixa;
	}

	public Integer getIdbaixa() {
		return this.idbaixa;
	}

	public void setIdbaixa(Integer idbaixa) {
		this.idbaixa = idbaixa;
	}
	
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Responsaveltecnico getResponsaveltecnico() {
		return responsaveltecnico;
	}

	public void setResponsaveltecnico(Responsaveltecnico responsaveltecnico) {
		this.responsaveltecnico = responsaveltecnico;
	}

	public String getNumprocesso() {
		return this.numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

}