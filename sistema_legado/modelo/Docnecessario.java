package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

/**
 * The persistent class for the docnecessario database table.
 * 
 */
@Entity
@NamedQuery(name = "Docnecessario.findAll", query = "SELECT d FROM Docnecessario d ORDER BY d.agrupamento.subgrupo.grupo.idgrupo, d.agrupamento.subgrupo.idsubgrupo, d.agrupamento.idagrupamento")
public class Docnecessario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "docnecessario_iddocnecessario", sequenceName = "docnecessario_iddocnecessario_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "docnecessario_iddocnecessario")
	private Integer iddocnecessario;

	@ManyToOne
	@JoinColumn(name = "idagrupamento")
	@NotNull(message = "Agrupamento campo Obrigatorio !")
	private Agrupamento agrupamento;

	@ManyToOne
	@JoinColumn(name = "iditenssolicitacao")
	@NotNull(message = "Itens Solicitação campo Obrigatorio !")
	private Itenssolicitacao itenssolicitacao;

	// bi-directional many-to-one association to Documento
	@ManyToOne
	@JoinColumn(name = "iddocumento")
	private Documento documento;

	// bi-directional many-to-one association to Uploadnecessario
	@OneToMany(mappedBy = "docnecessario")
	private List<Uploadnecessario> uploadnecessarios;

	public Docnecessario() {
	}

	public Integer getIddocnecessario() {
		return this.iddocnecessario;
	}

	public void setIddocnecessario(Integer iddocnecessario) {
		this.iddocnecessario = iddocnecessario;
	}

	public Agrupamento getAgrupamento() {
		return agrupamento;
	}

	public void setAgrupamento(Agrupamento agrupamento) {
		this.agrupamento = agrupamento;
	}

	public Itenssolicitacao getItenssolicitacao() {
		return itenssolicitacao;
	}

	public void setItenssolicitacao(Itenssolicitacao itenssolicitacao) {
		this.itenssolicitacao = itenssolicitacao;
	}

	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public List<Uploadnecessario> getUploadnecessarios() {
		return this.uploadnecessarios;
	}

	public void setUploadnecessarios(List<Uploadnecessario> uploadnecessarios) {
		this.uploadnecessarios = uploadnecessarios;
	}

	public Uploadnecessario addUploadnecessario(Uploadnecessario uploadnecessario) {
		getUploadnecessarios().add(uploadnecessario);
		uploadnecessario.setDocnecessario(this);

		return uploadnecessario;
	}

	public Uploadnecessario removeUploadnecessario(Uploadnecessario uploadnecessario) {
		getUploadnecessarios().remove(uploadnecessario);
		uploadnecessario.setDocnecessario(null);

		return uploadnecessario;
	}

}