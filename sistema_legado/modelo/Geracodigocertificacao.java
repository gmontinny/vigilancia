package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the geracodigocertificacao database table.
 * 
 */
@Entity
@NamedQuery(name="Geracodigocertificacao.findAll", query="SELECT g FROM Geracodigocertificacao g")
public class Geracodigocertificacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geracodigocertificacao_idcodigocertificacao", sequenceName = "geracodigocertificacao_idcodigocertificacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geracodigocertificacao_idcodigocertificacao")
	private Integer idcodigocertificacao;

	@Temporal(TemporalType.DATE)
	private Date datacertificacao;

	private Time horacertificacao;
	
	private String chavecertificacao;

	public Geracodigocertificacao() {
	}

	public Integer getIdcodigocertificacao() {
		return this.idcodigocertificacao;
	}

	public void setIdcodigocertificacao(Integer idcodigocertificacao) {
		this.idcodigocertificacao = idcodigocertificacao;
	}

	public Date getDatacertificacao() {
		return this.datacertificacao;
	}

	public void setDatacertificacao(Date datacertificacao) {
		this.datacertificacao = datacertificacao;
	}

	public Time getHoracertificacao() {
		return this.horacertificacao;
	}

	public void setHoracertificacao(Time horacertificacao) {
		this.horacertificacao = horacertificacao;
	}

	public String getChavecertificacao() {
		return chavecertificacao;
	}

	public void setChavecertificacao(String chavecertificacao) {
		this.chavecertificacao = chavecertificacao;
	}
	
	

}