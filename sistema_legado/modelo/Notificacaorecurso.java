package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the notificacaorecurso database table.
 * 
 */
@Entity
@NamedQuery(name="Notificacaorecurso.findAll", query="SELECT n FROM Notificacaorecurso n")
public class Notificacaorecurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacaorecurso_idnotificacaorecurso", sequenceName = "notificacaorecurso_idnotificacaorecurso_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacaorecurso_idnotificacaorecurso")
	private Integer idnotificacaorecurso;
	
	private String assinaturacoordenador;

	@NotNull(message="Coordenador(a) campo Obrigatorio !")
	private String coordenadorarecursonotificacao;

	@NotNull(message="Texto campo Obrigatorio !")
	private String textonotificacaorecurso;

	public Notificacaorecurso() {
	}

	public Integer getIdnotificacaorecurso() {
		return this.idnotificacaorecurso;
	}

	public void setIdnotificacaorecurso(Integer idnotificacaorecurso) {
		this.idnotificacaorecurso = idnotificacaorecurso;
	}

	public String getAssinaturacoordenador() {
		return this.assinaturacoordenador;
	}

	public void setAssinaturacoordenador(String assinaturacoordenador) {
		this.assinaturacoordenador = assinaturacoordenador;
	}

	public String getCoordenadorarecursonotificacao() {
		return this.coordenadorarecursonotificacao;
	}

	public void setCoordenadorarecursonotificacao(String coordenadorarecursonotificacao) {
		this.coordenadorarecursonotificacao = coordenadorarecursonotificacao;
	}

	public String getTextonotificacaorecurso() {
		return this.textonotificacaorecurso;
	}

	public void setTextonotificacaorecurso(String textonotificacaorecurso) {
		this.textonotificacaorecurso = textonotificacaorecurso;
	}

}