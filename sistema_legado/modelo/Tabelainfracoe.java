package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the tabelainfracoes database table.
 * 
 */
@Entity
@Table(name="tabelainfracoes")
@NamedQuery(name="Tabelainfracoe.findAll", query="SELECT t FROM Tabelainfracoe t ORDER BY t.tipograuinfracao")
public class Tabelainfracoe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tabelainfracoes_idtabelainfracoes", sequenceName = "tabelainfracoes_idtabelainfracoes_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="tabelainfracoes_idtabelainfracoes")
	private Integer idtabelainfracoes;

	@NotNull(message="CONFORMIDADE campo Obrigatório!")
	private String conformidade;

	@NotNull(message="TIPO RISCO campo Obrigatório!")
	private Integer tiporisco;

	private Integer tipograuinfracao;
		
	@NotNull(message="VALOR CONFORMIDADE campo Obrigatório!")
	private double valorconformidade;
	
	private Integer ordeminfracoes;

	public Tabelainfracoe() {
	}

	public Integer getIdtabelainfracoes() {
		return this.idtabelainfracoes;
	}

	public void setIdtabelainfracoes(Integer idtabelainfracoes) {
		this.idtabelainfracoes = idtabelainfracoes;
	}

	public String getConformidade() {
		return this.conformidade;
	}

	public void setConformidade(String conformidade) {
		this.conformidade = conformidade;
	}

	public Integer getTiporisco() {
		return this.tiporisco;
	}

	public void setTiporisco(Integer tiporisco) {
		this.tiporisco = tiporisco;
	}

	public double getValorconformidade() {
		return this.valorconformidade;
	}

	public void setValorconformidade(double valorconformidade) {
		this.valorconformidade = valorconformidade;
	}

	public Integer getTipograuinfracao() {
		return tipograuinfracao;
	}

	public void setTipograuinfracao(Integer tipograuinfracao) {
		this.tipograuinfracao = tipograuinfracao;
	}

	public Integer getOrdeminfracoes() {
		return ordeminfracoes;
	}

	public void setOrdeminfracoes(Integer ordeminfracoes) {
		this.ordeminfracoes = ordeminfracoes;
	}
	
	

}