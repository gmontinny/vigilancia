package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the tabelainfracoes database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tabelainfracoes")
@NamedQuery(name="Tabelainfracoe.findAll", query="SELECT t FROM Tabelainfracoe t ORDER BY t.tipograuinfracao")
public class Tabelainfracoe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tabelainfracoes_idtabelainfracoes", sequenceName = "tabelainfracoes_idtabelainfracoes_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="tabelainfracoes_idtabelainfracoes")
	private Integer idtabelainfracoes;

	@NotNull(message="CONFORMIDADE campo Obrigatório!")
	private String conformidade;

	@NotNull(message="TIPO RISCO campo Obrigatório!")
	private Integer tiporisco;

	private Integer tipograuinfracao;
		
	@NotNull(message="VALOR CONFORMIDADE campo Obrigatório!")
	private double valorconformidade;
	
	private Integer ordeminfracoes;

}