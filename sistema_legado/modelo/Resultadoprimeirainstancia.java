package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the resultadoprimeirainstancia database table.
 * 
 */
@Entity
@NamedQuery(name="Resultadoprimeirainstancia.findAll", query="SELECT r FROM Resultadoprimeirainstancia r")
public class Resultadoprimeirainstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="resultadoprimeirainstancia_idresultadoprimeira", sequenceName = "resultadoprimeirainstancia_idresultadoprimeira_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="resultadoprimeirainstancia_idresultadoprimeira")
	private Integer idresultadoprimeira;

	@Temporal(TemporalType.DATE)	
	private Date datalancada;

	private Integer idusuario;

	private String numprocesso;

	private String tipoprocedencia;

	public Resultadoprimeirainstancia() {
	}

	public Integer getIdresultadoprimeira() {
		return this.idresultadoprimeira;
	}

	public void setIdresultadoprimeira(Integer idresultadoprimeira) {
		this.idresultadoprimeira = idresultadoprimeira;
	}

	public Date getDatalancada() {
		return this.datalancada;
	}

	public void setDatalancada(Date datalancada) {
		this.datalancada = datalancada;
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getNumprocesso() {
		return this.numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public String getTipoprocedencia() {
		return this.tipoprocedencia;
	}

	public void setTipoprocedencia(String tipoprocedencia) {
		this.tipoprocedencia = tipoprocedencia;
	}

}