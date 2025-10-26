package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the carteirinha database table.
 * 
 */
@Entity
@NamedQuery(name="Carteirinha.findAll", query="SELECT c FROM Carteirinha c")
public class Carteirinha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="carteirinha_idcarteirinha", sequenceName = "carteirinha_idcarteirinha_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="carteirinha_idcarteirinha")
	private Integer idcarteirinha;

	@Temporal(TemporalType.DATE)
	private Date datacadastro;

	@Temporal(TemporalType.DATE)
	private Date dataemissao;
	
	@Temporal(TemporalType.DATE)
	private Date datavalidade;

	@NotNull(message="Foto campo Obrigatorio !")
	private String imagemcarteirinha;

	@NotNull(message="Processo campo Obrigatorio")
	private String numprocesso;
	

	private Integer statusimpresso;

	public Carteirinha() {
	}

	public Integer getIdcarteirinha() {
		return this.idcarteirinha;
	}

	public void setIdcarteirinha(Integer idcarteirinha) {
		this.idcarteirinha = idcarteirinha;
	}

	public Date getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Date getDataemissao() {
		return this.dataemissao;
	}

	public void setDataemissao(Date dataemissao) {
		this.dataemissao = dataemissao;
	}

	public String getImagemcarteirinha() {
		return this.imagemcarteirinha;
	}

	public void setImagemcarteirinha(String imagemcarteirinha) {
		this.imagemcarteirinha = imagemcarteirinha;
	}

	public String getNumprocesso() {
		return this.numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public Integer getStatusimpresso() {
		return statusimpresso;
	}

	public void setStatusimpresso(Integer statusimpresso) {
		this.statusimpresso = statusimpresso;
	}

	public Date getDatavalidade() {
		return datavalidade;
	}

	public void setDatavalidade(Date datavalidade) {
		this.datavalidade = datavalidade;
	}


	
}