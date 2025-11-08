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
 * The persistent class for the geraitensprodi database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Geraitensprodi.findAll", query="SELECT g FROM Geraitensprodi g")
public class Geraitensprodi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geraitensprodi_idgeraitensprodi", sequenceName = "geraitensprodi_idgeraitensprodi_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geraitensprodi_idgeraitensprodi")
	private Integer idgeraitensprodi;

	@Temporal(TemporalType.DATE)
	private Date dataitensprodi;

	private Time horaitensprodi;

	private Integer idusuario;

	private Integer statusitensprodi;

}