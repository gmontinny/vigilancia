package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the despachorevelia database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Despachorevelia.findAll", query="SELECT d FROM Despachorevelia d ORDER BY d.iddespachorevelia DESC")
public class Despachorevelia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="despachorevelia_iddespachorevelia", sequenceName = "despachorevelia_iddespachorevelia_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="despachorevelia_iddespachorevelia")
	private Integer iddespachorevelia;
	
	@NotNull(message="Secretario(a) campo Obrigatorio !")
	private String secretariodespachorevelia;
	
	@NotNull(message="Texto campo Obrigatorio !")
	private String textodespachorevelia;

}