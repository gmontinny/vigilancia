package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the notificacao database table.
 * 
 */
@Entity
@NamedQuery(name="Notificacao.findAll", query="SELECT n FROM Notificacao n")
public class Notificacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacao_idnotificacao", sequenceName = "notificacao_idnotificacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacao_idnotificacao")
	private Integer idnotificacao;

	@Temporal(TemporalType.DATE)
	private Date datanotificacao;
	
	private Integer statusnotificacao;
	
	private String denotificacao;
	
	private String paranotificacao;
	
	private String mensagemnotificacao;
	
	private Integer totalnotificacao;
	
	private Time horanotificacao;
	
	//bi-directional many-to-one association to Ordemservico
	@ManyToOne
	@JoinColumn(name="idusuario")
	@NotNull(message="Usuario Campo Obrigatorio!")
	private Usuario usuario;	


	public Notificacao() {
	}

	public Integer getIdnotificacao() {
		return this.idnotificacao;
	}

	public void setIdnotificacao(Integer idnotificacao) {
		this.idnotificacao = idnotificacao;
	}

	public Date getDatanotificacao() {
		return this.datanotificacao;
	}

	public void setDatanotificacao(Date datanotificacao) {
		this.datanotificacao = datanotificacao;
	}



	public Integer getStatusnotificacao() {
		return statusnotificacao;
	}

	public void setStatusnotificacao(Integer statusnotificacao) {
		this.statusnotificacao = statusnotificacao;
	}

	public String getDenotificacao() {
		return denotificacao;
	}

	public void setDenotificacao(String denotificacao) {
		this.denotificacao = denotificacao;
	}

	public String getParanotificacao() {
		return paranotificacao;
	}

	public void setParanotificacao(String paranotificacao) {
		this.paranotificacao = paranotificacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMensagemnotificacao() {
		return mensagemnotificacao;
	}

	public void setMensagemnotificacao(String mensagemnotificacao) {
		this.mensagemnotificacao = mensagemnotificacao;
	}

	public Integer getTotalnotificacao() {
		return totalnotificacao;
	}

	public void setTotalnotificacao(Integer totalnotificacao) {
		this.totalnotificacao = totalnotificacao;
	}

	public Time getHoranotificacao() {
		return horanotificacao;
	}

	public void setHoranotificacao(Time horanotificacao) {
		this.horanotificacao = horanotificacao;
	}
	
	

}