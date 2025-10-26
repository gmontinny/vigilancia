package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.caelum.stella.bean.validation.CPF;


/**
 * The persistent class for the entregador database table.
 * 
 */
@Entity
@NamedQuery(name="Entregador.findAll", query="SELECT e FROM Entregador e")
public class Entregador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="entregador_identregador", sequenceName = "entregador_identregador_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="entregador_identregador")
	private Integer identregador;

	private String celentregador;
	
	@NotNull(message="CPF campo obrigatorio !")
	@CPF(message="CPF invalido !")
	private String cpfentregador;

	private String emailentregador;
	
	@NotNull(message="Nome campo obrigatorio !")
	@Size(min=3, message="Digite pelo menos 3 caracteres !")
	private String nomeentregador;
	
	@NotNull(message="Processo campo obrigatorio !")
	private String numprocesso;
	
	private String imagementregador;

	private String telentregador;

	public Entregador() {
	}

	public Integer getIdentregador() {
		return this.identregador;
	}

	public void setIdentregador(Integer identregador) {
		this.identregador = identregador;
	}

	public String getCelentregador() {
		return this.celentregador;
	}

	public void setCelentregador(String celentregador) {
		this.celentregador = celentregador;
	}

	public String getCpfentregador() {
		return this.cpfentregador;
	}

	public void setCpfentregador(String cpfentregador) {
		this.cpfentregador = cpfentregador;
	}

	public String getEmailentregador() {
		return this.emailentregador;
	}

	public void setEmailentregador(String emailentregador) {
		this.emailentregador = emailentregador;
	}

	public String getNomeentregador() {
		return this.nomeentregador;
	}

	public void setNomeentregador(String nomeentregador) {
		this.nomeentregador = nomeentregador;
	}

	public String getNumprocesso() {
		return this.numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public String getTelentregador() {
		return this.telentregador;
	}

	public void setTelentregador(String telentregador) {
		this.telentregador = telentregador;
	}

	public String getImagementregador() {
		return imagementregador;
	}

	public void setImagementregador(String imagementregador) {
		this.imagementregador = imagementregador;
	}

}