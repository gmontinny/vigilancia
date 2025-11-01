package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the despachoinstancia database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Despachoinstancia.findAll", query="SELECT d FROM Despachoinstancia d ORDER BY d.iddespachoinstancia DESC")
public class Despachoinstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="despachoinstancia_iddespachoinstancia", sequenceName = "despachoinstancia_iddespachoinstancia_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="despachoinstancia_iddespachoinstancia")
	private Integer iddespachoinstancia;
	
	@NotNull(message="Gerente é um campo Necessário !")
	private String gerenteresponsavel;

	private String imagemassinatura;
	
	@NotNull(message="Texto é um campo Necessário !")
	private String textoinstancia;

}