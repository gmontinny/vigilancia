package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the termorevelia database table.
 * 
 */
@Entity
@NamedQuery(name="Termorevelia.findAll", query="SELECT t FROM Termorevelia t")
public class Termorevelia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="termorevelia_idtermorevelia", sequenceName = "termorevelia_idtermorevelia_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="termorevelia_idtermorevelia")
	private Integer idtermorevelia;
	
	@NotNull(message="Coordenadora campo obrigatorio !")
	private String coordenadorresponsavel;
	
	@NotNull(message="Assinatura campo obrigatorio !")
	private String imagemassinatura;

	@NotNull(message="Texto campo obrigatorio !")
	private String textorevelia;

	public Termorevelia() {
	}

	public Integer getIdtermorevelia() {
		return this.idtermorevelia;
	}

	public void setIdtermorevelia(Integer idtermorevelia) {
		this.idtermorevelia = idtermorevelia;
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

	public String getTextorevelia() {
		return this.textorevelia;
	}

	public void setTextorevelia(String textorevelia) {
		this.textorevelia = textorevelia;
	}

}