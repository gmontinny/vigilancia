package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the itensembalagem database table.
 * 
 */
@Entity
@NamedQuery(name="Itensembalagem.findAll", query="SELECT i FROM Itensembalagem i")
public class Itensembalagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensembalagem_iditensembalagem", sequenceName = "itensembalagem_iditensembalagem_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensembalagem_iditensembalagem")
	private Integer iditensembalagem;

	@ManyToOne
	@JoinColumn(name="idembalagem")
	private Embalagem embalagem;
	
	@ManyToOne
	@JoinColumn(name="idestabelecimento")
	private Estabelecimento estabelecimento;

	private Integer numeroprodi;
	
	private Integer numeroitensprodi;
	

	public Itensembalagem() {
	}

	public Integer getIditensembalagem() {
		return this.iditensembalagem;
	}

	public void setIditensembalagem(Integer iditensembalagem) {
		this.iditensembalagem = iditensembalagem;
	}

	public Embalagem getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(Embalagem embalagem) {
		this.embalagem = embalagem;
	}

	public Integer getNumeroprodi() {
		return this.numeroprodi;
	}

	public void setNumeroprodi(Integer numeroprodi) {
		this.numeroprodi = numeroprodi;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Integer getNumeroitensprodi() {
		return numeroitensprodi;
	}

	public void setNumeroitensprodi(Integer numeroitensprodi) {
		this.numeroitensprodi = numeroitensprodi;
	}
	
	
	
}