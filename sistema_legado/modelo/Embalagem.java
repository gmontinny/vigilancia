package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;


/**
 * The persistent class for the embalagem database table.
 * 
 */
@Entity
@NamedQuery(name="Embalagem.findAll", query="SELECT e FROM Embalagem e")
public class Embalagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="embalagem_idembalagem", sequenceName = "embalagem_idembalagem_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="embalagem_idembalagem")
	private Integer idembalagem;

	@NotNull(message="Descrição da Embalagem campo Obrigatorio !")
	private String descricaoembalagem;


	public Embalagem() {
	}

	public Integer getIdembalagem() {
		return this.idembalagem;
	}

	public void setIdembalagem(Integer idembalagem) {
		this.idembalagem = idembalagem;
	}

	public String getDescricaoembalagem() {
		return this.descricaoembalagem;
	}

	public void setDescricaoembalagem(String descricaoembalagem) {
		this.descricaoembalagem = descricaoembalagem;
	}


}