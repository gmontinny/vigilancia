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
 * The persistent class for the uploadnecessario database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Uploadnecessario.findAll", query="SELECT u FROM Uploadnecessario u")
public class Uploadnecessario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="uploadnecessario_iduploadnecessario", sequenceName = "uploadnecessario_iduploadnecessario_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="uploadnecessario_iduploadnecessario")
	private Integer iduploadnecessario;

	@Temporal(TemporalType.DATE)
	private Date dataupload;

	private String documentoupload;

	private Time horaupload;

	@ManyToOne
	@JoinColumn(name = "iddocnecessario")
	private Docnecessario docnecessario;

	private String numprocesso;

	private Integer validacaoupload;
	
	private Integer situacaoupload;
	
	private String textoupload;

}