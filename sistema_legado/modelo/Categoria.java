package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c ORDER BY c.tipocategoria")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="categoria_idcategoria", sequenceName = "categoria_idcategoria_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="categoria_idcategoria")
	private Integer idcategoria;

	private Integer codigocategoria;

	private String tipocategoria;

	//bi-directional many-to-one association to Veiculo
	@OneToMany(mappedBy="categoria")
	private List<Veiculo> veiculos;

	public Categoria() {
	}

	public Integer getIdcategoria() {
		return this.idcategoria;
	}

	public void setIdcategoria(Integer idcategoria) {
		this.idcategoria = idcategoria;
	}

	public Integer getCodigocategoria() {
		return this.codigocategoria;
	}

	public void setCodigocategoria(Integer codigocategoria) {
		this.codigocategoria = codigocategoria;
	}

	public String getTipocategoria() {
		return this.tipocategoria;
	}

	public void setTipocategoria(String tipocategoria) {
		this.tipocategoria = tipocategoria;
	}

	public List<Veiculo> getVeiculos() {
		return this.veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Veiculo addVeiculo(Veiculo veiculo) {
		getVeiculos().add(veiculo);
		veiculo.setCategoria(this);

		return veiculo;
	}

	public Veiculo removeVeiculo(Veiculo veiculo) {
		getVeiculos().remove(veiculo);
		veiculo.setCategoria(null);

		return veiculo;
	}

}