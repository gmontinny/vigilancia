package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;


/**
 * The persistent class for the legislacao database table.
 * 
 */
@Entity
@NamedQuery(name="Legislacao.findAll", query="SELECT l FROM Legislacao l")
public class Legislacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="legislacao_idlegislcao", sequenceName = "legislacao_idlegislacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="legislacao_idlegislcao")
	private Integer idlegislacao;

	@NotNull(message="Artigo campo obrigatorio !")
	private String artigolegislacao;
	
	@NotNull(message="Descrição campo obrigatorio !")
	private String descricaolegislacao;

	private String incisolegislacao;
	
	private Integer decretolegislacao;

	@NotNull(message="Lei campo obrigatorio !")
	private String leilegislacao;
	
	private String paragrafolegislacao;

	private String valorlegislacao;
	
	private String riscolegislacao;


	public Legislacao() {
	}

	public Integer getIdlegislacao() {
		return this.idlegislacao;
	}

	public void setIdlegislacao(Integer idlegislacao) {
		this.idlegislacao = idlegislacao;
	}

	public String getArtigolegislacao() {
		return this.artigolegislacao;
	}

	public void setArtigolegislacao(String artigolegislacao) {
		this.artigolegislacao = artigolegislacao;
	}

	public Integer getDecretolegislacao() {
		return this.decretolegislacao;
	}

	public void setDecretolegislacao(Integer decretolegislacao) {
		this.decretolegislacao = decretolegislacao;
	}

	public String getDescricaolegislacao() {
		return this.descricaolegislacao;
	}

	public void setDescricaolegislacao(String descricaolegislacao) {
		this.descricaolegislacao = descricaolegislacao;
	}

	public String getIncisolegislacao() {
		return this.incisolegislacao;
	}

	public void setIncisolegislacao(String incisolegislacao) {
		this.incisolegislacao = incisolegislacao;
	}

	public String getLeilegislacao() {
		return this.leilegislacao;
	}

	public void setLeilegislacao(String leilegislacao) {
		this.leilegislacao = leilegislacao;
	}

	public String getParagrafolegislacao() {
		return this.paragrafolegislacao;
	}

	public void setParagrafolegislacao(String paragrafolegislacao) {
		this.paragrafolegislacao = paragrafolegislacao;
	}

	public String getValorlegislacao() {
		return this.valorlegislacao;
	}

	public void setValorlegislacao(String valorlegislacao) {
		this.valorlegislacao = valorlegislacao;
	}


	public String getRiscolegislacao() {
		return riscolegislacao;
	}

	public void setRiscolegislacao(String riscolegislacao) {
		this.riscolegislacao = riscolegislacao;
	}
	
	

}