package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the galeria database table.
 * 
 */
@Entity
@NamedQuery(name="Galeria.findAll", query="SELECT g FROM Galeria g")
public class Galeria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="galeria_idgaleria", sequenceName = "galeria_idgaleria_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="galeria_idgaleria")
	private Integer idgaleria;
	
	@NotNull(message="Capa campo Obrigatorio !")
	private String capagaleria;

	@Temporal(TemporalType.DATE)
	private Date datagaleria;

	private Time horagaleria;

	private Integer seguenciagaleria;
	
	@NotNull(message="Titulo campo Obrigatorio !")
	private String titulogaleria;

	public Galeria() {
	}

	public Integer getIdgaleria() {
		return this.idgaleria;
	}

	public void setIdgaleria(Integer idgaleria) {
		this.idgaleria = idgaleria;
	}

	public String getCapagaleria() {
		return this.capagaleria;
	}

	public void setCapagaleria(String capagaleria) {
		this.capagaleria = capagaleria;
	}

	public Date getDatagaleria() {
		return this.datagaleria;
	}

	public void setDatagaleria(Date datagaleria) {
		this.datagaleria = datagaleria;
	}

	public Time getHoragaleria() {
		return this.horagaleria;
	}

	public void setHoragaleria(Time horagaleria) {
		this.horagaleria = horagaleria;
	}

	public Integer getSeguenciagaleria() {
		return this.seguenciagaleria;
	}

	public void setSeguenciagaleria(Integer seguenciagaleria) {
		this.seguenciagaleria = seguenciagaleria;
	}

	public String getTitulogaleria() {
		return this.titulogaleria;
	}

	public void setTitulogaleria(String titulogaleria) {
		this.titulogaleria = titulogaleria;
	}

}