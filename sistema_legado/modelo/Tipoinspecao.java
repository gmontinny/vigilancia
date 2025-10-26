package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the tipoinspecao database table.
 * 
 */
@Entity
@NamedQuery(name="Tipoinspecao.findAll", query="SELECT t FROM Tipoinspecao t ORDER BY t.descricaotipoinspecao")
public class Tipoinspecao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tipoinspecao_idtipoinspecao", sequenceName = "tipoinspecao_idtipoinspecao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="tipoinspecao_idtipoinspecao")
	private Integer idtipoinspecao;
	
	@NotNull(message="Descrição campo obrigatorio !")
	private String descricaotipoinspecao;
	
	private Integer analiseprocesso;
	
	private Integer autoinfracao;
	
	private Integer notificacao;
	
	private Integer colheita;
	
	private Integer arquitetonico;
	
	private Integer administrativo;

	public Tipoinspecao() {
	}

	public Integer getIdtipoinspecao() {
		return this.idtipoinspecao;
	}

	public void setIdtipoinspecao(Integer idtipoinspecao) {
		this.idtipoinspecao = idtipoinspecao;
	}

	public String getDescricaotipoinspecao() {
		return this.descricaotipoinspecao;
	}

	public void setDescricaotipoinspecao(String descricaotipoinspecao) {
		this.descricaotipoinspecao = descricaotipoinspecao;
	}

	public Integer getAnaliseprocesso() {
		return analiseprocesso;
	}

	public void setAnaliseprocesso(Integer analiseprocesso) {
		this.analiseprocesso = analiseprocesso;
	}

	public Integer getAutoinfracao() {
		return autoinfracao;
	}

	public void setAutoinfracao(Integer autoinfracao) {
		this.autoinfracao = autoinfracao;
	}

	public Integer getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(Integer notificacao) {
		this.notificacao = notificacao;
	}

	public Integer getColheita() {
		return colheita;
	}

	public void setColheita(Integer colheita) {
		this.colheita = colheita;
	}

	public Integer getArquitetonico() {
		return arquitetonico;
	}

	public void setArquitetonico(Integer arquitetonico) {
		this.arquitetonico = arquitetonico;
	}

	public Integer getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(Integer administrativo) {
		this.administrativo = administrativo;
	}


}