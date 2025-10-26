package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the bpa database table.
 * 
 */
@Entity
@NamedQuery(name="Bpa.findAll", query="SELECT b FROM Bpa b ORDER BY b.descricaobpa")
public class Bpa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="bpa_idbpa", sequenceName = "bpa_idbpa_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="bpa_idbpa")
	private Integer idbpa;
	
	@NotNull(message="Descrição BPA campo Obrigatorio !")
	private String descricaobpa;

	public Bpa() {
	}

	public Integer getIdbpa() {
		return this.idbpa;
	}

	public void setIdbpa(Integer idbpa) {
		this.idbpa = idbpa;
	}

	public String getDescricaobpa() {
		return this.descricaobpa;
	}

	public void setDescricaobpa(String descricaobpa) {
		this.descricaobpa = descricaobpa;
	}

}