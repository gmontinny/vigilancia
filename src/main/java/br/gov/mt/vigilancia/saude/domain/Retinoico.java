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
 * The persistent class for the retinoico database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Retinoico.findAll", query="SELECT r FROM Retinoico r")
public class Retinoico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="retinoico_idretinoico", sequenceName = "retinoico_idretinoico_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="retinoico_idretinoico")
	private Integer idretinoico;

	private Integer statusretinoico;

	@Temporal(TemporalType.DATE)
	private Date dataretinoico;
	
	@NotNull(message="Processo campo obrigatorio !")
	private String numprocesso;
	
	@NotNull(message="Tipo campo obrigatorio !")
	private Integer tiporetinoico;

}