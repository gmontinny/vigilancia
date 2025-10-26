package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the cupomauto database table.
 * 
 */
@Entity
@NamedQuery(name="Cupomauto.findAll", query="SELECT c FROM Cupomauto c")
public class Cupomauto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="cupomauto_idcupom", sequenceName = "cupomauto_idcupom_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="cupomauto_idcupom")
	private Integer idcupom;

	private String descconformidade;

	private String descporte;

	private Integer numeroauto;

	private String valorconformidade;

	private String valorgerado;

	private String valorporte;
	
	private Integer numeroconformidade;
	
	private Integer percconformidade;
	
	private Integer percporte;

	public Cupomauto() {
	}

	public Integer getIdcupom() {
		return this.idcupom;
	}

	public void setIdcupom(Integer idcupom) {
		this.idcupom = idcupom;
	}

	public String getDescconformidade() {
		return this.descconformidade;
	}

	public void setDescconformidade(String descconformidade) {
		this.descconformidade = descconformidade;
	}

	public String getDescporte() {
		return this.descporte;
	}

	public void setDescporte(String descporte) {
		this.descporte = descporte;
	}

	public Integer getNumeroauto() {
		return this.numeroauto;
	}

	public void setNumeroauto(Integer numeroauto) {
		this.numeroauto = numeroauto;
	}

	public String getValorconformidade() {
		return this.valorconformidade;
	}

	public void setValorconformidade(String valorconformidade) {
		this.valorconformidade = valorconformidade;
	}

	public String getValorgerado() {
		return this.valorgerado;
	}

	public void setValorgerado(String valorgerado) {
		this.valorgerado = valorgerado;
	}

	public String getValorporte() {
		return this.valorporte;
	}

	public void setValorporte(String valorporte) {
		this.valorporte = valorporte;
	}

	public Integer getNumeroconformidade() {
		return numeroconformidade;
	}

	public void setNumeroconformidade(Integer numeroconformidade) {
		this.numeroconformidade = numeroconformidade;
	}

	public Integer getPercconformidade() {
		return percconformidade;
	}

	public void setPercconformidade(Integer percconformidade) {
		this.percconformidade = percconformidade;
	}

	public Integer getPercporte() {
		return percporte;
	}

	public void setPercporte(Integer percporte) {
		this.percporte = percporte;
	}
	
	

}