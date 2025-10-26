package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the assuntosolicitacao database table.
 * 
 */
@Entity
@NamedQuery(name="Assuntosolicitacao.findAll", query="SELECT a FROM Assuntosolicitacao a")
public class Assuntosolicitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idassunto;

	private Integer iditenssolicitacao;

	private String numprocesso;

	public Assuntosolicitacao() {
	}

	public Integer getIdassunto() {
		return this.idassunto;
	}

	public void setIdassunto(Integer idassunto) {
		this.idassunto = idassunto;
	}

	public Integer getIditenssolicitacao() {
		return this.iditenssolicitacao;
	}

	public void setIditenssolicitacao(Integer iditenssolicitacao) {
		this.iditenssolicitacao = iditenssolicitacao;
	}

	public String getNumprocesso() {
		return this.numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

}