package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Time;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the tramitacao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Tramitacao.findAll", query="SELECT t FROM Tramitacao t")
public class Tramitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tramitacao_idtramitacao", sequenceName = "tramitacao_idtramitacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="tramitacao_idtramitacao")
	private Integer idtramitacao;

	@Temporal(TemporalType.DATE)
	private Date datafinal;

	@Temporal(TemporalType.DATE)
	private Date datainicial;
	
	@Temporal(TemporalType.DATE)
	private Date dataresposta;
	
	private String usuarioresposta;

	private Time horatramitacao;
	
	private Integer tipocolheita;
	
	private Integer tipoauto;
	
	private Integer tiponotificacao;
	
	private Integer tipoarquitetonico;
	
	private Integer tipoadministrativo;
	
	private Integer tipooperacao;
	
	private Integer prioridadetramite;
	
	private Integer numerotramitacao;
	
	private Integer statustramitacao;
	
	private Integer situacaotramitacao;
	
	private Integer leutramitacao;

	@ManyToOne
	@JoinColumn(name="idordemservico")
	private OrdemServico ordemservico;
	
	@ManyToOne
	@JoinColumn(name="idtipoinspecao")
	private Tipoinspecao tipoinspecao;

	private String textotramitacao;
	
	private String textoresposta;

}