package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the exiberoteiro database table.
 * 
 */
@Entity
@NamedQuery(name="Exiberoteiro.findAll", query="SELECT e FROM Exiberoteiro e")
public class Exiberoteiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="exiberoteiro_idexiberoteiro", sequenceName = "exiberoteiro_idexiberoteiro_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="exiberoteiro_idexiberoteiro")
	private Integer idexiberoteiro;
	
	@ManyToOne
	@JoinColumn(name="idmontarroteiro")
	private Montarroteiro montarroteiro;
	
	@ManyToOne
	@JoinColumn(name="numprocesso")
	private Processo processo;


	public Exiberoteiro() {
	}

	public Integer getIdexiberoteiro() {
		return this.idexiberoteiro;
	}

	public void setIdexiberoteiro(Integer idexiberoteiro) {
		this.idexiberoteiro = idexiberoteiro;
	}

	public Montarroteiro getMontarroteiro() {
		return montarroteiro;
	}

	public void setMontarroteiro(Montarroteiro montarroteiro) {
		this.montarroteiro = montarroteiro;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}


}