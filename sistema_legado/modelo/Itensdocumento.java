package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the itensdocumento database table.
 * 
 */
@Entity
@NamedQuery(name="Itensdocumento.findAll", query="SELECT i FROM Itensdocumento i")
public class Itensdocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensdocumento_iditensdocumento", sequenceName = "itensdocumento_iditensdocumento_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensdocumento_iditensdocumento")
	private Integer iditensdocumento;

	@NotNull(message="NOME ARQUIVO campo Obrigatorio !")
	private String nomearquivo;

	private Integer numerodocumento;

	@NotNull(message="ARQUIVO campo Obrigatorio !")
	private String oldarquivo;

	@NotNull(message="TIPO ARQUIVO campo Obrigatorio !")
	private String tipoarquivo;
	
	private Integer status;

	public Itensdocumento() {
	}

	public Integer getIditensdocumento() {
		return this.iditensdocumento;
	}

	public void setIditensdocumento(Integer iditensdocumento) {
		this.iditensdocumento = iditensdocumento;
	}

	public String getNomearquivo() {
		return this.nomearquivo;
	}

	public void setNomearquivo(String nomearquivo) {
		this.nomearquivo = nomearquivo;
	}

	public Integer getNumerodocumento() {
		return this.numerodocumento;
	}

	public void setNumerodocumento(Integer numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public String getOldarquivo() {
		return this.oldarquivo;
	}

	public void setOldarquivo(String oldarquivo) {
		this.oldarquivo = oldarquivo;
	}

	public String getTipoarquivo() {
		return this.tipoarquivo;
	}

	public void setTipoarquivo(String tipoarquivo) {
		this.tipoarquivo = tipoarquivo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
}