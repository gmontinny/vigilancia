package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the empresainfracoes database table.
 * 
 */
@Entity
@Table(name="empresainfracoes")
@NamedQuery(name="Empresainfracoe.findAll", query="SELECT e FROM Empresainfracoe e")
public class Empresainfracoe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="empresainfracoes_idempresainfracoes", sequenceName = "empresainfracoes_idempresainfracoes_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="empresainfracoes_idempresainfracoes")
	private Integer idempresainfracoes;

	@NotNull(message="TIPO EMPRESA campo Obrogatório!")
	private Integer tipoempresa;

	@NotNull(message="TIPO INFRAÇÕES campo Obrogatório!")
	private Integer tipoinfracoes;

	@NotNull(message="VALOR campo Obrogatório!")
	private double valor;

	public Empresainfracoe() {
	}

	public Integer getIdempresainfracoes() {
		return this.idempresainfracoes;
	}

	public void setIdempresainfracoes(Integer idempresainfracoes) {
		this.idempresainfracoes = idempresainfracoes;
	}

	public Integer getTipoempresa() {
		return this.tipoempresa;
	}

	public void setTipoempresa(Integer tipoempresa) {
		this.tipoempresa = tipoempresa;
	}

	public Integer getTipoinfracoes() {
		return this.tipoinfracoes;
	}

	public void setTipoinfracoes(Integer tipoinfracoes) {
		this.tipoinfracoes = tipoinfracoes;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}