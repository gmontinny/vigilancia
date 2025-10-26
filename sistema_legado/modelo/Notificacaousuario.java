package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the notificacaousuario database table.
 * 
 */
@Entity
@NamedQuery(name="Notificacaousuario.findAll", query="SELECT n FROM Notificacaousuario n")
public class Notificacaousuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacaousuario_idnotificacaousuario", sequenceName = "notificacaousuario_idnotificacaousuario_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacaousuario_idnotificacaousuario")
	private Integer idnotificacaousuario;

	private Integer idusuario;

	private Integer numerodocumento;

	public Notificacaousuario() {
	}

	public Integer getIdnotificacaousuario() {
		return this.idnotificacaousuario;
	}

	public void setIdnotificacaousuario(Integer idnotificacaousuario) {
		this.idnotificacaousuario = idnotificacaousuario;
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getNumerodocumento() {
		return this.numerodocumento;
	}

	public void setNumerodocumento(Integer numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

}