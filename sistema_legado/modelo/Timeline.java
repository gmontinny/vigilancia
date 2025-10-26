package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the timeline database table.
 * 
 */
@Entity
@NamedQuery(name="Timeline.findAll", query="SELECT t FROM Timeline t")
public class Timeline implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="timeline_idtimeline", sequenceName = "timeline_idtimeline_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="timeline_idtimeline")
	private Integer idtimeline;

	@Temporal(TemporalType.DATE)
	private Date datatimeline;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	private Integer situacao;

	private String textotimeline;
	
	private String numprocesso;
	
	private String tiposituacao;
	
	private Time horatimeline;

	public Timeline() {
	}

	public Integer getIdtimeline() {
		return this.idtimeline;
	}

	public void setIdtimeline(Integer idtimeline) {
		this.idtimeline = idtimeline;
	}

	public Date getDatatimeline() {
		return this.datatimeline;
	}

	public void setDatatimeline(Date datatimeline) {
		this.datatimeline = datatimeline;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getSituacao() {
		return this.situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public String getTextotimeline() {
		return this.textotimeline;
	}

	public void setTextotimeline(String textotimeline) {
		this.textotimeline = textotimeline;
	}

	public String getNumprocesso() {
		return numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public Time getHoratimeline() {
		return horatimeline;
	}

	public void setHoratimeline(Time horatimeline) {
		this.horatimeline = horatimeline;
	}

	public String getTiposituacao() {
		return tiposituacao;
	}

	public void setTiposituacao(String tiposituacao) {
		this.tiposituacao = tiposituacao;
	}

	
}