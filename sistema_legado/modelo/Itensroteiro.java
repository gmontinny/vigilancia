package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;


/**
 * The persistent class for the itensroteiro database table.
 * 
 */
@Entity
@NamedQuery(name="Itensroteiro.findAll", query="SELECT i FROM Itensroteiro i ORDER BY i.descricaoitensroteiro")
public class Itensroteiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensroteiro_iditensroteiro", sequenceName = "itensroteiro_iditensroteiro_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensroteiro_iditensroteiro")
	private Integer iditensroteiro;
	
	private Integer numeroroteiro;
	
	private Integer idlegislacao755;
	
	@NotNull(message="Gera Infração campo Obrigatorio !")
	private Integer gerainfracao;
	
	@NotNull(message="Criticidade campo Obrigatorio !")
	private Integer criticidade;
	
		
	@NotNull(message="Descrição campo Obrigatorio !")
	private String descricaoitensroteiro;

	//bi-directional many-to-one association to Categoriaroteiro
	@ManyToOne
	@JoinColumn(name="idcategoriaroteiro")
	@NotNull(message="Categoria campo Obrigatorio !")
	private Categoriaroteiro categoriaroteiro;

	
	@ManyToOne
	@JoinColumn(name="idlegislacao")
	@NotNull(message="Legislação campo Obrigatorio !")
	private Legislacao legislacao;
	
	
	public Itensroteiro() {
	}

	public Integer getIditensroteiro() {
		return this.iditensroteiro;
	}

	public void setIditensroteiro(Integer iditensroteiro) {
		this.iditensroteiro = iditensroteiro;
	}

	public String getDescricaoitensroteiro() {
		return this.descricaoitensroteiro;
	}

	public void setDescricaoitensroteiro(String descricaoitensroteiro) {
		this.descricaoitensroteiro = descricaoitensroteiro;
	}

	public Categoriaroteiro getCategoriaroteiro() {
		return this.categoriaroteiro;
	}

	public void setCategoriaroteiro(Categoriaroteiro categoriaroteiro) {
		this.categoriaroteiro = categoriaroteiro;
	}


	public Integer getNumeroroteiro() {
		return numeroroteiro;
	}

	public void setNumeroroteiro(Integer numeroroteiro) {
		this.numeroroteiro = numeroroteiro;
	}

	public Integer getGerainfracao() {
		return gerainfracao;
	}

	public void setGerainfracao(Integer gerainfracao) {
		this.gerainfracao = gerainfracao;
	}

	public Integer getCriticidade() {
		return criticidade;
	}

	public void setCriticidade(Integer criticidade) {
		this.criticidade = criticidade;
	}

	public Legislacao getLegislacao() {
		return legislacao;
	}

	public void setLegislacao(Legislacao legislacao) {
		this.legislacao = legislacao;
	}

	public Integer getIdlegislacao755() {
		return idlegislacao755;
	}

	public void setIdlegislacao755(Integer idlegislacao755) {
		this.idlegislacao755 = idlegislacao755;
	}
	
}