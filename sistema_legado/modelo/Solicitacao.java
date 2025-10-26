package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the solicitacao database table.
 * 
 */
@Entity
@NamedQuery(name="Solicitacao.findAll", query="SELECT s FROM Solicitacao s")
public class Solicitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="solicitacao_idsolicitacao", sequenceName = "solicitacao_idsolicitacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="solicitacao_idsolicitacao")
	private Integer idsolicitacao;
	
	@NotNull(message="Nome campo obrigatorio!")
	@Size(min=5, message="Digite no minimo 5 caracteres !")
	private String nomesolicitacao;

	//bi-directional many-to-one association to Itenssolicitacao
	@OneToMany(mappedBy="solicitacao")
	private List<Itenssolicitacao> itenssolicitacaos;

	public Solicitacao() {
	}

	public Integer getIdsolicitacao() {
		return this.idsolicitacao;
	}

	public void setIdsolicitacao(Integer idsolicitacao) {
		this.idsolicitacao = idsolicitacao;
	}

	public String getNomesolicitacao() {
		return this.nomesolicitacao;
	}

	public void setNomesolicitacao(String nomesolicitacao) {
		this.nomesolicitacao = nomesolicitacao;
	}

	public List<Itenssolicitacao> getItenssolicitacaos() {
		return this.itenssolicitacaos;
	}

	public void setItenssolicitacaos(List<Itenssolicitacao> itenssolicitacaos) {
		this.itenssolicitacaos = itenssolicitacaos;
	}

	public Itenssolicitacao addItenssolicitacao(Itenssolicitacao itenssolicitacao) {
		getItenssolicitacaos().add(itenssolicitacao);
		itenssolicitacao.setSolicitacao(this);

		return itenssolicitacao;
	}

	public Itenssolicitacao removeItenssolicitacao(Itenssolicitacao itenssolicitacao) {
		getItenssolicitacaos().remove(itenssolicitacao);
		itenssolicitacao.setSolicitacao(null);

		return itenssolicitacao;
	}

}