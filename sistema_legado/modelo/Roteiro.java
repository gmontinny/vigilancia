package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;


/**
 * The persistent class for the roteiro database table.
 * 
 */
@Entity
@NamedQuery(name="Roteiro.findAll", query="SELECT r FROM Roteiro r ORDER BY r.descricaoroteiro")
public class Roteiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="roteiro_idroteiro", sequenceName = "roteiro_idroteiro_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="roteiro_idroteiro")
	private Integer idroteiro;
	
	@NotNull(message="Descrição campo Obrigatorio !")
	private String descricaoroteiro;
	
	private Integer situacaoroteiro;

	//bi-directional many-to-one association to Montarroteiro
	@OneToMany(mappedBy="roteiro")
	private List<Montarroteiro> montarroteiros;

	public Roteiro() {
	}

	public Integer getIdroteiro() {
		return this.idroteiro;
	}

	public void setIdroteiro(Integer idroteiro) {
		this.idroteiro = idroteiro;
	}

	public String getDescricaoroteiro() {
		return this.descricaoroteiro;
	}

	public void setDescricaoroteiro(String descricaoroteiro) {
		this.descricaoroteiro = descricaoroteiro;
	}

	public List<Montarroteiro> getMontarroteiros() {
		return this.montarroteiros;
	}

	public void setMontarroteiros(List<Montarroteiro> montarroteiros) {
		this.montarroteiros = montarroteiros;
	}

	public Montarroteiro addMontarroteiro(Montarroteiro montarroteiro) {
		getMontarroteiros().add(montarroteiro);
		montarroteiro.setRoteiro(this);

		return montarroteiro;
	}

	public Montarroteiro removeMontarroteiro(Montarroteiro montarroteiro) {
		getMontarroteiros().remove(montarroteiro);
		montarroteiro.setRoteiro(null);

		return montarroteiro;
	}

	public Integer getSituacaoroteiro() {
		return situacaoroteiro;
	}

	public void setSituacaoroteiro(Integer situacaoroteiro) {
		this.situacaoroteiro = situacaoroteiro;
	}
	
	

}