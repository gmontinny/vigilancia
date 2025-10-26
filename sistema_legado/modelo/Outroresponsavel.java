package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.com.caelum.stella.bean.validation.CPF;


/**
 * The persistent class for the outroresponsavel database table.
 * 
 */
@Entity
@NamedQuery(name="Outroresponsavel.findAll", query="SELECT o FROM Outroresponsavel o")
public class Outroresponsavel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="outroresponsavel_idoutrosresponsaveis", sequenceName = "outroresponsavel_idoutrosresponsaveis_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="outroresponsavel_idoutrosresponsaveis")
	private Integer idoutrosresponsaveis;

	@ManyToOne
	@JoinColumn(name="idconselho")
	@NotNull(message="Conselho campo Obrigatorio !")
	private Conselho conselho;

	@NotNull(message="Responsavel campo Obrigatorio !")
	private String nomeresponsavel;

	private Integer numeroestabelecimento;

	@NotNull(message="Setor campo Obrigatorio !")
	private String setorresponsavel;
	
	@NotNull(message="N° Conselho campo Obrigatorio !")
	private String numeroconselho;
	
	@NotNull(message="CPF campo Obrigatorio !")
	@CPF(message="CPF Invalido !")
	private String cpfresponsavel;
	
	private Integer statusbaixa;

	public Outroresponsavel() {
	}

	public Integer getIdoutrosresponsaveis() {
		return this.idoutrosresponsaveis;
	}

	public void setIdoutrosresponsaveis(Integer idoutrosresponsaveis) {
		this.idoutrosresponsaveis = idoutrosresponsaveis;
	}

	public Conselho getConselho() {
		return conselho;
	}

	public void setConselho(Conselho conselho) {
		this.conselho = conselho;
	}

	public String getNomeresponsavel() {
		return this.nomeresponsavel;
	}

	public void setNomeresponsavel(String nomeresponsavel) {
		this.nomeresponsavel = nomeresponsavel;
	}

	public Integer getNumeroestabelecimento() {
		return this.numeroestabelecimento;
	}

	public void setNumeroestabelecimento(Integer numeroestabelecimento) {
		this.numeroestabelecimento = numeroestabelecimento;
	}

	public String getSetorresponsavel() {
		return this.setorresponsavel;
	}

	public void setSetorresponsavel(String setorresponsavel) {
		this.setorresponsavel = setorresponsavel;
	}

	public String getNumeroconselho() {
		return numeroconselho;
	}

	public void setNumeroconselho(String numeroconselho) {
		this.numeroconselho = numeroconselho;
	}

	public String getCpfresponsavel() {
		return cpfresponsavel;
	}

	public void setCpfresponsavel(String cpfresponsavel) {
		this.cpfresponsavel = cpfresponsavel;
	}

	public Integer getStatusbaixa() {
		return statusbaixa;
	}

	public void setStatusbaixa(Integer statusbaixa) {
		this.statusbaixa = statusbaixa;
	}
	
	

}