package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the notificacaoordemservico database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Notificacaoordemservico.findAll", query="SELECT n FROM Notificacaoordemservico n")
public class Notificacaoordemservico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacaoordemservico_idnotificacaoordemservico", sequenceName = "notificacaoordemservico_idnotificacaoordemservico_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacaoordemservico_idnotificacaoordemservico")

	private Integer idnotificacaoordemservico;

	@Temporal(TemporalType.DATE)
	private Date datanotificacaoordemservico;

	private Time horanotificacaooredemservico;


	@ManyToOne
	@JoinColumn(name="idordemservico")
	@NotNull(message="Ordem de Serviço Campo Obrigatorio!")
	private OrdemServico ordemservico;

	//bi-directional many-to-one association to OrdemServico
	@ManyToOne
	@JoinColumn(name="idusuario")
	@NotNull(message="Usuario Campo Obrigatorio!")
	private Usuario usuario;
	
	private Integer statusordemservico;

}