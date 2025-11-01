package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The persistent class for the docnecessario database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Docnecessario.findAll", query = "SELECT d FROM Docnecessario d ORDER BY d.agrupamento.subgrupo.grupo.id, d.agrupamento.subgrupo.id, d.agrupamento.idagrupamento")
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

	public Uploadnecessario addUploadnecessario(Uploadnecessario uploadnecessario) {
		this.uploadnecessarios.add(uploadnecessario);
		uploadnecessario.setDocnecessario(this);

		return uploadnecessario;
	}

	public Uploadnecessario removeUploadnecessario(Uploadnecessario uploadnecessario) {
		this.uploadnecessarios.remove(uploadnecessario);
		uploadnecessario.setDocnecessario(null);

		return uploadnecessario;
	}

}