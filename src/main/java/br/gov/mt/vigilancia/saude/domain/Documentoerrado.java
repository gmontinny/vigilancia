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
 * The persistent class for the documentoerrado database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Documentoerrado.findAll", query="SELECT d FROM Documentoerrado d")
public class Documentoerrado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="documentoerrado_iddocumentoerrado", sequenceName = "documentoerrado_iddocumentoerrado_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="documentoerrado_iddocumentoerrado")
	private Integer iddocumentoerrado;

	@Temporal(TemporalType.DATE)
	private Date datadocumentoerrado;

	private Time horadocumentoerrado;
	
	private String arquivodocumentoerrado;

	@ManyToOne
	@JoinColumn(name="iduploadnecessario")
	private Uploadnecessario uploadnecessario;

}