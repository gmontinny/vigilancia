package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the resposta database table.
 * 
 */
@Entity
@NamedQuery(name="Resposta.findAll", query="SELECT r FROM Resposta r")
public class Resposta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="resposta_idresposta", sequenceName = "resposta_idresposta_seq")
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="resposta_idresposta")
	private Integer idresposta;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtresposta;

	@ManyToOne
	@JoinColumn(name="idforum")
	@NotNull(message="Forum Campo Obrigatorio!")
	private Forum forum;

	private String textoresposta;

	public Resposta() {
	}

	public Integer getIdresposta() {
		return this.idresposta;
	}

	public void setIdresposta(Integer idresposta) {
		this.idresposta = idresposta;
	}

	public Date getDtresposta() {
		return this.dtresposta;
	}

	public void setDtresposta(Date dtresposta) {
		this.dtresposta = dtresposta;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public String getTextoresposta() {
		return this.textoresposta;
	}

	public void setTextoresposta(String textoresposta) {
		this.textoresposta = textoresposta;
	}

}