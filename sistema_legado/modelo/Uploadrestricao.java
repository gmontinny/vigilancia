package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;




/**
 * The persistent class for the uploadrestricao database table.
 * 
 */
@Entity
@NamedQuery(name="Uploadrestricao.findAll", query="SELECT u FROM Uploadrestricao u")
public class Uploadrestricao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="uploadrestricao_iduploadrestricao", sequenceName = "uploadrestricao_iduploadrestricao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="uploadrestricao_iduploadrestricao")
	private Integer iduploadrestricao;

	@NotNull(message = "ITENSSOLICITAÇÃO campo Obrigatório !")
	private Integer iditenssolicitacao;

	@NotNull(message = "TOTAL DOCUMENTO campo Obrigatório !")
	private Integer totaldocumentos;
	
	private String descricao;

	public Uploadrestricao() {
	}

	public Integer getIduploadrestricao() {
		return this.iduploadrestricao;
	}

	public void setIduploadrestricao(Integer iduploadrestricao) {
		this.iduploadrestricao = iduploadrestricao;
	}

	public Integer getIditenssolicitacao() {
		return this.iditenssolicitacao;
	}

	public void setIditenssolicitacao(Integer iditenssolicitacao) {
		this.iditenssolicitacao = iditenssolicitacao;
	}

	public Integer getTotaldocumentos() {
		return this.totaldocumentos;
	}

	public void setTotaldocumentos(Integer totaldocumentos) {
		this.totaldocumentos = totaldocumentos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}