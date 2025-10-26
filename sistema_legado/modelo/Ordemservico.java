package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordemservico database table.
 * 
 */
@Entity
@NamedQuery(name="Ordemservico.findAll", query="SELECT o FROM Ordemservico o WHERE o.situacaoordemservico NOT IN (0,-1,2,3,6) ORDER BY o.dataordemservico")
public class Ordemservico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ordemservico_idordemservico", sequenceName = "ordemservico_idordemservico_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="ordemservico_idordemservico")
	private Integer idordemservico;

	@Temporal(TemporalType.DATE)
	private Date datafinal;

	@Temporal(TemporalType.DATE)
	private Date datainicial;

	@Temporal(TemporalType.DATE)
	private Date dataordemservico;
	
	@Temporal(TemporalType.DATE)
	private Date dataconclusao;
	
	private String usuarioconclusao;

	private Integer situacaoordemservico;
	
	private String textoconclusao;

	private String textoproblema;
	
	private Integer prioridadeordemservico;
	
	private Integer tlsordemservico;
	
	private Integer tipoordemservico;
	
	private Time horaordemservico;
	
	private String tipodocumento;
	
	private String descricaodocumento;

	//bi-directional many-to-one association to Acao
	@ManyToOne
	@JoinColumn(name="idacao")
	private Acao acao;


	//bi-directional many-to-one association to Processo
	@ManyToOne
	@JoinColumn(name="numprocesso")
	private Processo processo;

	//bi-directional many-to-one association to Reclamacao
	@OneToMany(mappedBy="ordemservico")
	private List<Reclamacao> reclamacaos;



	public Ordemservico() {
	}

	public Integer getIdordemservico() {
		return this.idordemservico;
	}

	public void setIdordemservico(Integer idordemservico) {
		this.idordemservico = idordemservico;
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

	public Date getDataordemservico() {
		return this.dataordemservico;
	}

	public void setDataordemservico(Date dataordemservico) {
		this.dataordemservico = dataordemservico;
	}

	public Integer getSituacaoordemservico() {
		return this.situacaoordemservico;
	}

	public void setSituacaoordemservico(Integer situacaoordemservico) {
		this.situacaoordemservico = situacaoordemservico;
	}

	public String getTextoconclusao() {
		return this.textoconclusao;
	}

	public void setTextoconclusao(String textoconclusao) {
		this.textoconclusao = textoconclusao;
	}

	public String getTextoproblema() {
		return this.textoproblema;
	}

	public void setTextoproblema(String textoproblema) {
		this.textoproblema = textoproblema;
	}

	public Acao getAcao() {
		return this.acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}


	public Processo getProcesso() {
		return this.processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public List<Reclamacao> getReclamacaos() {
		return this.reclamacaos;
	}

	public void setReclamacaos(List<Reclamacao> reclamacaos) {
		this.reclamacaos = reclamacaos;
	}

	public Reclamacao addReclamacao(Reclamacao reclamacao) {
		getReclamacaos().add(reclamacao);
		reclamacao.setOrdemservico(this);

		return reclamacao;
	}

	public Reclamacao removeReclamacao(Reclamacao reclamacao) {
		getReclamacaos().remove(reclamacao);
		reclamacao.setOrdemservico(null);

		return reclamacao;
	}


	public Integer getPrioridadeordemservico() {
		return prioridadeordemservico;
	}

	public void setPrioridadeordemservico(Integer prioridadeordemservico) {
		this.prioridadeordemservico = prioridadeordemservico;
	}

	public Integer getTlsordemservico() {
		return tlsordemservico;
	}

	public void setTlsordemservico(Integer tlsordemservico) {
		this.tlsordemservico = tlsordemservico;
	}

	public Integer getTipoordemservico() {
		return tipoordemservico;
	}

	public void setTipoordemservico(Integer tipoordemservico) {
		this.tipoordemservico = tipoordemservico;
	}

	public Time getHoraordemservico() {
		return horaordemservico;
	}

	public void setHoraordemservico(Time horaordemservico) {
		this.horaordemservico = horaordemservico;
	}

	public Date getDataconclusao() {
		return dataconclusao;
	}

	public void setDataconclusao(Date dataconclusao) {
		this.dataconclusao = dataconclusao;
	}

	public String getUsuarioconclusao() {
		return usuarioconclusao;
	}

	public void setUsuarioconclusao(String usuarioconclusao) {
		this.usuarioconclusao = usuarioconclusao;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getDescricaodocumento() {
		return descricaodocumento;
	}

	public void setDescricaodocumento(String descricaodocumento) {
		this.descricaodocumento = descricaodocumento;
	}
	
	
	
}