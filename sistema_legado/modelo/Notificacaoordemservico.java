package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the notificacaoordemservico database table.
 * 
 */
@Entity
@NamedQuery(name="Notificacaoordemservico.findAll", query="SELECT n FROM Notificacaoordemservico n")
public class Notificacaoordemservico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacaoordemservico_idnotificacaoordemservico", sequenceName = "notificacaoordemservico_idnotificacaoordemservico_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacaoordemservico_idnotificacaoordemservico")

	private Integer idnotificacaoordemservico;

	@Temporal(TemporalType.DATE)
	private Date datanotificacaoordemservico;

	private Time horanotificacaooredemservico;


	@ManyToOne
	@JoinColumn(name="idordemservico")
	@NotNull(message="Ordem de Serviço Campo Obrigatorio!")
	private Ordemservico ordemservico;

	//bi-directional many-to-one association to Ordemservico
	@ManyToOne
	@JoinColumn(name="idusuario")
	@NotNull(message="Usuario Campo Obrigatorio!")
	private Usuario usuario;
	
	private Integer statusordemservico;

	public Notificacaoordemservico() {
	}

	public Integer getIdnotificacaoordemservico() {
		return this.idnotificacaoordemservico;
	}

	public void setIdnotificacaoordemservico(Integer idnotificacaoordemservico) {
		this.idnotificacaoordemservico = idnotificacaoordemservico;
	}

	public Date getDatanotificacaoordemservico() {
		return this.datanotificacaoordemservico;
	}

	public void setDatanotificacaoordemservico(Date datanotificacaoordemservico) {
		this.datanotificacaoordemservico = datanotificacaoordemservico;
	}

	public Time getHoranotificacaooredemservico() {
		return this.horanotificacaooredemservico;
	}

	public void setHoranotificacaooredemservico(Time horanotificacaooredemservico) {
		this.horanotificacaooredemservico = horanotificacaooredemservico;
	}

	public Ordemservico getOrdemservico() {
		return ordemservico;
	}

	public void setOrdemservico(Ordemservico ordemservico) {
		this.ordemservico = ordemservico;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getStatusordemservico() {
		return this.statusordemservico;
	}

	public void setStatusordemservico(Integer statusordemservico) {
		this.statusordemservico = statusordemservico;
	}

}