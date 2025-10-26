package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the balancomedicamento database table.
 * 
 */
@Entity
@NamedQuery(name="Balancomedicamento.findAll", query="SELECT b FROM Balancomedicamento b")
public class Balancomedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="balanco_idbalanco", sequenceName = "balanco_idbalanco_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="balanco_idbalanco")
	private Integer idbalanco;

	private Integer bmpoanual;

	private Integer bmpotrimestral;

	private Integer bspoanual;

	private Integer bspotrimestral;

	@Temporal(TemporalType.DATE)
	@NotNull(message="Data de entrega campo Obrigatorio !")
	private Date dataentrega;

	@ManyToOne
	@JoinColumn(name="idestabelecimento")
	@NotNull(message="Estabelecimento é Obrigatorio para Balanço Medicamento !")
	private Estabelecimento estabelecimento;

	private Integer livroreceituario;
	
	@NotNull(message="Mês de Referência campo Obrigatorio !")
	private Integer mesreferencia;

	private Integer qtdareceitaa;

	private Integer qtdareceitab;

	private Integer rmnramensal;

	private Integer rmnrb2mensal;

	private Integer rmvmensal;

	private Integer statusbalanco;

	private String textobalanco;

	private Integer trimestrebmpo;

	private Integer trimestrebspo;
	
	private Integer idusuario;
	
	private Integer balancoanual;
	
	@NotNull(message="Nome entregador é campo Obrigatorio !")
	private String entregador;

	public Balancomedicamento() {
	}

	public Integer getIdbalanco() {
		return this.idbalanco;
	}

	public void setIdbalanco(Integer idbalanco) {
		this.idbalanco = idbalanco;
	}

	public Integer getBmpoanual() {
		return this.bmpoanual;
	}

	public void setBmpoanual(Integer bmpoanual) {
		this.bmpoanual = bmpoanual;
	}

	public Integer getBmpotrimestral() {
		return this.bmpotrimestral;
	}

	public void setBmpotrimestral(Integer bmpotrimestral) {
		this.bmpotrimestral = bmpotrimestral;
	}

	public Integer getBspoanual() {
		return this.bspoanual;
	}

	public void setBspoanual(Integer bspoanual) {
		this.bspoanual = bspoanual;
	}

	public Integer getBspotrimestral() {
		return this.bspotrimestral;
	}

	public void setBspotrimestral(Integer bspotrimestral) {
		this.bspotrimestral = bspotrimestral;
	}

	public Date getDataentrega() {
		return this.dataentrega;
	}

	public void setDataentrega(Date dataentrega) {
		this.dataentrega = dataentrega;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Integer getLivroreceituario() {
		return this.livroreceituario;
	}

	public void setLivroreceituario(Integer livroreceituario) {
		this.livroreceituario = livroreceituario;
	}

	public Integer getMesreferencia() {
		return this.mesreferencia;
	}

	public void setMesreferencia(Integer mesreferencia) {
		this.mesreferencia = mesreferencia;
	}

	public Integer getQtdareceitaa() {
		return this.qtdareceitaa;
	}

	public void setQtdareceitaa(Integer qtdareceitaa) {
		this.qtdareceitaa = qtdareceitaa;
	}

	public Integer getQtdareceitab() {
		return this.qtdareceitab;
	}

	public void setQtdareceitab(Integer qtdareceitab) {
		this.qtdareceitab = qtdareceitab;
	}

	public Integer getRmnramensal() {
		return this.rmnramensal;
	}

	public void setRmnramensal(Integer rmnramensal) {
		this.rmnramensal = rmnramensal;
	}

	public Integer getRmnrb2mensal() {
		return this.rmnrb2mensal;
	}

	public void setRmnrb2mensal(Integer rmnrb2mensal) {
		this.rmnrb2mensal = rmnrb2mensal;
	}

	public Integer getRmvmensal() {
		return this.rmvmensal;
	}

	public void setRmvmensal(Integer rmvmensal) {
		this.rmvmensal = rmvmensal;
	}

	public Integer getStatusbalanco() {
		return this.statusbalanco;
	}

	public void setStatusbalanco(Integer statusbalanco) {
		this.statusbalanco = statusbalanco;
	}

	public String getTextobalanco() {
		return this.textobalanco;
	}

	public void setTextobalanco(String textobalanco) {
		this.textobalanco = textobalanco;
	}

	public Integer getTrimestrebmpo() {
		return this.trimestrebmpo;
	}

	public void setTrimestrebmpo(Integer trimestrebmpo) {
		this.trimestrebmpo = trimestrebmpo;
	}

	public Integer getTrimestrebspo() {
		return this.trimestrebspo;
	}

	public void setTrimestrebspo(Integer trimestrebspo) {
		this.trimestrebspo = trimestrebspo;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getEntregador() {
		return entregador;
	}

	public void setEntregador(String entregador) {
		this.entregador = entregador;
	}

	public Integer getBalancoanual() {
		return balancoanual;
	}

	public void setBalancoanual(Integer balancoanual) {
		this.balancoanual = balancoanual;
	}
	
	

}