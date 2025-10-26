package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the geraatividade database table.
 * 
 */
@Entity
@NamedQuery(name="Geraatividade.findAll", query="SELECT g FROM Geraatividade g")
public class Geraatividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geraatividade_idgeraatividade", sequenceName = "geraatividade_idgeraatividade_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geraatividade_idgeraatividade")
	private Integer idgeraatividade;

	@Temporal(TemporalType.DATE)
	private Date dataatividade;

	private Time horaatividade;

	private Integer idusuario;

	private Integer statusgeraatividade;

	public Geraatividade() {
	}

	public Integer getIdgeraatividade() {
		return this.idgeraatividade;
	}

	public void setIdgeraatividade(Integer idgeraatividade) {
		this.idgeraatividade = idgeraatividade;
	}

	public Date getDataatividade() {
		return this.dataatividade;
	}

	public void setDataatividade(Date dataatividade) {
		this.dataatividade = dataatividade;
	}

	public Time getHoraatividade() {
		return this.horaatividade;
	}

	public void setHoraatividade(Time horaatividade) {
		this.horaatividade = horaatividade;
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getStatusgeraatividade() {
		return this.statusgeraatividade;
	}

	public void setStatusgeraatividade(Integer statusgeraatividade) {
		this.statusgeraatividade = statusgeraatividade;
	}

}