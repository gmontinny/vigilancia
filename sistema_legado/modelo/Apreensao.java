package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the apreensao database table.
 * 
 */
@Entity
@NamedQuery(name="Apreensao.findAll", query="SELECT a FROM Apreensao a")
public class Apreensao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="apreensao_idapreensao", sequenceName = "apreensao_idapreensao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="apreensao_idapreensao")
	private Integer idapreensao;

	private Integer descarteapreensao;

	@NotNull(message="Marca campo obrigatorio !")
	private String marcaapreensao;

	private Integer numeroauto;
	
	private Integer quantidadeapreensao;

	@NotNull(message="Produto campo obrigatorio !")
	private String produtoapreensao;
	
	private String localdescarte;
	
	@Temporal(TemporalType.DATE)	
	private Date validadeapreensao;
	
	private String loteapreensao;
	
	private String volumeapreensao;
	
	@Temporal(TemporalType.DATE)	
	private Date datafabricante; 

	//bi-directional many-to-one association to Unidademedida
	@ManyToOne
	@JoinColumn(name="idunidademedida")
	private Unidademedida unidademedida;

	public Apreensao() {
	}

	public Integer getIdapreensao() {
		return this.idapreensao;
	}

	public void setIdapreensao(Integer idapreensao) {
		this.idapreensao = idapreensao;
	}

	public Integer getDescarteapreensao() {
		return this.descarteapreensao;
	}

	public void setDescarteapreensao(Integer descarteapreensao) {
		this.descarteapreensao = descarteapreensao;
	}

	public String getMarcaapreensao() {
		return this.marcaapreensao;
	}

	public void setMarcaapreensao(String marcaapreensao) {
		this.marcaapreensao = marcaapreensao;
	}

	public Integer getNumeroauto() {
		return this.numeroauto;
	}

	public void setNumeroauto(Integer numeroauto) {
		this.numeroauto = numeroauto;
	}

	public String getProdutoapreensao() {
		return this.produtoapreensao;
	}

	public void setProdutoapreensao(String produtoapreensao) {
		this.produtoapreensao = produtoapreensao;
	}

	public Unidademedida getUnidademedida() {
		return this.unidademedida;
	}

	public void setUnidademedida(Unidademedida unidademedida) {
		this.unidademedida = unidademedida;
	}

	public Integer getQuantidadeapreensao() {
		return quantidadeapreensao;
	}

	public void setQuantidadeapreensao(Integer quantidadeapreensao) {
		this.quantidadeapreensao = quantidadeapreensao;
	}

	public String getLocaldescarte() {
		return localdescarte;
	}

	public void setLocaldescarte(String localdescarte) {
		this.localdescarte = localdescarte;
	}

	public Date getValidadeapreensao() {
		return validadeapreensao;
	}

	public void setValidadeapreensao(Date validadeapreensao) {
		this.validadeapreensao = validadeapreensao;
	}

	public String getLoteapreensao() {
		return loteapreensao;
	}

	public void setLoteapreensao(String loteapreensao) {
		this.loteapreensao = loteapreensao;
	}

	public String getVolumeapreensao() {
		return volumeapreensao;
	}

	public void setVolumeapreensao(String volumeapreensao) {
		this.volumeapreensao = volumeapreensao;
	}

	public Date getDatafabricante() {
		return datafabricante;
	}

	public void setDatafabricante(Date datafabricante) {
		this.datafabricante = datafabricante;
	}
	
	
	
	
}