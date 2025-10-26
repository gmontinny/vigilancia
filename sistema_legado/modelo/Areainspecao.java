package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the areainspecao database table.
 * 
 */
@Entity
@NamedQuery(name="Areainspecao.findAll", query="SELECT a FROM Areainspecao a")
public class Areainspecao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idareainspecao;

	private String nomeareainspecao;

	public Areainspecao() {
	}

	public Integer getIdareainspecao() {
		return this.idareainspecao;
	}

	public void setIdareainspecao(Integer idareainspecao) {
		this.idareainspecao = idareainspecao;
	}

	public String getNomeareainspecao() {
		return this.nomeareainspecao;
	}

	public void setNomeareainspecao(String nomeareainspecao) {
		this.nomeareainspecao = nomeareainspecao;
	}


}