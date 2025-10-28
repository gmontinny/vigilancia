package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the servicosaude database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Servicosaude.findAll", query="SELECT s FROM Servicosaude s ORDER BY s.idservicosaude")
public class Servicosaude implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="servicosaude_idservicosaude", sequenceName = "servicosaude_idservicosaude_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="servicosaude_idservicosaude")
	private Integer idservicosaude;
	
	@ManyToOne
	@JoinColumn(name="idagrupamento")
	private Agrupamento agrupamento;

	@NotNull(message="N° SERVIÇO campo Obrigatorio !")
	private Integer numeroservico;

	//bi-directional many-to-one association to Categoriaservico
	@ManyToOne
	@JoinColumn(name="idcategoriaservico")
	private Categoriaservico categoriaservico;
	
	private Integer idcategoriaanalise;

}