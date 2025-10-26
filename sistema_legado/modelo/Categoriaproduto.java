package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;


/**
 * The persistent class for the categoriaproduto database table.
 * 
 */
@Entity
@NamedQuery(name="Categoriaproduto.findAll", query="SELECT c FROM Categoriaproduto c")
public class Categoriaproduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="categoriaproduto_idcategoriaproduto", sequenceName = "categoriaproduto_idcategoriaproduto_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="categoriaproduto_idcategoriaproduto")
	private Integer idcategoriaproduto;

	@NotNull(message="Categoria do Produto campo Obrigatorio !")
	private String descricaocategoriaproduto;

	@NotNull(message="Código do Prodir campo obrigatorio !")
	private Integer codigoprodi;

	public Categoriaproduto() {
	}

	public Integer getIdcategoriaproduto() {
		return this.idcategoriaproduto;
	}

	public void setIdcategoriaproduto(Integer idcategoriaproduto) {
		this.idcategoriaproduto = idcategoriaproduto;
	}

	public String getDescricaocategoriaproduto() {
		return this.descricaocategoriaproduto;
	}

	public void setDescricaocategoriaproduto(String descricaocategoriaproduto) {
		this.descricaocategoriaproduto = descricaocategoriaproduto;
	}

	public Integer getCodigoprodi() {
		return codigoprodi;
	}

	public void setCodigoprodi(Integer codigoprodi) {
		this.codigoprodi = codigoprodi;
	}

	
	

}