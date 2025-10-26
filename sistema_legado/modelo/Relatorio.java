package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;


/**
 * The persistent class for the relatorio database table.
 * 
 */
@Entity
@NamedQuery(name="Relatorio.findAll", query="SELECT r FROM Relatorio r")
public class Relatorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="relatorio_idrelatorio", sequenceName = "relatorio_idrelatorio_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="relatorio_idrelatorio")
	private Integer idrelatorio;
	
	@NotNull(message="Descrição campo obrigatorio !")
	private String descricaorelatorio;
	
	@NotNull(message="Nome campo obrigatorio !")
	private String nomerelatorio;

	//bi-directional many-to-one association to Itensrelatorio
	@OneToMany(mappedBy="relatorio")
	private List<Itensrelatorio> itensrelatorios;

	public Relatorio() {
	}

	public Integer getIdrelatorio() {
		return this.idrelatorio;
	}

	public void setIdrelatorio(Integer idrelatorio) {
		this.idrelatorio = idrelatorio;
	}

	public String getDescricaorelatorio() {
		return this.descricaorelatorio;
	}

	public void setDescricaorelatorio(String descricaorelatorio) {
		this.descricaorelatorio = descricaorelatorio;
	}

	public String getNomerelatorio() {
		return this.nomerelatorio;
	}

	public void setNomerelatorio(String nomerelatorio) {
		this.nomerelatorio = nomerelatorio;
	}

	public List<Itensrelatorio> getItensrelatorios() {
		return this.itensrelatorios;
	}

	public void setItensrelatorios(List<Itensrelatorio> itensrelatorios) {
		this.itensrelatorios = itensrelatorios;
	}

	public Itensrelatorio addItensrelatorio(Itensrelatorio itensrelatorio) {
		getItensrelatorios().add(itensrelatorio);
		itensrelatorio.setRelatorio(this);

		return itensrelatorio;
	}

	public Itensrelatorio removeItensrelatorio(Itensrelatorio itensrelatorio) {
		getItensrelatorios().remove(itensrelatorio);
		itensrelatorio.setRelatorio(null);

		return itensrelatorio;
	}

}