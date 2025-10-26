package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the forum database table.
 * 
 */
@Entity
@NamedQuery(name="Forum.findAll", query="SELECT f FROM Forum f")
public class Forum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="forum_idforum", sequenceName = "forum_idforum_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="forum_idforum")
	private Integer idforum;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtforum;

	@ManyToOne
	@JoinColumn(name="idordemservico")
	@NotNull(message="Ordem Serviço Campo Obrigatorio!")
	private Ordemservico ordemservico;

	private String textoforum;
		
	private String textousuario;
	
	private Integer statusforum;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	@NotNull(message="Usuario Campo Obrigatorio!")
	private Usuario usuario;

	public Forum() {
	}

	public Integer getIdforum() {
		return this.idforum;
	}

	public void setIdforum(Integer idforum) {
		this.idforum = idforum;
	}

	public Date getDtforum() {
		return this.dtforum;
	}

	public void setDtforum(Date dtforum) {
		this.dtforum = dtforum;
	}

	public Ordemservico getOrdemservico() {
		return ordemservico;
	}

	public void setOrdemservico(Ordemservico ordemservico) {
		this.ordemservico = ordemservico;
	}

	public String getTextoforum() {
		return this.textoforum;
	}

	public void setTextoforum(String textoforum) {
		this.textoforum = textoforum;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTextousuario() {
		return textousuario;
	}

	public void setTextousuario(String textousuario) {
		this.textousuario = textousuario;
	}

	public Integer getStatusforum() {
		return statusforum;
	}

	public void setStatusforum(Integer statusforum) {
		this.statusforum = statusforum;
	}

	

}