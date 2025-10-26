package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.caelum.stella.bean.validation.CPF;

import java.util.List;


/**
 * The persistent class for the responsaveltecnico database table.
 * 
 */
@Entity
@NamedQuery(name="Responsaveltecnico.findAll", query="SELECT r FROM Responsaveltecnico r")
public class Responsaveltecnico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="responsaveltecnico_idresponsavel", sequenceName = "responsaveltecnico_idresponsavel_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="responsaveltecnico_idresponsavel")
	private Integer idresponsavel;
	
	@NotNull(message = "CPF campo obrigatorio !")
	@CPF(message="CPF invalido !")
	private String cpfresponsavel;
	
	@NotNull(message="Nome do Técnico campo obrigatorio !")
	@Size(min=5,message="Digite pelo menos 5 Caracteres !")
	private String nometecnico;
	
	@NotNull(message="Numero campo obrigatorio !")
	//@Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Campo valido somente para número.")
	private String numeroresponsavel;
	
	private String numprocesso;

	//bi-directional many-to-one association to Conselho
	@ManyToOne
	@JoinColumn(name="idconselho")
	@NotNull(message="Conselho campo obrigatorio !")
	private Conselho conselho;

	public Responsaveltecnico() {
	}

	public Integer getIdresponsavel() {
		return this.idresponsavel;
	}

	public void setIdresponsavel(Integer idresponsavel) {
		this.idresponsavel = idresponsavel;
	}

	public String getCpfresponsavel() {
		return this.cpfresponsavel;
	}

	public void setCpfresponsavel(String cpfresponsavel) {
		this.cpfresponsavel = cpfresponsavel;
	}

	public String getNometecnico() {
		return this.nometecnico;
	}

	public void setNometecnico(String nometecnico) {
		this.nometecnico = nometecnico;
	}

	public String getNumeroresponsavel() {
		return this.numeroresponsavel;
	}

	public void setNumeroresponsavel(String numeroresponsavel) {
		this.numeroresponsavel = numeroresponsavel;
	}

	public Conselho getConselho() {
		return this.conselho;
	}

	public void setConselho(Conselho conselho) {
		this.conselho = conselho;
	}

	public String getNumprocesso() {
		return numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}
	
	

}