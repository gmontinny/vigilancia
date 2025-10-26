package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the alvara database table.
 * 
 */
@Entity
@NamedQuery(name="Alvara.findAll", query="SELECT a FROM Alvara a")
public class Alvara implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="alvara_idalvara", sequenceName = "alvara_idalvara_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="alvara_idalvara")
	private Integer idalvara;

	@Temporal(TemporalType.DATE)
	private Date dataalvara;
	
	@Temporal(TemporalType.DATE)
	private Date datavencimento;
	
	private Integer qtimpresso;
	
	private String numprocesso;
	
	@ManyToOne
	@JoinColumn(name="idestabelecimento")
	@NotNull(message="Estabelecimento campo Obrigatorio !")
	private Estabelecimento estabelecimento;
	
	@NotNull(message="Tipo Alvara campo obrigatorio !")
	private Integer tipoalvara;
	
	private Integer statusalvara;

	public Alvara() {
	}

	public Integer getIdalvara() {
		return this.idalvara;
	}

	public void setIdalvara(Integer idalvara) {
		this.idalvara = idalvara;
	}

	public Date getDataalvara() {
		return this.dataalvara;
	}

	public void setDataalvara(Date dataalvara) {
		this.dataalvara = dataalvara;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Integer getTipoalvara() {
		return this.tipoalvara;
	}

	public void setTipoalvara(Integer tipoalvara) {
		this.tipoalvara = tipoalvara;
	}

	public Integer getStatusalvara() {
		return statusalvara;
	}

	public void setStatusalvara(Integer statusalvara) {
		this.statusalvara = statusalvara;
	}

	public Date getDatavencimento() {
		return datavencimento;
	}

	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}

	public Integer getQtimpresso() {
		return qtimpresso;
	}

	public void setQtimpresso(Integer qtimpresso) {
		this.qtimpresso = qtimpresso;
	}

	public String getNumprocesso() {
		return numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

}