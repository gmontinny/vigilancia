package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;


/**
 * The persistent class for the produtocategoria database table.
 * 
 */
@Entity
@NamedQuery(name="Produtocategoria.findAll", query="SELECT p FROM Produtocategoria p ORDER BY p.nomeprodutocategoria")
public class Produtocategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="produtocategoria_idprodutocategoria", sequenceName = "produtocategoria_idprodutocategoria_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="produtocategoria_idprodutocategoria")
	private Integer idprodutocategoria;

	@NotNull(message="Nome campo obrigatorio !")
	private String nomeprodutocategoria;

	//bi-directional many-to-one association to Reclamacao
	@OneToMany(mappedBy="produtocategoria")
	private List<Reclamacao> reclamacaos;



	public Produtocategoria() {
	}

	public Integer getIdprodutocategoria() {
		return this.idprodutocategoria;
	}

	public void setIdprodutocategoria(Integer idprodutocategoria) {
		this.idprodutocategoria = idprodutocategoria;
	}

	public String getNomeprodutocategoria() {
		return this.nomeprodutocategoria;
	}

	public void setNomeprodutocategoria(String nomeprodutocategoria) {
		this.nomeprodutocategoria = nomeprodutocategoria;
	}

	public List<Reclamacao> getReclamacaos() {
		return this.reclamacaos;
	}

	public void setReclamacaos(List<Reclamacao> reclamacaos) {
		this.reclamacaos = reclamacaos;
	}

	public Reclamacao addReclamacao(Reclamacao reclamacao) {
		getReclamacaos().add(reclamacao);
		reclamacao.setProdutocategoria(this);

		return reclamacao;
	}

	public Reclamacao removeReclamacao(Reclamacao reclamacao) {
		getReclamacaos().remove(reclamacao);
		reclamacao.setProdutocategoria(null);

		return reclamacao;
	}



}