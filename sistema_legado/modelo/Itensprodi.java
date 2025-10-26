package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the itensprodi database table.
 * 
 */
@Entity
@NamedQuery(name="Itensprodi.findAll", query="SELECT i FROM Itensprodi i")
public class Itensprodi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensprodi_iditensprodi", sequenceName = "itensprodi_iditensprodi_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensprodi_iditensprodi")
	private Integer iditensprodi;

	private Integer anovalidade;

	private Integer diavalidade;

	private Integer estadualcomercial;

	private Integer exportacaocomercial;
	
	@NotNull(message="Marca campo Obrigatorio !")
	private String marcaproduto;

	private Integer mesvalidade;

	private Integer municipalcomercial;

	private Integer nacionalcomercial;
	
	private Integer numeroitensprodi;
	
	@NotNull(message="Nome Produto campo Obrigatorio !")
	private String nomeproduto;

	private Integer numeroprodi;
	
	@NotNull(message="Validade campo Obrigatorio !")
	private Integer numerovalidade;
	
	private String descembalagem;
	
	@NotNull(message="Categoria campo Obrigatorio !")
	@ManyToOne
	@JoinColumn(name="idcategoriaproduto")
	private Categoriaproduto categoriaproduto;
	
	@ManyToOne
	@JoinColumn(name="idestabelecimento")
	private Estabelecimento estabelecimento;

	public Itensprodi() {
	}

	public Integer getIditensprodi() {
		return this.iditensprodi;
	}

	public void setIditensprodi(Integer iditensprodi) {
		this.iditensprodi = iditensprodi;
	}

	public Integer getAnovalidade() {
		return this.anovalidade;
	}

	public void setAnovalidade(Integer anovalidade) {
		this.anovalidade = anovalidade;
	}

	public Integer getDiavalidade() {
		return this.diavalidade;
	}

	public void setDiavalidade(Integer diavalidade) {
		this.diavalidade = diavalidade;
	}

	public Integer getEstadualcomercial() {
		return this.estadualcomercial;
	}

	public void setEstadualcomercial(Integer estadualcomercial) {
		this.estadualcomercial = estadualcomercial;
	}

	public Integer getExportacaocomercial() {
		return this.exportacaocomercial;
	}

	public void setExportacaocomercial(Integer exportacaocomercial) {
		this.exportacaocomercial = exportacaocomercial;
	}

	public String getMarcaproduto() {
		return this.marcaproduto;
	}

	public void setMarcaproduto(String marcaproduto) {
		this.marcaproduto = marcaproduto;
	}

	public Integer getMesvalidade() {
		return this.mesvalidade;
	}

	public void setMesvalidade(Integer mesvalidade) {
		this.mesvalidade = mesvalidade;
	}

	public Integer getMunicipalcomercial() {
		return this.municipalcomercial;
	}

	public void setMunicipalcomercial(Integer municipalcomercial) {
		this.municipalcomercial = municipalcomercial;
	}

	public Integer getNacionalcomercial() {
		return this.nacionalcomercial;
	}

	public void setNacionalcomercial(Integer nacionalcomercial) {
		this.nacionalcomercial = nacionalcomercial;
	}

	public String getNomeproduto() {
		return this.nomeproduto;
	}

	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}

	public Integer getNumeroprodi() {
		return this.numeroprodi;
	}

	public void setNumeroprodi(Integer numeroprodi) {
		this.numeroprodi = numeroprodi;
	}

	public Integer getNumerovalidade() {
		return this.numerovalidade;
	}

	public void setNumerovalidade(Integer numerovalidade) {
		this.numerovalidade = numerovalidade;
	}

	public Categoriaproduto getCategoriaproduto() {
		return categoriaproduto;
	}

	public void setCategoriaproduto(Categoriaproduto categoriaproduto) {
		this.categoriaproduto = categoriaproduto;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Integer getNumeroitensprodi() {
		return numeroitensprodi;
	}

	public void setNumeroitensprodi(Integer numeroitensprodi) {
		this.numeroitensprodi = numeroitensprodi;
	}

	public String getDescembalagem() {
		return descembalagem;
	}

	public void setDescembalagem(String descembalagem) {
		this.descembalagem = descembalagem;
	}
	
	

}