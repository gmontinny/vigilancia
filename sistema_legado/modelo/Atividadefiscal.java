package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atividadefiscal database table.
 * 
 */
@Entity
@NamedQuery(name="Atividadefiscal.findAll", query="SELECT a FROM Atividadefiscal a")
public class Atividadefiscal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idatividadefiscal;

	private Integer idlicenciamento;

	private String numprocesso;

	public Atividadefiscal() {
	}

	public Integer getIdatividadefiscal() {
		return this.idatividadefiscal;
	}

	public void setIdatividadefiscal(Integer idatividadefiscal) {
		this.idatividadefiscal = idatividadefiscal;
	}

	public Integer getIdlicenciamento() {
		return this.idlicenciamento;
	}

	public void setIdlicenciamento(Integer idlicenciamento) {
		this.idlicenciamento = idlicenciamento;
	}

	public String getNumprocesso() {
		return this.numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

}