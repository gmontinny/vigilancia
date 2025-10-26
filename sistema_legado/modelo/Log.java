package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the logs database table.
 * 
 */
@Entity
@Table(name="logs")
@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="logs_idlogs", sequenceName = "logs_idlogs_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="logs_idlogs")
	private Integer idlogs;

	@Temporal(TemporalType.DATE)
	private Date datalog;

	private Time horalog;

	private Integer idusuario;

	public Log() {
	}

	public Integer getIdlogs() {
		return this.idlogs;
	}

	public void setIdlogs(Integer idlogs) {
		this.idlogs = idlogs;
	}

	public Date getDatalog() {
		return this.datalog;
	}

	public void setDatalog(Date datalog) {
		this.datalog = datalog;
	}

	public Time getHoralog() {
		return this.horalog;
	}

	public void setHoralog(Time horalog) {
		this.horalog = horalog;
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

}