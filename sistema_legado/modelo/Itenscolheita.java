package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the itenscolheita database table.
 * 
 */
@Entity
@NamedQuery(name="Itenscolheita.findAll", query="SELECT i FROM Itenscolheita i")
public class Itenscolheita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itenscolheita_iditenscolheita", sequenceName = "itenscolheita_iditenscolheita_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itenscolheita_iditenscolheita")
	private Integer iditenscolheita;
	
	private Integer numerotramitacao;

	@ManyToOne
	@JoinColumn(name="idtermocolheita")
	@NotNull(message="Termo da colheita campo obrigatorio !")
	private Termocolheita termocolheita;

	public Itenscolheita() {
	}

	public Integer getIditenscolheita() {
		return this.iditenscolheita;
	}

	public void setIditenscolheita(Integer iditenscolheita) {
		this.iditenscolheita = iditenscolheita;
	}

	public Termocolheita getTermocolheita() {
		return termocolheita;
	}

	public void setTermocolheita(Termocolheita termocolheita) {
		this.termocolheita = termocolheita;
	}

	public Integer getNumerotramitacao() {
		return numerotramitacao;
	}

	public void setNumerotramitacao(Integer numerotramitacao) {
		this.numerotramitacao = numerotramitacao;
	}

	
	
	
}