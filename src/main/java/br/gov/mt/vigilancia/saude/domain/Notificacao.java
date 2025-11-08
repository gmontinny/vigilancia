package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import java.sql.Time;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the notificacao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Notificacao.findAll", query="SELECT n FROM Notificacao n")
public class Notificacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacao_idnotificacao", sequenceName = "notificacao_idnotificacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacao_idnotificacao")
	private Integer idnotificacao;

	@Temporal(TemporalType.DATE)
	private Date datanotificacao;
	
	private Integer statusnotificacao;
	
	private String denotificacao;
	
	private String paranotificacao;
	
	private String mensagemnotificacao;
	
	private Integer totalnotificacao;
	
	private Time horanotificacao;
	
	//bi-directional many-to-one association to OrdemServico
	@ManyToOne
	@JoinColumn(name="idusuario")
	@NotNull(message="Usuario Campo Obrigatorio!")
	private Usuario usuario;	

}