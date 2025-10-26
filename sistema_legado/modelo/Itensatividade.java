package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the itensatividade database table.
 * 
 */
@Entity
@NamedQuery(name="Itensatividade.findAll", query="SELECT i FROM Itensatividade i")
public class Itensatividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensatividade_iditensatividade", sequenceName = "itensatividade_iditensatividade_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensatividade_iditensatividade")
	private Integer iditensatividade;
	
	@ManyToOne
	@JoinColumn(name="idatividades")
	@NotNull(message="Atividade campo obrigatorio !")
	private Atividades atividades;
	
	@ManyToOne
	@JoinColumn(name="idestabelecimento")
	@NotNull(message="Estebelecimento campo obrigatorio !")
	private Estabelecimento estabelecimento;

	public Itensatividade() {
	}

	public Integer getIditensatividade() {
		return this.iditensatividade;
	}

	public void setIditensatividade(Integer iditensatividade) {
		this.iditensatividade = iditensatividade;
	}

	public Atividades getAtividades() {
		return atividades;
	}

	public void setAtividades(Atividades atividades) {
		this.atividades = atividades;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}


}