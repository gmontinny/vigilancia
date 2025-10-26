package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the itensautoinfracao database table.
 * 
 */
@Entity
@NamedQuery(name="Itensautoinfracao.findAll", query="SELECT i FROM Itensautoinfracao i")
public class Itensautoinfracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensautoinfracao_iditensautoinfracao", sequenceName = "itensautoinfracao_iditensautoinfracao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensautoinfracao_iditensautoinfracao")
	private Integer iditensautoinfracao;

	private Integer numeroauto;
	
	private String valoritens;
	
	private String textoitens;
	
	private String tiporisco;

	private Integer idlegislacao;

	public Itensautoinfracao() {
	}

	public Integer getIditensautoinfracao() {
		return this.iditensautoinfracao;
	}

	public void setIditensautoinfracao(Integer iditensautoinfracao) {
		this.iditensautoinfracao = iditensautoinfracao;
	}

	public Integer getNumeroauto() {
		return this.numeroauto;
	}

	public void setNumeroauto(Integer numeroauto) {
		this.numeroauto = numeroauto;
	}

	public Integer getIdlegislacao() {
		return idlegislacao;
	}

	public void setIdlegislacao(Integer idlegislacao) {
		this.idlegislacao = idlegislacao;
	}

	public String getValoritens() {
		return valoritens;
	}

	public void setValoritens(String valoritens) {
		this.valoritens = valoritens;
	}

	public String getTextoitens() {
		return textoitens;
	}

	public void setTextoitens(String textoitens) {
		this.textoitens = textoitens;
	}

	public String getTiporisco() {
		return tiporisco;
	}

	public void setTiporisco(String tiporisco) {
		this.tiporisco = tiporisco;
	}
	
	

}