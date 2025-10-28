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
 * The persistent class for the categoriaroteiro database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Categoriaroteiro.findAll", query="SELECT c FROM Categoriaroteiro c ORDER BY c.descricaocategoria")
public class Categoriaroteiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="categoriaroteiro_idcategoriaroteiro", sequenceName = "categoriaroteiro_idcategoriaroteiro_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="categoriaroteiro_idcategoriaroteiro")
	private Integer idcategoriaroteiro;

	@NotNull(message="Descrição Campo Obrigatorio !")
	private String descricaocategoria;

	//bi-directional many-to-one association to Itensroteiro
	@OneToMany(mappedBy="categoriaroteiro")
	private List<Itensroteiro> itensroteiros;

	public Itensroteiro addItensroteiro(Itensroteiro itensroteiro) {
		this.itensroteiros.add(itensroteiro);
		itensroteiro.setCategoriaroteiro(this);

		return itensroteiro;
	}

	public Itensroteiro removeItensroteiro(Itensroteiro itensroteiro) {
		this.itensroteiros.remove(itensroteiro);
		itensroteiro.setCategoriaroteiro(null);

		return itensroteiro;
	}

}