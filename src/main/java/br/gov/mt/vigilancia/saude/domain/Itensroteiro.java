package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the itensroteiro database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Itensroteiro.findAll", query="SELECT i FROM Itensroteiro i ORDER BY i.descricaoitensroteiro")
public class Itensroteiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensroteiro_iditensroteiro", sequenceName = "itensroteiro_iditensroteiro_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensroteiro_iditensroteiro")
	private Integer iditensroteiro;
	
	private Integer numeroroteiro;
	
	private Integer idlegislacao755;
	
	@NotNull(message="Gera Infração campo Obrigatorio !")
	private Integer gerainfracao;
	
	@NotNull(message="Criticidade campo Obrigatorio !")
	private Integer criticidade;
	
		
	@NotNull(message="Descrição campo Obrigatorio !")
	private String descricaoitensroteiro;

	//bi-directional many-to-one association to Categoriaroteiro
	@ManyToOne
	@JoinColumn(name="idcategoriaroteiro")
	@NotNull(message="Categoria campo Obrigatorio !")
	private Categoriaroteiro categoriaroteiro;

	
	@ManyToOne
	@JoinColumn(name="idlegislacao")
	@NotNull(message="Legislação campo Obrigatorio !")
	private Legislacao legislacao;

}