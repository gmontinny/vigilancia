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
 * The persistent class for the geragaleria database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Geragaleria.findAll", query="SELECT g FROM Geragaleria g")
public class Geragaleria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geragaleria_idgeragaleria", sequenceName = "geragaleria_idgeragaleria_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geragaleria_idgeragaleria")
	private Integer idgeragaleria;

	@Temporal(TemporalType.DATE)
	private Date datageragaleria;

	private Time horageragaleria;
	
	private Integer idusuario;
	
	private Integer statusgeragaleria;

}