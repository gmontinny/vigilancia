package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the processosolicitacao database table.
 * 
 */
@Entity
@NamedQuery(name="Processosolicitacao.findAll", query="SELECT p FROM Processosolicitacao p")
public class Processosolicitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="processosolicitacao_idprocessosolicitacao", sequenceName = "processosolicitacao_idprocessosolicitacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="processosolicitacao_idprocessosolicitacao")
	private Integer idprocessosolicitacao;
	
	@NotNull(message="Numero de Processo campo Obrigatorio !")
	private String numprocesso;

	//bi-directional many-to-one association to Itenssolicitacao
	@ManyToOne
	@JoinColumn(name="iditenssolicitacao")
	@NotNull(message="Itens Solicitação campo obrigatorio !")
	private Itenssolicitacao itenssolicitacao;

	public Processosolicitacao() {
	}

	public Integer getIdprocessosolicitacao() {
		return this.idprocessosolicitacao;
	}

	public void setIdprocessosolicitacao(Integer idprocessosolicitacao) {
		this.idprocessosolicitacao = idprocessosolicitacao;
	}

	public String getNumprocesso() {
		return this.numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public Itenssolicitacao getItenssolicitacao() {
		return this.itenssolicitacao;
	}

	public void setItenssolicitacao(Itenssolicitacao itenssolicitacao) {
		this.itenssolicitacao = itenssolicitacao;
	}

}