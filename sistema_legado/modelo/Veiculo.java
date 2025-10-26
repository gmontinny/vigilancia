package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * The persistent class for the veiculo database table.
 * 
 */
@Entity
@NamedQuery(name="Veiculo.findAll", query="SELECT v FROM Veiculo v")
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="veiculo_idveiculo", sequenceName = "veiculo_idveiculo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="veiculo_idveiculo")
	private Integer idveiculo;
	
	@NotNull(message="Chassi campo obrigatorio !")
	@Size(min=17, message="Digite pelo menos 17 caracteres no chassi!")
	private String chassiveiculo;

	@NotNull(message="Placa campo obrigatorio !")	
	private String placaveiculo;
	
	private String numprocesso;
	
	private String placacaminhao;
	
	private String chassicaminhao;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="idcategoria")
	@NotNull(message="Categoria campo Obrigatorio !")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="idestabelecimento")
	@NotNull(message="Estabelecimento campo Obrigatorio !")
	private Estabelecimento estabelecimento;

	public Veiculo() {
	}

	public Integer getIdveiculo() {
		return this.idveiculo;
	}

	public void setIdveiculo(Integer idveiculo) {
		this.idveiculo = idveiculo;
	}

	public String getChassiveiculo() {
		return this.chassiveiculo;
	}

	public void setChassiveiculo(String chassiveiculo) {
		this.chassiveiculo = chassiveiculo;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public String getPlacaveiculo() {
		return this.placaveiculo;
	}

	public void setPlacaveiculo(String placaveiculo) {
		this.placaveiculo = placaveiculo;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNumprocesso() {
		return numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public String getPlacacaminhao() {
		return placacaminhao;
	}

	public void setPlacacaminhao(String placacaminhao) {
		this.placacaminhao = placacaminhao;
	}

	public String getChassicaminhao() {
		return chassicaminhao;
	}

	public void setChassicaminhao(String chassicaminhao) {
		this.chassicaminhao = chassicaminhao;
	}
	
	

}