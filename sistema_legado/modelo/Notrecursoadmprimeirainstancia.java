package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the notrecursoadmprimeirainstancia database table.
 * 
 */
@Entity
@NamedQuery(name="Notrecursoadmprimeirainstancia.findAll", query="SELECT n FROM Notrecursoadmprimeirainstancia n ORDER BY n.idnotrecursoadmprimeirainstancia DESC")
public class Notrecursoadmprimeirainstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notrecursoadmprimeirainstanci_idnotrecursoadmprimeirainstan", sequenceName = "notrecursoadmprimeirainstanci_idnotrecursoadmprimeirainstan_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notrecursoadmprimeirainstanci_idnotrecursoadmprimeirainstan")
	private Integer idnotrecursoadmprimeirainstancia;
	
	@NotNull(message="Assinatura campo Obrigatorio !")
	private String assinatura;

	@NotNull(message="Coordenador campo Obrigatorio !")
	private String coordenador;

	@Temporal(TemporalType.DATE)
	private Date datarecursoadministrativo;

	private Time horarecursoadministrativo;

	@NotNull(message="Texto campo Obrigatorio !")
	private String textorecursoadministrativo;

	public Notrecursoadmprimeirainstancia() {
	}

	public Integer getIdnotrecursoadmprimeirainstancia() {
		return this.idnotrecursoadmprimeirainstancia;
	}

	public void setIdnotrecursoadmprimeirainstancia(Integer idnotrecursoadmprimeirainstancia) {
		this.idnotrecursoadmprimeirainstancia = idnotrecursoadmprimeirainstancia;
	}

	public String getAssinatura() {
		return this.assinatura;
	}

	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
	}

	public String getCoordenador() {
		return this.coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

	public Date getDatarecursoadministrativo() {
		return this.datarecursoadministrativo;
	}

	public void setDatarecursoadministrativo(Date datarecursoadministrativo) {
		this.datarecursoadministrativo = datarecursoadministrativo;
	}

	public Time getHorarecursoadministrativo() {
		return this.horarecursoadministrativo;
	}

	public void setHorarecursoadministrativo(Time horarecursoadministrativo) {
		this.horarecursoadministrativo = horarecursoadministrativo;
	}

	public String getTextorecursoadministrativo() {
		return this.textorecursoadministrativo;
	}

	public void setTextorecursoadministrativo(String textorecursoadministrativo) {
		this.textorecursoadministrativo = textorecursoadministrativo;
	}

}