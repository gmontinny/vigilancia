package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the montarroteiro database table.
 * 
 */
@Entity
@NamedQuery(name="Montarroteiro.findAll", query="SELECT m FROM Montarroteiro m ")
public class Montarroteiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="montarroteiro_idmontarroteiro", sequenceName = "montarroteiro_idmontarroteiro_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="montarroteiro_idmontarroteiro")
	private Integer idmontarroteiro;
	
	
	private Integer numeroroteiro;
	
	//bi-directional many-to-one association to Roteiro
	@ManyToOne
	@JoinColumn(name="idroteiro")
	private Roteiro roteiro;

	public Montarroteiro() {
	}

	public Integer getIdmontarroteiro() {
		return this.idmontarroteiro;
	}

	public void setIdmontarroteiro(Integer idmontarroteiro) {
		this.idmontarroteiro = idmontarroteiro;
	}


	public Roteiro getRoteiro() {
		return this.roteiro;
	}

	public void setRoteiro(Roteiro roteiro) {
		this.roteiro = roteiro;
	}

	public Integer getNumeroroteiro() {
		return numeroroteiro;
	}

	public void setNumeroroteiro(Integer numeroroteiro) {
		this.numeroroteiro = numeroroteiro;
	}
	
	

}