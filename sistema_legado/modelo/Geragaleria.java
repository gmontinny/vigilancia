package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the geragaleria database table.
 * 
 */
@Entity
@NamedQuery(name="Geragaleria.findAll", query="SELECT g FROM Geragaleria g")
public class Geragaleria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geragaleria_idgeragaleria", sequenceName = "geragaleria_idgeragaleria_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geragaleria_idgeragaleria")
	private Integer idgeragaleria;

	@Temporal(TemporalType.DATE)
	private Date datageragaleria;

	private Time horageragaleria;
	
	private Integer idusuario;
	
	private Integer statusgeragaleria;

	public Geragaleria() {
	}

	public Integer getIdgeragaleria() {
		return this.idgeragaleria;
	}

	public void setIdgeragaleria(Integer idgeragaleria) {
		this.idgeragaleria = idgeragaleria;
	}

	public Date getDatageragaleria() {
		return this.datageragaleria;
	}

	public void setDatageragaleria(Date datageragaleria) {
		this.datageragaleria = datageragaleria;
	}

	public Time getHorageragaleria() {
		return this.horageragaleria;
	}

	public void setHorageragaleria(Time horageragaleria) {
		this.horageragaleria = horageragaleria;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getStatusgeragaleria() {
		return statusgeragaleria;
	}

	public void setStatusgeragaleria(Integer statusgeragaleria) {
		this.statusgeragaleria = statusgeragaleria;
	}
	
	

}