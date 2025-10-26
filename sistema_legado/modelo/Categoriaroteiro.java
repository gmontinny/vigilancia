package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;


/**
 * The persistent class for the categoriaroteiro database table.
 * 
 */
@Entity
@NamedQuery(name="Categoriaroteiro.findAll", query="SELECT c FROM Categoriaroteiro c ORDER BY c.descricaocategoria")
public class Categoriaroteiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="categoriaroteiro_idcategoriaroteiro", sequenceName = "categoriaroteiro_idcategoriaroteiro_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="categoriaroteiro_idcategoriaroteiro")
	private Integer idcategoriaroteiro;

	@NotNull(message="Descrição Campo Obrigatorio !")
	private String descricaocategoria;

	//bi-directional many-to-one association to Itensroteiro
	@OneToMany(mappedBy="categoriaroteiro")
	private List<Itensroteiro> itensroteiros;

	public Categoriaroteiro() {
	}

	public Integer getIdcategoriaroteiro() {
		return this.idcategoriaroteiro;
	}

	public void setIdcategoriaroteiro(Integer idcategoriaroteiro) {
		this.idcategoriaroteiro = idcategoriaroteiro;
	}

	public String getDescricaocategoria() {
		return this.descricaocategoria;
	}

	public void setDescricaocategoria(String descricaocategoria) {
		this.descricaocategoria = descricaocategoria;
	}

	public List<Itensroteiro> getItensroteiros() {
		return this.itensroteiros;
	}

	public void setItensroteiros(List<Itensroteiro> itensroteiros) {
		this.itensroteiros = itensroteiros;
	}

	public Itensroteiro addItensroteiro(Itensroteiro itensroteiro) {
		getItensroteiros().add(itensroteiro);
		itensroteiro.setCategoriaroteiro(this);

		return itensroteiro;
	}

	public Itensroteiro removeItensroteiro(Itensroteiro itensroteiro) {
		getItensroteiros().remove(itensroteiro);
		itensroteiro.setCategoriaroteiro(null);

		return itensroteiro;
	}

}