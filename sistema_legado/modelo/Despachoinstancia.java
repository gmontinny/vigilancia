package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the despachoinstancia database table.
 * 
 */
@Entity
@NamedQuery(name="Despachoinstancia.findAll", query="SELECT d FROM Despachoinstancia d ORDER BY d.iddespachoinstancia DESC")
public class Despachoinstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="despachoinstancia_iddespachoinstancia", sequenceName = "despachoinstancia_iddespachoinstancia_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="despachoinstancia_iddespachoinstancia")
	private Integer iddespachoinstancia;
	
	@NotNull(message="Gerente é um campo Necessário !")
	private String gerenteresponsavel;

	private String imagemassinatura;
	
	@NotNull(message="Texto é um campo Necessário !")
	private String textoinstancia;

	public Despachoinstancia() {
	}

	public Integer getIddespachoinstancia() {
		return this.iddespachoinstancia;
	}

	public void setIddespachoinstancia(Integer iddespachoinstancia) {
		this.iddespachoinstancia = iddespachoinstancia;
	}

	public String getGerenteresponsavel() {
		return this.gerenteresponsavel;
	}

	public void setGerenteresponsavel(String gerenteresponsavel) {
		this.gerenteresponsavel = gerenteresponsavel;
	}

	public String getImagemassinatura() {
		return this.imagemassinatura;
	}

	public void setImagemassinatura(String imagemassinatura) {
		this.imagemassinatura = imagemassinatura;
	}

	public String getTextoinstancia() {
		return this.textoinstancia;
	}

	public void setTextoinstancia(String textoinstancia) {
		this.textoinstancia = textoinstancia;
	}

}