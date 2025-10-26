package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the licenciamento database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Licenciamento.findAll", query="SELECT l FROM Licenciamento l")
public class Licenciamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="licenciamento_idlicenciamento", sequenceName = "licenciamento_idlicenciamento_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="licenciamento_idlicenciamento")
	private Integer idlicenciamento;

	@Temporal(TemporalType.DATE)
	private Date datalicenciamento;
	
	@Temporal(TemporalType.DATE)
	private Date datavencimento;
	
	private Integer qtimpresso;
	
	private String obslicenciamento;
	
	@NotNull(message="Veiculo campo obrigatorio !")
	@ManyToOne
	@JoinColumn(name="idveiculo")
	private Veiculo veiculo;

	private Integer statuslicenciamento;

	//bi-directional many-to-one association to Agrupamento
	@ManyToOne
	@JoinColumn(name="idagrupamento") // Assuming 'idagrupamento' is the foreign key column in the 'licenciamento' table
	private Agrupamento agrupamento;

}