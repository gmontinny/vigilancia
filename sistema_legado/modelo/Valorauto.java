package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the valorauto database table.
 * 
 */
@Entity
@NamedQuery(name="Valorauto.findAll", query="SELECT v FROM Valorauto v ORDER BY v.valor")
public class Valorauto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="valorauto_idvalorauto", sequenceName = "valorauto_idvalorauto_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="valorauto_idvalorauto")
	private Integer idvalorauto;
	
	@NotNull(message="GRAU campo Obrigatório!")
	private Integer grauinfracao;

	@NotNull(message="VALOR campo Obrigatório!")
	private String valor;
	
	@NotNull(message="VALOR MINIMO campo Obrigatório!")
	private String valorminimo;

	public Valorauto() {
	}

	public Integer getIdvalorauto() {
		return this.idvalorauto;
	}

	public void setIdvalorauto(Integer idvalorauto) {
		this.idvalorauto = idvalorauto;
	}

	public Integer getGrauinfracao() {
		return this.grauinfracao;
	}

	public void setGrauinfracao(Integer grauinfracao) {
		this.grauinfracao = grauinfracao;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValorminimo() {
		return valorminimo;
	}

	public void setValorminimo(String valorminimo) {
		this.valorminimo = valorminimo;
	}
	
	

}