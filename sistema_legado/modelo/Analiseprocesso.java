package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the analiseprocesso database table.
 * 
 */
@Entity
@NamedQuery(name="Analiseprocesso.findAll", query="SELECT a FROM Analiseprocesso a")
public class Analiseprocesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idanaliseprocesso;

	private String autorizacaoanaliseprocesso;

	private Integer statusanaliseprocesso;

	private String textoanaliseprocesso;

	//bi-directional many-to-one association to Processo
	@ManyToOne
	@JoinColumn(name="numprocesso")
	private Processo processo;

	public Analiseprocesso() {
	}

	public Integer getIdanaliseprocesso() {
		return this.idanaliseprocesso;
	}

	public void setIdanaliseprocesso(Integer idanaliseprocesso) {
		this.idanaliseprocesso = idanaliseprocesso;
	}

	public String getAutorizacaoanaliseprocesso() {
		return this.autorizacaoanaliseprocesso;
	}

	public void setAutorizacaoanaliseprocesso(String autorizacaoanaliseprocesso) {
		this.autorizacaoanaliseprocesso = autorizacaoanaliseprocesso;
	}

	public Integer getStatusanaliseprocesso() {
		return this.statusanaliseprocesso;
	}

	public void setStatusanaliseprocesso(Integer statusanaliseprocesso) {
		this.statusanaliseprocesso = statusanaliseprocesso;
	}

	public String getTextoanaliseprocesso() {
		return this.textoanaliseprocesso;
	}

	public void setTextoanaliseprocesso(String textoanaliseprocesso) {
		this.textoanaliseprocesso = textoanaliseprocesso;
	}

	public Processo getProcesso() {
		return this.processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

}