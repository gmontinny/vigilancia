package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;


/**
 * The persistent class for the documento database table.
 * 
 */
@Entity
@NamedQuery(name="Documento.findAll", query="SELECT d FROM Documento d ORDER BY d.descricaodocumento, d.restricaodocumento")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="documento_iddocumento", sequenceName = "documento_iddocumento_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="documento_iddocumento")
	private Integer iddocumento;
	
	@NotNull(message="Descrição campo obrigatorio !")
	private String descricaodocumento;
	
	@NotNull(message="Restrição Documento campo obrigatorio !")
	private Integer restricaodocumento;

	//bi-directional many-to-one association to Docnecessario
	@OneToMany(mappedBy="documento")
	private List<Docnecessario> docnecessarios;

	public Documento() {
	}

	public Integer getIddocumento() {
		return this.iddocumento;
	}

	public void setIddocumento(Integer iddocumento) {
		this.iddocumento = iddocumento;
	}

	public String getDescricaodocumento() {
		return this.descricaodocumento;
	}

	public void setDescricaodocumento(String descricaodocumento) {
		this.descricaodocumento = descricaodocumento;
	}

	public Integer getRestricaodocumento() {
		return this.restricaodocumento;
	}

	public void setRestricaodocumento(Integer restricaodocumento) {
		this.restricaodocumento = restricaodocumento;
	}

	public List<Docnecessario> getDocnecessarios() {
		return this.docnecessarios;
	}

	public void setDocnecessarios(List<Docnecessario> docnecessarios) {
		this.docnecessarios = docnecessarios;
	}

	public Docnecessario addDocnecessario(Docnecessario docnecessario) {
		getDocnecessarios().add(docnecessario);
		docnecessario.setDocumento(this);

		return docnecessario;
	}

	public Docnecessario removeDocnecessario(Docnecessario docnecessario) {
		getDocnecessarios().remove(docnecessario);
		docnecessario.setDocumento(null);

		return docnecessario;
	}

}