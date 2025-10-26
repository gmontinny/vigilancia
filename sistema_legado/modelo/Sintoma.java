package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the sintomas database table.
 * 
 */
@Entity
@Table(name="sintomas")
@NamedQuery(name="Sintoma.findAll", query="SELECT s FROM Sintoma s")
public class Sintoma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="sintomas_idsintomas", sequenceName = "sintomas_idsintomas_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="sintomas_idsintomas")
	private Integer idsintomas;
	
	@NotNull(message="Descrição campo obrigatorio !")
	@Size(min=5, message="Digite pelo menos 5 caracteres !")
	private String descricaosintomas;


	public Sintoma() {
	}

	public Integer getIdsintomas() {
		return this.idsintomas;
	}

	public void setIdsintomas(Integer idsintomas) {
		this.idsintomas = idsintomas;
	}

	public String getDescricaosintomas() {
		return this.descricaosintomas;
	}

	public void setDescricaosintomas(String descricaosintomas) {
		this.descricaosintomas = descricaosintomas;
	}



}