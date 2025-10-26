package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the atividadebpa database table.
 * 
 */
@Entity
@NamedQuery(name="Atividades.findAll", query="SELECT a FROM Atividades a ORDER BY a.descricaoatividades")
public class Atividades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="atividadebpa_idatividadebpa", sequenceName = "atividadebpa_idatividadebpa_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="atividadebpa_idatividadebpa")
	private Integer idatividades;
	
	@NotNull(message="Nome atividade campo obrigatorio !")
	private String descricaoatividades;
	

	public Atividades() {
	}

	public Integer getIdatividades() {
		return idatividades;
	}

	public void setIdatividades(Integer idatividades) {
		this.idatividades = idatividades;
	}

	public String getDescricaoatividades() {
		return descricaoatividades;
	}

	public void setDescricaoatividades(String descricaoatividades) {
		this.descricaoatividades = descricaoatividades;
	}

}