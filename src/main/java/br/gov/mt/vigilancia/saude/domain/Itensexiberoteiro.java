package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the itensexiberoteiro database table.
 * 
 */
@Entity
@Table(name = "itensexiberoteiro", schema = "app")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Itensexiberoteiro.findAll", query="SELECT i FROM Itensexiberoteiro i")
public class Itensexiberoteiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensexiberoteiro_iditensexiberoteiro", sequenceName = "itensexiberoteiro_iditensexiberoteiro_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensexiberoteiro_iditensexiberoteiro")
	private Integer iditensexiberoteiro;

	private Integer atende;

	private Integer atendeparcialmente;
	
	@ManyToOne
	@JoinColumn(name="idexiberoteiro")
	@NotNull(message="Exibe Roteiro campo obrigatorio !")
	private Exiberoteiro exiberoteiro;
	
	@ManyToOne
	@JoinColumn(name="iditensroteiro")
	@NotNull(message="Itens Roteiro campo obrigatorio !")
	private Itensroteiro itensroteiro;

	private Integer naoatende;

	private Integer naoseaplica;
	
	private Integer numeroauto;

}