package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the tramiteadm database table.
 * 
 */
@Entity
@NamedQuery(name="Tramiteadm.findAll", query="SELECT t FROM Tramiteadm t")
public class Tramiteadm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tramiteadm_idtramiteadm", sequenceName = "tramiteadm_idtramiteadm_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="tramiteadm_idtramiteadm")
	private Integer idtramiteadm;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "Data Final campo obrigatório!")
	private Date datafinal;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "Data Inicial campo obrigatório!")
	private Date datainicial;

	private Integer idusuario;

	private Integer numerotramiteadm;
	
	private String numprocesso;

	private String situacao;

	private Integer status;
	
	private Integer numeroauto;


	public Tramiteadm() {
	}

	public Integer getIdtramiteadm() {
		return this.idtramiteadm;
	}

	public void setIdtramiteadm(Integer idtramiteadm) {
		this.idtramiteadm = idtramiteadm;
	}

	public Date getDatafinal() {
		return this.datafinal;
	}

	public void setDatafinal(Date datafinal) {
		this.datafinal = datafinal;
	}

	public Date getDatainicial() {
		return this.datainicial;
	}

	public void setDatainicial(Date datainicial) {
		this.datainicial = datainicial;
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getNumerotramiteadm() {
		return this.numerotramiteadm;
	}

	public void setNumerotramiteadm(Integer numerotramiteadm) {
		this.numerotramiteadm = numerotramiteadm;
	}

	public String getNumprocesso() {
		return this.numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getNumeroauto() {
		return numeroauto;
	}

	public void setNumeroauto(Integer numeroauto) {
		this.numeroauto = numeroauto;
	}
	

}