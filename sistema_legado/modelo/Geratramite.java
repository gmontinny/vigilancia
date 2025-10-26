package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the geratramite database table.
 * 
 */
@Entity
@NamedQuery(name="Geratramite.findAll", query="SELECT g FROM Geratramite g")
public class Geratramite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geratramite_idgeratramite", sequenceName = "geratramite_idgeratramite_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geratramite_idgeratramite")
	private Integer idgeratramite;

	@Temporal(TemporalType.DATE)
	private Date dtgeratramite;

	private Time hrgeratramite;

	public Geratramite() {
	}

	public Integer getIdgeratramite() {
		return this.idgeratramite;
	}

	public void setIdgeratramite(Integer idgeratramite) {
		this.idgeratramite = idgeratramite;
	}

	public Date getDtgeratramite() {
		return this.dtgeratramite;
	}

	public void setDtgeratramite(Date dtgeratramite) {
		this.dtgeratramite = dtgeratramite;
	}

	public Time getHrgeratramite() {
		return this.hrgeratramite;
	}

	public void setHrgeratramite(Time hrgeratramite) {
		this.hrgeratramite = hrgeratramite;
	}

}