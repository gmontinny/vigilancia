package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the notificacaoprimeirainstancia database table.
 * 
 */
@Entity
@NamedQuery(name="Notificacaoprimeirainstancia.findAll", query="SELECT n FROM Notificacaoprimeirainstancia n ORDER BY n.idprimeirainstancia DESC")
public class Notificacaoprimeirainstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacaoprimeirainstancia_idprimeirainstancia", sequenceName = "notificacaoprimeirainstancia_idprimeirainstancia_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacaoprimeirainstancia_idprimeirainstancia")
	private Integer idprimeirainstancia;
	
	@NotNull(message="Assinatura campo Obrigatorio !")
	private String assinatura;

	@NotNull(message="Coordenador(a) campo Obrigatorio !")
	private String coordenador;
	
	@NotNull(message="Texto campo Obrigatorio !")
	private String texto;

	public Notificacaoprimeirainstancia() {
	}

	public Integer getIdprimeirainstancia() {
		return this.idprimeirainstancia;
	}

	public void setIdprimeirainstancia(Integer idprimeirainstancia) {
		this.idprimeirainstancia = idprimeirainstancia;
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

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}