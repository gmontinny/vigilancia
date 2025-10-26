package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the processoadministrativo database table.
 * 
 */
@Entity
@NamedQuery(name="Processoadministrativo.findAll", query="SELECT p FROM Processoadministrativo p")
public class Processoadministrativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="processoadministrativo_idprocessoadministrativo", sequenceName = "processoadministrativo_idprocessoadministrativo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="processoadministrativo_idprocessoadministrativo")
	private Integer idprocessoadministrativo;

	@Temporal(TemporalType.DATE)
	private Date dataprocesso;
	
	@Temporal(TemporalType.DATE)
	private Date dataciencia;
	
	private Integer indicadorcontrarazao;

	private Integer numeroauto;
	
	@ManyToOne
	@JoinColumn(name="numprocesso")
	@NotNull(message="Processo campo Obrigatorio !")
	private Processo processo;

	private String textorazao;

	private String textoresposta;
	
	private String processogerado;

	private Integer tiporesultado;
	
	private Integer fiscalresponsavel;
	
	private Integer fiscalcontraresposta;
	
	private Integer tiposituacao;

	public Processoadministrativo() {
	}

	public Integer getIdprocessoadministrativo() {
		return this.idprocessoadministrativo;
	}

	public void setIdprocessoadministrativo(Integer idprocessoadministrativo) {
		this.idprocessoadministrativo = idprocessoadministrativo;
	}

	public Date getDataprocesso() {
		return this.dataprocesso;
	}

	public void setDataprocesso(Date dataprocesso) {
		this.dataprocesso = dataprocesso;
	}

	public Integer getIndicadorcontrarazao() {
		return this.indicadorcontrarazao;
	}

	public void setIndicadorcontrarazao(Integer indicadorcontrarazao) {
		this.indicadorcontrarazao = indicadorcontrarazao;
	}

	public Integer getNumeroauto() {
		return this.numeroauto;
	}

	public void setNumeroauto(Integer numeroauto) {
		this.numeroauto = numeroauto;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public String getTextorazao() {
		return this.textorazao;
	}

	public void setTextorazao(String textorazao) {
		this.textorazao = textorazao;
	}

	public String getTextoresposta() {
		return this.textoresposta;
	}

	public void setTextoresposta(String textoresposta) {
		this.textoresposta = textoresposta;
	}

	public Integer getTiporesultado() {
		return this.tiporesultado;
	}

	public void setTiporesultado(Integer tiporesultado) {
		this.tiporesultado = tiporesultado;
	}

	public String getProcessogerado() {
		return processogerado;
	}

	public void setProcessogerado(String processogerado) {
		this.processogerado = processogerado;
	}

	public Integer getFiscalresponsavel() {
		return fiscalresponsavel;
	}

	public void setFiscalresponsavel(Integer fiscalresponsavel) {
		this.fiscalresponsavel = fiscalresponsavel;
	}

	public Integer getFiscalcontraresposta() {
		return fiscalcontraresposta;
	}

	public void setFiscalcontraresposta(Integer fiscalcontraresposta) {
		this.fiscalcontraresposta = fiscalcontraresposta;
	}

	public Integer getTiposituacao() {
		return tiposituacao;
	}

	public void setTiposituacao(Integer tiposituacao) {
		this.tiposituacao = tiposituacao;
	}

	public Date getDataciencia() {
		return dataciencia;
	}

	public void setDataciencia(Date dataciencia) {
		this.dataciencia = dataciencia;
	}
	

}