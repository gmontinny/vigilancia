package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the geraprodi database table.
 * 
 */
@Entity
@NamedQuery(name="Geraprodi.findAll", query="SELECT g FROM Geraprodi g")
public class Geraprodi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geraprodi_idgeraprodi", sequenceName = "geraprodi_idgeraprodi_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geraprodi_idgeraprodi")
	private Integer idgeraprodi;

	@Temporal(TemporalType.DATE)
	private Date dataprodi;

	private Time horaprodi;

	private Integer idusuario;
	
	private Integer statusprodi;

	public Geraprodi() {
	}

	public Integer getIdgeraprodi() {
		return this.idgeraprodi;
	}

	public void setIdgeraprodi(Integer idgeraprodi) {
		this.idgeraprodi = idgeraprodi;
	}

	public Date getDataprodi() {
		return this.dataprodi;
	}

	public void setDataprodi(Date dataprodi) {
		this.dataprodi = dataprodi;
	}

	public Time getHoraprodi() {
		return this.horaprodi;
	}

	public void setHoraprodi(Time horaprodi) {
		this.horaprodi = horaprodi;
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getStatusprodi() {
		return statusprodi;
	}

	public void setStatusprodi(Integer statusprodi) {
		this.statusprodi = statusprodi;
	}

	
	
}