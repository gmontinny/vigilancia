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
 * The persistent class for the notificacaoadministrativa database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Notificacaoadministrativa.findAll", query="SELECT n FROM Notificacaoadministrativa n")
public class Notificacaoadministrativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacaoadministrativa_idnotivicacaoadministrativa", sequenceName = "notificacaoadministrativa_idnotivicacaoadministrativa_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacaoadministrativa_idnotivicacaoadministrativa")
	private Integer idnotificacaoadministrativa;

	@Temporal(TemporalType.DATE)
	private Date datanotificacaoadministrativa;

	private Time horanotificacaoadministrativa;

	private Integer liberarnotificacaoadministrativa;
	
	@NotNull(message="Número do Auto campo Obrigatorio !")
	private Integer numeroauto;
	
	@NotNull(message="Texto campo Obrigatorio !")
	private String textonotificacaoadministrativa;

}