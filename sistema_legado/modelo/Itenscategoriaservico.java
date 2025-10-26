package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the itenscategoriaservico database table.
 * 
 */
@Entity
@NamedQuery(name="Itenscategoriaservico.findAll", query="SELECT i FROM Itenscategoriaservico i")
public class Itenscategoriaservico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itenscategoria_iditenscategoriaservico", sequenceName = "itenscategoria_iditenscategoriaservico_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itenscategoria_iditenscategoriaservico")
	private Integer iditenscategoriaservico;

	@NotNull(message="DESCRIÇÃO do Serviço campo Obrigatorio !")
	private String descitenscategoriaservico;

	@NotNull(message="N° Serviço campo Obrigatorio !")
	private Integer numeroservico;

	public Itenscategoriaservico() {
	}

	public Integer getIditenscategoriaservico() {
		return this.iditenscategoriaservico;
	}

	public void setIditenscategoriaservico(Integer iditenscategoriaservico) {
		this.iditenscategoriaservico = iditenscategoriaservico;
	}

	public String getDescitenscategoriaservico() {
		return this.descitenscategoriaservico;
	}

	public void setDescitenscategoriaservico(String descitenscategoriaservico) {
		this.descitenscategoriaservico = descitenscategoriaservico;
	}

	public Integer getNumeroservico() {
		return this.numeroservico;
	}

	public void setNumeroservico(Integer numeroservico) {
		this.numeroservico = numeroservico;
	}

}