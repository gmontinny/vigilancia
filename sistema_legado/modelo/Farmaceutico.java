package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the farmaceuticos database table.
 * 
 */
@Entity
@Table(name="farmaceuticos")
@NamedQuery(name="Farmaceutico.findAll", query="SELECT f FROM Farmaceutico f")
public class Farmaceutico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="farmaceuticos_idfarmaceuticos", sequenceName = "farmaceuticos_idfarmaceuticos_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="farmaceuticos_idfarmaceuticos")
	private Integer idfarmaceuticos;

	private Integer administracaofarmaceuticos;

	private Integer afericaofarmaceuticos;

	private Integer atencaofarmaceuticos;

	private Integer entregafarmaceuticos;

	private Integer inalacaofarmaceuticos;

	private Integer perfuracaofarmaceuticos;

	private String quaisfarmaceuticos;

	//bi-directional many-to-one association to Processo
	@ManyToOne
	@JoinColumn(name="numprocesso")
	private Processo processo;

	public Farmaceutico() {
	}

	public Integer getIdfarmaceuticos() {
		return this.idfarmaceuticos;
	}

	public void setIdfarmaceuticos(Integer idfarmaceuticos) {
		this.idfarmaceuticos = idfarmaceuticos;
	}

	public Integer getAdministracaofarmaceuticos() {
		return this.administracaofarmaceuticos;
	}

	public void setAdministracaofarmaceuticos(Integer administracaofarmaceuticos) {
		this.administracaofarmaceuticos = administracaofarmaceuticos;
	}

	public Integer getAfericaofarmaceuticos() {
		return this.afericaofarmaceuticos;
	}

	public void setAfericaofarmaceuticos(Integer afericaofarmaceuticos) {
		this.afericaofarmaceuticos = afericaofarmaceuticos;
	}

	public Integer getAtencaofarmaceuticos() {
		return this.atencaofarmaceuticos;
	}

	public void setAtencaofarmaceuticos(Integer atencaofarmaceuticos) {
		this.atencaofarmaceuticos = atencaofarmaceuticos;
	}

	public Integer getEntregafarmaceuticos() {
		return this.entregafarmaceuticos;
	}

	public void setEntregafarmaceuticos(Integer entregafarmaceuticos) {
		this.entregafarmaceuticos = entregafarmaceuticos;
	}

	public Integer getInalacaofarmaceuticos() {
		return this.inalacaofarmaceuticos;
	}

	public void setInalacaofarmaceuticos(Integer inalacaofarmaceuticos) {
		this.inalacaofarmaceuticos = inalacaofarmaceuticos;
	}

	public Integer getPerfuracaofarmaceuticos() {
		return this.perfuracaofarmaceuticos;
	}

	public void setPerfuracaofarmaceuticos(Integer perfuracaofarmaceuticos) {
		this.perfuracaofarmaceuticos = perfuracaofarmaceuticos;
	}

	public String getQuaisfarmaceuticos() {
		return this.quaisfarmaceuticos;
	}

	public void setQuaisfarmaceuticos(String quaisfarmaceuticos) {
		this.quaisfarmaceuticos = quaisfarmaceuticos;
	}

	public Processo getProcesso() {
		return this.processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

}