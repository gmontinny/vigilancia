package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;


/**
 * The persistent class for the unidademedida database table.
 * 
 */
@Entity
@NamedQuery(name="Unidademedida.findAll", query="SELECT u FROM Unidademedida u ORDER BY u.siglaunidade")
public class Unidademedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="unidademedida_idunidademedida", sequenceName = "unidademedida_idunidademedida_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="unidademedida_idunidademedida")
	private Integer idunidademedida;
	
	@NotNull(message="Descrição campo obrigatorio !")
	private String descricaounidade;

	@NotNull(message="Sigla campo obrigatorio !")
	private String siglaunidade;

	//bi-directional many-to-one association to Apreensao
	@OneToMany(mappedBy="unidademedida")
	private List<Apreensao> apreensaos;

	public Unidademedida() {
	}

	public Integer getIdunidademedida() {
		return this.idunidademedida;
	}

	public void setIdunidademedida(Integer idunidademedida) {
		this.idunidademedida = idunidademedida;
	}

	public String getDescricaounidade() {
		return this.descricaounidade;
	}

	public void setDescricaounidade(String descricaounidade) {
		this.descricaounidade = descricaounidade;
	}

	public String getSiglaunidade() {
		return this.siglaunidade;
	}

	public void setSiglaunidade(String siglaunidade) {
		this.siglaunidade = siglaunidade;
	}

	public List<Apreensao> getApreensaos() {
		return this.apreensaos;
	}

	public void setApreensaos(List<Apreensao> apreensaos) {
		this.apreensaos = apreensaos;
	}

	public Apreensao addApreensao(Apreensao apreensao) {
		getApreensaos().add(apreensao);
		apreensao.setUnidademedida(this);

		return apreensao;
	}

	public Apreensao removeApreensao(Apreensao apreensao) {
		getApreensaos().remove(apreensao);
		apreensao.setUnidademedida(null);

		return apreensao;
	}

}