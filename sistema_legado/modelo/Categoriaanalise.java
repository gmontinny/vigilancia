package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the categoriaanalise database table.
 * 
 */
@Entity
@NamedQuery(name="Categoriaanalise.findAll", query="SELECT c FROM Categoriaanalise c")
public class Categoriaanalise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="categoriaanalise_idcategoriaanalise", sequenceName = "categoriaanalise_idcategoriaanalise_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="categoriaanalise_idcategoriaanalise")
	private Integer idcategoriaanalise;
	
	@NotNull(message="Nome Categoria campo obrigatorio !")
	private String nomecategoriaanalise;

	public Categoriaanalise() {
	}

	public Integer getIdcategoriaanalise() {
		return this.idcategoriaanalise;
	}

	public void setIdcategoriaanalise(Integer idcategoriaanalise) {
		this.idcategoriaanalise = idcategoriaanalise;
	}

	public String getNomecategoriaanalise() {
		return this.nomecategoriaanalise;
	}

	public void setNomecategoriaanalise(String nomecategoriaanalise) {
		this.nomecategoriaanalise = nomecategoriaanalise;
	}

}