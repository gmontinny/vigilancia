package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the processolicenciamento database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Processolicenciamento.findAll", query="SELECT p FROM Processolicenciamento p")
public class Processolicenciamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="processolicenciamento_idprocessolicenciamento", sequenceName = "processolicenciamento_idprocessolicenciamento_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="processolicenciamento_idprocessolicenciamento")
	private Integer idprocessolicenciamento;
	
	@NotNull(message="Processo campo obrigatorio !")
	private String numprocesso;

	//bi-directional many-to-one association to Licenciamento
	@ManyToOne
	@JoinColumn(name="idlicenciamento")
	@NotNull(message="Licenciamento campo obrigatorio !")
	private Licenciamento licenciamento;
	
	private Integer liberacao;

}