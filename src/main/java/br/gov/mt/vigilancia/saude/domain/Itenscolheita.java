package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the itenscolheita database table.
 * 
 */
@Entity
@Table(name = "itenscolheita", schema = "app")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Itenscolheita.findAll", query="SELECT i FROM Itenscolheita i")
public class Itenscolheita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itenscolheita_iditenscolheita", sequenceName = "itenscolheita_iditenscolheita_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itenscolheita_iditenscolheita")
	private Integer iditenscolheita;
	
	private Integer numerotramitacao;

	@ManyToOne
	@JoinColumn(name="idtermocolheita")
	@NotNull(message="Termo da colheita campo obrigatorio !")
	private Termocolheita termocolheita;

}