package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;


/**
 * The persistent class for the tecnicoprojeto database table.
 * 
 */
@Entity
@NamedQuery(name="Tecnicoprojeto.findAll", query="SELECT t FROM Tecnicoprojeto t ORDER BY t.nometecnicoprojeto")
public class Tecnicoprojeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tecnicoprojeto_idtecnicoprojeto", sequenceName = "tecnicoprojeto_idtecnicoprojeto_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="tecnicoprojeto_idtecnicoprojeto")
	private Integer idtecnicoprojeto;

	private String celulartecnicoprojeto;

	@NotNull(message="Email campo obrigatorio !")
	@Email(message="Email invalido !")
	private String emailtecnicoprojeto;

	//bi-directional many-to-one association to Conselho
	@ManyToOne
	@JoinColumn(name="idconselho")
	@NotNull(message="Conselho campo obrigatorio !")
	private Conselho conselho;
	
	@NotNull(message="Nome Técnico campo obrigatorio !")
	private String nometecnicoprojeto;
	
	private String numprocesso;
	
	@NotNull(message="CPF campo obrigatorio !")
	private String cpftecnicoprojeto;

	private String numeroconselho;

	public Tecnicoprojeto() {
	}

	public Integer getIdtecnicoprojeto() {
		return this.idtecnicoprojeto;
	}

	public void setIdtecnicoprojeto(Integer idtecnicoprojeto) {
		this.idtecnicoprojeto = idtecnicoprojeto;
	}

	public String getCelulartecnicoprojeto() {
		return this.celulartecnicoprojeto;
	}

	public void setCelulartecnicoprojeto(String celulartecnicoprojeto) {
		this.celulartecnicoprojeto = celulartecnicoprojeto;
	}

	public String getEmailtecnicoprojeto() {
		return this.emailtecnicoprojeto;
	}

	public void setEmailtecnicoprojeto(String emailtecnicoprojeto) {
		this.emailtecnicoprojeto = emailtecnicoprojeto;
	}

	public Conselho getConselho() {
		return conselho;
	}

	public void setConselho(Conselho conselho) {
		this.conselho = conselho;
	}

	public String getNometecnicoprojeto() {
		return this.nometecnicoprojeto;
	}

	public void setNometecnicoprojeto(String nometecnicoprojeto) {
		this.nometecnicoprojeto = nometecnicoprojeto;
	}

	public String getNumeroconselho() {
		return this.numeroconselho;
	}

	public void setNumeroconselho(String numeroconselho) {
		this.numeroconselho = numeroconselho;
	}

	public String getNumprocesso() {
		return numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public String getCpftecnicoprojeto() {
		return cpftecnicoprojeto;
	}

	public void setCpftecnicoprojeto(String cpftecnicoprojeto) {
		this.cpftecnicoprojeto = cpftecnicoprojeto;
	}
	
	

}