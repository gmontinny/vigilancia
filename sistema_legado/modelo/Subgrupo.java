package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * The persistent class for the subgrupo database table.
 * 
 */
@Entity
@NamedQuery(name="Subgrupo.findAll", query="SELECT s FROM Subgrupo s ORDER BY s.nomesubgrupo")
public class Subgrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="subgrupo_idsubgrupo", sequenceName = "subgrupo_idsubgrupo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="subgrupo_idsubgrupo")
	private Integer idsubgrupo;
	
	@NotNull(message="Nome campo obrigatorio !")
	@Size(min=5, message="Digite pelo menos 5 caracteres !")
	private String nomesubgrupo;


	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="idgrupo")
	@NotNull(message="Grupo campo obrigatorio !")
	private Grupo grupo;

	public Subgrupo() {
	}

	public Integer getIdsubgrupo() {
		return this.idsubgrupo;
	}

	public void setIdsubgrupo(Integer idsubgrupo) {
		this.idsubgrupo = idsubgrupo;
	}

	public String getNomesubgrupo() {
		return this.nomesubgrupo;
	}

	public void setNomesubgrupo(String nomesubgrupo) {
		this.nomesubgrupo = nomesubgrupo;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}