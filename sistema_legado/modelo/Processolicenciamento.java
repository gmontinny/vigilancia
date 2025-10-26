package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the processolicenciamento database table.
 * 
 */
@Entity
@NamedQuery(name="Processolicenciamento.findAll", query="SELECT p FROM Processolicenciamento p")
public class Processolicenciamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="processolicenciamento_idprocessolicenciamento", sequenceName = "processolicenciamento_idprocessolicenciamento_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="processolicenciamento_idprocessolicenciamento")
	private Integer idprocessolicenciamento;
	
	@NotNull(message="Processo campo obrigatorio !")
	private String numprocesso;

	//bi-directional many-to-one association to Licenciamento
	@ManyToOne
	@JoinColumn(name="idlicenciamento")
	@NotNull(message="Licenciamento campo obrigatorio !")
	private Licenciamento licenciamento;
	
	private Integer liberacao;

	public Processolicenciamento() {
	}

	public Integer getIdprocessolicenciamento() {
		return this.idprocessolicenciamento;
	}

	public void setIdprocessolicenciamento(Integer idprocessolicenciamento) {
		this.idprocessolicenciamento = idprocessolicenciamento;
	}

	public String getNumprocesso() {
		return this.numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public Licenciamento getLicenciamento() {
		return this.licenciamento;
	}

	public void setLicenciamento(Licenciamento licenciamento) {
		this.licenciamento = licenciamento;
	}

	public Integer getLiberacao() {
		return liberacao;
	}

	public void setLiberacao(Integer liberacao) {
		this.liberacao = liberacao;
	}
	

}