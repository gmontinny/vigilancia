package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the categoriaservico database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

	public Servicosaude addServicosaude(Servicosaude servicosaude) {
		this.servicosaudes.add(servicosaude);
		servicosaude.setCategoriaservico(this);

		return servicosaude;
	}

	public Servicosaude removeServicosaude(Servicosaude servicosaude) {
		this.servicosaudes.remove(servicosaude);
		servicosaude.setCategoriaservico(null);

		return servicosaude;
	}

}