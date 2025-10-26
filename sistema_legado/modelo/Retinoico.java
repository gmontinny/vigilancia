package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the retinoico database table.
 * 
 */
@Entity
@NamedQuery(name="Retinoico.findAll", query="SELECT r FROM Retinoico r")
public class Retinoico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="retinoico_idretinoico", sequenceName = "retinoico_idretinoico_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="retinoico_idretinoico")
	private Integer idretinoico;

	private Integer statusretinoico;

	@Temporal(TemporalType.DATE)
	private Date dataretinoico;
	
	@NotNull(message="Processo campo obrigatorio !")
	private String numprocesso;
	
	@NotNull(message="Tipo campo obrigatorio !")
	private Integer tiporetinoico;

	public Retinoico() {
	}

	public Integer getIdretinoico() {
		return this.idretinoico;
	}

	public void setIdretinoico(Integer idretinoico) {
		this.idretinoico = idretinoico;
	}

	public Integer getStatusretinoico() {
		return statusretinoico;
	}

	public void setStatusretinoico(Integer statusretinoico) {
		this.statusretinoico = statusretinoico;
	}

	public Date getDataretinoico() {
		return this.dataretinoico;
	}

	public void setDataretinoico(Date dataretinoico) {
		this.dataretinoico = dataretinoico;
	}

	public String getNumprocesso() {
		return this.numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public Integer getTiporetinoico() {
		return tiporetinoico;
	}

	public void setTiporetinoico(Integer tiporetinoico) {
		this.tiporetinoico = tiporetinoico;
	}
	
	

}