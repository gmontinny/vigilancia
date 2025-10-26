package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipoempresa database table.
 * 
 */
@Entity
@NamedQuery(name="Tipoempresa.findAll", query="SELECT t FROM Tipoempresa t ORDER BY t.descricaotipoempresa")
public class Tipoempresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tipoempresa_idtipoempresa", sequenceName = "tipoempresa_idtipoempresa_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="tipoempresa_idtipoempresa")
	private Integer idtipoempresa;

	private String descricaotipoempresa;

	private String siglatipoempresa;

	public Tipoempresa() {
	}

	public Integer getIdtipoempresa() {
		return this.idtipoempresa;
	}

	public void setIdtipoempresa(Integer idtipoempresa) {
		this.idtipoempresa = idtipoempresa;
	}

	public String getDescricaotipoempresa() {
		return this.descricaotipoempresa;
	}

	public void setDescricaotipoempresa(String descricaotipoempresa) {
		this.descricaotipoempresa = descricaotipoempresa;
	}

	public String getSiglatipoempresa() {
		return this.siglatipoempresa;
	}

	public void setSiglatipoempresa(String siglatipoempresa) {
		this.siglatipoempresa = siglatipoempresa;
	}

}