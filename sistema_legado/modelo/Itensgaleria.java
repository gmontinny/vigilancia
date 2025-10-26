package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the itensgaleria database table.
 * 
 */
@Entity
@NamedQuery(name="Itensgaleria.findAll", query="SELECT i FROM Itensgaleria i")
public class Itensgaleria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensgaleria_iditensgaleria", sequenceName = "itensgaleria_iditensgaleria_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensgaleria_iditensgaleria")
	private Integer iditensgaleria;

	private String imagemitensgaleria;

	private Integer seguenciagaleria;

	private String tituloitensgaleria;

	public Itensgaleria() {
	}

	public Integer getIditensgaleria() {
		return this.iditensgaleria;
	}

	public void setIditensgaleria(Integer iditensgaleria) {
		this.iditensgaleria = iditensgaleria;
	}

	public String getImagemitensgaleria() {
		return this.imagemitensgaleria;
	}

	public void setImagemitensgaleria(String imagemitensgaleria) {
		this.imagemitensgaleria = imagemitensgaleria;
	}

	public Integer getSeguenciagaleria() {
		return this.seguenciagaleria;
	}

	public void setSeguenciagaleria(Integer seguenciagaleria) {
		this.seguenciagaleria = seguenciagaleria;
	}

	public String getTituloitensgaleria() {
		return this.tituloitensgaleria;
	}

	public void setTituloitensgaleria(String tituloitensgaleria) {
		this.tituloitensgaleria = tituloitensgaleria;
	}

}