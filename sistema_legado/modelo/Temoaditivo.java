package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the temoaditivo database table.
 * 
 */
@Entity
@NamedQuery(name="Temoaditivo.findAll", query="SELECT t FROM Temoaditivo t")
public class Temoaditivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="temoaditivo_idtermoaditivo", sequenceName = "temoaditivo_idtermoaditivo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="temoaditivo_idtermoaditivo")
	private Integer idtermoaditivo;

	@NotNull(message = "COORDENADOR campo Obrigatório !")
	private String coordenadorresponsavel;

	@NotNull(message = "IMAGEM campo Obrigatório !")
	private String imagemassinatura;

	@NotNull(message = "TEXTO campo Obrigatório !")
	private String textoaditivo;

	public Temoaditivo() {
	}

	public Integer getIdtermoaditivo() {
		return this.idtermoaditivo;
	}

	public void setIdtermoaditivo(Integer idtermoaditivo) {
		this.idtermoaditivo = idtermoaditivo;
	}

	public String getCoordenadorresponsavel() {
		return this.coordenadorresponsavel;
	}

	public void setCoordenadorresponsavel(String coordenadorresponsavel) {
		this.coordenadorresponsavel = coordenadorresponsavel;
	}

	public String getImagemassinatura() {
		return this.imagemassinatura;
	}

	public void setImagemassinatura(String imagemassinatura) {
		this.imagemassinatura = imagemassinatura;
	}

	public String getTextoaditivo() {
		return this.textoaditivo;
	}

	public void setTextoaditivo(String textoaditivo) {
		this.textoaditivo = textoaditivo;
	}

}