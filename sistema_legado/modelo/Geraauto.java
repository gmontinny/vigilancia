package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the geraauto database table.
 * 
 */
@Entity
@NamedQuery(name="Geraauto.findAll", query="SELECT g FROM Geraauto g")
public class Geraauto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geraauto_idgeraauto", sequenceName = "geraauto_idgeraauto_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geraauto_idgeraauto")
	private Integer idgeraauto;

	@Temporal(TemporalType.DATE)
	private Date datageraauto;

	private Time horageraauto;
	
	private Integer idusuario;
	
	private Integer status;
	
	private String numprocesso;
	
	private String tipopenalidade;
	
	private String valor;
	
	private Integer grauinfracao;
	
	private Integer idtramitacao;

	public Geraauto() {
	}

	public Integer getIdgeraauto() {
		return this.idgeraauto;
	}

	public void setIdgeraauto(Integer idgeraauto) {
		this.idgeraauto = idgeraauto;
	}

	public Date getDatageraauto() {
		return this.datageraauto;
	}

	public void setDatageraauto(Date datageraauto) {
		this.datageraauto = datageraauto;
	}

	public Time getHorageraauto() {
		return this.horageraauto;
	}

	public void setHorageraauto(Time horageraauto) {
		this.horageraauto = horageraauto;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getNumprocesso() {
		return numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public String getTipopenalidade() {
		return tipopenalidade;
	}

	public void setTipopenalidade(String tipopenalidade) {
		this.tipopenalidade = tipopenalidade;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getGrauinfracao() {
		return grauinfracao;
	}

	public void setGrauinfracao(Integer grauinfracao) {
		this.grauinfracao = grauinfracao;
	}

	public Integer getIdtramitacao() {
		return idtramitacao;
	}

	public void setIdtramitacao(Integer idtramitacao) {
		this.idtramitacao = idtramitacao;
	}
	
	
}