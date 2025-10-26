package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the despachoimprocedencia database table.
 * 
 */
@Entity
@NamedQuery(name="Despachoimprocedencia.findAll", query="SELECT d FROM Despachoimprocedencia d ORDER BY d.iddespachoimprocedencia DESC")
public class Despachoimprocedencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="despachoimprocedencia_iddespachoimprocedencia", sequenceName = "despachoimprocedencia_iddespachoimprocedencia_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="despachoimprocedencia_iddespachoimprocedencia")
	private Integer iddespachoimprocedencia;
	
	@NotNull(message="Secretario campo Obrigatorio !")
	private String secreatriodespachoimprocedencia;
	
	@NotNull(message="Texto campo Obrigatorio !")
	private String textodespachoimprocedencia;

	public Despachoimprocedencia() {
	}

	public Integer getIddespachoimprocedencia() {
		return this.iddespachoimprocedencia;
	}

	public void setIddespachoimprocedencia(Integer iddespachoimprocedencia) {
		this.iddespachoimprocedencia = iddespachoimprocedencia;
	}

	public String getSecreatriodespachoimprocedencia() {
		return this.secreatriodespachoimprocedencia;
	}

	public void setSecreatriodespachoimprocedencia(String secreatriodespachoimprocedencia) {
		this.secreatriodespachoimprocedencia = secreatriodespachoimprocedencia;
	}

	public String getTextodespachoimprocedencia() {
		return this.textodespachoimprocedencia;
	}

	public void setTextodespachoimprocedencia(String textodespachoimprocedencia) {
		this.textodespachoimprocedencia = textodespachoimprocedencia;
	}

}