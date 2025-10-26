package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the timelineadm database table.
 * 
 */
@Entity
@NamedQuery(name="Timelineadm.findAll", query="SELECT t FROM Timelineadm t")
public class Timelineadm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="timelineadm_idtimelineadm", sequenceName = "timelineadm_idtimelineadm_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="timelineadm_idtimelineadm")
	private Integer idtimelineadm;

	@Temporal(TemporalType.DATE)
	private Date data;

	private Time hora;

	private String numprocesso;

	private String processogerado;

	private String situacao;

	public Timelineadm() {
	}

	public Integer getIdtimelineadm() {
		return this.idtimelineadm;
	}

	public void setIdtimelineadm(Integer idtimelineadm) {
		this.idtimelineadm = idtimelineadm;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getNumprocesso() {
		return this.numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public String getProcessogerado() {
		return this.processogerado;
	}

	public void setProcessogerado(String processogerado) {
		this.processogerado = processogerado;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}