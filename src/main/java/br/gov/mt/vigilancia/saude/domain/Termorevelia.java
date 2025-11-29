package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the termorevelia database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Termorevelia.findAll", query="SELECT t FROM Termorevelia t")
public class Termorevelia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="termorevelia_idtermorevelia", sequenceName = "termorevelia_idtermorevelia_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="termorevelia_idtermorevelia")
	private Integer idtermorevelia;
	
	@NotNull(message="Coordenadora campo obrigatorio !")
	private String coordenadorresponsavel;
	
	@NotNull(message="Assinatura campo obrigatorio !")
	private String imagemassinatura;

	@NotNull(message="Texto campo obrigatorio !")
	private String textorevelia;

}