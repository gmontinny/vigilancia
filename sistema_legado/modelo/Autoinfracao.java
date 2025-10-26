package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the autoinfracao database table.
 * 
 */
@Entity
@NamedQuery(name="Autoinfracao.findAll", query="SELECT a FROM Autoinfracao a")
public class Autoinfracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="autoinfracao_idautoinfracao", sequenceName = "autoinfracao_idautoinfracao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="autoinfracao_idautoinfracao")
	private Integer idautoinfracao;

	@Temporal(TemporalType.DATE)
	private Date dataautoinfracao;
	
	private Integer grauinfracaoautoinfracao;
	
	private String textoautoinfracao;
	
	private Integer gerainterdicao;
		
	private Integer numeroauto;
	
	private Integer geraadvertencia;
	
	private Integer geramulta;
	
	private String valormulta;
	
	private String termoadvertencia;
	
	private String termointerdicao;
	
	private String textointerdicao;
	
	private String tipoinfracao;
	
	//bi-directional many-to-one association to Ordemservico
	@ManyToOne
	@JoinColumn(name="idtramitacao")
	private Tramitacao tramitacao;
	


	public Autoinfracao() {
	}

	public Integer getIdautoinfracao() {
		return this.idautoinfracao;
	}

	public void setIdautoinfracao(Integer idautoinfracao) {
		this.idautoinfracao = idautoinfracao;
	}

	public Date getDataautoinfracao() {
		return this.dataautoinfracao;
	}

	public void setDataautoinfracao(Date dataautoinfracao) {
		this.dataautoinfracao = dataautoinfracao;
	}

	public Integer getGrauinfracaoautoinfracao() {
		return this.grauinfracaoautoinfracao;
	}

	public void setGrauinfracaoautoinfracao(Integer grauinfracaoautoinfracao) {
		this.grauinfracaoautoinfracao = grauinfracaoautoinfracao;
	}

	public Tramitacao getTramitacao() {
		return tramitacao;
	}

	public void setTramitacao(Tramitacao tramitacao) {
		this.tramitacao = tramitacao;
	}


	public String getTextoautoinfracao() {
		return textoautoinfracao;
	}

	public void setTextoautoinfracao(String textoautoinfracao) {
		this.textoautoinfracao = textoautoinfracao;
	}


	public Integer getGerainterdicao() {
		return gerainterdicao;
	}

	public void setGerainterdicao(Integer gerainterdicao) {
		this.gerainterdicao = gerainterdicao;
	}

	public Integer getNumeroauto() {
		return numeroauto;
	}

	public void setNumeroauto(Integer numeroauto) {
		this.numeroauto = numeroauto;
	}

	public Integer getGeraadvertencia() {
		return geraadvertencia;
	}

	public void setGeraadvertencia(Integer geraadvertencia) {
		this.geraadvertencia = geraadvertencia;
	}

	public Integer getGeramulta() {
		return geramulta;
	}

	public void setGeramulta(Integer geramulta) {
		this.geramulta = geramulta;
	}

	public String getValormulta() {
		return valormulta;
	}

	public void setValormulta(String valormulta) {
		this.valormulta = valormulta;
	}

	public String getTermoadvertencia() {
		return termoadvertencia;
	}

	public void setTermoadvertencia(String termoadvertencia) {
		this.termoadvertencia = termoadvertencia;
	}

	public String getTermointerdicao() {
		return termointerdicao;
	}

	public void setTermointerdicao(String termointerdicao) {
		this.termointerdicao = termointerdicao;
	}

	public String getTextointerdicao() {
		return textointerdicao;
	}

	public void setTextointerdicao(String textointerdicao) {
		this.textointerdicao = textointerdicao;
	}

	public String getTipoinfracao() {
		return tipoinfracao;
	}

	public void setTipoinfracao(String tipoinfracao) {
		this.tipoinfracao = tipoinfracao;
	}

		
}