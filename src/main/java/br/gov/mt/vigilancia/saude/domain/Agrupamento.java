package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the agrupamento database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Agrupamento.findAll", query="SELECT a FROM Agrupamento a")
public class Agrupamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="agrupamento_idagrupamento", sequenceName = "agrupamento_idagrupamento_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="agrupamento_idagrupamento")
	private Integer idagrupamento;
	
	@NotNull(message="Nome campo Obrigatorio!")
	@Size(min=5, message="Digite pelo menos 5 caracteres!")
	private String nomeagrupamento;

	//bi-directional many-to-one association to Subgrupo
	@ManyToOne
	@JoinColumn(name="idsubgrupo")
	private Subgrupo subgrupo;

	//bi-directional many-to-one association to Licenciamento
	@OneToMany(mappedBy="agrupamento")
	private List<Licenciamento> licenciamentos;

	public Licenciamento addLicenciamento(Licenciamento licenciamento) {
		this.licenciamentos.add(licenciamento);
		licenciamento.setAgrupamento(this);

		return licenciamento;
	}

	public Licenciamento removeLicenciamento(Licenciamento licenciamento) {
		this.licenciamentos.remove(licenciamento);
		licenciamento.setAgrupamento(null);

		return licenciamento;
	}

}