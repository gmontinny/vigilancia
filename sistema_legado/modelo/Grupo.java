package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="grupo_idgrupo", sequenceName = "grupo_idgrupo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="grupo_idgrupo")
	private Integer idgrupo;
	
	@NotNull(message="Nome campo Obrigatorio!")
	@Size(min=5,message="Digite pelo menos 5 caracteres!")
	private String nomegrupo;

	//bi-directional many-to-one association to Subgrupo
	@OneToMany(mappedBy="grupo")
	private List<Subgrupo> subgrupos;

	public Grupo() {
	}

	public Integer getIdgrupo() {
		return this.idgrupo;
	}

	public void setIdgrupo(Integer idgrupo) {
		this.idgrupo = idgrupo;
	}

	public String getNomegrupo() {
		return this.nomegrupo;
	}

	public void setNomegrupo(String nomegrupo) {
		this.nomegrupo = nomegrupo;
	}

	public List<Subgrupo> getSubgrupos() {
		return this.subgrupos;
	}

	public void setSubgrupos(List<Subgrupo> subgrupos) {
		this.subgrupos = subgrupos;
	}

	public Subgrupo addSubgrupo(Subgrupo subgrupo) {
		getSubgrupos().add(subgrupo);
		subgrupo.setGrupo(this);

		return subgrupo;
	}

	public Subgrupo removeSubgrupo(Subgrupo subgrupo) {
		getSubgrupos().remove(subgrupo);
		subgrupo.setGrupo(null);

		return subgrupo;
	}

}