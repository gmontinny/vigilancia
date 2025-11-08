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
 * The persistent class for the itensavaliacao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Itensavaliacao.findAll", query="SELECT i FROM Itensavaliacao i")
public class Itensavaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensavaliacao_iditensavaliacao", sequenceName = "itensavaliacao_iditensavaliacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensavaliacao_iditensavaliacao")
	private Integer iditensavaliacao;
	
	@Temporal(TemporalType.DATE)
	private Date datafinal;

	@NotNull(message="DATA RECEBIMENTO campo obrigatorio !")
	@Temporal(TemporalType.DATE)
	private Date datarecebimento;

	@NotNull(message="PRAZO campo obrigatorio !")
	private Integer prazo;

	@NotNull(message="RESPONSAVEL campo obrigatorio !")
	private Integer responsavel;

	private Integer status;

	@NotNull(message="TEXTO campo obrigatorio !")
	private String texto;
	
	
	@ManyToOne
	@JoinColumn(name="idgestaodocumento")
	private Gestaodocumento gestaodocumento;

}