package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the itensexiberoteiro database table.
 * 
 */
@Entity
@NamedQuery(name="Itensexiberoteiro.findAll", query="SELECT i FROM Itensexiberoteiro i")
public class Itensexiberoteiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensexiberoteiro_iditensexiberoteiro", sequenceName = "itensexiberoteiro_iditensexiberoteiro_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensexiberoteiro_iditensexiberoteiro")
	private Integer iditensexiberoteiro;

	private Integer atende;

	private Integer atendeparcialmente;
	
	@ManyToOne
	@JoinColumn(name="idexiberoteiro")
	@NotNull(message="Exibe Roteiro campo obrigatorio !")
	private Exiberoteiro exiberoteiro;
	
	@ManyToOne
	@JoinColumn(name="iditensroteiro")
	@NotNull(message="Itens Roteiro campo obrigatorio !")
	private Itensroteiro itensroteiro;

	private Integer naoatende;

	private Integer naoseaplica;
	
	private Integer numeroauto;

	public Itensexiberoteiro() {
	}

	public Integer getIditensexiberoteiro() {
		return this.iditensexiberoteiro;
	}

	public void setIditensexiberoteiro(Integer iditensexiberoteiro) {
		this.iditensexiberoteiro = iditensexiberoteiro;
	}

	public Integer getAtende() {
		return this.atende;
	}

	public void setAtende(Integer atende) {
		this.atende = atende;
	}

	public Integer getAtendeparcialmente() {
		return this.atendeparcialmente;
	}

	public void setAtendeparcialmente(Integer atendeparcialmente) {
		this.atendeparcialmente = atendeparcialmente;
	}

	public Exiberoteiro getExiberoteiro() {
		return exiberoteiro;
	}

	public void setExiberoteiro(Exiberoteiro exiberoteiro) {
		this.exiberoteiro = exiberoteiro;
	}

	public Itensroteiro getItensroteiro() {
		return itensroteiro;
	}

	public void setItensroteiro(Itensroteiro itensroteiro) {
		this.itensroteiro = itensroteiro;
	}

	public Integer getNaoatende() {
		return this.naoatende;
	}

	public void setNaoatende(Integer naoatende) {
		this.naoatende = naoatende;
	}

	public Integer getNaoseaplica() {
		return this.naoseaplica;
	}

	public void setNaoseaplica(Integer naoseaplica) {
		this.naoseaplica = naoseaplica;
	}

	public Integer getNumeroauto() {
		return numeroauto;
	}

	public void setNumeroauto(Integer numeroauto) {
		this.numeroauto = numeroauto;
	}

}