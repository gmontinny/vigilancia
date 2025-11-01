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
 * The persistent class for the geraatividade database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Geraatividade.findAll", query="SELECT g FROM Geraatividade g")
public class Geraatividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geraatividade_idgeraatividade", sequenceName = "geraatividade_idgeraatividade_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geraatividade_idgeraatividade")
	private Integer idgeraatividade;

	@Temporal(TemporalType.DATE)
	private Date dataatividade;

	private Time horaatividade;

	private Integer idusuario;

	private Integer statusgeraatividade;

}