package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the notificacaosegundainstancia database table.
 * 
 */
@Entity
@NamedQuery(name="Notificacaosegundainstancia.findAll", query="SELECT n FROM Notificacaosegundainstancia n ORDER BY n.idsegundainstancia DESC")
public class Notificacaosegundainstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacaosegundainstancia_idsegundainstancia", sequenceName = "notificacaosegundainstancia_idsegundainstancia_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacaosegundainstancia_idsegundainstancia")
	private Integer idsegundainstancia;
	
	@NotNull(message="Assinatura campo Obrigatorio !")
	private String assinatura;
	
	@NotNull(message="Coordenador(a) campo Obrigatorio !")
	private String coordenador;

	@NotNull(message="Texto campo Obrigatorio !")
	private String texto;
	
	private String tipo;

	public Notificacaosegundainstancia() {
	}

	public Integer getIdsegundainstancia() {
		return this.idsegundainstancia;
	}

	public void setIdsegundainstancia(Integer idsegundainstancia) {
		this.idsegundainstancia = idsegundainstancia;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}