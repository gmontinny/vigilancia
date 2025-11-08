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
 * The persistent class for the geratramite database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Geratramite.findAll", query="SELECT g FROM Geratramite g")
public class Geratramite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geratramite_idgeratramite", sequenceName = "geratramite_idgeratramite_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geratramite_idgeratramite")
	private Integer idgeratramite;

	@Temporal(TemporalType.DATE)
	private Date dtgeratramite;

	private Time hrgeratramite;

}