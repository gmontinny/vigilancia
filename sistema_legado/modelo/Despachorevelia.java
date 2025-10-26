package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the despachorevelia database table.
 * 
 */
@Entity
@NamedQuery(name="Despachorevelia.findAll", query="SELECT d FROM Despachorevelia d ORDER BY d.iddespachorevelia DESC")
public class Despachorevelia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="despachorevelia_iddespachorevelia", sequenceName = "despachorevelia_iddespachorevelia_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="despachorevelia_iddespachorevelia")
	private Integer iddespachorevelia;
	
	@NotNull(message="Secretario(a) campo Obrigatorio !")
	private String secretariodespachorevelia;
	
	@NotNull(message="Texto campo Obrigatorio !")
	private String textodespachorevelia;

	public Despachorevelia() {
	}

	public Integer getIddespachorevelia() {
		return this.iddespachorevelia;
	}

	public void setIddespachorevelia(Integer iddespachorevelia) {
		this.iddespachorevelia = iddespachorevelia;
	}

	public String getSecretariodespachorevelia() {
		return this.secretariodespachorevelia;
	}

	public void setSecretariodespachorevelia(String secretariodespachorevelia) {
		this.secretariodespachorevelia = secretariodespachorevelia;
	}

	public String getTextodespachorevelia() {
		return this.textodespachorevelia;
	}

	public void setTextodespachorevelia(String textodespachorevelia) {
		this.textodespachorevelia = textodespachorevelia;
	}

}