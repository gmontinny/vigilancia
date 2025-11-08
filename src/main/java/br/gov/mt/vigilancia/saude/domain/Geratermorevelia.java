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
 * The persistent class for the geratermorevelia database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Geratermorevelia.findAll", query="SELECT g FROM Geratermorevelia g")
public class Geratermorevelia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geratermorevelia_idtermorevelia", sequenceName = "geratermorevelia_idtermorevelia_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geratermorevelia_idtermorevelia")
	private Integer idtermorevelia;

	@Temporal(TemporalType.DATE)
	private Date datarevelia;

	private Time horarevelia;

	private Integer numeroauto;

}