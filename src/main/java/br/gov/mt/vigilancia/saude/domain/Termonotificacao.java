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
 * The persistent class for the termonotificacao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Termonotificacao.findAll", query="SELECT t FROM Termonotificacao t")
public class Termonotificacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="termonotificacao_idtermonotificacao", sequenceName = "termonotificacao_idtermonotificacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="termonotificacao_idtermonotificacao")
	private Integer idtermonotificacao;

	@Temporal(TemporalType.DATE)
	private Date datanotificacao;

	private Time horanotificacao;
	
	@ManyToOne
	@JoinColumn(name="idestabelecimento")
	private Estabelecimento estabelecimento;

	private Integer numerotramitacao;

	private String textonotificacao;
	
	private Integer diasnotificacao;

}