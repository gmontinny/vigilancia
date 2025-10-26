package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the geradocumento database table.
 * 
 */
@Entity
@NamedQuery(name="Geradocumento.findAll", query="SELECT g FROM Geradocumento g")
public class Geradocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geradocumento_idgeradocumento", sequenceName = "geradocumento_idgeradocumento_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geradocumento_idgeradocumento")
	private Integer idgeradocumento;

	private Integer idusuario;

	private Integer status;

	public Geradocumento() {
	}

	public Integer getIdgeradocumento() {
		return this.idgeradocumento;
	}

	public void setIdgeradocumento(Integer idgeradocumento) {
		this.idgeradocumento = idgeradocumento;
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}