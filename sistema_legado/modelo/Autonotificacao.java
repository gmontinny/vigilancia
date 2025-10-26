package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the autonotificacao database table.
 * 
 */
@Entity
@NamedQuery(name="Autonotificacao.findAll", query="SELECT a FROM Autonotificacao a")
public class Autonotificacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idautonotificacao;

	private String descricaonotificacao;

	@ManyToOne
	@JoinColumn(name="idtramitacao")
	private Tramitacao tramitacao;

	private Integer prazo;

	public Autonotificacao() {
	}

	public Integer getIdautonotificacao() {
		return this.idautonotificacao;
	}

	public void setIdautonotificacao(Integer idautonotificacao) {
		this.idautonotificacao = idautonotificacao;
	}

	public String getDescricaonotificacao() {
		return this.descricaonotificacao;
	}

	public void setDescricaonotificacao(String descricaonotificacao) {
		this.descricaonotificacao = descricaonotificacao;
	}


	public Tramitacao getTramitacao() {
		return tramitacao;
	}

	public void setTramitacao(Tramitacao tramitacao) {
		this.tramitacao = tramitacao;
	}

	public Integer getPrazo() {
		return this.prazo;
	}

	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}

}