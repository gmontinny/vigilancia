package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the geraroteiro database table.
 * 
 */
@Entity
@NamedQuery(name="Geraroteiro.findAll", query="SELECT g FROM Geraroteiro g")
public class Geraroteiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geraroteiro_idgeraroteiro", sequenceName = "geraroteiro_idgeraroteiro_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geraroteiro_idgeraroteiro")
	private Integer idgeraroteiro;

	@Temporal(TemporalType.DATE)
	private Date datageraroteiro;

	private Time horageraroteiro;
	
	private Integer statusroteiro;
	
	private Integer idusuario;

	public Geraroteiro() {
	}

	public Integer getIdgeraroteiro() {
		return this.idgeraroteiro;
	}

	public void setIdgeraroteiro(Integer idgeraroteiro) {
		this.idgeraroteiro = idgeraroteiro;
	}

	public Date getDatageraroteiro() {
		return this.datageraroteiro;
	}

	public void setDatageraroteiro(Date datageraroteiro) {
		this.datageraroteiro = datageraroteiro;
	}

	public Time getHorageraroteiro() {
		return this.horageraroteiro;
	}

	public void setHorageraroteiro(Time horageraroteiro) {
		this.horageraroteiro = horageraroteiro;
	}

	public Integer getStatusroteiro() {
		return statusroteiro;
	}

	public void setStatusroteiro(Integer statusroteiro) {
		this.statusroteiro = statusroteiro;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	
	

}