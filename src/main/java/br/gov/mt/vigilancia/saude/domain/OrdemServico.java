package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import java.sql.Time;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the ordemservico database table.
 * 
 */
@Entity
@Table(name = "ordemservico", schema = "app")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Ordemservico.findAll", query="SELECT o FROM OrdemServico o WHERE o.situacaoordemservico NOT IN (0,-1,2,3,6) ORDER BY o.dataordemservico")
public class OrdemServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ordemservico_idordemservico", sequenceName = "app.ordemservico_idordemservico_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="ordemservico_idordemservico")
	@Column(name = "id")
	private Integer idordemservico;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_final")
	private Date datafinal;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicial")
	private Date datainicial;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_ordem_servico")
	private Date dataordemservico;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_conclusao")
	private Date dataconclusao;
	
	@Column(name = "usuario_conclusao")
	private String usuarioconclusao;

	@Column(name = "situacao")
	private Integer situacaoordemservico;
	
	@Column(name = "texto_conclusao", length = 1024)
	private String textoconclusao;

	@Column(name = "texto_problema", length = 1024)
	private String textoproblema;
	
	@Column(name = "prioridade")
	private Integer prioridadeordemservico;
	
	@Column(name = "tls")
	private Integer tlsordemservico;
	
	@Column(name = "tipo")
	private Integer tipoordemservico;
	
	@Column(name = "hora_ordem_servico")
	private Time horaordemservico;
	
	@Column(name = "tipo_documento")
	private String tipodocumento;
	
	@Column(name = "descricao_documento")
	private String descricaodocumento;

	//bi-directional many-to-one association to Acao
	@ManyToOne
	@JoinColumn(name="idacao")
	private Acao acao;


	//bi-directional many-to-one association to Processo
	@ManyToOne
	@JoinColumn(name="numprocesso")
	private Processo processo;

	//bi-directional many-to-one association to Reclamacao
	@OneToMany(mappedBy="ordemServico")
	private List<Reclamacao> reclamacaos;

	public Reclamacao addReclamacao(Reclamacao reclamacao) {
		this.reclamacaos.add(reclamacao);
		reclamacao.setOrdemServico(this);
		return reclamacao;
	}

	public Reclamacao removeReclamacao(Reclamacao reclamacao) {
		this.reclamacaos.remove(reclamacao);
		reclamacao.setOrdemServico(null);
		return reclamacao;
	}
	
}