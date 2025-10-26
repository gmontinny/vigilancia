package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the geraitensprodi database table.
 * 
 */
@Entity
@NamedQuery(name="Geraitensprodi.findAll", query="SELECT g FROM Geraitensprodi g")
public class Geraitensprodi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geraitensprodi_idgeraitensprodi", sequenceName = "geraitensprodi_idgeraitensprodi_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geraitensprodi_idgeraitensprodi")
	private Integer idgeraitensprodi;

	@Temporal(TemporalType.DATE)
	private Date dataitensprodi;

	private Time horaitensprodi;

	private Integer idusuario;

	private Integer statusitensprodi;

	public Geraitensprodi() {
	}

	public Integer getIdgeraitensprodi() {
		return this.idgeraitensprodi;
	}

	public void setIdgeraitensprodi(Integer idgeraitensprodi) {
		this.idgeraitensprodi = idgeraitensprodi;
	}

	public Date getDataitensprodi() {
		return this.dataitensprodi;
	}

	public void setDataitensprodi(Date dataitensprodi) {
		this.dataitensprodi = dataitensprodi;
	}

	public Time getHoraitensprodi() {
		return this.horaitensprodi;
	}

	public void setHoraitensprodi(Time horaitensprodi) {
		this.horaitensprodi = horaitensprodi;
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getStatusitensprodi() {
		return this.statusitensprodi;
	}

	public void setStatusitensprodi(Integer statusitensprodi) {
		this.statusitensprodi = statusitensprodi;
	}

}