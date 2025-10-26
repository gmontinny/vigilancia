package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the localizacaoarquivo database table.
 * 
 */
@Entity
@NamedQuery(name="Localizacaoarquivo.findAll", query="SELECT l FROM Localizacaoarquivo l")
public class Localizacaoarquivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="localizacaoarquivo_idlocalizacaoarquivo", sequenceName = "localizacaoarquivo_idlocalizacaoarquivo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="localizacaoarquivo_idlocalizacaoarquivo")
	private Integer idlocalizacaoarquivo;
	
	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="numprocesso")
	@NotNull(message="Processo campo obrigatório !")
	private Processo processo;
	
	@NotNull(message="Tipo Localização campo obrigatório !")
	private Integer tipolocalizacao;
	
	@NotNull(message="Prateleira campo obrigatório !")
	private Integer prateleira;

	public Localizacaoarquivo() {
	}

	public Integer getIdlocalizacaoarquivo() {
		return this.idlocalizacaoarquivo;
	}

	public void setIdlocalizacaoarquivo(Integer idlocalizacaoarquivo) {
		this.idlocalizacaoarquivo = idlocalizacaoarquivo;
	}


	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Integer getTipolocalizacao() {
		return this.tipolocalizacao;
	}

	public void setTipolocalizacao(Integer tipolocalizacao) {
		this.tipolocalizacao = tipolocalizacao;
	}

	public Integer getPrateleira() {
		return prateleira;
	}

	public void setPrateleira(Integer prateleira) {
		this.prateleira = prateleira;
	}

}