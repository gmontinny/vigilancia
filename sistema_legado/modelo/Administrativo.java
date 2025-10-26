package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the administrativo database table.
 * 
 */
@Entity
@NamedQuery(name="Administrativo.findAll", query="SELECT a FROM Administrativo a")
public class Administrativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="administrativo_idadministrativo", sequenceName = "administrativo_idadministrativo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="administrativo_idadministrativo")
	private Integer idadministrativo;
	
	@NotNull(message="Assinatura do(a) Coordenador(a) é obrigatorio !")
	private String assinaturacoordenadoria;
	
	@NotNull(message="Assinatura do(a) Diretor(a) é obrigatorio !")
	private String assinaturadiretoria;
	
	@NotNull(message="Nome do(a) Coordenador(a) é obrigatorio !")
	private String coordenadoria;
	
	@NotNull(message="Nome do(a) Diretor(a) é obrigatorio !")
	private String diretoria;
	
	private String urlqrcode;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataadministrativo;

	public Administrativo() {
	}

	public Integer getIdadministrativo() {
		return this.idadministrativo;
	}

	public void setIdadministrativo(Integer idadministrativo) {
		this.idadministrativo = idadministrativo;
	}

	public String getAssinaturacoordenadoria() {
		return this.assinaturacoordenadoria;
	}

	public void setAssinaturacoordenadoria(String assinaturacoordenadoria) {
		this.assinaturacoordenadoria = assinaturacoordenadoria;
	}

	public String getAssinaturadiretoria() {
		return this.assinaturadiretoria;
	}

	public void setAssinaturadiretoria(String assinaturadiretoria) {
		this.assinaturadiretoria = assinaturadiretoria;
	}

	public String getCoordenadoria() {
		return this.coordenadoria;
	}

	public void setCoordenadoria(String coordenadoria) {
		this.coordenadoria = coordenadoria;
	}

	public String getDiretoria() {
		return this.diretoria;
	}

	public void setDiretoria(String diretoria) {
		this.diretoria = diretoria;
	}

	public Date getDataadministrativo() {
		return dataadministrativo;
	}

	public void setDataadministrativo(Date dataadministrativo) {
		this.dataadministrativo = dataadministrativo;
	}

	public String getUrlqrcode() {
		return urlqrcode;
	}

	public void setUrlqrcode(String urlqrcode) {
		this.urlqrcode = urlqrcode;
	}
	
	

}