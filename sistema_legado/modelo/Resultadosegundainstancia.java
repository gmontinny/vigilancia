package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the resultadosegundainstancia database table.
 * 
 */
@Entity
@NamedQuery(name="Resultadosegundainstancia.findAll", query="SELECT r FROM Resultadosegundainstancia r")
public class Resultadosegundainstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="resultadosegundainstancia_idresultadosegunda_seq", sequenceName = "resultadosegundainstancia_idresultadosegunda_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="resultadosegundainstancia_idresultadosegunda_seq")
	private Integer idresultadosegunda;

	@Temporal(TemporalType.DATE)
	private Date datalancada;

	private Integer idusuario;

	private String numprocesso;

	private String tipoprocedencia;

	public Resultadosegundainstancia() {
	}

	public Integer getIdresultadosegunda() {
		return this.idresultadosegunda;
	}

	public void setIdresultadosegunda(Integer idresultadosegunda) {
		this.idresultadosegunda = idresultadosegunda;
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