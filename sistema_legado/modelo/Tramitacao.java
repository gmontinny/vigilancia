package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the tramitacao database table.
 * 
 */
@Entity
@NamedQuery(name="Tramitacao.findAll", query="SELECT t FROM Tramitacao t")
public class Tramitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tramitacao_idtramitacao", sequenceName = "tramitacao_idtramitacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="tramitacao_idtramitacao")
	private Integer idtramitacao;

	@Temporal(TemporalType.DATE)
	private Date datafinal;

	@Temporal(TemporalType.DATE)
	private Date datainicial;
	
	@Temporal(TemporalType.DATE)
	private Date dataresposta;
	
	private String usuarioresposta;

	private Time horatramitacao;
	
	private Integer tipocolheita;
	
	private Integer tipoauto;
	
	private Integer tiponotificacao;
	
	private Integer tipoarquitetonico;
	
	private Integer tipoadministrativo;
	
	private Integer tipooperacao;
	
	private Integer prioridadetramite;
	
	private Integer numerotramitacao;
	
	private Integer statustramitacao;
	
	private Integer situacaotramitacao;
	
	private Integer leutramitacao;

	@ManyToOne
	@JoinColumn(name="idordemservico")
	private Ordemservico ordemservico;
	
	@ManyToOne
	@JoinColumn(name="idtipoinspecao")
	private Tipoinspecao tipoinspecao;

	private String textotramitacao;
	
	private String textoresposta;

	public Tramitacao() {
	}

	public Integer getIdtramitacao() {
		return this.idtramitacao;
	}

	public void setIdtramitacao(Integer idtramitacao) {
		this.idtramitacao = idtramitacao;
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

	public Time getHoratramitacao() {
		return this.horatramitacao;
	}

	public void setHoratramitacao(Time horatramitacao) {
		this.horatramitacao = horatramitacao;
	}

	public Ordemservico getOrdemservico() {
		return ordemservico;
	}

	public void setOrdemservico(Ordemservico ordemservico) {
		this.ordemservico = ordemservico;
	}

	public String getTextotramitacao() {
		return this.textotramitacao;
	}

	public void setTextotramitacao(String textotramitacao) {
		this.textotramitacao = textotramitacao;
	}

	public Tipoinspecao getTipoinspecao() {
		return tipoinspecao;
	}

	public void setTipoinspecao(Tipoinspecao tipoinspecao) {
		this.tipoinspecao = tipoinspecao;
	}

	public Integer getTipocolheita() {
		return tipocolheita;
	}

	public void setTipocolheita(Integer tipocolheita) {
		this.tipocolheita = tipocolheita;
	}

	public Integer getTipoauto() {
		return tipoauto;
	}

	public void setTipoauto(Integer tipoauto) {
		this.tipoauto = tipoauto;
	}

	public Integer getTiponotificacao() {
		return tiponotificacao;
	}

	public void setTiponotificacao(Integer tiponotificacao) {
		this.tiponotificacao = tiponotificacao;
	}

	public Integer getTipoarquitetonico() {
		return tipoarquitetonico;
	}

	public void setTipoarquitetonico(Integer tipoarquitetonico) {
		this.tipoarquitetonico = tipoarquitetonico;
	}

	public Integer getTipoadministrativo() {
		return tipoadministrativo;
	}

	public void setTipoadministrativo(Integer tipoadministrativo) {
		this.tipoadministrativo = tipoadministrativo;
	}

	public Integer getPrioridadetramite() {
		return prioridadetramite;
	}

	public void setPrioridadetramite(Integer prioridadetramite) {
		this.prioridadetramite = prioridadetramite;
	}

	public Integer getNumerotramitacao() {
		return numerotramitacao;
	}

	public void setNumerotramitacao(Integer numerotramitacao) {
		this.numerotramitacao = numerotramitacao;
	}

	public Integer getStatustramitacao() {
		return statustramitacao;
	}

	public void setStatustramitacao(Integer statustramitacao) {
		this.statustramitacao = statustramitacao;
	}

	public Integer getTipooperacao() {
		return tipooperacao;
	}

	public void setTipooperacao(Integer tipooperacao) {
		this.tipooperacao = tipooperacao;
	}

	public String getTextoresposta() {
		return textoresposta;
	}

	public void setTextoresposta(String textoresposta) {
		this.textoresposta = textoresposta;
	}

	public Integer getSituacaotramitacao() {
		return situacaotramitacao;
	}

	public void setSituacaotramitacao(Integer situacaotramitacao) {
		this.situacaotramitacao = situacaotramitacao;
	}

	public Date getDataresposta() {
		return dataresposta;
	}

	public void setDataresposta(Date dataresposta) {
		this.dataresposta = dataresposta;
	}

	public String getUsuarioresposta() {
		return usuarioresposta;
	}

	public void setUsuarioresposta(String usuarioresposta) {
		this.usuarioresposta = usuarioresposta;
	}

	public Integer getLeutramitacao() {
		return leutramitacao;
	}

	public void setLeutramitacao(Integer leutramitacao) {
		this.leutramitacao = leutramitacao;
	}
	
	
	
	
}