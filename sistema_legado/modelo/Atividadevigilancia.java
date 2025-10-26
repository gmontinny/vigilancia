package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atividadevigilancia database table.
 * 
 */
@Entity
@NamedQuery(name="Atividadevigilancia.findAll", query="SELECT a FROM Atividadevigilancia a")
public class Atividadevigilancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="atividadevigilancia_idatividade", sequenceName = "atividadevigilancia_idatividade_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="atividadevigilancia_idatividade")
	private Integer idatividade;

	@ManyToOne
	@JoinColumn(name="idlicenciamento")
	private Licenciamento licenciamento;	
	
	private Integer liberacao;
	
	private Integer numeroatividade;

	public Atividadevigilancia() {
	}

	public Integer getIdatividade() {
		return this.idatividade;
	}

	public void setIdatividade(Integer idatividade) {
		this.idatividade = idatividade;
	}


	public Licenciamento getLicenciamento() {
		return licenciamento;
	}

	public void setLicenciamento(Licenciamento licenciamento) {
		this.licenciamento = licenciamento;
	}

	public Integer getNumeroatividade() {
		return numeroatividade;
	}

	public void setNumeroatividade(Integer numeroatividade) {
		this.numeroatividade = numeroatividade;
	}

	public Integer getLiberacao() {
		return liberacao;
	}

	public void setLiberacao(Integer liberacao) {
		this.liberacao = liberacao;
	}
	
	

}