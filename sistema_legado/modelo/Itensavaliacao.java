package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the itensavaliacao database table.
 * 
 */
@Entity
@NamedQuery(name="Itensavaliacao.findAll", query="SELECT i FROM Itensavaliacao i")
public class Itensavaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensavaliacao_iditensavaliacao", sequenceName = "itensavaliacao_iditensavaliacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensavaliacao_iditensavaliacao")
	private Integer iditensavaliacao;
	
	@Temporal(TemporalType.DATE)
	private Date datafinal;

	@NotNull(message="DATA RECEBIMENTO campo obrigatorio !")
	@Temporal(TemporalType.DATE)
	private Date datarecebimento;

	@NotNull(message="PRAZO campo obrigatorio !")
	private Integer prazo;

	@NotNull(message="RESPONSAVEL campo obrigatorio !")
	private Integer responsavel;

	private Integer status;

	@NotNull(message="TEXTO campo obrigatorio !")
	private String texto;
	
	
	@ManyToOne
	@JoinColumn(name="idgestaodocumento")
	private Gestaodocumento gestaodocumento;

	public Itensavaliacao() {
	}

	public Integer getIditensavaliacao() {
		return this.iditensavaliacao;
	}

	public void setIditensavaliacao(Integer iditensavaliacao) {
		this.iditensavaliacao = iditensavaliacao;
	}

	public Date getDatafinal() {
		return this.datafinal;
	}

	public void setDatafinal(Date datafinal) {
		this.datafinal = datafinal;
	}

	public Date getDatarecebimento() {
		return this.datarecebimento;
	}

	public void setDatarecebimento(Date datarecebimento) {
		this.datarecebimento = datarecebimento;
	}

	public Integer getPrazo() {
		return this.prazo;
	}

	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}

	public Integer getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(Integer responsavel) {
		this.responsavel = responsavel;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Gestaodocumento getGestaodocumento() {
		return gestaodocumento;
	}

	public void setGestaodocumento(Gestaodocumento gestaodocumento) {
		this.gestaodocumento = gestaodocumento;
	}


}