package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;


/**
 * The persistent class for the categoriaservico database table.
 * 
 */
@Entity
@NamedQuery(name="Categoriaservico.findAll", query="SELECT c FROM Categoriaservico c ORDER BY c.desccategoriaservico")
public class Categoriaservico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="categoriaservico_idcategoriaservico", sequenceName = "categoriaservico_idcategoriaservico_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="categoriaservico_idcategoriaservico")
	private Integer idcategoriaservico;

	@NotNull(message="DESCRIÇÃO campo Obrigatório!")
	private String desccategoriaservico;

	//bi-directional many-to-one association to Servicosaude
	@OneToMany(mappedBy="categoriaservico")
	private List<Servicosaude> servicosaudes;

	public Categoriaservico() {
	}

	public Integer getIdcategoriaservico() {
		return this.idcategoriaservico;
	}

	public void setIdcategoriaservico(Integer idcategoriaservico) {
		this.idcategoriaservico = idcategoriaservico;
	}

	public String getDesccategoriaservico() {
		return this.desccategoriaservico;
	}

	public void setDesccategoriaservico(String desccategoriaservico) {
		this.desccategoriaservico = desccategoriaservico;
	}

	public List<Servicosaude> getServicosaudes() {
		return this.servicosaudes;
	}

	public void setServicosaudes(List<Servicosaude> servicosaudes) {
		this.servicosaudes = servicosaudes;
	}

	public Servicosaude addServicosaude(Servicosaude servicosaude) {
		getServicosaudes().add(servicosaude);
		servicosaude.setCategoriaservico(this);

		return servicosaude;
	}

	public Servicosaude removeServicosaude(Servicosaude servicosaude) {
		getServicosaudes().remove(servicosaude);
		servicosaude.setCategoriaservico(null);

		return servicosaude;
	}

}