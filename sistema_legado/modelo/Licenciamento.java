package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * The persistent class for the licenciamento database table.
 * 
 */
@Entity
@NamedQuery(name="Licenciamento.findAll", query="SELECT l FROM Licenciamento l JOIN l.agrupamento a JOIN a.subgrupo s JOIN s.grupo g ORDER BY g.idgrupo, s.idsubgrupo, a.idagrupamento, l.idlicenciamento")
public class Licenciamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="licenciamento_idlicenciamento", sequenceName = "licenciamento_idlicenciamento_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="licenciamento_idlicenciamento")
	private Integer idlicenciamento;
	
	@NotNull(message="Descrição campo obrigatorio !")
	@Size(min=5, message="Digite pelo menos 5 caracteres !")
	private String descricaolicenciamento;
	
	@NotNull(message="Orientação campo obrigatorio !")
	@Size(min=5, message="Digite pelo menos 5 caracteres !")
	private String orientacaolicenciamento;

	@NotNull(message="Risco campo obrigatorio !")
	private Integer riscolicenciamento;

	//bi-directional many-to-one association to Agrupamento
	@ManyToOne
	@JoinColumn(name="idagrupamento")
	private Agrupamento agrupamento;

	public Licenciamento() {
	}

	public Integer getIdlicenciamento() {
		return this.idlicenciamento;
	}

	public void setIdlicenciamento(Integer idlicenciamento) {
		this.idlicenciamento = idlicenciamento;
	}

	public String getDescricaolicenciamento() {
		return this.descricaolicenciamento;
	}

	public void setDescricaolicenciamento(String descricaolicenciamento) {
		this.descricaolicenciamento = descricaolicenciamento;
	}

	public String getOrientacaolicenciamento() {
		return this.orientacaolicenciamento;
	}

	public void setOrientacaolicenciamento(String orientacaolicenciamento) {
		this.orientacaolicenciamento = orientacaolicenciamento;
	}

	public Integer getRiscolicenciamento() {
		return this.riscolicenciamento;
	}

	public void setRiscolicenciamento(Integer riscolicenciamento) {
		this.riscolicenciamento = riscolicenciamento;
	}

	public Agrupamento getAgrupamento() {
		return this.agrupamento;
	}

	public void setAgrupamento(Agrupamento agrupamento) {
		this.agrupamento = agrupamento;
	}

}