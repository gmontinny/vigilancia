package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the arquitetonicos database table.
 * 
 */
@Entity
@Table(name="arquitetonicos")
@NamedQuery(name="Arquitetonico.findAll", query="SELECT a FROM Arquitetonico a")
public class Arquitetonico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="arquitetonicos_idarquitetonicos", sequenceName = "arquitetonicos_idarquitetonicos_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="arquitetonicos_idarquitetonicos")
	private Integer idarquitetonicos;


	@Temporal(TemporalType.DATE)
	private Date dataanalisearquitetonicos;
	
	@NotNull(message="Situação do projeto arquitetônico campo obrigatorio !")
	private Integer situacaoarquitetonicos;
	
	@NotNull(message="Numero Tramitação campo Obrigatorio !")
	private Integer numerotramitacao;
	
	
	private Integer analisearquitetonico;
	
	@NotNull(message="Texto campo obrigatorio !")
	private String textoarquitetonico;
	


	public Arquitetonico() {
	}

	public Integer getIdarquitetonicos() {
		return this.idarquitetonicos;
	}

	public void setIdarquitetonicos(Integer idarquitetonicos) {
		this.idarquitetonicos = idarquitetonicos;
	}


	public Date getDataanalisearquitetonicos() {
		return this.dataanalisearquitetonicos;
	}

	public void setDataanalisearquitetonicos(Date dataanalisearquitetonicos) {
		this.dataanalisearquitetonicos = dataanalisearquitetonicos;
	}

	public Integer getSituacaoarquitetonicos() {
		return this.situacaoarquitetonicos;
	}

	public void setSituacaoarquitetonicos(Integer situacaoarquitetonicos) {
		this.situacaoarquitetonicos = situacaoarquitetonicos;
	}

	public Integer getNumerotramitacao() {
		return numerotramitacao;
	}

	public void setNumerotramitacao(Integer numerotramitacao) {
		this.numerotramitacao = numerotramitacao;
	}

	public Integer getAnalisearquitetonico() {
		return analisearquitetonico;
	}

	public void setAnalisearquitetonico(Integer analisearquitetonico) {
		this.analisearquitetonico = analisearquitetonico;
	}

	public String getTextoarquitetonico() {
		return textoarquitetonico;
	}

	public void setTextoarquitetonico(String textoarquitetonico) {
		this.textoarquitetonico = textoarquitetonico;
	}


	
	

}