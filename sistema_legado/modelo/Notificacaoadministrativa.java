package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the notificacaoadministrativa database table.
 * 
 */
@Entity
@NamedQuery(name="Notificacaoadministrativa.findAll", query="SELECT n FROM Notificacaoadministrativa n")
public class Notificacaoadministrativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacaoadministrativa_idnotivicacaoadministrativa", sequenceName = "notificacaoadministrativa_idnotivicacaoadministrativa_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacaoadministrativa_idnotivicacaoadministrativa")
	private Integer idnotificacaoadministrativa;

	@Temporal(TemporalType.DATE)
	private Date datanotificacaoadministrativa;

	private Time horanotificacaoadministrativa;

	private Integer liberarnotificacaoadministrativa;
	
	@NotNull(message="Número do Auto campo Obrigatorio !")
	private Integer numeroauto;
	
	@NotNull(message="Texto campo Obrigatorio !")
	private String textonotificacaoadministrativa;

	public Notificacaoadministrativa() {
	}

	public Integer getIdnotificacaoadministrativa() {
		return this.idnotificacaoadministrativa;
	}

	public void setIdnotificacaoadministrativa(Integer idnotificacaoadministrativa) {
		this.idnotificacaoadministrativa = idnotificacaoadministrativa;
	}

	public Date getDatanotificacaoadministrativa() {
		return this.datanotificacaoadministrativa;
	}

	public void setDatanotificacaoadministrativa(Date datanotificacaoadministrativa) {
		this.datanotificacaoadministrativa = datanotificacaoadministrativa;
	}

	public Time getHoranotificacaoadministrativa() {
		return this.horanotificacaoadministrativa;
	}

	public void setHoranotificacaoadministrativa(Time horanotificacaoadministrativa) {
		this.horanotificacaoadministrativa = horanotificacaoadministrativa;
	}

	public Integer getLiberarnotificacaoadministrativa() {
		return this.liberarnotificacaoadministrativa;
	}

	public void setLiberarnotificacaoadministrativa(Integer liberarnotificacaoadministrativa) {
		this.liberarnotificacaoadministrativa = liberarnotificacaoadministrativa;
	}

	public Integer getNumeroauto() {
		return this.numeroauto;
	}

	public void setNumeroauto(Integer numeroauto) {
		this.numeroauto = numeroauto;
	}

	public String getTextonotificacaoadministrativa() {
		return this.textonotificacaoadministrativa;
	}

	public void setTextonotificacaoadministrativa(String textonotificacaoadministrativa) {
		this.textonotificacaoadministrativa = textonotificacaoadministrativa;
	}

}