package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bloqueioitenssolicitacao database table.
 * 
 */
@Entity
@NamedQuery(name="Bloqueioitenssolicitacao.findAll", query="SELECT b FROM Bloqueioitenssolicitacao b")
public class Bloqueioitenssolicitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="bloqueioitenssolicitacao_idbloqueioitenssolicitacao", sequenceName = "bloqueioitenssolicitacao_idbloqueioitenssolicitacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="bloqueioitenssolicitacao_idbloqueioitenssolicitacao")
	private Integer idbloqueioitenssolicitacao;
	
	@ManyToOne
	@JoinColumn(name="iditenssolicitacao")
	private Itenssolicitacao itenssolicitacao;
	
	private Integer codigoreferencia;

	public Bloqueioitenssolicitacao() {
	}

	public Integer getIdbloqueioitenssolicitacao() {
		return this.idbloqueioitenssolicitacao;
	}

	public void setIdbloqueioitenssolicitacao(Integer idbloqueioitenssolicitacao) {
		this.idbloqueioitenssolicitacao = idbloqueioitenssolicitacao;
	}

	public Itenssolicitacao getItenssolicitacao() {
		return itenssolicitacao;
	}

	public void setItenssolicitacao(Itenssolicitacao itenssolicitacao) {
		this.itenssolicitacao = itenssolicitacao;
	}

	public Integer getCodigoreferencia() {
		return codigoreferencia;
	}

	public void setCodigoreferencia(Integer codigoreferencia) {
		this.codigoreferencia = codigoreferencia;
	}
	
	

}