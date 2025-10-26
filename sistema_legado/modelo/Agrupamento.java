package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the agrupamento database table.
 * 
 */
@Entity
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

	public Agrupamento() {
	}

	public Integer getIdagrupamento() {
		return this.idagrupamento;
	}

	public void setIdagrupamento(Integer idagrupamento) {
		this.idagrupamento = idagrupamento;
	}

	public String getNomeagrupamento() {
		return this.nomeagrupamento;
	}

	public void setNomeagrupamento(String nomeagrupamento) {
		this.nomeagrupamento = nomeagrupamento;
	}

	public Subgrupo getSubgrupo() {
		return this.subgrupo;
	}

	public void setSubgrupo(Subgrupo subgrupo) {
		this.subgrupo = subgrupo;
	}

	public List<Licenciamento> getLicenciamentos() {
		return this.licenciamentos;
	}

	public void setLicenciamentos(List<Licenciamento> licenciamentos) {
		this.licenciamentos = licenciamentos;
	}

	public Licenciamento addLicenciamento(Licenciamento licenciamento) {
		getLicenciamentos().add(licenciamento);
		licenciamento.setAgrupamento(this);

		return licenciamento;
	}

	public Licenciamento removeLicenciamento(Licenciamento licenciamento) {
		getLicenciamentos().remove(licenciamento);
		licenciamento.setAgrupamento(null);

		return licenciamento;
	}

}