package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * The persistent class for the itenssolicitacao database table.
 * 
 */
@Entity
@NamedQuery(name="Itenssolicitacao.findAll", query="SELECT i FROM Itenssolicitacao i ORDER BY i.nomeitenssolicitacao")
public class Itenssolicitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itenssolicitacao_iditenssolicitacao", sequenceName = "itenssolicitacao_iditenssolicitacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itenssolicitacao_iditenssolicitacao")
	private Integer iditenssolicitacao;

	@NotNull(message="Nome campo obrigatorio !")
	@Size(min=5,message="Digite pelo menos 5 caracteres !")
	private String nomeitenssolicitacao;

	//bi-directional many-to-one association to Solicitacao
	@ManyToOne
	@JoinColumn(name="idsolicitacao")
	@NotNull(message="Solicitação campo obrigatorio !")
	private Solicitacao solicitacao;
	
	private Integer restritoitenssolicitacao;

	public Itenssolicitacao() {
	}

	public Integer getIditenssolicitacao() {
		return this.iditenssolicitacao;
	}

	public void setIditenssolicitacao(Integer iditenssolicitacao) {
		this.iditenssolicitacao = iditenssolicitacao;
	}

	public String getNomeitenssolicitacao() {
		return this.nomeitenssolicitacao;
	}

	public void setNomeitenssolicitacao(String nomeitenssolicitacao) {
		this.nomeitenssolicitacao = nomeitenssolicitacao;
	}

	public Solicitacao getSolicitacao() {
		return this.solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Integer getRestritoitenssolicitacao() {
		return restritoitenssolicitacao;
	}

	public void setRestritoitenssolicitacao(Integer restritoitenssolicitacao) {
		this.restritoitenssolicitacao = restritoitenssolicitacao;
	}

}