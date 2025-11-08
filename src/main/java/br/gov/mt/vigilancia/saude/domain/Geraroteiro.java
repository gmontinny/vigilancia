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
 * The persistent class for the geraroteiro database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Geraroteiro.findAll", query="SELECT g FROM Geraroteiro g")
public class Geraroteiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geraroteiro_idgeraroteiro", sequenceName = "geraroteiro_idgeraroteiro_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geraroteiro_idgeraroteiro")
	private Integer idgeraroteiro;

	@Temporal(TemporalType.DATE)
	private Date datageraroteiro;

	private Time horageraroteiro;
	
	private Integer statusroteiro;
	
	private Integer idusuario;

}