package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the acao database table.
 * 
 */
@Entity
@NamedQuery(name="Acao.findAll", query="SELECT a FROM Acao a ORDER BY a.nomeacao")
public class Acao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="acao_idacao", sequenceName = "acao_idacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="acao_idacao")
	private Integer idacao;
	
	@NotNull(message="Nome Campo Obrigatorio !")
	@Size(min=5, message="Digite pelo menos 5 caracteres !")
	private String nomeacao;

	//bi-directional many-to-one association to Ordemservico
	@OneToMany(mappedBy="acao")
	private List<Ordemservico> ordemservicos;

	public Acao() {
	}

	public Integer getIdacao() {
		return this.idacao;
	}

	public void setIdacao(Integer idacao) {
		this.idacao = idacao;
	}

	public String getNomeacao() {
		return this.nomeacao;
	}

	public void setNomeacao(String nomeacao) {
		this.nomeacao = nomeacao;
	}

	public List<Ordemservico> getOrdemservicos() {
		return this.ordemservicos;
	}

	public void setOrdemservicos(List<Ordemservico> ordemservicos) {
		this.ordemservicos = ordemservicos;
	}

	public Ordemservico addOrdemservico(Ordemservico ordemservico) {
		getOrdemservicos().add(ordemservico);
		ordemservico.setAcao(this);

		return ordemservico;
	}

	public Ordemservico removeOrdemservico(Ordemservico ordemservico) {
		getOrdemservicos().remove(ordemservico);
		ordemservico.setAcao(null);

		return ordemservico;
	}

}