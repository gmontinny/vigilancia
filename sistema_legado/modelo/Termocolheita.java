package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.com.caelum.stella.bean.validation.CNPJ;


/**
 * The persistent class for the termocolheita database table.
 * 
 */
@Entity
@NamedQuery(name="Termocolheita.findAll", query="SELECT t FROM Termocolheita t")
public class Termocolheita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="termocolheita_idtermocolheita", sequenceName = "termocolheita_idtermocolheita_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="termocolheita_idtermocolheita")
	private Integer idtermocolheita;
	
	private String apresentacaotermocolheita;
	
	private String bairrotermocolheita;

	private String ceptermocolheita;

	private String cidadetermocolheita;

	private String cnpjtermocolheita;

	private Integer contraprova01;

	private Integer contraprova02;

	private Integer contraprova03;

	private String embaladortermocolheita;
	
	private String enderecotermocolheita;

	private String fabricantetermocolheita;

	private Integer finsanalisetermocolheita;

	private Integer numerotramitacao;
	
	private String nomeproduto;
	
	@Temporal(TemporalType.DATE)
	private Date datacolheita;
	
	@ManyToOne
	@JoinColumn(name="idprodutocategoria")
	private Produtocategoria produtocategoria;

	private String inscricaotermocolheita;

	private Integer laboratorio01;

	private Integer laboratorio02;

	private Integer laboratorio03;

	private Integer lacre01termocolheita;

	private Integer lacre02termocolheita;

	private Integer lacre03termocolheita;
	
	private String localconsumo;

	private String lotetermocolheita;

	private String marcatermocolheita;
	
	private Integer numeroconsumidor;

	private String observacao;

	private String periodoincubacao;
	
	
	private String pesovolumento;


	private Integer quantidadeamostra;

	private Integer quantidadedoente;

	private String registrotermocolheita;

	private String tecnicoresponsavel;

	private String termometrotermocolheita;
	

	private String tipoanalise;
	

	private String uftermocolheita;


	private String validadetermocolheita;
	

	private String fabricacaotermocolheita;

	//bi-directional many-to-one association to Motivo
	@ManyToOne
	@JoinColumn(name="idmotivo")
	private Motivo motivo;
	
	private Integer numeroendereco;

	private String sintomastermocolheita;
	
	private String telefonetermocolheita;
	
	private String arquivolaudo;
	
	private Integer tipoformatacao;

	public Termocolheita() {
	}

	public Integer getIdtermocolheita() {
		return this.idtermocolheita;
	}

	public void setIdtermocolheita(Integer idtermocolheita) {
		this.idtermocolheita = idtermocolheita;
	}

	public String getApresentacaotermocolheita() {
		return this.apresentacaotermocolheita;
	}

	public void setApresentacaotermocolheita(String apresentacaotermocolheita) {
		this.apresentacaotermocolheita = apresentacaotermocolheita;
	}

	public String getBairrotermocolheita() {
		return this.bairrotermocolheita;
	}

	public void setBairrotermocolheita(String bairrotermocolheita) {
		this.bairrotermocolheita = bairrotermocolheita;
	}

	public String getCeptermocolheita() {
		return this.ceptermocolheita;
	}

	public void setCeptermocolheita(String ceptermocolheita) {
		this.ceptermocolheita = ceptermocolheita;
	}

	public String getCidadetermocolheita() {
		return this.cidadetermocolheita;
	}

	public void setCidadetermocolheita(String cidadetermocolheita) {
		this.cidadetermocolheita = cidadetermocolheita;
	}

	public String getCnpjtermocolheita() {
		return this.cnpjtermocolheita;
	}

	public void setCnpjtermocolheita(String cnpjtermocolheita) {
		this.cnpjtermocolheita = cnpjtermocolheita;
	}

	public Integer getContraprova01() {
		return this.contraprova01;
	}

	public void setContraprova01(Integer contraprova01) {
		this.contraprova01 = contraprova01;
	}

	public Integer getContraprova02() {
		return this.contraprova02;
	}

	public void setContraprova02(Integer contraprova02) {
		this.contraprova02 = contraprova02;
	}

	public Integer getContraprova03() {
		return this.contraprova03;
	}

	public void setContraprova03(Integer contraprova03) {
		this.contraprova03 = contraprova03;
	}

	public String getEmbaladortermocolheita() {
		return this.embaladortermocolheita;
	}

	public void setEmbaladortermocolheita(String embaladortermocolheita) {
		this.embaladortermocolheita = embaladortermocolheita;
	}

	public String getEnderecotermocolheita() {
		return this.enderecotermocolheita;
	}

	public void setEnderecotermocolheita(String enderecotermocolheita) {
		this.enderecotermocolheita = enderecotermocolheita;
	}

	public String getFabricantetermocolheita() {
		return this.fabricantetermocolheita;
	}

	public void setFabricantetermocolheita(String fabricantetermocolheita) {
		this.fabricantetermocolheita = fabricantetermocolheita;
	}

	public Integer getFinsanalisetermocolheita() {
		return this.finsanalisetermocolheita;
	}

	public void setFinsanalisetermocolheita(Integer finsanalisetermocolheita) {
		this.finsanalisetermocolheita = finsanalisetermocolheita;
	}


	public Produtocategoria getProdutocategoria() {
		return produtocategoria;
	}

	public void setProdutocategoria(Produtocategoria produtocategoria) {
		this.produtocategoria = produtocategoria;
	}

	public String getInscricaotermocolheita() {
		return this.inscricaotermocolheita;
	}

	public void setInscricaotermocolheita(String inscricaotermocolheita) {
		this.inscricaotermocolheita = inscricaotermocolheita;
	}

	public Integer getLaboratorio01() {
		return this.laboratorio01;
	}

	public void setLaboratorio01(Integer laboratorio01) {
		this.laboratorio01 = laboratorio01;
	}

	public Integer getLaboratorio02() {
		return this.laboratorio02;
	}

	public void setLaboratorio02(Integer laboratorio02) {
		this.laboratorio02 = laboratorio02;
	}

	public Integer getLaboratorio03() {
		return this.laboratorio03;
	}

	public void setLaboratorio03(Integer laboratorio03) {
		this.laboratorio03 = laboratorio03;
	}

	public Integer getLacre01termocolheita() {
		return this.lacre01termocolheita;
	}

	public void setLacre01termocolheita(Integer lacre01termocolheita) {
		this.lacre01termocolheita = lacre01termocolheita;
	}

	public Integer getLacre02termocolheita() {
		return this.lacre02termocolheita;
	}

	public void setLacre02termocolheita(Integer lacre02termocolheita) {
		this.lacre02termocolheita = lacre02termocolheita;
	}

	public Integer getLacre03termocolheita() {
		return this.lacre03termocolheita;
	}

	public void setLacre03termocolheita(Integer lacre03termocolheita) {
		this.lacre03termocolheita = lacre03termocolheita;
	}

	public String getLocalconsumo() {
		return this.localconsumo;
	}

	public void setLocalconsumo(String localconsumo) {
		this.localconsumo = localconsumo;
	}

	public String getLotetermocolheita() {
		return this.lotetermocolheita;
	}

	public void setLotetermocolheita(String lotetermocolheita) {
		this.lotetermocolheita = lotetermocolheita;
	}

	public String getMarcatermocolheita() {
		return this.marcatermocolheita;
	}

	public void setMarcatermocolheita(String marcatermocolheita) {
		this.marcatermocolheita = marcatermocolheita;
	}

	public Integer getNumeroconsumidor() {
		return this.numeroconsumidor;
	}

	public void setNumeroconsumidor(Integer numeroconsumidor) {
		this.numeroconsumidor = numeroconsumidor;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getPeriodoincubacao() {
		return this.periodoincubacao;
	}

	public void setPeriodoincubacao(String periodoincubacao) {
		this.periodoincubacao = periodoincubacao;
	}

	public String getPesovolumento() {
		return this.pesovolumento;
	}

	public void setPesovolumento(String pesovolumento) {
		this.pesovolumento = pesovolumento;
	}

	public Integer getQuantidadeamostra() {
		return this.quantidadeamostra;
	}

	public void setQuantidadeamostra(Integer quantidadeamostra) {
		this.quantidadeamostra = quantidadeamostra;
	}

	public Integer getQuantidadedoente() {
		return this.quantidadedoente;
	}

	public void setQuantidadedoente(Integer quantidadedoente) {
		this.quantidadedoente = quantidadedoente;
	}

	public String getRegistrotermocolheita() {
		return this.registrotermocolheita;
	}

	public void setRegistrotermocolheita(String registrotermocolheita) {
		this.registrotermocolheita = registrotermocolheita;
	}

	public String getTecnicoresponsavel() {
		return this.tecnicoresponsavel;
	}

	public void setTecnicoresponsavel(String tecnicoresponsavel) {
		this.tecnicoresponsavel = tecnicoresponsavel;
	}

	public String getTermometrotermocolheita() {
		return this.termometrotermocolheita;
	}

	public void setTermometrotermocolheita(String termometrotermocolheita) {
		this.termometrotermocolheita = termometrotermocolheita;
	}

	public String getTipoanalise() {
		return this.tipoanalise;
	}

	public void setTipoanalise(String tipoanalise) {
		this.tipoanalise = tipoanalise;
	}

	public String getUftermocolheita() {
		return this.uftermocolheita;
	}

	public void setUftermocolheita(String uftermocolheita) {
		this.uftermocolheita = uftermocolheita;
	}

	public String getValidadetermocolheita() {
		return this.validadetermocolheita;
	}

	public void setValidadetermocolheita(String validadetermocolheita) {
		this.validadetermocolheita = validadetermocolheita;
	}

	public Motivo getMotivo() {
		return this.motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public Integer getNumerotramitacao() {
		return numerotramitacao;
	}

	public void setNumerotramitacao(Integer numerotramitacao) {
		this.numerotramitacao = numerotramitacao;
	}

	public String getSintomastermocolheita() {
		return sintomastermocolheita;
	}

	public void setSintomastermocolheita(String sintomastermocolheita) {
		this.sintomastermocolheita = sintomastermocolheita;
	}

	public String getTelefonetermocolheita() {
		return telefonetermocolheita;
	}

	public void setTelefonetermocolheita(String telefonetermocolheita) {
		this.telefonetermocolheita = telefonetermocolheita;
	}

	public String getFabricacaotermocolheita() {
		return fabricacaotermocolheita;
	}

	public void setFabricacaotermocolheita(String fabricacaotermocolheita) {
		this.fabricacaotermocolheita = fabricacaotermocolheita;
	}

	public String getArquivolaudo() {
		return arquivolaudo;
	}

	public void setArquivolaudo(String arquivolaudo) {
		this.arquivolaudo = arquivolaudo;
	}

	public Integer getNumeroendereco() {
		return numeroendereco;
	}

	public void setNumeroendereco(Integer numeroendereco) {
		this.numeroendereco = numeroendereco;
	}

	public String getNomeproduto() {
		return nomeproduto;
	}

	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}

	public Date getDatacolheita() {
		return datacolheita;
	}

	public void setDatacolheita(Date datacolheita) {
		this.datacolheita = datacolheita;
	}

	public Integer getTipoformatacao() {
		return tipoformatacao;
	}

	public void setTipoformatacao(Integer tipoformatacao) {
		this.tipoformatacao = tipoformatacao;
	}

	
}