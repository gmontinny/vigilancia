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
 * The persistent class for the uploadvalidate database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Uploadvalidate.findAll", query="SELECT u FROM Uploadvalidate u")
public class Uploadvalidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="uploadvalidate_iduploadvalidate", sequenceName = "uploadvalidate_iduploadvalidate_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="uploadvalidate_iduploadvalidate")
	private Integer iduploadvalidate;

	@Temporal(TemporalType.DATE)
	private Date dataupload;

	private String documentoupload;

	private Time horaupload;

	private Integer iddocnecessario;

	private String numprocesso;

	private Integer situacaoupload;

	private String textoupload;

	private Integer validacaoupload;

}