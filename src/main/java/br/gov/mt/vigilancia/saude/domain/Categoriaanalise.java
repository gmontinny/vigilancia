package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the categoriaanalise database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Categoriaanalise.findAll", query="SELECT c FROM Categoriaanalise c")
public class Categoriaanalise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="categoriaanalise_idcategoriaanalise", sequenceName = "categoriaanalise_idcategoriaanalise_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="categoriaanalise_idcategoriaanalise")
	private Integer idcategoriaanalise;
	
	@NotNull(message="Nome Categoria campo obrigatorio !")
	private String nomecategoriaanalise;

}