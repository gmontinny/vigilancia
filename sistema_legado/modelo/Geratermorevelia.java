package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the geratermorevelia database table.
 * 
 */
@Entity
@NamedQuery(name="Geratermorevelia.findAll", query="SELECT g FROM Geratermorevelia g")
public class Geratermorevelia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geratermorevelia_idtermorevelia", sequenceName = "geratermorevelia_idtermorevelia_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geratermorevelia_idtermorevelia")
	private Integer idtermorevelia;

	@Temporal(TemporalType.DATE)
	private Date datarevelia;

	private Time horarevelia;

	private Integer numeroauto;

	public Geratermorevelia() {
	}

	public Integer getIdtermorevelia() {
		return this.idtermorevelia;
	}

	public void setIdtermorevelia(Integer idtermorevelia) {
		this.idtermorevelia = idtermorevelia;
	}

	public Date getDatarevelia() {
		return this.datarevelia;
	}

	public void setDatarevelia(Date datarevelia) {
		this.datarevelia = datarevelia;
	}

	public Time getHorarevelia() {
		return this.horarevelia;
	}

	public void setHorarevelia(Time horarevelia) {
		this.horarevelia = horarevelia;
	}

	public Integer getNumeroauto() {
		return this.numeroauto;
	}

	public void setNumeroauto(Integer numeroauto) {
		this.numeroauto = numeroauto;
	}

}