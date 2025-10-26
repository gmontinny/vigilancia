package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the fiscaladm database table.
 * 
 */
@Entity
@NamedQuery(name="Fiscaladm.findAll", query="SELECT f FROM Fiscaladm f")
public class Fiscaladm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="fiscaladm_idfiscaladm", sequenceName = "fiscaladm_idfiscaladm_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="fiscaladm_idfiscaladm")
	private Integer idfiscaladm;

	@ManyToOne
	@JoinColumn(name="idusuario")
	@NotNull(message="Usuario campo obrigatorio !")
	private Usuario usuario;

	
	private Integer responsavelfiscal;

	private Integer statusfiscal;
	
	private Integer numerotramiteadm;

	public Fiscaladm() {
	}

	public Integer getIdfiscaladm() {
		return this.idfiscaladm;
	}

	public void setIdfiscaladm(Integer idfiscaladm) {
		this.idfiscaladm = idfiscaladm;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getResponsavelfiscal() {
		return this.responsavelfiscal;
	}

	public void setResponsavelfiscal(Integer responsavelfiscal) {
		this.responsavelfiscal = responsavelfiscal;
	}

	public Integer getStatusfiscal() {
		return this.statusfiscal;
	}

	public void setStatusfiscal(Integer statusfiscal) {
		this.statusfiscal = statusfiscal;
	}

	public Integer getNumerotramiteadm() {
		return numerotramiteadm;
	}

	public void setNumerotramiteadm(Integer numerotramiteadm) {
		this.numerotramiteadm = numerotramiteadm;
	}
	
	

}