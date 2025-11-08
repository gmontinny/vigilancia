package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the autoinfracao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Autoinfracao.findAll", query="SELECT a FROM Autoinfracao a")
public class Autoinfracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="autoinfracao_idautoinfracao", sequenceName = "autoinfracao_idautoinfracao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="autoinfracao_idautoinfracao")
	private Integer idautoinfracao;

	@Temporal(TemporalType.DATE)
	private Date dataautoinfracao;
	
	private Integer grauinfracaoautoinfracao;
	
	private String textoautoinfracao;
	
	private Integer gerainterdicao;
		
	private Integer numeroauto;
	
	private Integer geraadvertencia;
	
	private Integer geramulta;
	
	private String valormulta;
	
	private String termoadvertencia;
	
	private String termointerdicao;
	
	private String textointerdicao;
	
	private String tipoinfracao;
	
	//bi-directional many-to-one association to OrdemServico
	@ManyToOne
	@JoinColumn(name="idtramitacao")
	private Tramitacao tramitacao;

}