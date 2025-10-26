package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the notificacaorecursoadministrativo database table.
 * 
 */
@Entity
@NamedQuery(name="Notificacaorecursoadministrativo.findAll", query="SELECT n FROM Notificacaorecursoadministrativo n ORDER BY n.idrecursoadministrativo DESC")
public class Notificacaorecursoadministrativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacaorecursoadministrativo_idrecursoadministrativo", sequenceName = "notificacaorecursoadministrativo_idrecursoadministrativo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacaorecursoadministrativo_idrecursoadministrativo")
	private Integer idrecursoadministrativo;

	@Temporal(TemporalType.DATE)
	private Date datarecursoadministrativo;

	private Time horarecursoadministrativo;

	private String textorecursoadministrativo;
	
	private String coordenador;
	
	private String assinatura;

	public Notificacaorecursoadministrativo() {
	}

	public Integer getIdrecursoadministrativo() {
		return this.idrecursoadministrativo;
	}

	public void setIdrecursoadministrativo(Integer idrecursoadministrativo) {
		this.idrecursoadministrativo = idrecursoadministrativo;
	}

	public Date getDatarecursoadministrativo() {
		return this.datarecursoadministrativo;
	}

	public void setDatarecursoadministrativo(Date datarecursoadministrativo) {
		this.datarecursoadministrativo = datarecursoadministrativo;
	}

	public Time getHorarecursoadministrativo() {
		return horarecursoadministrativo;
	}

	public void setHorarecursoadministrativo(Time horarecursoadministrativo) {
		this.horarecursoadministrativo = horarecursoadministrativo;
	}

	public String getTextorecursoadministrativo() {
		return textorecursoadministrativo;
	}

	public void setTextorecursoadministrativo(String textorecursoadministrativo) {
		this.textorecursoadministrativo = textorecursoadministrativo;
	}

	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

	public String getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
	}

	

}