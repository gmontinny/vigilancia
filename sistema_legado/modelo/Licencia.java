package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the licencia database table.
 * 
 */
@Entity
@NamedQuery(name="Licencia.findAll", query="SELECT l FROM Licencia l")
public class Licencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="licencia_idlicencia", sequenceName = "licencia_idlicencia_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="licencia_idlicencia")
	private Integer idlicencia;

	@Temporal(TemporalType.DATE)
	private Date datalicencia;
	
	private Date datavencimento;
	
	private Integer qtimpresso;
	
	private String obslicencia;
	
	@NotNull(message="Veiculo campo obrigatorio !")
	@ManyToOne
	@JoinColumn(name="idveiculo")
	private Veiculo veiculo;

	private Integer statuslicencia;

	public Licencia() {
	}

	public Integer getIdlicencia() {
		return this.idlicencia;
	}

	public void setIdlicencia(Integer idlicencia) {
		this.idlicencia = idlicencia;
	}

	public Date getDatalicencia() {
		return this.datalicencia;
	}

	public void setDatalicencia(Date datalicencia) {
		this.datalicencia = datalicencia;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Integer getStatuslicencia() {
		return this.statuslicencia;
	}

	public void setStatuslicencia(Integer statuslicencia) {
		this.statuslicencia = statuslicencia;
	}

	public Date getDatavencimento() {
		return datavencimento;
	}

	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}

	public Integer getQtimpresso() {
		return qtimpresso;
	}

	public void setQtimpresso(Integer qtimpresso) {
		this.qtimpresso = qtimpresso;
	}

	public String getObslicencia() {
		return obslicencia;
	}

	public void setObslicencia(String obslicencia) {
		this.obslicencia = obslicencia;
	}


}