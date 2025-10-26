package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the termonotificacao database table.
 * 
 */
@Entity
@NamedQuery(name="Termonotificacao.findAll", query="SELECT t FROM Termonotificacao t")
public class Termonotificacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="termonotificacao_idtermonotificacao", sequenceName = "termonotificacao_idtermonotificacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="termonotificacao_idtermonotificacao")
	private Integer idtermonotificacao;

	@Temporal(TemporalType.DATE)
	private Date datanotificacao;

	private Time horanotificacao;
	
	@ManyToOne
	@JoinColumn(name="idestabelecimento")
	private Estabelecimento estabelecimento;

	private Integer numerotramitacao;

	private String textonotificacao;
	
	private Integer diasnotificacao;

	public Termonotificacao() {
	}

	public Integer getIdtermonotificacao() {
		return this.idtermonotificacao;
	}

	public void setIdtermonotificacao(Integer idtermonotificacao) {
		this.idtermonotificacao = idtermonotificacao;
	}

	public Date getDatanotificacao() {
		return this.datanotificacao;
	}

	public void setDatanotificacao(Date datanotificacao) {
		this.datanotificacao = datanotificacao;
	}

	public Time getHoranotificacao() {
		return this.horanotificacao;
	}

	public void setHoranotificacao(Time horanotificacao) {
		this.horanotificacao = horanotificacao;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Integer getNumerotramitacao() {
		return this.numerotramitacao;
	}

	public void setNumerotramitacao(Integer numerotramitacao) {
		this.numerotramitacao = numerotramitacao;
	}

	public String getTextonotificacao() {
		return this.textonotificacao;
	}

	public void setTextonotificacao(String textonotificacao) {
		this.textonotificacao = textonotificacao;
	}

	public Integer getDiasnotificacao() {
		return diasnotificacao;
	}

	public void setDiasnotificacao(Integer diasnotificacao) {
		this.diasnotificacao = diasnotificacao;
	}

}