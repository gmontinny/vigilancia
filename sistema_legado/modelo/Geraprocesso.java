package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the geraprocesso database table.
 * 
 */
@Entity
@NamedQuery(name="Geraprocesso.findAll", query="SELECT g FROM Geraprocesso g")
public class Geraprocesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geraprocesso_idprocesso", sequenceName = "geraprocesso_idprocesso_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geraprocesso_idprocesso")
	private Integer idprocesso;

	@Temporal(TemporalType.DATE)
	private Date dataprocesso;

	private Time horaprocesso;

	private Integer idusuario;

	private Integer statusprocesso;

	public Geraprocesso() {
	}

	public Integer getIdprocesso() {
		return this.idprocesso;
	}

	public void setIdprocesso(Integer idprocesso) {
		this.idprocesso = idprocesso;
	}

	public Date getDataprocesso() {
		return this.dataprocesso;
	}

	public void setDataprocesso(Date dataprocesso) {
		this.dataprocesso = dataprocesso;
	}

	public Time getHoraprocesso() {
		return this.horaprocesso;
	}

	public void setHoraprocesso(Time horaprocesso) {
		this.horaprocesso = horaprocesso;
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getStatusprocesso() {
		return this.statusprocesso;
	}

	public void setStatusprocesso(Integer statusprocesso) {
		this.statusprocesso = statusprocesso;
	}

}